package org.cross.elsclient.blimpl.goodsblimpl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.blUtility.GoodsInfo;
import org.cross.elsclient.blservice.goodsblservice.GoodsBLService;
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
		// TODO Auto-generated method stub
		goodspo = goodsDataService.show(id);
		goodspo.setHistoryPO(toHistroyPO(nowHistory));
		goodspo.setGoodsState(nowState);
		goodsDataService.update(goodspo);
		
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<HistoryVO> findGoods(String id) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<HistoryVO> histroy = new ArrayList<HistoryVO>();
		
		goodspo = goodsDataService.show(id);
		if(goodspo==null) return null;
		goodsvo = toGoodsVO(goodspo);
		
		for (int i = 0; i < goodsvo.historyVO.size(); i++) {
//			System.out.println("in");
			HistoryVO vo = goodsvo.historyVO.get(i);
			histroy.add(vo);
		}
		return histroy;
	}
	
	@Override
	public GoodsVO toGoodsVO(GoodsPO po){
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HistoryPO toHistroyPO(HistoryVO vo) {
		// TODO Auto-generated method stub
		HistoryPO historyPO = new HistoryPO(vo.time, vo.place);
		return historyPO;
	}

	@Override
	public GoodsVO searchGoods(String goodsID) throws RemoteException {
		goodspo = goodsDataService.show(goodsID);
		goodsvo = toGoodsVO(goodspo);
		return goodsvo;
	}
	
//	public ArrayList<HistoryVO> toHistroyVO(GoodsPO po){}

}
