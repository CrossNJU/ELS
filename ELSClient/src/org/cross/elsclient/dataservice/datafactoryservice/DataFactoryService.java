package org.cross.elsclient.dataservice.datafactoryservice;

import java.rmi.RemoteException;

import org.cross.elsclient.dataservice.stockdataservice.StockDataService;

public interface DataFactoryService {
	
	public StockDataService getStockData() throws RemoteException;
}
