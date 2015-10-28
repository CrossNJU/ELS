package org.cross.elscommon.dataservice.userdataservice;

import java.rmi.RemoteException;

import org.cross.elscommon.po.UserPO;
import org.cross.elscommon.util.UserType;

public class UserDataService_Driver {
	
	public void drive(UserDataService userDataService) throws RemoteException{
		userDataService.insert(new UserPO("12345678", "赛文奥特曼", UserType.COUNTER));
		userDataService.delete(new UserPO("12345678", "杰克奥特曼", UserType.COUNTER));
		userDataService.update(new UserPO("12345678","爱迪奥特曼", UserType.COUNTER));
		userDataService.findByName("雷欧奥特曼");
		userDataService.findById("001");
		userDataService.findByType(UserType.COUNTER);
		userDataService.show();

	}
}
