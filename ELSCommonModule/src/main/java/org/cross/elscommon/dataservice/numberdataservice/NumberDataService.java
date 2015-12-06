package org.cross.elscommon.dataservice.numberdataservice;

import java.rmi.RemoteException;

import org.cross.elscommon.po.NumberPO;
import org.cross.elscommon.util.ResultMessage;

public interface NumberDataService {

	public ResultMessage insert(NumberPO po) throws RemoteException;

	public ResultMessage update(NumberPO po) throws RemoteException;

	public NumberPO show() throws RemoteException;
}
