package org.cross.elsclient.blimpl.stockblimpl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.blUtility.GoodsInfo;
import org.cross.elsclient.blimpl.blUtility.ReceiptInfo;
import org.cross.elsclient.blimpl.blUtility.StockInfo;
import org.cross.elsclient.blservice.stockblservice.StockBLService;
import org.cross.elscommon.dataservice.stockdataservice.StockDataService;
import org.cross.elscommon.po.GoodsPO;
import org.cross.elscommon.po.Receipt_OrderPO;
import org.cross.elscommon.po.StockAreaPO;
import org.cross.elscommon.po.StockOperationPO;
import org.cross.elscommon.po.StockPO;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StockOperationType;
import org.cross.elscommon.util.StockState;
import org.cross.elscommon.util.StockType;
import org.cross.elsclient.vo.GoodsVO;
import org.cross.elsclient.vo.Receipt_OrderVO;
import org.cross.elsclient.vo.StockAreaVO;
import org.cross.elsclient.vo.StockCheckVO;
import org.cross.elsclient.vo.StockOperationVO;
import org.cross.elsclient.vo.StockVO;

public class StockBLImpl implements StockBLService{
	
	public StockDataService stockData;
	GoodsInfo goodsInfo;
	StockInfo stockInfo;
	ReceiptInfo receiptInfo;
	
	public StockBLImpl(StockDataService stockData,GoodsInfo goodsInfo,StockInfo stockInfo,ReceiptInfo receiptInfo){
		this.stockData = stockData;
		this.goodsInfo = goodsInfo;
		this.stockInfo = stockInfo;
		this.receiptInfo = receiptInfo;
	}
	
	@Override
	public ArrayList<StockCheckVO> showStockCheck(String stockID) throws RemoteException {
		ArrayList<StockCheckVO> checkVOs = new ArrayList<StockCheckVO>();
		ArrayList<StockAreaPO> areaPOs = stockData.findAreas(stockID);
		if (areaPOs == null) {
			return null;
		}
		int size = areaPOs.size();
		System.out.println(size + "<---- size");
		for (int i = 0; i < size; i++) {
			ArrayList<GoodsVO> goodsVOs = goodsInfo.findByStockAreaNum(areaPOs.get(i).getNumber());
			int goodsSize = goodsVOs.size();
			for (int j = 0; j < goodsSize; j++) {
				Receipt_OrderVO order = (Receipt_OrderVO)receiptInfo.findByID(goodsVOs.get(j).orderNum);
				if (order == null) {
					return null;
				}
				String targetCity = order.targetPlace.toString();
				String inTime = getInTime(stockID, goodsVOs.get(j).number);
				StockCheckVO checkVO = new StockCheckVO(goodsVOs.get(i).number, inTime, targetCity, areaPOs.get(i).getNumber());
				checkVOs.add(checkVO);
			}
		}
		return checkVOs;
	}
	
	@Override
	public ArrayList<StockOperationVO> showStockInfo(String stockID,String time1, String time2) throws RemoteException {
		ArrayList<StockOperationVO> stockOperationVOs = new ArrayList<StockOperationVO>();
		ArrayList<StockOperationPO> stockOperationPOs = stockData.showStockOps(stockID, time1, time2);
		int size = stockOperationPOs.size();
		for (int i = 0; i < size; i++) {
			stockOperationVOs.add(stockInfo.toStockOperationVO(stockOperationPOs.get(i)));
		}
		return stockOperationVOs;
	}
	
	@Override
	public StockVO findStock(String ID) throws RemoteException {
		StockPO stockPO = stockData.findStockByNum(ID);
		if (stockPO == null) {
			return null;
		}
		StockVO stockVO = stockInfo.toStockVO(stockPO);
		
		int size = stockPO.getStockAreas().size();
		for (int i = 0; i < size; i++) {
			StockAreaPO area = stockPO.getStockAreas().get(i);
			ArrayList<GoodsVO> goodsVOs = goodsInfo.findByStockAreaNum(area.getNumber());
			stockVO.stockAreas.get(i).goodsList = goodsVOs;
		}
		return stockVO;
	}
	
	@Override
	public ResultMessage exportStockCheck() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ArrayList<StockAreaVO> stockCapacity(String id, StockType type)
			throws RemoteException {
		ArrayList<StockAreaVO> vo = new ArrayList<StockAreaVO>();
		StockPO stock = stockData.findStockByNum(id);
		if (stock == null) {
			return null;
		}
		ArrayList<StockAreaPO> po = stock.getStockAreas();
		if (po == null) {
			return null;
		}
		int size = po.size();
		for (int i = 0; i < size; i++) {
			if (po.get(i).getStockType() == type) {
				vo.add(stockInfo.toStockAreaVO(po.get(i)));
			}
		}
		return vo;
	}
	
