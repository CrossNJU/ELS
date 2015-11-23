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
import org.cross.elscommon.util.City;
import org.cross.elscommon.util.GoodsState;
import org.cross.elscommon.util.OrganizationType;
import org.cross.elscommon.util.ResultMessage;

public interface GoodsDataService extends Remote{
	
	public ResultMessage updateLocation(String number, City nowLocation, OrganizationType org) throws RemoteException;
	
	public ResultMessage updateState(String number, GoodsState state) throws RemoteException;
	
	//create order first, double reflect
	public ResultMessage addToOrder(String number, String orderNum) throws RemoteException;
	public ResultMessage deleteFromOrder(String number) throws RemoteException;
	
	public ResultMessage addToTrans(String number, String transNum) throws RemoteException;
	public ResultMessage deleteFromTrans(String number) throws RemoteException;
	
	public ResultMessage addToArri(String number, String arriNum) throws RemoteException;
	public ResultMessage deleteFromArri(String number) throws RemoteException;
	
	public ResultMessage addToStock(String number, String stockAreaNum) throws RemoteException;
	public ResultMessage deleteFromStock(String number) throws RemoteException;
	
	public ResultMessage addHistory(String number , HistoryPO history) throws RemoteException;
	
	public ResultMessage insertToDB(GoodsPO goods) throws RemoteException;
	
	public GoodsPO findByNum(String number)throws RemoteException;

	public ArrayList<GoodsPO> findByStockAreaNum(String stockAreaNum)throws RemoteException;
	
	public String findStockAreaNum(String number)throws RemoteException;

}
