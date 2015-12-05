/**
 * 快件管理数据接口
 * @author danni
 * @date 2015/10/22
 */
package org.cross.elscommon.dataservice.goodsdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elscommon.po.GoodsPO;
import org.cross.elscommon.po.HistoryPO;
import org.cross.elscommon.util.ResultMessage;

public interface GoodsDataService extends Remote{

	public ResultMessage addHistory(String number, HistoryPO history)throws RemoteException;
	public ArrayList<HistoryPO> findHistory(String number) throws RemoteException;
	
	public ResultMessage insert(GoodsPO po)throws RemoteException;
	
	public ResultMessage update(GoodsPO po)throws RemoteException;
	
	public GoodsPO findByNum(String number)throws RemoteException;
	public ArrayList<GoodsPO> findByStockAreaNum(String stockAreaNum)throws RemoteException;
	public ArrayList<GoodsPO> findByStockNum(String stockNum)throws RemoteException;
	public ArrayList<GoodsPO> findByTransNum(String transNum)throws RemoteException;
	public ArrayList<GoodsPO> findByArriNum(String arriNum)throws RemoteException;
	public ArrayList<GoodsPO> findByDelNum(String delNum)throws RemoteException;
}
