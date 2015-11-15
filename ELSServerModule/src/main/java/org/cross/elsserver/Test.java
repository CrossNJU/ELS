//package org.cross.elsserver;
//
//import java.rmi.RemoteException;
//import java.util.ArrayList;
//
//import org.cross.elscommon.dataservice.goodsdataservice.GoodsDataService;
//import org.cross.elscommon.po.GoodsPO;
//import org.cross.elscommon.po.HistoryPO;
//import org.cross.elscommon.po.Receipt_OrderPO;
//import org.cross.elscommon.po.StockAreaPO;
//import org.cross.elscommon.po.StockPO;
//import org.cross.elscommon.util.City;
//import org.cross.elscommon.util.StockType;
//import org.cross.elsserver.dataimpl.goodsdataimpl.GoodsDataImpl;
//import org.cross.elsserver.dataimpl.stockdataimpl.StockDataImpl;
//
//public class Test {
//	public static void main(String [] args) throws RemoteException{
//		//---------------------Goods----------------------------
//
//		GoodsPO good1 = new GoodsPO(20, 20, City.BEIJING);
//		GoodsPO good2 = new GoodsPO(20, 20, City.BEIJING);
//		GoodsPO good3 = new GoodsPO(20, 20, City.BEIJING);
//		GoodsPO good4 = new GoodsPO(20, 20, City.BEIJING);
//		Receipt_OrderPO order1 = new Receipt_OrderPO("R120151023000001", "2015-10-25 01:10:10");
//		Receipt_OrderPO order2 = new Receipt_OrderPO("R120151023000002", "2015-10-25 02:10:10");
//		Receipt_OrderPO order3 = new Receipt_OrderPO("R120151023000003", "2015-10-25 03:10:10");
//		Receipt_OrderPO order4 = new Receipt_OrderPO("R120151023000004", "2015-10-25 04:10:10");
//		good1.setOrderPO(order1);
//		good2.setOrderPO(order2);
//		good3.setOrderPO(order3);
//		good4.setOrderPO(order4);
//		good1.setHistoryPO(new HistoryPO(order1.getTime(), good1.getCurrentLocate()));
//		good2.setHistoryPO(new HistoryPO(order2.getTime(), good2.getCurrentLocate()));
//		good3.setHistoryPO(new HistoryPO(order3.getTime(), good3.getCurrentLocate()));
//		good4.setHistoryPO(new HistoryPO(order4.getTime(), good4.getCurrentLocate()));
//		
//		GoodsDataService goodsdata = new GoodsDataImpl();
//		goodsdata.update(good1);
//		goodsdata.update(good2);
//		goodsdata.update(good3);
//		goodsdata.update(good4);
//		
////		GoodsPO goods = goodsdata.show("R120151023000002");
////		System.out.println(goods.getOrderPO().getNumber());
//		
//		System.out.println("goodsok");
//		
//		StockPO stock1 = new StockPO("S00001", 10);
//		StockPO stock2 = new StockPO("S00002", 10);
//		StockPO stock3 = new StockPO("S00003", 10);
//		
//		ArrayList<StockAreaPO> stockAreaPOs1 = new ArrayList<StockAreaPO>();
//		ArrayList<StockAreaPO> stockAreaPOs2 = new ArrayList<StockAreaPO>();
//		ArrayList<StockAreaPO> stockAreaPOs3 = new ArrayList<StockAreaPO>();
//		StockAreaPO stock_1_fast = new StockAreaPO(StockType.Fast, 1000);
//		StockAreaPO stock_1_common = new StockAreaPO(StockType.COMMON, 1000);
//		StockAreaPO stock_1_economical = new StockAreaPO(StockType.ECONOMICAL, 1000);
//		StockAreaPO stock_2_fast = new StockAreaPO(StockType.Fast, 1000);
//		StockAreaPO stock_2_common = new StockAreaPO(StockType.COMMON, 1000);
//		StockAreaPO stock_2_economical = new StockAreaPO(StockType.ECONOMICAL, 1000);
//		StockAreaPO stock_3_fast = new StockAreaPO(StockType.Fast, 1000);
//		StockAreaPO stock_3_common = new StockAreaPO(StockType.COMMON, 1000);
//		StockAreaPO stock_3_economical = new StockAreaPO(StockType.ECONOMICAL, 1000);
//		stockAreaPOs1.add(stock_1_fast);
//		stockAreaPOs1.add(stock_1_common);
//		stockAreaPOs1.add(stock_1_economical);
//		stock1.setUsedArea(stock1.getUsedArea() + 3);
//		stockAreaPOs2.add(stock_2_fast);
//		stockAreaPOs2.add(stock_2_common);
//		stockAreaPOs2.add(stock_2_economical);
//		stock1.setUsedArea(stock1.getUsedArea() + 3);
//		stockAreaPOs3.add(stock_3_fast);
//		stockAreaPOs3.add(stock_3_common);
//		stockAreaPOs3.add(stock_3_economical);
//		stock1.setUsedArea(stock1.getUsedArea() + 3);
//		stock1.setSpecialStockPOs(stockAreaPOs1);
//		stock2.setSpecialStockPOs(stockAreaPOs2);
//		stock3.setSpecialStockPOs(stockAreaPOs3);
//		
//		StockDataImpl stockdata = new StockDataImpl();
//		System.out.println("ininini");
//		stockdata.insert(stock1);
////		System.out.println("end");
//	}
//}
