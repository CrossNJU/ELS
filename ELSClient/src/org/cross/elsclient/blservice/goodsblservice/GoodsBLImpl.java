package org.cross.elsclient.blservice.goodsblservice;

import org.cross.elsclient.blservice.receiptblservice.ReceiptBLImpl;
import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.dataservice.goodsdataservice.GoodsDataService;
import org.cross.elsclient.po.GoodsPO;
import org.cross.elsclient.util.ResultMessage;
import org.cross.elsclient.vo.GoodsVO;

public class GoodsBLImpl implements GoodsBLService{
	
	ReceiptBLImpl receiptbl;
	GoodsVO goodsvo;
	GoodsPO goodspo;
	GoodsDataService goodsDataService;
	
	public GoodsBLImpl(GoodsDataService goodsDataService, ReceiptBLService receiptbl){
		this.goodsDataService = goodsDataService;
		this.receiptbl = (ReceiptBLImpl)receiptbl;
	}
	
	@Override
	public ResultMessage updateGoodsLocate(GoodsVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GoodsVO findGoods(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public GoodsVO toVO(GoodsPO po){
		GoodsVO vo = new GoodsVO(po.getGoodsWeight(), po.getGoodsVolume(), po.getCurrentLocate());
		vo.order = receiptbl.toVOsimple(po.getOrderPO());
		return vo;
	}

}
