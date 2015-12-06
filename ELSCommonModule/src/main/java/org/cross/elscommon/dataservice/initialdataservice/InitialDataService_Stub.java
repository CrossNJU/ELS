/**
 * 期初建账数据桩程序
 * @author Polaris Chen
 * @date 2015/10/23
 */
package org.cross.elscommon.dataservice.initialdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elscommon.po.InitialPO;
import org.cross.elscommon.util.ResultMessage;

public class InitialDataService_Stub  implements InitialDataService {

	@Override
	public ResultMessage insert(InitialPO po) throws RemoteException {
		System.out.println("增加期初建账信息成功");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<InitialPO> show() throws RemoteException {
		System.out.println("显示期初建账信息成功");
		ArrayList<InitialPO> list = new ArrayList<InitialPO>();
//		list.add(new InitialPO("I20141", "2014年期初",2015, null, null, null, null, null));
		return list;
	}

	@Override
	public InitialPO findByID(String initialID) {
		// TODO Auto-generated method stub
		return null;
	}

}
