package org.cross.elsclient.blimpl.blUtility;

import java.rmi.RemoteException;

import org.cross.elscommon.po.SalaryPO;

public interface SalaryInfo {
	
	public SalaryPO findbyPerNum(String perNum) throws RemoteException; 

}
