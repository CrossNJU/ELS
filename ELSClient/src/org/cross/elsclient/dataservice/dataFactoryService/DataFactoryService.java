package org.cross.elsclient.dataservice.dataFactoryService;

import java.rmi.RemoteException;

import org.cross.elsclient.dataservice.stockdataservice.StockDataService;

public interface DataFactoryService {
	
	public StockDataService getStockData() throws RemoteException;
}
