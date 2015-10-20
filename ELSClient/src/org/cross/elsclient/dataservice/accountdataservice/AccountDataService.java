/**
 * 账户管理数据接口
 * @author Polaris Chen
 * @date 2015/10/19
 */
package org.cross.elsclient.dataservice.accountdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.po.AccountPO;

public interface AccountDataService {

	public ArrayList<AccountPO> find(String name) throws RemoteException;

	public void insert(AccountPO po) throws RemoteException;

	public void delete(AccountPO po) throws RemoteException;

	public void update(AccountPO po) throws RemoteException;

	public ArrayList<AccountPO> show() throws RemoteException;
}
