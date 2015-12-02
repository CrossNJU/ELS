package org.cross.elsclient.test;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.goodsblimpl.GoodsInfoImpl;
import org.cross.elsclient.blimpl.personnelblimpl.PersonnelInfoImpl;
import org.cross.elsclient.blimpl.receiptblimpl.ReceiptBLImpl;
import org.cross.elsclient.blimpl.receiptblimpl.ReceiptInfoImpl;
import org.cross.elsclient.blimpl.stockblimpl.StockInfoImpl;
import org.cross.elsclient.network.Datafactory;
import org.cross.elsclient.vo.PersonnelVO;
import org.cross.elsclient.vo.ReceiptVO;
import org.cross.elsclient.vo.Receipt_ArriveVO;
import org.cross.elsclient.vo.Receipt_MoneyInVO;
import org.cross.elscommon.dataservice.datafactoryservice.DataFactoryService;
import org.cross.elscommon.util.City;
import org.cross.elscommon.util.OrganizationType;
import org.cross.elscommon.util.PositionType;
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
		Receipt_MoneyInVO newVO = new Receipt_MoneyInVO("2015-10-10-11:11", 20, 
				new PersonnelVO("P00001", "灿海", PositionType.ADMINISTRATOR, OrganizationType.BUSINESSHALL, "O00001"), "M00002");
//		ReceiptVO newVO = new ReceiptVO("0001", ReceiptType.ARRIVE, "2015-10-10-11:11");
		ResultMessage addMessage = receiptBLImpl.add(newVO);
		if (addMessage == ResultMessage.SUCCESS) {
			System.out.println("增加成功");
		}else {
			System.out.println("增加失败");
		}
//		System.out.println("---test - delete---");
////		ReceiptVO deleteVO = new ReceiptVO("P00001", ReceiptType.MONEYIN, "2015-10-10-11:11");
//		ResultMessage delMessage = receiptBLImpl.delete("M00001",ReceiptType.MONEYIN);
//		if (delMessage == ResultMessage.SUCCESS) {
//			System.out.println("删除成功");
//		}else {
//			System.out.println("删除失败");
//		}
		System.out.println("---test - update---");
		Receipt_MoneyInVO updateVO = new Receipt_MoneyInVO("2015-12-10-11:11", 40, 
				new PersonnelVO("P00001", "灿海", PositionType.ADMINISTRATOR, OrganizationType.BUSINESSHALL, "O00001"), "M00001");
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
		ReceiptVO idVO = receiptBLImpl.findByID("M00002");
		if (idVO == null) {
			System.out.println("查找失败");
		}else {
			System.out.println(idVO.number + " " + idVO.time + " " + idVO.type.toString());
		}
		System.out.println("---test - findByTime---");
		ArrayList<ReceiptVO> timeVOs = receiptBLImpl.findByTime("2015-10-10 11:10:09", "2015-12-10 11:19:09");
		if (timeVOs == null) {
			System.out.println("查找失败");
		}else {
			int size2 = timeVOs.size();
			for (int i = 0; i < size2; i++) {
				System.out.println(timeVOs.get(i).number + " " + timeVOs.get(i).type.toString());
			}
		}
		System.out.println("---test - findByType---");
		ArrayList<ReceiptVO> typeVO = receiptBLImpl.findByType(ReceiptType.MONEYIN);
		int size3 = typeVO.size();
		for (int i = 0; i < size3; i++) {
			System.out.println(typeVO.get(i).number + " " + typeVO.get(i).time + " " + typeVO.get(i).type);
		}
//		System.out.println("---test - findByTimeAndType---");
//		System.out.println("---test - check---");
	}
}
