package org.cross.elsclient.blimpl.goodsblimpl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.blUtility.GoodsInfo;
import org.cross.elsclient.blservice.goodsblservice.GoodsBLService;
import org.cross.elscommon.dataservice.goodsdataservice.GoodsDataService;
import org.cross.elscommon.po.GoodsPO;
import org.cross.elscommon.po.HistoryPO;
import org.cross.elscommon.util.GoodsState;
import org.cross.elscommon.util.PositionType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elsclient.vo.GoodsVO;
import org.cross.elsclient.vo.HistoryVO;

public class GoodsBLImpl implements GoodsBLService{

	public GoodsDataService goodsData;
	public GoodsInfo goodsInfo;
	
	public GoodsBLImpl(GoodsDataService goodsData,GoodsInfo goodsInfo){
		this.goodsData = goodsData;
		this.goodsInfo = goodsInfo;
	}
	
		@Override
	public ResultMessage updateGoods(String id, HistoryVO nowHistory,
			GoodsState nowState) throws RemoteException {
		GoodsPO goodsPO = goodsData.findByNum(id);
		ResultMessage addHistroy = goodsData.addHistory(id, goodsInfo.toHistroyPO(nowHistory, id));
		goodsPO.setState(nowState);
		ResultMessage updateMessage = goodsData.update(goodsPO); 
		if (updateMessage == ResultMessage.SUCCESS && addHistroy == ResultMessage.SUCCESS) {
			return ResultMessage.SUCCESS;
		}
		return ResultMessage.FAILED;
	}

	@Override
	public ArrayList<HistoryVO> findGoods(String id) throws RemoteException {
		GoodsVO goodsVO = searchGoods(id);
		if (goodsVO == null) {
			return null;
		}
		ArrayList<HistoryVO> historyVOs = goodsVO.history;
		return historyVOs;
	}

	@Override
	public GoodsVO searchGoods(String goodsID) throws RemoteException {
		System.out.println(goodsID);
		GoodsPO po = goodsData.findByNum(goodsID);
		ArrayList<HistoryPO> historyPOs = goodsData.findHistory(goodsID);
		ArrayList<HistoryVO> historyVOs = new ArrayList<HistoryVO>();
		int size = historyPOs.size();
		for (int i = 0; i < size; i++) {
			historyVOs.add(goodsInfo.toHistroyVO(historyPOs.get(i)));
		}
		GoodsVO vo = goodsInfo.toGoodsVO(po,historyVOs);
		return vo;
	}

	@Override
	public ResultMessage addGoods(GoodsVO goods) throws RemoteException {
		GoodsPO goodsPO = goodsInfo.toGoodsPO(goods);
		return goodsData.insert(goodsPO);
	}

}
