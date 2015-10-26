/**
 * 单据管理数据接口
 * @author raychen
 * @date 2015/10/19
 */
package org.cross.elscommon.dataservice.receiptdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elscommon.po.ReceiptPO;
import org.cross.elscommon.util.ReceiptType;

public interface ReceiptDataService {
	public void insert(ReceiptPO po) throws RemoteException;
	public void delete(ReceiptPO po) throws RemoteException;
	public void update(ReceiptPO po) throws RemoteException;
	public ArrayList<ReceiptPO> show() throws RemoteException;
	public ReceiptPO findByID(String names) throws RemoteException; 
	public ArrayList<ReceiptPO> findByTime(String startTime, String endTime) throws RemoteException;
	public ArrayList<ReceiptPO> findByType(ReceiptType type) throws RemoteException;
	public ArrayList<ReceiptPO> findByTimeAndType(String startTime, String endTime, ReceiptType type) throws RemoteException;
}
