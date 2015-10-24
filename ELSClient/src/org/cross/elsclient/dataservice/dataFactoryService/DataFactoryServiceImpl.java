package org.cross.elsclient.dataservice.dataFactoryService;

import java.rmi.RemoteException;

import org.cross.elsclient.dataservice.stockdataservice.StockDataService;
import org.cross.elsclient.dataservice.stockdataservice.StockDataService_Driver;
import org.cross.elsclient.dataservice.stockdataservice.StockDataService_Stub;

public class DataFactoryServiceImpl implements DataFactoryService{

	@Override
	public StockDataService getStockData() throws RemoteException {
		// TODO Auto-generated method stub
		return new StockDataService_Stub();
	}

}
