package org.cross.elsclient.test;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.blUtility.GoodsInfo;
import org.cross.elsclient.blimpl.blUtility.ReceiptInfo;
import org.cross.elsclient.blimpl.goodsblimpl.GoodsBLImpl;
import org.cross.elsclient.blimpl.receiptblimpl.ReceiptBLImpl;
import org.cross.elsclient.network.Datafactory;
import org.cross.elsclient.vo.HistoryVO;
import org.cross.elscommon.dataservice.datafactoryservice.DataFactoryService;
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
		for (int i = 0; i < history.size(); i++) {
			System.out.println("途经 ： " + history.get(i).place + "   时间 ： " + history.get(i).time);
		}
		
		System.out.println("=======测试更新快件信息（位置和状态）(updateGoods)=======");
		HistoryVO newHistroy = new HistoryVO("2015-11-2 11:34:19", City.GUANGZHOU);
		ResultMessage resultMessage = goodsBLImpl.updateGoods("R120151023000002", newHistroy, GoodsState.LIVE);
		if (resultMessage == ResultMessage.SUCCESS) {
			System.out.println("更新成功");
		}else {
			System.out.println("更新失败");
		}
		//--------看看成功了没----------
		ArrayList<HistoryVO> history2 = goodsBLImpl.findGoods("R120151023000002");
		for (int i = 0; i < history2.size(); i++) {
			System.out.println("途经 ： " + history2.get(i).place + "   时间 ： " + history2.get(i).time);
		}

		
	}

}
