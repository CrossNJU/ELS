package org.cross.elsclient.blimpl.stockblimpl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.blUtility.GoodsInfo;
import org.cross.elsclient.blimpl.blUtility.StockInfo;
import org.cross.elsclient.blservice.stockblservice.StockBLService;
import org.cross.elsclient.demo.StockInfoUI.returnAct;
import org.cross.elscommon.dataservice.goodsdataservice.GoodsDataService;
import org.cross.elscommon.dataservice.stockdataservice.StockDataService;
import org.cross.elscommon.po.GoodsPO;
import org.cross.elscommon.po.StockAreaPO;
import org.cross.elscommon.po.StockOperationPO;
import org.cross.elscommon.po.StockPO;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StockType;
import org.cross.elsclient.vo.GoodsVO;
import org.cross.elsclient.vo.StockAreaVO;
import org.cross.elsclient.vo.StockOperationVO;
import org.cross.elsclient.vo.StockVO;

public class StockBLImpl implements StockBLService,StockInfo{
	
	public StockPO stockpo;
	public StockDataService stockData;
	public GoodsDataService goodsData;
	GoodsInfo goodsInfo;
	
	public StockBLImpl(StockDataService stockdata,GoodsDataService goodsData, GoodsInfo goodsInfo){
		this.stockData = stockdata;
		this.goodsData = goodsData;
		this.goodsInfo = goodsInfo;
	}
	
	@Override
	public ArrayList<StockVO> showStockCheck() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<StockOperationVO> showStockInfo(String time1, String time2) {
//		ArrayList<StockOperationVO> ops = new ArrayList<StockOperationVO>();
//		for (int i = 0; i < stockvo.stockOperations.size(); i++) {
//			StockOperationVO vo = stockvo.stockOperations.get(i);
//			if(CompareTime.compare(vo.time, time1)>=0 && 
//					CompareTime.compare(time2, vo.time)>=0){
//				ops.add(vo);
//			}
//		}
//		return ops;
		return null;
	}

	@Override
	public StockVO findStock(String ID) throws RemoteException {
		stockpo = stockData.findStock(ID);
		StockVO stockvo = toStockVO(stockpo);
		return stockvo;
	}

	@Override
	public ResultMessage exportStockCheck() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<StockAreaVO> stockCapacity(String id,StockType type) throws RemoteException {
		ArrayList<StockAreaVO> stockAreaVOs = new ArrayList<StockAreaVO>();
		stockpo = stockData.findStock(id);
		StockAreaPO stockAreaPO = null;
		if (stockpo == null) {
			return null;
		}
		
		for (int i = 0; i < stockpo.getSpecialStockPOs().size(); i++) {
			if (stockpo.getSpecialStockPOs().get(i).getStockType().equals(type)) {
				stockAreaPO = stockpo.getSpecialStockPOs().get(i);
				stockAreaVOs.add(toStockAreaVO(stockAreaPO));
//				System.out.println("used : " + stockpo.getSpecialStockPOs().get(i).getUsedCapacity());
			}
		}
		return stockAreaVOs;
	}

	@Override
	public ResultMessage checkGoods(String goodsID,String stockID) throws RemoteException {
		stockpo = stockData.findStock(stockID);
		GoodsPO goodspo = goodsData.show(goodsID);
		for (int i = 0; i < stockpo.getSpecialStockPOs().size(); i++) {
			if (stockpo.getSpecialStockPOs().get(i).getStockType() == goodspo.getGoodsType()) {
				for (int j = 0; j < stockpo.getSpecialStockPOs().get(i).getGoodsList().size(); j++) {
					if (stockpo.getSpecialStockPOs().get(i).getGoodsList().get(j).getOrderNumber().
							equals(goodspo.getOrderNumber())) {
						return ResultMessage.SUCCESS;
					}
				}
			}
		}
		return ResultMessage.FAILED;
	}

