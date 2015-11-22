package org.cross.elsserver.dataimpl.receiptdataimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import org.cross.elscommon.dataservice.receiptdataservice.ReceiptDataService;
import org.cross.elscommon.po.ReceiptPO;
import org.cross.elscommon.util.ReceiptType;
import org.cross.elscommon.util.ResultMessage;

@SuppressWarnings("serial")
public class ReceiptDataImpl extends UnicastRemoteObject implements ReceiptDataService{

	public ReceiptDataImpl() throws RemoteException {
		super();
	}

	@Override
	public ResultMessage insert(ReceiptPO po) throws RemoteException {
		if(po.getType().equals(ReceiptType.ORDER)){
			
		}
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage delete(String number) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage updateCheck(String number) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ReceiptPO> show() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReceiptPO findByNum(String number) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ReceiptPO> findByTime(String startTime, String endTime) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ReceiptPO> findByType(ReceiptType type) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ReceiptPO> findByTimeAndType(String startTime, String endTime, ReceiptType type)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
