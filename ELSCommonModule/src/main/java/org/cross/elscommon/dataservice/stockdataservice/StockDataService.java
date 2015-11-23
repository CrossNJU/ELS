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
import org.cross.elscommon.util.StockType;

public interface StockDataService extends Remote{
	
	public ResultMessage insert(StockPO po) throws RemoteException;
	
	public ResultMessage delete(String number) throws RemoteException;
	
	public ResultMessage updateInstock(String stockNum, String stockAreaNum, StockOperationPO op) throws RemoteException;
	
	public ResultMessage updateOutstock(String stockNum, String stockAreaNum, StockOperationPO op) throws RemoteException;
	
	//don't understand -- don't worry,我来改改( •̀ ω •́ )y
	public ResultMessage updateAdjust(String stockAreaNum,StockType type) throws RemoteException;
	
	//show all
	public ArrayList<StockOperationPO> showStockOps(String stockNum, String startTime, String endTime) throws RemoteException;
	
	public StockPO findStockByNum(String number) throws RemoteException;
	
	//更新入库单拥有仓库小间
	public ResultMessage addToInstock(String stockAreaNum, String receipt)throws RemoteException;
	public ResultMessage deleteFromInstock(String stockAreaNum) throws RemoteException;
}

