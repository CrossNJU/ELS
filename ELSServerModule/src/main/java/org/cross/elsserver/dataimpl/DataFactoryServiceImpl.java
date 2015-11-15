package org.cross.elsserver.dataimpl;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.cross.elscommon.dataservice.datafactoryservice.DataFactoryService;
import org.cross.elscommon.dataservice.goodsdataservice.GoodsDataService;
import org.cross.elscommon.dataservice.receiptdataservice.ReceiptDataService;
import org.cross.elscommon.dataservice.receiptdataservice.ReceiptDataService_Stub;
import org.cross.elscommon.dataservice.stockdataservice.StockDataService;
import org.cross.elsserver.dataimpl.goodsdataimpl.GoodsDataImpl;
import org.cross.elsserver.dataimpl.stockdataimpl.StockDataImpl;

public class DataFactoryServiceImpl extends UnicastRemoteObject implements DataFactoryService,Serializable{

	public DataFactoryServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public StockDataService getStockData() throws RemoteException {
		// TODO Auto-generated method stub
		return new StockDataImpl();
	}

	@Override
	public GoodsDataService getGoodsData() throws RemoteException {
		// TODO Auto-generated method stub
		return new GoodsDataImpl();
	}

	@Override
	public ReceiptDataService getReceiptData() throws RemoteException {
		// TODO Auto-generated method stub
		return new ReceiptDataService_Stub();
	}

}
