/**
 * 单据管理数据接口
 * @author raychen
 * @date 2015/10/19
 */
package org.cross.elscommon.dataservice.receiptdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elscommon.po.ReceiptPO;
import org.cross.elscommon.util.ReceiptType;
import org.cross.elscommon.util.ResultMessage;

public interface ReceiptDataService extends Remote{
	public ResultMessage insert(ReceiptPO po) throws RemoteException;
	public ResultMessage delete(String number) throws RemoteException;
	public ResultMessage updateCheck(String number) throws RemoteException;
	public ArrayList<ReceiptPO> show() throws RemoteException;
	public ReceiptPO findByNum(String number) throws RemoteException; 
	public ArrayList<ReceiptPO> findByTime(String startTime, String endTime) throws RemoteException;
	public ArrayList<ReceiptPO> findByType(ReceiptType type) throws RemoteException;
	public ArrayList<ReceiptPO> findByTimeAndType(String startTime, String endTime, ReceiptType type) throws RemoteException;
}
