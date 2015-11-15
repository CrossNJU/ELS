/**
 * 快件管理数据接口
 * @author danni
 * @date 2015/10/22
 */
package org.cross.elscommon.dataservice.goodsdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import org.cross.elscommon.po.GoodsPO;

public interface GoodsDataService extends Remote{
	
	public void update(GoodsPO goods) throws RemoteException;
	
	public GoodsPO show(String id)throws RemoteException;

	public String justTest() throws RemoteException;
	
	public void setTestString(String s) throws RemoteException;
}
