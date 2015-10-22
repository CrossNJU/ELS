package org.cross.elsclient.dataservice.userdataservice;

import org.cross.elsclient.po.UserPO;
import org.cross.elsclient.util.UserType;

public class UserDataService_Driver {
	
	public void drive(UserDataService userDataService){
		userDataService.insert(new UserPO("001", "赛文奥特曼", UserType.COUNTER));
		userDataService.delete(new UserPO("001", "杰克奥特曼", UserType.COUNTER));
		userDataService.update(new UserPO("001", "爱迪奥特曼", UserType.COUNTER));
		userDataService.findByName("雷欧奥特曼");
		userDataService.findById("001");
		userDataService.findByType(UserType.COUNTER);
		userDataService.show();

	}
}
