package org.cross.elsclient.blservice.numberblservice;

import java.rmi.RemoteException;

import org.cross.elscommon.po.NumberPO;
import org.cross.elscommon.util.NumberType;
import org.cross.elscommon.util.ResultMessage;

public interface NumberBLService {
	/**
	 * 得到编号
	 * 
	 * @throws RemoteException
	 */
	public String getPostNumber(NumberType type);
	public NumberPO getPO()throws RemoteException;
}
