package org.cross.elsclient.blimpl.blfactoryimpl;

import java.rmi.RemoteException;

import org.cross.elsclient.blimpl.blUtility.UserInfo;
import org.cross.elsclient.blimpl.userblimpl.UserBLImpl;
import org.cross.elsclient.blimpl.userblimpl.UserInfoImpl;
import org.cross.elsclient.blservice.blfactoryservice.BLFactoryService;
import org.cross.elsclient.blservice.userblservice.UserBLService;
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

}
