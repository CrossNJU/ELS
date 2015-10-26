package org.cross.elsclient.dataservice.datafactoryservice;

import java.rmi.RemoteException;

import org.cross.elsclient.dataservice.goodsdataservice.GoodsDataService;
import org.cross.elsclient.dataservice.receiptdataservice.ReceiptDataService;
import org.cross.elsclient.dataservice.stockdataservice.StockDataService;

public interface DataFactoryService {
	
	public StockDataService getStockData() throws RemoteException;
	
	public GoodsDataService getGoodsData() throws RemoteException;
	
	public ReceiptDataService getReceiptData() throws RemoteException;
}
