package org.cross.elsserver.dataimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.cross.elscommon.dataservice.datafactoryservice.DataFactoryService;
import org.cross.elscommon.dataservice.goodsdataservice.GoodsDataService;
import org.cross.elscommon.dataservice.receiptdataservice.ReceiptDataService;
import org.cross.elscommon.dataservice.stockdataservice.StockDataService;
import org.cross.elscommon.dataservice.vehicledataservice.VehicleDataService;
import org.cross.elsserver.dataimpl.goodsdataimpl.GoodsDataImpl;
import org.cross.elsserver.dataimpl.goodsdataimpl.GoodsInfoImpl;
import org.cross.elsserver.dataimpl.goodsdataimpl.HistoryDataImpl;
import org.cross.elsserver.dataimpl.receiptdataimpl.ReceiptDataImpl;
import org.cross.elsserver.dataimpl.stockdataimpl.StockDataImpl;
import org.cross.elsserver.dataimpl.tools.GoodsTool;
import org.cross.elsserver.dataimpl.tools.HistoryTool;
import org.cross.elsserver.dataimpl.vehicledataimpl.VehicleDataImpl;

public class DataFactoryServiceImpl extends UnicastRemoteObject implements DataFactoryService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HistoryTool historyTool;
	private GoodsTool goodsTool;
	
	public DataFactoryServiceImpl() throws RemoteException {
		super();
		historyTool = new HistoryDataImpl();
		goodsTool = new GoodsInfoImpl();
		// TODO Auto-generated constructor stub
	}

	@Override
	public StockDataService getStockData() throws RemoteException {
		// TODO Auto-generated method stub
		return new StockDataImpl(goodsTool);
	}

	@Override
	public GoodsDataService getGoodsData() throws RemoteException {
		// TODO Auto-generated method stub
		return new GoodsDataImpl(historyTool);
	}

	@Override
	public ReceiptDataService getReceiptData() throws RemoteException {
		// TODO Auto-generated method stub
		return new ReceiptDataImpl();
	}

	@Override
	public VehicleDataService getVehicleData() throws RemoteException {
		// TODO Auto-generated method stub
		return new VehicleDataImpl();
	}

}
