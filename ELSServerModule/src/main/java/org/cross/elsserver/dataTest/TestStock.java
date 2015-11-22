package org.cross.elsserver.dataTest;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elscommon.po.StockAreaPO;
import org.cross.elscommon.po.StockOperationPO;
import org.cross.elscommon.po.StockPO;
import org.cross.elscommon.util.StockOperationType;
import org.cross.elscommon.util.StockType;
import org.cross.elsserver.dataimpl.goodsdataimpl.GoodsInfoImpl;
import org.cross.elsserver.dataimpl.stockdataimpl.StockDataImpl;
import org.cross.elsserver.dataimpl.tools.GoodsTool;

public class TestStock {
	public static void main(String[] args) throws RemoteException{
		GoodsTool goodsTool = new GoodsInfoImpl();
		StockDataImpl impl = new StockDataImpl(goodsTool);
		
		StockPO test1 = new StockPO("S001", 100);
		StockAreaPO test1_a1 = new StockAreaPO("SA001", StockType.COMMON, 20);
		StockAreaPO test1_a2 = new StockAreaPO("SA002", StockType.Fast, 25);
		StockAreaPO test1_a3 = new StockAreaPO("SA003", StockType.ECONOMICAL, 30);
		StockAreaPO test1_a4 = new StockAreaPO("SA004", StockType.COMMON, 35);
		test1.setUsedAreas(4);
		ArrayList<StockAreaPO> list = new ArrayList<StockAreaPO>();
		list.add(test1_a1);
		list.add(test1_a2);
		list.add(test1_a3);
		list.add(test1_a4);
		test1.setStockAreas(list);
		
		StockOperationPO test_op1 = new StockOperationPO("2015", StockOperationType.STOCKIN, "G002", 20.3, StockType.COMMON);
		StockOperationPO test_op2 = new StockOperationPO("2012", StockOperationType.STOCKOUT, "G002", 20.3, StockType.COMMON);
		impl.updateOutstock("S001", "SA001", test_op2);
//		impl.updateInstock("S001", "SA001", test_op1);
//		impl.insert(test1);
		
//		StockPO testGet = impl.findStockByNum("S001");
//		System.out.println(testGet.getStockAreas().size());
//		System.out.println(testGet.getStockOPs().size());
	}
}
