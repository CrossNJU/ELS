/**
 * 人员管理数据接口
 * @author Polaris Chen
 * @date 2015/10/19
 */
package org.cross.elscommon.dataservice.personneldataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elscommon.po.PersonnelPO;
import org.cross.elscommon.util.ResultMessage;

public interface PersonnelDataService {

	public PersonnelPO findById(String id) throws RemoteException;

	public ArrayList<PersonnelPO> findByName(String name) throws RemoteException;

	public ResultMessage insert(PersonnelPO po) throws RemoteException;

	public ResultMessage delete(String id) throws RemoteException;

	public ResultMessage update(PersonnelPO po) throws RemoteException;

	public ArrayList<PersonnelPO> show() throws RemoteException;
}
