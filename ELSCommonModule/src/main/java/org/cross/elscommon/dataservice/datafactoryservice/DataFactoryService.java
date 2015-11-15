package org.cross.elscommon.dataservice.datafactoryservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import org.cross.elscommon.dataservice.goodsdataservice.GoodsDataService;
import org.cross.elscommon.dataservice.receiptdataservice.ReceiptDataService;
import org.cross.elscommon.dataservice.stockdataservice.StockDataService;

public interface DataFactoryService {
	
	public StockDataService getStockData() throws RemoteException;
	
	public GoodsDataService getGoodsData() throws RemoteException;
	
	public ReceiptDataService getReceiptData() throws RemoteException;
}
