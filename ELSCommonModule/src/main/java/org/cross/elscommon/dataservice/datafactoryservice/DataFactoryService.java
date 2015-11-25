package org.cross.elscommon.dataservice.datafactoryservice;

import java.rmi.RemoteException;

import org.cross.elscommon.dataservice.accountdataservice.AccountDataService;
import org.cross.elscommon.dataservice.goodsdataservice.GoodsDataService;
import org.cross.elscommon.dataservice.organizationdataservice.OrganizationDataService;
import org.cross.elscommon.dataservice.receiptdataservice.ReceiptDataService;
import org.cross.elscommon.dataservice.stockdataservice.StockDataService;
import org.cross.elscommon.dataservice.vehicledataservice.VehicleDataService;

public interface DataFactoryService {
	
	public StockDataService getStockData() throws RemoteException;
	
	public GoodsDataService getGoodsData() throws RemoteException;
	
	public ReceiptDataService getReceiptData() throws RemoteException;
	
	public VehicleDataService getVehicleData() throws RemoteException;
	
	public AccountDataService getAccountData() throws RemoteException;
	
	public OrganizationDataService getOrganizationData() throws RemoteException;
}
