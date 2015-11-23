package org.cross.elsclient.blimpl.stockblimpl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.blUtility.GoodsInfo;
import org.cross.elsclient.blimpl.blUtility.ReceiptInfo;
import org.cross.elsclient.blimpl.blUtility.StockInfo;
import org.cross.elsclient.blservice.stockblservice.StockBLService;
import org.cross.elsclient.demo.StockInfoUI.returnAct;
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
import org.cross.elsclient.vo.StockOperationVO;
import org.cross.elsclient.vo.StockVO;

public class StockBLImpl implements StockBLService{
	
	public StockDataService stockData;
	GoodsInfo goodsInfo;
	StockInfo stockInfo;
	
	public StockBLImpl(StockDataService stockData,GoodsInfo goodsInfo,StockInfo stockInfo){
		this.stockData = stockData;
		this.goodsInfo = goodsInfo;
		this.stockInfo = stockInfo;
	}
	
	@Override
	public ArrayList<StockVO> showStockCheck(String stockID) {
		
		return null;
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
		ArrayList<StockAreaPO> po = stockData.findStockByNum(id).getStockAreas();
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
		StockOperationPO operationPO = new StockOperationPO(time, StockOperationType.STOCKIN, goodsID, 0, goodsVO.goodsType);
		StockPO stockPO = stockData.findStockByNum(stockID);
		ArrayList<StockAreaPO> areaPOs = stockPO.getStockAreas();
		int size = areaPOs.size();
		for (int i = 0; i < size; i++) {
			if (areaPOs.get(i).getStockType() == goodsVO.goodsType) {
				if (areaPOs.get(i).getTotalCapacity() > areaPOs.get(i).getUsedCapacity()) {
					ResultMessage res = stockData.updateInstock(stockID, areaPOs.get(i).getNumber(), operationPO);
					ResultMessage res2 = goodsInfo.updateToArea(goodsID, areaPOs.get(i).getNumber());
					if (res == ResultMessage.SUCCESS && res2 == ResultMessage.SUCCESS) {
						return ResultMessage.SUCCESS;
					}
					return ResultMessage.FAILED;
				}
			}
		}
		return ResultMessage.FAILED;
	}
	@Override
	public ResultMessage outStock(String goodsID, String stockID, String time)
			throws RemoteException {
		GoodsVO goodsVO = goodsInfo.searchGoods(goodsID);
		StockOperationPO operationPO = new StockOperationPO(time, StockOperationType.STOCKIN, goodsID, 0, goodsVO.goodsType);
		StockPO stockPO = stockData.findStockByNum(stockID);
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
	

}
