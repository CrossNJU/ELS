package org.cross.elsserver.dataimpl.receiptdataimpl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elscommon.dataservice.receiptdataservice.ReceiptDataService;
import org.cross.elscommon.po.ReceiptPO;
import org.cross.elscommon.util.CompareTime;
import org.cross.elscommon.util.Filename;
import org.cross.elscommon.util.ReceiptType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.SerIO;

public class ReceiptDataImpl implements ReceiptDataService{

	ArrayList<ReceiptPO> receipts;
	String fileName = Filename.RECEIPTPO.toString();
	
	@SuppressWarnings("unchecked")
	@Override
	public ResultMessage insert(ReceiptPO po) throws RemoteException {
		// TODO Auto-generated method stub
		receipts = (ArrayList<ReceiptPO>)SerIO.readPO(fileName);
		if(receipts == null) receipts = new ArrayList<ReceiptPO>();
		for (int i = 0; i < receipts.size(); i++) {
			if (po.getNumber().equals(receipts.get(i).getNumber())) {
				return ResultMessage.FAILED;
			}
		}
		receipts.add(po);
		SerIO.writePO(receipts, fileName);
		return ResultMessage.SUCCESS;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ResultMessage delete(ReceiptPO po) throws RemoteException {
		// TODO Auto-generated method stub
		receipts = (ArrayList<ReceiptPO>)SerIO.readPO(fileName);
		if(receipts == null) return ResultMessage.FAILED;
		for (int i = 0; i < receipts.size(); i++) {
			if (receipts.get(i).getNumber().equals(po.getNumber())) {
				receipts.remove(i);
				SerIO.writePO(receipts, fileName);
				return ResultMessage.SUCCESS;
			}
		}
		return ResultMessage.FAILED;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ResultMessage update(ReceiptPO po) throws RemoteException {
		// TODO Auto-generated method stub
		receipts = (ArrayList<ReceiptPO>)SerIO.readPO(fileName);
		if(receipts == null) return ResultMessage.FAILED;
		for (int i = 0; i < receipts.size(); i++) {
			if (receipts.get(i).getNumber().equals(po.getNumber())) {
				receipts.remove(i);
				receipts.add(po);
				SerIO.writePO(receipts, fileName);
				return ResultMessage.SUCCESS;
			}
		}
		return ResultMessage.FAILED;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<ReceiptPO> show() throws RemoteException {
		// TODO Auto-generated method stub
		receipts = (ArrayList<ReceiptPO>)SerIO.readPO(fileName);
		return receipts;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ReceiptPO findByID(String names) throws RemoteException {
		// TODO Auto-generated method stub
		receipts = (ArrayList<ReceiptPO>)SerIO.readPO(fileName);
		if(receipts == null) return null;
		for (int i = 0; i < receipts.size(); i++) {
			if (names.equals(receipts.get(i).getNumber())) {
				return receipts.get(i);
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<ReceiptPO> findByTime(String startTime, String endTime) throws RemoteException {
		// TODO Auto-generated method stub
		receipts = (ArrayList<ReceiptPO>)SerIO.readPO(fileName);
		ArrayList<ReceiptPO> pos = new ArrayList<ReceiptPO>();
		for (int i = 0; i < receipts.size(); i++) {
			ReceiptPO po = receipts.get(i);
			if (CompareTime.compare(startTime,po.getTime())<=0 
					&& CompareTime.compare(po.getTime(), endTime)<=0) {
				pos.add(po);
			}
		}
		return pos;
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
