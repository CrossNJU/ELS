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
		ResultMessage resultMessage1 = goodsData.updateLocation(id, nowHistory.placeCity, nowHistory.placeOrg);
		ResultMessage resultMessage2 = goodsData.updateState(id, nowState);
		ResultMessage resultMessage3 = goodsData.addHistory(id,goodsInfo.toHistroyPO(nowHistory));
		if (resultMessage1 == ResultMessage.FAILED || resultMessage2 == ResultMessage.FAILED || resultMessage3 == ResultMessage.FAILED) {
			return ResultMessage.FAILED;
		}
		return ResultMessage.SUCCESS;
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
		GoodsPO po = goodsData.findByNum(goodsID);
		GoodsVO vo = goodsInfo.toGoodsVO(po);
		return vo;
	}

	@Override
	public ResultMessage addGoods(GoodsVO goods) throws RemoteException {
		GoodsPO goodsPO = goodsInfo.toGoodsPO(goods);
		return goodsData.insertToDB(goodsPO);
	}

}
