package org.cross.elsclient.blimpl.goodsblimpl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.blUtility.GoodsInfo;
import org.cross.elsclient.vo.GoodsVO;
import org.cross.elsclient.vo.HistoryVO;
import org.cross.elscommon.dataservice.goodsdataservice.GoodsDataService;
import org.cross.elscommon.po.GoodsPO;
import org.cross.elscommon.po.HistoryPO;
import org.cross.elscommon.util.ResultMessage;

public class GoodsInfoImpl implements GoodsInfo{
	
	GoodsDataService goodsData;
	
	public GoodsInfoImpl(GoodsDataService goodsData){
		this.goodsData = goodsData;
	}

	@Override
	public GoodsVO toGoodsVO(GoodsPO po) {
		if (po == null) {
			return null;
		}
		GoodsVO goodsVO = new GoodsVO(po.getNumber(), po.getGoodsType(), po.getPlaceCity(), po.getPlaceOrg(), po.getWeight(), po.getVolume());
		ArrayList<HistoryVO> historyVOs = new ArrayList<HistoryVO>();
		ArrayList<HistoryPO> historyPOs = po.getHistory();
		int size = historyPOs.size();
		for (int i = 0; i < size; i++) {
			historyVOs.add(toHistroyVO(historyPOs.get(i)));
		}
		goodsVO.state = po.getState();
		goodsVO.history = historyVOs;
		goodsVO.orderNum = po.getOrderNum();
		return goodsVO;
	}

	@Override
	public HistoryVO toHistroyVO(HistoryPO po) {
		if (po == null) {
			return null;
		}
		HistoryVO historyVO = new HistoryVO(po.getTime(), po.getPlaceCity(), po.getPlaceOrg(), po.isArrive());
		return historyVO;
	}

	@Override
	public GoodsPO toGoodsPO(GoodsVO vo) {
		if (vo == null) {
			return null;
		}
		GoodsPO goodsPO = new GoodsPO(vo.goodsType, vo.number, vo.placeCity, vo.placeOrg, vo.weight, vo.volume);
		ArrayList<HistoryVO> historyVOs = vo.history;
		int size = historyVOs.size();
		for (int i = 0; i < size; i++) {
			goodsPO.addHistory(toHistroyPO(historyVOs.get(i)));
		}
		goodsPO.setState(vo.state);
		goodsPO.setOrderNum(vo.orderNum);
		
		return goodsPO;
	}

	@Override
	public HistoryPO toHistroyPO(HistoryVO vo) {
		if (vo == null) {
			return null;
		}
		HistoryPO historyPO = new HistoryPO(vo.time, vo.placeCity, vo.placeOrg, vo.isArrive);
		return historyPO;
	}

	@Override
	public GoodsVO searchGoods(String goodsID) throws RemoteException {
		System.out.println(goodsID);
		GoodsPO po = goodsData.findByNum(goodsID);
		GoodsVO vo = toGoodsVO(po);
		return vo;
	}

	@Override
	public ArrayList<GoodsVO> findByStockAreaNum(String stockAreaNum)
			throws RemoteException {
		ArrayList<GoodsPO> goodsPOs = goodsData.findByStockAreaNum(stockAreaNum);
		ArrayList<GoodsVO> goodsVOs = new ArrayList<GoodsVO>();
		int size = goodsPOs.size();
		for (int i = 0; i < size; i++) {
			goodsVOs.add(toGoodsVO(goodsPOs.get(i)));
		}
		return null;
	}

	@Override
	public ResultMessage updateToArea(String goodsID,String stockNum, String stockAreaNum) throws RemoteException {
		System.out.println("in");
		return goodsData.addToStock(goodsID, stockNum,stockAreaNum);
	}

	@Override
	public ResultMessage deleteFromStock(String goodsID) throws RemoteException {
		return goodsData.deleteFromStock(goodsID);
	}

	@Override
	public String findStockAreaNum(String goodsID) throws RemoteException {
		String areaNum = goodsData.findStockAreaNum(goodsID);
		return areaNum;
	}

	@Override
	public ResultMessage addToOrder(String goodsNum, String orderNum) throws RemoteException {
		return goodsData.addToOrder(goodsNum, orderNum);
	}

	@Override
	public ResultMessage addToTrans(String goodsNum, String transNum) throws RemoteException {
		return goodsData.addToTrans(goodsNum, transNum);
	}

	@Override
	public ResultMessage addToArri(String goodsNum, String arriNum) throws RemoteException {
		return goodsData.addToArri(goodsNum, arriNum);
	}

	@Override
	public ResultMessage deleteFromOrder(String goodsNum) throws RemoteException {
		return goodsData.deleteFromOrder(goodsNum);
	}

	@Override
	public ResultMessage deleteFromTrans(String goodsNum) throws RemoteException {
		return goodsData.deleteFromTrans(goodsNum);
	}

	@Override
	public ResultMessage deleteFromArri(String goodsNum) throws RemoteException {
		return goodsData.deleteFromArri(goodsNum);
	}

}