	@Override
	public ResultMessage intoStock(String goodsID, String stockID, String time)
			throws RemoteException {
		GoodsVO goodsVO = goodsInfo.searchGoods(goodsID);
		if (goodsVO == null) {
			System.out.println("goodsVo = null");
			return ResultMessage.FAILED;
		}
		StockOperationPO operationPO = new StockOperationPO(time, StockOperationType.STOCKIN, goodsID, 0, goodsVO.goodsType);
		StockPO stockPO = stockData.findStockByNum(stockID);
		if (stockPO == null) {
			return ResultMessage.FAILED;
		}
		String stockAreaNum = goodsInfo.findStockAreaNum(goodsID);
		if(stockAreaNum != null) 
			return ResultMessage.FAILED;
//		System.out.println(stockAreaNum + " kkkkk");
//		System.out.println("in");
		ArrayList<StockAreaPO> areaPOs = stockPO.getStockAreas();
		int size = areaPOs.size();
//		System.out.println(size);
		for (int i = 0; i < size; i++) {
			if (areaPOs.get(i).getStockType() == goodsVO.goodsType) {
				if (areaPOs.get(i).getTotalCapacity() > areaPOs.get(i).getUsedCapacity()) {
					stockData.updateInstock(stockID, areaPOs.get(i).getNumber(), operationPO);
//					System.out.println(res.toString());
					System.out.println(goodsID+" "+stockID+" "+areaPOs.get(i).getNumber());
					goodsInfo.updateToArea(goodsID, stockID,areaPOs.get(i).getNumber());
//					System.out.println(res2.toString());
//					if (res == ResultMessage.SUCCESS && res2 == ResultMessage.SUCCESS) {
//						return ResultMessage.SUCCESS;
//					}
//					return ResultMessage.FAILED;
					return ResultMessage.SUCCESS;
				}
			}
		}
		return ResultMessage.FAILED;
	}
	@Override
	public ResultMessage outStock(String goodsID, String stockID, String time)
			throws RemoteException {
		String stockAreaNum = goodsInfo.findStockAreaNum(goodsID);
		if(stockAreaNum==null) return ResultMessage.FAILED;
		GoodsVO goodsVO = goodsInfo.searchGoods(goodsID);
		StockOperationPO operationPO = new StockOperationPO(time, StockOperationType.STOCKOUT, goodsID, 0, goodsVO.goodsType);
		ResultMessage res = stockData.updateOutstock(stockID, goodsInfo.findStockAreaNum(goodsID), operationPO);
		ResultMessage res2 = goodsInfo.deleteFromStock(goodsID);
		if (res == ResultMessage.SUCCESS && res2 == ResultMessage.SUCCESS) {
			return ResultMessage.SUCCESS;
		}
		return ResultMessage.FAILED;
	}
	@Override
	public StockState stockAlert(String stockID, StockType stockType)
			throws RemoteException {
		ArrayList<StockAreaVO> areaVOs = stockCapacity(stockID, stockType);
		if (areaVOs == null) {
			System.out.println("找不到仓库");
			return StockState.NORMAL;
		}
		int size = areaVOs.size();
		int total = 0;
		int used = 0;
		for (int i = 0; i < size; i++) {
			total += areaVOs.get(i).totalCapacity;
			used += areaVOs.get(i).usedCapacity;
		}
		if (10*used > 9*total) {
			return StockState.ALERT;
		}
		return StockState.NORMAL;
	}
	@Override
	public ResultMessage stockAdjust(String stockAreaID, StockType stockType) throws RemoteException {
		return stockData.updateAdjust(stockAreaID, stockType);
	}

	@Override
	public ResultMessage addStock(StockVO vo) throws RemoteException {
		StockPO po = stockInfo.toStockPO(vo);
		return stockData.insert(po);
	}

	@Override
	public ResultMessage deleteStock(String stockID) throws RemoteException {
		return stockData.delete(stockID);
	}

	@Override
	public ArrayList<String> getChangeableArea(String stockID) throws RemoteException {
		ArrayList<String> areaNum = new ArrayList<String>();
		ArrayList<StockAreaPO> areaPOs = stockData.findAreas(stockID);
		if (areaPOs == null) {
			return null;
		}
		int size = areaPOs.size();
		for (int i = 0; i < size; i++) {
			if (areaPOs.get(i).getUsedCapacity() == 0) {
				areaNum.add(areaPOs.get(i).getNumber());
			}
		}
		return areaNum;
	}

	@Override
	public String getInTime(String stockNum,String goodsNum) throws RemoteException {
		return stockData.getIntoStockTime(stockNum, goodsNum);
	}
	

}
