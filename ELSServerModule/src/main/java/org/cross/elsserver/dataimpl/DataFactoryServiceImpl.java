package org.cross.elsserver.dataimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.cross.elscommon.dataservice.datafactoryservice.DataFactoryService;
import org.cross.elscommon.dataservice.goodsdataservice.GoodsDataService;
import org.cross.elscommon.dataservice.receiptdataservice.ReceiptDataService;
import org.cross.elscommon.dataservice.receiptdataservice.ReceiptDataService_Stub;
import org.cross.elscommon.dataservice.stockdataservice.StockDataService;
import org.cross.elsserver.dataimpl.goodsdataimpl.GoodsDataImpl;
import org.cross.elsserver.dataimpl.goodsdataimpl.HistoryDataImpl;
import org.cross.elsserver.dataimpl.stockdataimpl.StockDataImpl;
import org.cross.elsserver.dataimpl.tools.HistoryTool;

public class DataFactoryServiceImpl extends UnicastRemoteObject implements DataFactoryService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	HistoryTool historyTool;
	
	public DataFactoryServiceImpl() throws RemoteException {
		super();
		historyTool = new HistoryDataImpl();
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
		return new GoodsDataImpl(historyTool);
	}

	@Override
	public ReceiptDataService getReceiptData() throws RemoteException {
		// TODO Auto-generated method stub
		return new ReceiptDataService_Stub();
	}

}
