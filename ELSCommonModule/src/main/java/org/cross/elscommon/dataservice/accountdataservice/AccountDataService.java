/**
 * 账户管理数据接口
 * @author Polaris Chen
 * @date 2015/10/19
 */
package org.cross.elscommon.dataservice.accountdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elscommon.po.AccountPO;
import org.cross.elscommon.util.ResultMessage;

public interface AccountDataService extends Remote{

	public AccountPO findbyID(String ID) throws RemoteException;
	public ArrayList<AccountPO> findbyName(String name) throws RemoteException;

	public ResultMessage insert(AccountPO po) throws RemoteException;

	public ResultMessage delete(String id) throws RemoteException;

	public ResultMessage update(AccountPO po) throws RemoteException;

	public ArrayList<AccountPO> show() throws RemoteException;
}
