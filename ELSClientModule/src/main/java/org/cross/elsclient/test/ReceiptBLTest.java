package org.cross.elsclient.test;

import java.rmi.RemoteException;

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
		System.out.println("---test - show---");
		System.out.println("---test - findByID---");
		System.out.println("---test - findByTime---");
		System.out.println("---test - findByType---");
		System.out.println("---test - findByTimeAndType---");
		System.out.println("---test - check---");
	}
}
