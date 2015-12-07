package org.cross.elsclient.blservice.numberblservice;

import java.rmi.RemoteException;

import org.cross.elscommon.util.NumberType;
import org.cross.elscommon.util.ResultMessage;

public interface NumberBLService {
	/**
	 * 得到编号
	 * 
	 * @throws RemoteException
	 */
	public String getNumber(NumberType type);

	/**
	 * 存储下一编号，输入当前编号即可
	 */
	public ResultMessage saveNextNumber(NumberType type, String currentNum);
}
