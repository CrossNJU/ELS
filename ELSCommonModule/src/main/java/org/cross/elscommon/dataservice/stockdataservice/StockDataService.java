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
	
	public ResultMessage delete(String id) throws RemoteException;
	
	public ResultMessage update(StockPO po) throws RemoteException;
	
	public ArrayList<StockOperationPO> show(String startTime, String endTime) throws RemoteException;
	
	public StockPO findStock(String ID) throws RemoteException;
	
	public boolean find(String id) throws RemoteException;
}

