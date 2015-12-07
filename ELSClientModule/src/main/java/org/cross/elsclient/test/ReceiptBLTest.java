package org.cross.elsclient.test;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.blUtility.OrganizationInfo;
import org.cross.elsclient.blimpl.blUtility.SalaryInfo;
import org.cross.elsclient.blimpl.goodsblimpl.GoodsInfoImpl;
import org.cross.elsclient.blimpl.organizationblimpl.OrganizationInfoImpl;
import org.cross.elsclient.blimpl.personnelblimpl.PersonnelInfoImpl;
import org.cross.elsclient.blimpl.receiptblimpl.ReceiptBLImpl;
import org.cross.elsclient.blimpl.receiptblimpl.ReceiptInfoImpl;
import org.cross.elsclient.blimpl.salaryblimpl.SalaryBLImpl;
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
	public static void main(String[] args) throws RemoteException {
		DataFactoryService dataFactory = new Datafactory();

		GoodsInfoImpl goodsInfo = new GoodsInfoImpl(dataFactory.getGoodsData());
		OrganizationInfo orgInfo = new OrganizationInfoImpl(
				dataFactory.getOrganizationData());
		StockInfoImpl stockInfo = new StockInfoImpl(goodsInfo, orgInfo,
				dataFactory.getStockData());
		SalaryInfo salaryInfo = new SalaryBLImpl(dataFactory.getSalaryData());
		PersonnelInfoImpl personnelInfo = new PersonnelInfoImpl(
				dataFactory.getPersonnelData(), salaryInfo);
		ReceiptInfoImpl receiptInfo = new ReceiptInfoImpl(
				dataFactory.getReceiptData());
		receiptInfo.goodsInfo = goodsInfo;
		receiptInfo.stockInfo = stockInfo;
		personnelInfo.receiptInfo = receiptInfo;
		ReceiptBLImpl receiptBLImpl = new ReceiptBLImpl(
				dataFactory.getReceiptData(), receiptInfo, goodsInfo);

		System.out.println("---test - add---");
		ArrayList<String> orderNumbers = new ArrayList<String>();
		orderNumbers.add("R0000001");
		orderNumbers.add("R0000002");
		orderNumbers.add("R0000003");
		Receipt_MoneyInVO newVO = new Receipt_MoneyInVO("2015-10-10-11:11", 20,
				"灿海", "M00002", orderNumbers, "O0000001", "P00001");
		// ReceiptVO newVO = new ReceiptVO("0001", ReceiptType.ARRIVE,
		// "2015-10-10-11:11");
		ResultMessage addMessage = receiptBLImpl.add(newVO);
		if (addMessage == ResultMessage.SUCCESS) {
			System.out.println("增加成功");
		} else {
			System.out.println("增加失败");
		}
		System.out.println("---test - delete---");
		ReceiptVO deleteVO = new ReceiptVO("R0000001", ReceiptType.ORDER,
				"2015-10-10-11:11", "P00001", "O00001");
		ResultMessage delMessage = receiptBLImpl.delete("M00001",
				ReceiptType.MONEYIN);
		if (delMessage == ResultMessage.SUCCESS) {
			System.out.println("删除成功");
		} else {
			System.out.println("删除失败");
		}
		System.out.println("---test - update---");
		Receipt_MoneyInVO updateVO = new Receipt_MoneyInVO("2015-10-10-11:11", 80,
				"灿海", "M00002", orderNumbers, "O0000001", "P00001");
		ResultMessage updateMessage = receiptBLImpl.update(updateVO);
		if (updateMessage == ResultMessage.SUCCESS) {
			System.out.println("更新成功");
		} else {
			System.out.println("更新失败");
		}
		System.out.println("---test - show---");
		ArrayList<ReceiptVO> shows = receiptBLImpl.show();
		if (shows == null) {
			System.out.println("是空的");
		} else {
			int size = shows.size();
			for (int i = 0; i < size; i++) {
				System.out.println(shows.get(i).number + " "
						+ shows.get(i).type.toString());
			}
		}
		System.out.println("---test - findByID---");
		ReceiptVO idVO = receiptBLImpl.findByID("M00002");
		if (idVO == null) {
			System.out.println("查找失败");
		} else {
			System.out.println(idVO.number + " " + idVO.time + " "
					+ idVO.type.toString());
		}

		System.out.println("---test - check---");

		System.out.println("---test - findByTime---");
		ArrayList<ReceiptVO> timeVOs = receiptBLImpl.findByTime(
				"2015-10-10 11:10:09", "2015-12-10 11:19:09");
		if (timeVOs == null) {
			System.out.println("查找失败");
		} else {
			int size2 = timeVOs.size();
			for (int i = 0; i < size2; i++) {
				System.out.println(timeVOs.get(i).number + " "
						+ timeVOs.get(i).type.toString());
			}
		}
		System.out.println("---test - findByType---");
		ArrayList<ReceiptVO> typeVO = receiptBLImpl
				.findByType(ReceiptType.MONEYIN);
		int size3 = typeVO.size();
		for (int i = 0; i < size3; i++) {
			System.out.println(typeVO.get(i).number + " " + typeVO.get(i).time
					+ " " + typeVO.get(i).type);
		}
		System.out.println("---test - findByTimeAndType---");
		ArrayList<ReceiptVO> tatVO = receiptBLImpl.findByTimeAndType(
				"2015-10-1", "2015-10-2", ReceiptType.ARRIVE);
		for (int i = 0; i < tatVO.size(); i++) {
			System.out.println(tatVO.get(i).number + " " + tatVO.get(i).time
					+ " " + tatVO.get(i).type);
		}

		System.out.println("---test - findByUser---");
		ArrayList<ReceiptVO> urVO = receiptBLImpl.findByUser("u99280");
		for (int i = 0; i < urVO.size(); i++) {
			System.out.println(urVO.get(i).number + " " + urVO.get(i).time
					+ " " + urVO.get(i).type);
		}

		System.out.println("---test - findByOrgan---");
		ArrayList<ReceiptVO> orVO = receiptBLImpl.findByOrgan("O00209");
		for (int i = 0; i < orVO.size(); i++) {
			System.out.println(orVO.get(i).number + " " + orVO.get(i).time
					+ " " + orVO.get(i).type);
		}
	}
}
