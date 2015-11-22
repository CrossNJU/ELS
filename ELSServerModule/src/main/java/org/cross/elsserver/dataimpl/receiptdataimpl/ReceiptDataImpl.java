package org.cross.elsserver.dataimpl.receiptdataimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import org.cross.elscommon.dataservice.receiptdataservice.ReceiptDataService;
import org.cross.elscommon.po.ReceiptPO;
import org.cross.elscommon.po.Receipt_OrderPO;
import org.cross.elscommon.util.MySQL;
import org.cross.elscommon.util.ReceiptType;
import org.cross.elscommon.util.ResultMessage;

@SuppressWarnings("serial")
public class ReceiptDataImpl extends UnicastRemoteObject implements ReceiptDataService{

	private MySQL mysql;
	private Receipt_OrderDataImpl order;
	
	public ReceiptDataImpl() throws RemoteException {
		super();
		this.order = new Receipt_OrderDataImpl();
		this.mysql = new MySQL();
	}

	@Override
	public ResultMessage insert(ReceiptPO po) throws RemoteException {
		if(po.getType().equals(ReceiptType.ORDER)){
			order.insert((Receipt_OrderPO)po);
		}
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage delete(String number, ReceiptType type) throws RemoteException {
		String sql = "delete from `"+Typetotable.gettable(type)+"` where `number`='"+number+"'";
		if(mysql.execute(sql)) return ResultMessage.SUCCESS;
		else return ResultMessage.FAILED;
	}

	@Override
	public ResultMessage updateCheck(String number, ReceiptType type) throws RemoteException {
		String sql = "update `"+Typetotable.gettable(type)+"` set `isApproved`=true where `number`='"+number+"'";
		if(mysql.execute(sql)) return ResultMessage.SUCCESS;
		else return ResultMessage.FAILED;
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
