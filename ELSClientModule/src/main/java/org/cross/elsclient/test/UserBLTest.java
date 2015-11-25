package org.cross.elsclient.test;

import java.rmi.RemoteException;

import org.cross.elsclient.blimpl.blUtility.UserInfo;
import org.cross.elsclient.blimpl.userblimpl.UserBLImpl;
import org.cross.elsclient.blimpl.userblimpl.UserInfoImpl;
import org.cross.elsclient.network.Datafactory;
import org.cross.elsclient.vo.UserVO;
import org.cross.elscommon.dataservice.datafactoryservice.DataFactoryService;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.UserType;

public class UserBLTest {
	
	public static void main(String[] args) throws RemoteException{
		DataFactoryService dataFactory = new Datafactory();
		UserInfo userInfo = new UserInfoImpl();
		UserBLImpl userBLImpl = new UserBLImpl(dataFactory.getuserdaData(), userInfo);
		
		System.out.println("=======测试addUser========");
		UserVO newVo = new UserVO("88728","123321", "daniel", UserType.COURIER);
		newVo.id = "110001";
		ResultMessage addMessage = userBLImpl.add(newVo);
		if (addMessage == ResultMessage.SUCCESS) {
			System.out.println("增加成功");
		}else {
			System.out.println("增加失败");
		}
		System.out.println("=======测试deleteUser========");
//		ResultMessage delMessage = userBLImpl.delete(id)
		System.out.println("=======测试updateUser========");
		System.out.println("=======测试findByName========");
		System.out.println("=======测试findByType========");
		System.out.println("=======测试findByID========");
		System.out.println("=======测试show========");
		System.out.println("=======测试login========");
	}

}
