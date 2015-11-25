package org.cross.elsclient.network;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.cross.elscommon.dataservice.datafactoryservice.DataFactoryService;
import org.cross.elscommon.dataservice.goodsdataservice.GoodsDataService;
import org.cross.elscommon.dataservice.receiptdataservice.ReceiptDataService;
import org.cross.elscommon.dataservice.stockdataservice.StockDataService;
import org.cross.elscommon.dataservice.vehicledataservice.VehicleDataService;
import org.cross.elscommon.util.NetWork;

public class Datafactory implements DataFactoryService{

	@Override
	public StockDataService getStockData() throws RemoteException {
		// TODO Auto-generated method stub
		
		StockDataService stockdata = null;
		
		try {
			stockdata = (StockDataService)Naming.lookup(NetWork.preAddress+NetWork.port+"/stockdata");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return stockdata;
	}

	@Override
	public GoodsDataService getGoodsData() throws RemoteException {
		// TODO Auto-generated method stub
		
		GoodsDataService goodsdata = null;
		
		try {
			goodsdata = (GoodsDataService)Naming.lookup(NetWork.preAddress+NetWork.port+"/goodsdata");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return goodsdata;
	}

	@Override
	public ReceiptDataService getReceiptData() throws RemoteException {
		
		ReceiptDataService receiptdata = null;
		
		try {
			receiptdata = (ReceiptDataService)Naming.lookup(NetWork.preAddress+NetWork.port+"/receiptdata");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return receiptdata;
		
	}

	@Override
	public VehicleDataService getVehicleData() throws RemoteException {
		VehicleDataService vehicleData = null;
		try {
			vehicleData = (VehicleDataService)Naming.lookup(NetWork.preAddress+NetWork.port+"/vehicledata");
		} catch (MalformedURLException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vehicleData;
	}

}
