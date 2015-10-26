package org.cross.elscommon.dataservice.datafactoryservice;

import java.rmi.RemoteException;

import org.cross.elscommon.dataservice.goodsdataservice.GoodsDataService;
import org.cross.elscommon.dataservice.goodsdataservice.GoodsDataService_Stub;
import org.cross.elscommon.dataservice.receiptdataservice.ReceiptDataService;
import org.cross.elscommon.dataservice.receiptdataservice.ReceiptDataService_Stub;
import org.cross.elscommon.dataservice.stockdataservice.StockDataService;
import org.cross.elscommon.dataservice.stockdataservice.StockDataService_Stub;

public class DataFactoryServiceImpl implements DataFactoryService{

	@Override
	public StockDataService getStockData() throws RemoteException {
		// TODO Auto-generated method stub
		return new StockDataService_Stub();
	}

	@Override
	public GoodsDataService getGoodsData() throws RemoteException {
		// TODO Auto-generated method stub
		return new GoodsDataService_Stub();
	}

	@Override
	public ReceiptDataService getReceiptData() throws RemoteException {
		// TODO Auto-generated method stub
		return new ReceiptDataService_Stub();
	}

}
