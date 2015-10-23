/**
 * 期初建账数据桩程序
 * @author Polaris Chen
 * @date 2015/10/23
 */
package org.cross.elsclient.dataservice.initialdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.po.InitialPO;

public class InitialDataService_Stub  implements InitialDataService {

	@Override
	public void insert(InitialPO po) throws RemoteException {
		System.out.println("增加期初建账信息成功");
	}

	@Override
	public ArrayList<InitialPO> findById(String id) throws RemoteException {
		System.out.println("查找期初建账信息成功");
		ArrayList<InitialPO> list = new ArrayList<InitialPO>();
		list.add(new InitialPO(id, "2014年期初", null, null, null, null, null));
		return list;
	}

	@Override
	public ArrayList<InitialPO> show() throws RemoteException {
		System.out.println("显示期初建账信息成功");
		ArrayList<InitialPO> list = new ArrayList<InitialPO>();
		list.add(new InitialPO("I20141", "2014年期初", null, null, null, null, null));
		return list;
	}

}
