/**
 * 期初建账数据接口
 * @author Polaris Chen
 * @date 2015/10/23
 */
package org.cross.elscommon.dataservice.initialdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elscommon.po.InitialPO;

public interface InitialDataService {

	public void insert(InitialPO po) throws RemoteException;

	public ArrayList<InitialPO> show() throws RemoteException;

}
