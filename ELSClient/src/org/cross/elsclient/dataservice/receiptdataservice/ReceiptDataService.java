/**
 * 单据管理数据接口
 * @author raychen
 * @date 2015/10/19
 */
package org.cross.elsclient.dataservice.receiptdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.po.ReceiptPO;

public interface ReceiptDataService {
	public void insert(ReceiptPO po) throws RemoteException;
	public void delete(ReceiptPO po) throws RemoteException;
	public void update(ReceiptPO po) throws RemoteException;
	public ArrayList<ReceiptPO> show() throws RemoteException;
	public ArrayList<ReceiptPO> find(String names) throws RemoteException; 
}
