package org.cross.elsserver.network;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import org.cross.elscommon.dataservice.datafactoryservice.DataFactoryService;
import org.cross.elscommon.util.NetWork;
import org.cross.elsserver.dataimpl.DataFactoryServiceImpl;

public class TransDataImpl {
	public static void main(String [] args){
		DataFactoryService datafactory;
		
		try {
			datafactory = new DataFactoryServiceImpl();
			LocateRegistry.createRegistry(NetWork.port);
			Naming.bind(NetWork.preAddress+NetWork.port+"/stockdata", datafactory.getStockData());
			Naming.bind(NetWork.preAddress+NetWork.port+"/goodsdata", datafactory.getGoodsData());
			Naming.bind(NetWork.preAddress+NetWork.port+"/receiptdata", datafactory.getReceiptData());
			Naming.bind(NetWork.preAddress+NetWork.port+"/vehicledata",datafactory.getVehicleData());
			Naming.bind(NetWork.preAddress+NetWork.port+"/accountdata",datafactory.getAccountData());
			Naming.bind(NetWork.preAddress+NetWork.port+"/organizationdata",datafactory.getOrganizationData());
			System.out.println("server started successfully");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
