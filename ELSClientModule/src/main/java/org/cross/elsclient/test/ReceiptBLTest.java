package org.cross.elsclient.test;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.goodsblimpl.GoodsInfoImpl;
import org.cross.elsclient.blimpl.personnelblimpl.PersonnelInfoImpl;
import org.cross.elsclient.blimpl.receiptblimpl.ReceiptBLImpl;
import org.cross.elsclient.blimpl.receiptblimpl.ReceiptInfoImpl;
import org.cross.elsclient.blimpl.stockblimpl.StockInfoImpl;
import org.cross.elsclient.network.Datafactory;
import org.cross.elsclient.vo.ReceiptVO;
import org.cross.elscommon.dataservice.datafactoryservice.DataFactoryService;
import org.cross.elscommon.util.ReceiptType;
import org.cross.elscommon.util.ResultMessage;

public class ReceiptBLTest {
	public static void main(String[] args) throws RemoteException{
		DataFactoryService dataFactory = new Datafactory();
		
		GoodsInfoImpl goodsInfo = new GoodsInfoImpl(dataFactory.getGoodsData());
		StockInfoImpl stockInfo = new StockInfoImpl(goodsInfo);
		PersonnelInfoImpl personnelInfo = new PersonnelInfoImpl();
		ReceiptInfoImpl receiptInfo = new ReceiptInfoImpl(dataFactory.getReceiptData(), stockInfo, personnelInfo);
		personnelInfo.receiptInfo = receiptInfo;
		ReceiptBLImpl receiptBLImpl = new ReceiptBLImpl(dataFactory.getReceiptData(), receiptInfo, goodsInfo);
		
		System.out.println("---test - add---");
		ReceiptVO newVO = new ReceiptVO("0001", ReceiptType.ARRIVE, "2015-10-10-11:11");
		ResultMessage addMessage = receiptBLImpl.add(newVO);
		if (addMessage == ResultMessage.SUCCESS) {
			System.out.println("增加成功");
		}else {
			System.out.println("增加失败");
		}
		System.out.println("---test - delete---");
		ReceiptVO deleteVO = new ReceiptVO("0001", ReceiptType.ARRIVE, "2015-10-10-11:11");
		ResultMessage delMessage = receiptBLImpl.delete(deleteVO);
		if (delMessage == ResultMessage.SUCCESS) {
			System.out.println("删除成功");
		}else {
			System.out.println("删除失败");
		}
		System.out.println("---test - update---");
		ReceiptVO updateVO = new ReceiptVO("0001", ReceiptType.MONEYIN, "2015-10-10-11:11");
		ResultMessage updateMessage = receiptBLImpl.update(updateVO);
		if (updateMessage == ResultMessage.SUCCESS) {
			System.out.println("更新成功");
		}else {
			System.out.println("更新失败");
		}
		System.out.println("---test - show---");
		ArrayList<ReceiptVO> shows = receiptBLImpl.show();
		if (shows == null) {
			System.out.println("是空的");
		}else {
			int size = shows.size();
			for (int i = 0; i < size; i++) {
				System.out.println(shows.get(i).number + " " + shows.get(i).type.toString());
			}
		}
		System.out.println("---test - findByID---");
		ReceiptVO idVO = receiptBLImpl.findByID("0001");
		if (idVO == null) {
			System.out.println("查找失败");
		}else {
			System.out.println(idVO.number + " " + idVO.time + " " + idVO.type.toString());
		}
		System.out.println("---test - findByTime---");
		ArrayList<ReceiptVO> timeVOs = receiptBLImpl.findByTime("2015-10-10-11:11", "2015-10-10-11:20");
		if (timeVOs == null) {
			System.out.println("查找失败");
		}else {
			int size2 = timeVOs.size();
			for (int i = 0; i < size2; i++) {
				System.out.println(timeVOs.get(i).number + " " + timeVOs.get(i).type.toString());
			}
		}
		System.out.println("---test - findByType---");
		System.out.println("---test - findByTimeAndType---");
		System.out.println("---test - check---");
	}
}
