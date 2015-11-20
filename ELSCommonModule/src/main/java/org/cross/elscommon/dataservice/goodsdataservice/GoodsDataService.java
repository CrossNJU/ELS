/**
 * 快件管理数据接口
 * @author danni
 * @date 2015/10/22
 */
package org.cross.elscommon.dataservice.goodsdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import org.cross.elscommon.po.GoodsPO;
import org.cross.elscommon.util.City;
import org.cross.elscommon.util.GoodsState;

public interface GoodsDataService extends Remote{
	
	public void updateLocation(String id, City nowLocation) throws RemoteException;
	
	public void updateState(String id, GoodsState state) throws RemoteException;
	
	public void updateTrans(String id, int transNum) throws RemoteException;
	
	public void updateStock(String id, int stockAreaNum) throws RemoteException;
	
	public void insert(GoodsPO goods) throws RemoteException;
	
	public GoodsPO show(String id)throws RemoteException;

}
