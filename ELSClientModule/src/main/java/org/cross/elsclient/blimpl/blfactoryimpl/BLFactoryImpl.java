package org.cross.elsclient.blimpl.blfactoryimpl;

import java.rmi.RemoteException;

import org.cross.elsclient.blimpl.blUtility.UserInfo;
import org.cross.elsclient.blimpl.userblimpl.UserBLImpl;
import org.cross.elsclient.blimpl.userblimpl.UserInfoImpl;
import org.cross.elsclient.blservice.accountblservice.AccountBLService;
import org.cross.elsclient.blservice.analysisblservice.AnalysisBLService;
import org.cross.elsclient.blservice.blfactoryservice.BLFactoryService;
import org.cross.elsclient.blservice.constantblservice.ConstantBLService;
import org.cross.elsclient.blservice.goodsblservice.GoodsBLService;
import org.cross.elsclient.blservice.initialblservice.InitialBLService;
import org.cross.elsclient.blservice.logblservice.LogBLService;
import org.cross.elsclient.blservice.organizationblservice.OrganizationBLService;
import org.cross.elsclient.blservice.personnelblservice.PersonnelBLService;
import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.blservice.stockblservice.StockBLService;
import org.cross.elsclient.blservice.userblservice.UserBLService;
import org.cross.elsclient.blservice.vehicleblservice.VehicleBLService;
import org.cross.elsclient.network.Datafactory;
import org.cross.elscommon.dataservice.datafactoryservice.DataFactoryService;
import org.cross.elscommon.dataservice.userdataservice.UserDataService;

public class BLFactoryImpl implements BLFactoryService{

	UserDataService userDataService;
	UserInfo userInfo;
	DataFactoryService dataFactoryService;
	
	public BLFactoryImpl() throws RemoteException{
		this.dataFactoryService = new Datafactory();
		this.userDataService = dataFactoryService.getuserdaData();
		this.userInfo = new UserInfoImpl();
	}
	
	@Override
	public UserBLService getUserBLService() throws RemoteException {
		
		return new UserBLImpl(userDataService, userInfo);
	}

	@Override
	public AccountBLService getAccountBLService() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AnalysisBLService analysisBLService() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ConstantBLService constantBLService() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GoodsBLService goodsBLService() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InitialBLService initialBLService() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LogBLService logBLService() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrganizationBLService organizationBLService() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonnelBLService personnelBLService() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReceiptBLService receiptBLService() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StockBLService stockBLService() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VehicleBLService vehicleBLService() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
