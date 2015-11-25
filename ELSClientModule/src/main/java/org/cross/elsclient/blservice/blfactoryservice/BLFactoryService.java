package org.cross.elsclient.blservice.blfactoryservice;

import java.rmi.RemoteException;

import org.cross.elsclient.blservice.userblservice.UserBLService;

public interface BLFactoryService {
	public UserBLService getUserBLService()throws RemoteException;
}
