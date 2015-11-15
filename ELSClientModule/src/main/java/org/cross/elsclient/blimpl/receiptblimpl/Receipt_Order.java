package org.cross.elsclient.blimpl.receiptblimpl;

import org.cross.elsclient.vo.Receipt_OrderVO;
import org.cross.elscommon.po.GoodsPO;
import org.cross.elscommon.po.HistoryPO;
import org.cross.elscommon.util.City;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StockType;

public class Receipt_Order {
	
	/**
	 * 增加订单，创建Goods,更新PersonnelPO
	 * @param vo
	 * @return
	 */
	public ResultMessage add(Receipt_OrderVO vo){
		Receipt_OrderVO order = (Receipt_OrderVO)vo;
		
		MockGoods goodUT = new MockGoods();
		GoodsPO po = goodUT.toPO(order.goods);
		if(po == null) return ResultMessage.FAILED;
		
		HistoryPO history = new HistoryPO(order.time, order.startPlace);
		po.setHistoryPO(history);
		
		return goodUT.add(po);
		
//		MockConstant constantUT = new MockConstant();
//		order.expectTime = constantUT.expectTime(order.startPlace, order.targetPlace);
//		order.cost = constantUT.price(order.startPlace, order.targetPlace, order.goods.weightOfGoods);
	}
	
//	/**
//	 * 寻找订单
//	 * @return
//	 */
//	public ArrayList<Receipt_OrderPO> find(){
//		GoodsPO good1 = new GoodsPO(20, 20, City.BEIJING,StockType.COMMON);
//		GoodsPO good2 = new GoodsPO(20, 20, City.BEIJING,StockType.COMMON);
//		GoodsPO good3 = new GoodsPO(20, 20, City.BEIJING,StockType.COMMON);
//		GoodsPO good4 = new GoodsPO(20, 20, City.BEIJING,StockType.Fast);
//		Receipt_OrderPO order1 = new Receipt_OrderPO("R120151023000001", "2015-10-25 01:10:10");
//		Receipt_OrderPO order2 = new Receipt_OrderPO("R120151023000002", "2015-10-25 02:10:10");
//		Receipt_OrderPO order3 = new Receipt_OrderPO("R120151023000003", "2015-10-25 03:10:10");
//		Receipt_OrderPO order4 = new Receipt_OrderPO("R120151023000004", "2015-10-25 04:10:10");
//		order1.setGoods(good1);
//		order2.setGoods(good2);
//		order3.setGoods(good3);
//		order4.setGoods(good4);
//		ArrayList<Receipt_OrderPO> pos = new ArrayList<Receipt_OrderPO>();
//		pos.add(order1);
//		pos.add(order2);
//		pos.add(order3);
//		pos.add(order4);
//		return pos;
//	}
	
	/**
	 * Goods被送达，更新订单信息（未完成。。。），更新Goods历史轨迹
	 * @param vo
	 * @return
	 */
	public ResultMessage update(Receipt_OrderVO vo){
		Receipt_OrderVO order = vo;
		
		HistoryPO history = new HistoryPO(order.expectTime, order.targetPlace);
		
		MockGoods goodsUT = new MockGoods();
		GoodsPO po = goodsUT.toPO(order.goods);
		if(po ==  null) return ResultMessage.FAILED;
		
		po.setHistoryPO(history);
		return goodsUT.update(po);
	}

	/**
	 * 根据单号查找快递
	 * @param id
	 * @return
	 */
	public GoodsPO findByID(String id){
		return new GoodsPO(20, 10, City.NANJING, StockType.COMMON);
	}
}
