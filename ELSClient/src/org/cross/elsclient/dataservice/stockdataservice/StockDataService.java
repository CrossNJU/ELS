/**
 * 仓库管理数据接口
 * @author danni
 * @date 2015/10/19
 */
package org.cross.elsclient.dataservice.stockdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.po.StockPO;
import org.cross.elsclient.util.ResultMessage;

public interface StockDataService {
	
	public ResultMessage insert(StockPO po) throws RemoteException;
	
	public ResultMessage delete(StockPO po) throws RemoteException;
	
	public ResultMessage update(StockPO po) throws RemoteException;
	
	public ArrayList<StockPO> show() throws RemoteException;
	
	public boolean find(String id) throws RemoteException;
}