	@Override
	public ResultMessage intoStock(String goodsID,String stockID) throws RemoteException {
		// TODO 报警没写
		GoodsPO goodsPO = goodsData.show(goodsID);
		stockpo = stockData.findStock(stockID);
		if (checkGoods(goodsID, stockID) == ResultMessage.SUCCESS) {
			return ResultMessage.FAILED;
		}
		
		if (stockpo == null) {
			return ResultMessage.FAILED;
		}
		for (int i = 0; i < stockpo.getSpecialStockPOs().size(); i++) {
			if (stockpo.getSpecialStockPOs().get(i).getStockType() == goodsPO.getGoodsType()) {
				int total = stockpo.getSpecialStockPOs().get(i).getTotalCapacity();
				int used = stockpo.getSpecialStockPOs().get(i).getUsedCapacity();
				if (used < total) {
					ArrayList<GoodsPO> goodsList = stockpo.getSpecialStockPOs().get(i).getGoodsList();
					goodsList.add(goodsPO);
					stockpo.getSpecialStockPOs().get(i).setGoodList(goodsList);
					stockpo.getSpecialStockPOs().get(i).setUsedCapacity(used + 1);
					stockData.update(stockpo);
					return ResultMessage.SUCCESS;
				}
			}
		}
		
		return ResultMessage.FAILED;
	}

	@Override
	public ResultMessage outStock(String goodsID,String stockID) throws RemoteException {
		stockpo = stockData.findStock(stockID);
		GoodsPO goodspo = goodsData.show(goodsID);
		for (int i = 0; i < stockpo.getSpecialStockPOs().size(); i++) {
			if (stockpo.getSpecialStockPOs().get(i).getStockType() == goodspo.getGoodsType()) {
				for (int j = 0; j < stockpo.getSpecialStockPOs().get(i).getGoodsList().size(); j++) {
					ArrayList<GoodsPO> goodsList = stockpo.getSpecialStockPOs().get(i).getGoodsList();
					if (goodsList.get(j).getOrderNumber().
							equals(goodspo.getOrderNumber())) {
						goodsList.remove(j);
						int used = stockpo.getSpecialStockPOs().get(i).getUsedCapacity();
						stockpo.getSpecialStockPOs().get(i).setGoodList(goodsList);
						stockpo.getSpecialStockPOs().get(i).setUsedCapacity(used - 1);
						stockData.update(stockpo);
						return ResultMessage.SUCCESS;
					}
				}
			}
		}
		return ResultMessage.FAILED;
	}
		
	public ArrayList<StockAreaVO> getAreasVO(ArrayList<StockAreaPO> pos){
		ArrayList<StockAreaVO> areas = new ArrayList<StockAreaVO>();
		for (int i = 0; i < pos.size(); i++) {
			areas.add(toStockAreaVO(pos.get(i)));
		}
		return areas;
	}
	
	public ArrayList<StockOperationVO> getopVO(ArrayList<StockOperationPO> pos){
		ArrayList<StockOperationVO> ops = new ArrayList<StockOperationVO>();
		for (int i = 0; i < pos.size(); i++) {
			ops.add(toStockOperationVO(pos.get(i)));
		}
		return ops;
	}
		
	
	public ArrayList<GoodsVO> getGoodsVOs(ArrayList<GoodsPO> pos){
		ArrayList<GoodsVO> vos = new ArrayList<GoodsVO>();
		for (int i = 0; i < pos.size(); i++) {
			vos.add(goodsInfo.toGoodsVO(pos.get(i)));
		}
		return vos;
	}

	@Override
	public StockVO toStockVO(StockPO po) {
		if (po == null) {
			return null;
		}
		StockVO stockvo = new StockVO(stockpo.getStockID(),stockpo.getNumOfArea());
		stockvo.moneyIn = stockpo.getMoneyIn();
		stockvo.moneyOut = stockpo.getMoneyOut();
		stockvo.numIn = stockpo.getNumIn();
		stockvo.numInStock = stockpo.getNumInStock();
		stockvo.numOut = stockpo.getNumOut();
		stockvo.usedBooths = stockpo.getUsedArea();
		stockvo.specialStockPOs = getAreasVO(stockpo.getSpecialStockPOs());
		stockvo.stockOperations = getopVO(stockpo.getStockOperations());
		return stockvo;
	}

	@Override
	public StockAreaVO toStockAreaVO(StockAreaPO po) {
		StockAreaVO vo = new StockAreaVO(po.getStockType(), po.getTotalCapacity());
		vo.usedCapacity = po.getUsedCapacity();
		vo.goodsList = getGoodsVOs(po.getGoodsList());
		return vo;
	}

	@Override
	public StockOperationVO toStockOperationVO(StockOperationPO po) {
		StockOperationVO vo = new StockOperationVO(po.getTime(), po.getType(),
				goodsInfo.toGoodsVO(po.getGood()), po.getMoney(), po.getPlace());
		return vo;
	}

	@Override
	public ResultMessage stockAlert(String stockID, StockType stockType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage stockAdjust(String stockID, StockType stockType) {
		// TODO Auto-generated method stub
		return null;
	}
}
