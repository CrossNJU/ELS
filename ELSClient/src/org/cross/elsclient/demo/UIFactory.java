package org.cross.elsclient.demo;

import java.rmi.RemoteException;

import org.cross.elsclient.blservice.goodsblservice.GoodsBLImpl;
import org.cross.elsclient.blservice.goodsblservice.GoodsBLService;
import org.cross.elsclient.blservice.receiptblservice.ReceiptBLImpl;
import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.blservice.stockblservice.StockBLImpl;
import org.cross.elsclient.blservice.stockblservice.StockBLService;
import org.cross.elsclient.dataservice.datafactoryservice.DataFactoryServiceImpl;

public class UIFactory {
	
	StockBLService stockbl;
	GoodsBLService goodsbl;
	ReceiptBLService receiptbl;
	
	DataFactoryServiceImpl dataFactory;
	
	public UIFactory(){
		dataFactory = new DataFactoryServiceImpl();
		try {
			receiptbl = new ReceiptBLImpl(dataFactory.getReceiptData());
			goodsbl = new GoodsBLImpl(dataFactory.getGoodsData(), receiptbl);
			stockbl = new StockBLImpl(dataFactory.getStockData(), receiptbl, goodsbl);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public StockUI getStockUI(){
		return new StockUI(stockbl);
	}
}
