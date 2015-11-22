package org.cross.elsserver.dataTest;

import java.rmi.RemoteException;

import org.cross.elsserver.dataimpl.goodsdataimpl.GoodsDataImpl;

public class TestGoods {
	public static void main(String[] args) throws RemoteException{
		GoodsDataImpl impl = new GoodsDataImpl();
//		
//		GoodsPO test1 = new GoodsPO(StockType.COMMON, "G001", City.NANJING, OrganizationType.BUSINESSHALL, 10, 10);
//		GoodsPO test2 = new GoodsPO(StockType.Fast, "G002", City.BEIJING, OrganizationType.TRANSITCENTER, 20, 20);
//		GoodsPO test3 = new GoodsPO(StockType.ECONOMICAL, "G003", City.SHANGHAI, OrganizationType.TRANSITCENTER, 30, 30);
		
//		impl.insertToDB(test1);
//		impl.insertToDB(test2);
//		impl.insertToDB(test3);
		
//		impl.updateLocation("G001", City.SHANGHAI, OrganizationType.TRANSITCENTER);
//		impl.updateState("G001", GoodsState.DIE);
		
//		GoodsPO testFind = impl.findByNum("G001");
//		System.out.println(testFind.getNumber());
		
//		impl.addToTrans("G002", "T001");
		impl.addToStock("G003", "K001");
	}
}
