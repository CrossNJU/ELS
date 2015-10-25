package org.cross.elsclient.demo;

import java.util.ArrayList;

import org.cross.elsclient.po.GoodsPO;
import org.cross.elsclient.po.StockAreaPO;
import org.cross.elsclient.po.StockOperationPO;
import org.cross.elsclient.po.StockPO;
import org.cross.elsclient.util.City;
import org.cross.elsclient.util.StockOperationType;
import org.cross.elsclient.util.StockType;

public class TestStockIO {
	public ArrayList<StockOperationPO> stockOperations;
	public ArrayList<StockPO> stocks;
	public ArrayList<StockAreaPO> stockAreas;
	
	public TestStockIO(){
		//增加仓库
		stocks = new ArrayList<StockPO>();
		StockPO stock1 = new StockPO("00001", 10);
		StockPO stock2 = new StockPO("00002", 10);
		StockPO stock3 = new StockPO("00003", 10);
		stocks.add(stock1);
		stocks.add(stock2);
		stocks.add(stock3);
		
		//增加隔间
		stockAreas = new ArrayList<StockAreaPO>();
		StockAreaPO area1 = new StockAreaPO(StockType.COMMON, 100);
		StockAreaPO area2 = new StockAreaPO(StockType.Fast, 100);
		StockAreaPO area3 = new StockAreaPO(StockType.ECONOMICAL, 100);
		stockAreas.add(area1);
		stockAreas.add(area2);
		stockAreas.add(area3);
		stock1.setSpecialStockPOs(stockAreas);
		stock2.setSpecialStockPOs(stockAreas);
		stock3.setSpecialStockPOs(stockAreas);
		
		//增加操作
		stockOperations = new ArrayList<StockOperationPO>();
		StockOperationPO op1 = new StockOperationPO("2015-10-25 10:10:10", StockOperationType.STOCKIN, 
				new GoodsPO(20, 20, City.BEIJING), 20, StockType.COMMON);
		StockOperationPO op2 = new StockOperationPO("2015-10-26 09:10:10", StockOperationType.STOCKIN, 
				new GoodsPO(20, 20, City.BEIJING), 30, StockType.COMMON);
		StockOperationPO op3 = new StockOperationPO("2015-10-25 22:10:10", StockOperationType.STOCKIN, 
				new GoodsPO(20, 20, City.BEIJING), 40, StockType.COMMON);
		StockOperationPO op4 = new StockOperationPO("2015-10-26 10:11:10", StockOperationType.STOCKOUT, 
				new GoodsPO(20, 20, City.BEIJING), 20, StockType.COMMON);
		stockOperations.add(op1);
		stockOperations.add(op2);
		stockOperations.add(op3);
		stockOperations.add(op4);
		stock1.setStockOperations(stockOperations);
		stock2.setStockOperations(stockOperations);
		stock3.setStockOperations(stockOperations);
	}
}
