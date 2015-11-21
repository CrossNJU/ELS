package org.cross.elsclient.test;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.blUtility.GoodsInfo;
import org.cross.elsclient.blimpl.blUtility.ReceiptInfo;
import org.cross.elsclient.blimpl.goodsblimpl.GoodsBLImpl;
import org.cross.elsclient.blimpl.receiptblimpl.ReceiptBLImpl;
import org.cross.elsclient.network.Datafactory;
import org.cross.elsclient.vo.GoodsVO;
import org.cross.elsclient.vo.HistoryVO;
import org.cross.elscommon.dataservice.datafactoryservice.DataFactoryService;
import org.cross.elscommon.dataservice.goodsdataservice.GoodsDataService;
import org.cross.elscommon.po.GoodsPO;
import org.cross.elscommon.util.City;
import org.cross.elscommon.util.GoodsState;
import org.cross.elscommon.util.ResultMessage;

public class GoodsBLTest {
	public static void main(String[] args) throws RemoteException{
		DataFactoryService datafactory = new Datafactory();
		GoodsInfo goodsInfo = new GoodsBLImpl(datafactory.getGoodsData());
		GoodsBLImpl goodsBLImpl = new GoodsBLImpl(datafactory.getGoodsData());
		ReceiptInfo receiptInfo = new ReceiptBLImpl(goodsInfo,datafactory.getReceiptData());
		
		System.out.println("=======测试快件查询（findGoods）=======");
		ArrayList<HistoryVO> history = goodsBLImpl.findGoods("R120151023000002");
		GoodsDataService goodsdata = datafactory.getGoodsData();
		GoodsPO po = goodsdata.show("R120151023000001");
		if (po!=null) {
			System.out.println(po.getGoodsVolume());
			System.out.println(po.getHistoryPO().size());
		}else {
			System.out.println("not found");
		}
		for (int i = 0; i < history.size(); i++) {
			System.out.println("途经 ： " + history.get(i).city + "   时间 ： " + history.get(i).time);
		}
		
		System.out.println("=======测试更新快件信息（位置和状态）(updateGoods)=======");
		HistoryVO newHistroy = new HistoryVO("2015-11-2 12:39:10", City.BEIJING);
		ResultMessage resultMessage = goodsBLImpl.updateGoods("R120151023000001", newHistroy, GoodsState.DIE);
		if (resultMessage == ResultMessage.SUCCESS) {
			System.out.println("更新成功");
		}else {
			System.out.println("更新失败");
		}
		//--------看看成功了没----------
		ArrayList<HistoryVO> history2 = goodsBLImpl.findGoods("R120151023000001");
		for (int i = 0; i < history2.size(); i++) {
			System.out.println("途经 ： " + history2.get(i).city + "   时间 ： " + history2.get(i).time);
		}
		System.out.println("=======测试得到快件所有信息(searchGoods)=======");
		GoodsVO goods = goodsBLImpl.searchGoods("R120151023000002");
		if (goods != null) {
			System.out.println("search successfully");
		}

		
	}

}
