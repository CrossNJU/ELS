/**
 * 系统日志数据接口
 * @author Polaris Chen
 * @date 2015/10/19
 */
package org.cross.elscommon.dataservice.logdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elscommon.po.LogPO;
import org.cross.elscommon.util.ResultMessage;

public interface LogDataService extends Remote{

	public ResultMessage insert(LogPO po) throws RemoteException;

	public ArrayList<LogPO> find(String startTime, String endTime) throws RemoteException;

	public ArrayList<LogPO> show() throws RemoteException;
}
