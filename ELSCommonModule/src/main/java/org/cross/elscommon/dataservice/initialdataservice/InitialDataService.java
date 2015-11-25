/**
 * 期初建账数据接口
 * @author Polaris Chen
 * @date 2015/10/23
 */
package org.cross.elscommon.dataservice.initialdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elscommon.po.InitialPO;
import org.cross.elscommon.util.ResultMessage;

public interface InitialDataService extends Remote{

	public ResultMessage insert(InitialPO po) throws RemoteException;

	public ArrayList<InitialPO> show() throws RemoteException;

	public InitialPO findByID(String initialID);
}
