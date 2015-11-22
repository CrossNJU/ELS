/**
 * 仓库管理数据接口
 * @author danni
 * @date 2015/10/19
 */
package org.cross.elscommon.dataservice.stockdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elscommon.po.StockOperationPO;
import org.cross.elscommon.po.StockPO;
import org.cross.elscommon.util.ResultMessage;

public interface StockDataService extends Remote{
	
	public ResultMessage insert(StockPO po) throws RemoteException;
	
	public ResultMessage delete(String number) throws RemoteException;
	
	public ResultMessage updateInstock(String stockNum, String stockAreaNum, StockOperationPO op) throws RemoteException;
	
	public ResultMessage updateOutstock(String stockNum, String stockAreaNum, StockOperationPO op) throws RemoteException;
	
	//don't understand
	public ResultMessage updateAdjust(String stockNum) throws RemoteException;
	
	//show all
	public ArrayList<StockOperationPO> showStockOps(String stockNum, String startTime, String endTime) throws RemoteException;
	
	public StockPO findStockByNum(String number) throws RemoteException;
	
}

