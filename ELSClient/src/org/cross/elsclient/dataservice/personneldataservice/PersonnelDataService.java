/**
 * 人员管理数据接口
 * @author Polaris Chen
 * @date 2015/10/19
 */
package org.cross.elsclient.dataservice.personneldataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.po.PersonnelPO;

public interface PersonnelDataService {

	public ArrayList<PersonnelPO> findById(String id) throws RemoteException;

	public ArrayList<PersonnelPO> findByName(String name) throws RemoteException;

	public void insert(PersonnelPO po) throws RemoteException;

	public void delete(PersonnelPO po) throws RemoteException;

	public void update(PersonnelPO po) throws RemoteException;

	public ArrayList<PersonnelPO> show() throws RemoteException;
}
