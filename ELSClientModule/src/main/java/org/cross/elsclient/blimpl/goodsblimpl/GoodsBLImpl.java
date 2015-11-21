package org.cross.elsclient.blimpl.goodsblimpl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.blUtility.GoodsInfo;
import org.cross.elsclient.blservice.goodsblservice.GoodsBLService;
import org.cross.elsclient.demo.StockInfoUI.returnAct;
import org.cross.elscommon.dataservice.goodsdataservice.GoodsDataService;
import org.cross.elscommon.po.GoodsPO;
import org.cross.elscommon.po.HistoryPO;
import org.cross.elscommon.util.GoodsState;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elsclient.vo.GoodsVO;
import org.cross.elsclient.vo.HistoryVO;

public class GoodsBLImpl implements GoodsBLService,GoodsInfo{

	GoodsVO goodsvo;
	GoodsPO goodspo;
	GoodsDataService goodsDataService;
	
	public GoodsBLImpl(GoodsDataService goodsDataService){
		this.goodsDataService = goodsDataService;
	}
	
	@Override
	public ResultMessage updateGoods(String id,HistoryVO nowHistory,GoodsState nowState) throws RemoteException {
		goodspo = goodsDataService.show(id);
		if (goodspo == null) {
			return ResultMessage.FAILED;
		}
		goodspo.setHistoryPO(toHistroyPO(nowHistory));
		goodspo.setGoodsState(nowState);
		goodsDataService.updateLocation(id, nowHistory.place);
		goodsDataService.updateState(id, nowState);
		
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<HistoryVO> findGoods(String id) throws RemoteException {
		ArrayList<HistoryVO> histroy = new ArrayList<HistoryVO>();
		
		goodspo = goodsDataService.show(id);
//		GoodsPO goodspo = goodsDataService.show(id);
		if(goodspo==null){
			System.out.println("can not find it");
			return null;
		}
		System.out.println("    " + goodspo.getGoodsWeight());
		goodsvo = toGoodsVO(goodspo);
		int size = goodspo.getHistoryPO().size();
		System.out.println(size + "(size)");
		for (int i = 0; i < size; i++) {
			HistoryVO vo = goodsvo.historyVO.get(i);
			histroy.add(vo);
		}
		return histroy;
	}
	
	@Override
	public GoodsVO searchGoods(String goodsID) throws RemoteException {
		goodspo = goodsDataService.show(goodsID);
		goodsvo = toGoodsVO(goodspo);
		return goodsvo;
	}
	
	@Override
	public GoodsVO toGoodsVO(GoodsPO po){
		if (po == null) {
			return null;
		}
		GoodsVO vo = new GoodsVO(po.getGoodsWeight(), po.getGoodsVolume(), po.getCurrentLocate(),po.getGoodsType());
		vo.historyVO = toHistroyVO(po.getHistoryPO());
		vo.orderNumber = po.getOrderNumber();
		return vo;
	}

	@Override
	public ArrayList<HistoryVO> toHistroyVO(ArrayList<HistoryPO> po) {
		ArrayList<HistoryVO> histroyVO = new ArrayList<HistoryVO>();
		HistoryVO vo;
		for (int i = 0; i < po.size(); i++) {
			vo = new HistoryVO(po.get(i).getTime(), po.get(i).getPlace());
			histroyVO.add(vo);
		}
		return histroyVO;
	}

	@Override
	public GoodsPO toGoodsPO(GoodsVO vo) {
		if (vo == null) {
			return null;
		}
		GoodsPO goodsPO = new GoodsPO(vo.weightOfGoods, vo.volumeOfGoods, vo.currentLocate, vo.goodsType);
		ArrayList<HistoryPO> historyPOs = new ArrayList<HistoryPO>();
		for (int i = 0; i < vo.historyVO.size(); i++) {
			historyPOs.add(toHistroyPO(vo.historyVO.get(i)));
		}
		goodsPO.cloneHistroyFromVO(historyPOs);
		goodsPO.setOrderNumber(vo.orderNumber);
		goodsPO.setGoodsState(vo.state);
		return goodsPO;
	}

	@Override
	public HistoryPO toHistroyPO(HistoryVO vo) {
		HistoryPO historyPO = new HistoryPO(vo.time, vo.place);
		return historyPO;
	}
	
}
