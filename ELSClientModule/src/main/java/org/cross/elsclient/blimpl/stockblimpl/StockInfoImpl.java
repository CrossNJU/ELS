package org.cross.elsclient.blimpl.stockblimpl;

import java.util.ArrayList;

import org.cross.elsclient.blimpl.blUtility.GoodsInfo;
import org.cross.elsclient.blimpl.blUtility.StockInfo;
import org.cross.elsclient.vo.GoodsVO;
import org.cross.elsclient.vo.StockAreaVO;
import org.cross.elsclient.vo.StockOperationVO;
import org.cross.elsclient.vo.StockVO;
import org.cross.elscommon.po.GoodsPO;
import org.cross.elscommon.po.StockAreaPO;
import org.cross.elscommon.po.StockOperationPO;
import org.cross.elscommon.po.StockPO;

public class StockInfoImpl implements StockInfo{
	
		public GoodsInfo goodsInfo;
		
		public StockInfoImpl(){
			
		}
		
		public StockInfoImpl(GoodsInfo goodsInfo){
			this.goodsInfo = goodsInfo;
		}

	@Override
	public StockVO toStockVO(StockPO po) {
		if (po == null) {
			return null;
		}
		StockVO stockVO = new StockVO(po.getNumber(), po.getTotalAreas());
		ArrayList<StockAreaVO> stockAreaVOs = new ArrayList<StockAreaVO>();
		ArrayList<StockOperationVO> stockOperationVOs = new ArrayList<StockOperationVO>();
		
		ArrayList<StockAreaPO> stockAreaPOs = po.getStockAreas();
		ArrayList<StockOperationPO> stockOperationPOs = po.getStockOPs();
		int areaSize = stockAreaPOs.size();
		int opSize = stockOperationPOs.size();
		for (int i = 0; i < areaSize; i++) {
			stockAreaVOs.add(toStockAreaVO(stockAreaPOs.get(i)));
		}
		for (int i = 0; i < opSize; i++) {
			stockOperationVOs.add(toStockOperationVO(stockOperationPOs.get(i)));
		}
		
		stockVO.stockAreas = stockAreaVOs;
		stockVO.stockOPs = stockOperationVOs;
		stockVO.usedAreas = po.getUsedAreas();
		stockVO.outNum = po.getOutNum();
		stockVO.inNum = po.getInNum();
		stockVO.inMoney = po.getInMoney();
		stockVO.outMoney = po.getOutMoney();
		stockVO.numInStock = po.getNumInStock();
		return stockVO;
	}

	@Override
	public StockAreaVO toStockAreaVO(StockAreaPO po) {
		if (po == null) {
			return null;
		}
		StockAreaVO stockAreaVO = new StockAreaVO(po.getNumber(), po.getStockType(), po.getTotalCapacity());
		ArrayList<GoodsVO> goodsVOs = new ArrayList<GoodsVO>();
		ArrayList<GoodsPO> goodsPOs = po.getGoodslist();
		int size = goodsPOs.size();
		for (int i = 0; i < size; i++) {
			goodsVOs.add(goodsInfo.toGoodsVO(goodsPOs.get(i)));
		}
		stockAreaVO.goodsList = goodsVOs;
		stockAreaVO.usedCapacity = po.getUsedCapacity();
		
		return stockAreaVO;
	}

	@Override
	public StockOperationVO toStockOperationVO(StockOperationPO po) {
		if (po == null) {
			return null;
		}
		StockOperationVO stockOperationVO = new StockOperationVO(po.getTime(), po.getType(), po.getGoodNum(), po.getMoney(), po.getPlace());
		return stockOperationVO;
	}

	@Override
	public StockPO toStockPO(StockVO vo) {
		if (vo == null) {
			return null;
		}
		StockPO stockPO = new StockPO(vo.number, vo.totalAreas);
		ArrayList<StockAreaVO> stockAreaVOs = vo.stockAreas;
		ArrayList<StockOperationVO> stockOperationVOs = vo.stockOPs;
		
		ArrayList<StockAreaPO> stockAreaPOs = new ArrayList<StockAreaPO>();
		ArrayList<StockOperationPO> stockOperationPOs = new ArrayList<StockOperationPO>();
		int areaSize = stockAreaVOs.size();
		int opSize = stockOperationVOs.size();
		for (int i = 0; i < areaSize; i++) {
			stockAreaPOs.add(toStockAreaPO(stockAreaVOs.get(i)));
		}
		for (int i = 0; i < opSize; i++) {
			stockOperationPOs.add(toStockOperationPO(stockOperationVOs.get(i)));
		}
		
		stockPO.setStockAreas(stockAreaPOs);
		stockPO.setStockOPs(stockOperationPOs);
		stockPO.setUsedAreas(vo.usedAreas);
		stockPO.setOutNum(vo.outNum);
		stockPO.setInNum(vo.inNum);
		stockPO.setInMoney(vo.inMoney);
		stockPO.setOutMoney(vo.outMoney);
		stockPO.setNumInStock(vo.numInStock);
		return stockPO;
	}

	@Override
	public StockAreaPO toStockAreaPO(StockAreaVO vo) {
		if (vo == null) {
			return null;
		}
		StockAreaPO stockAreaPO = new StockAreaPO(vo.number, vo.stockType, vo.totalCapacity);
		ArrayList<GoodsVO> goodsVOs = vo.goodsList;
		ArrayList<GoodsPO> goodsPOs = new ArrayList<GoodsPO>();
		int size = goodsVOs.size();
		for (int i = 0; i < size; i++) {
			goodsPOs.add(goodsInfo.toGoodsPO(goodsVOs.get(i)));
		}
		stockAreaPO.setGoodslist(goodsPOs);
		stockAreaPO.setUsedCapacity(vo.usedCapacity);
		
		return stockAreaPO;
	}

	@Override
	public StockOperationPO toStockOperationPO(StockOperationVO vo) {
		if (vo == null) {
			return null;
		}
		StockOperationPO stockOperationPO = new StockOperationPO(vo.time, vo.type, vo.goodNum, vo.money, vo.place);
		return stockOperationPO;
	}

}
