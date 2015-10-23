/**
 * 单据数据桩程序
 * @author raychen
 * @date 2015/10/20
 */
package org.cross.elsclient.dataservice.receiptdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.po.ReceiptPO;
import org.cross.elsclient.util.ReceiptType;

public class ReceiptDataService_Stub implements ReceiptDataService{

	@Override
	public void insert(ReceiptPO po) {
		// TODO Auto-generated method stub
		if (po.getNumber() == "R120151023000001") {
			System.out.println("insert succeed!");
		}else System.out.println("insert failed!");
	}

	@Override
	public void delete(ReceiptPO po) {
		// TODO Auto-generated method stub
		if (po.getNumber() == "R120151023000001") {
			System.out.println("delete succeed!");
		}else System.out.println("delete failed!");
	}

	@Override
	public void update(ReceiptPO po) {
		// TODO Auto-generated method stub
		if (po.getNumber() == "R120151023000001") {
			System.out.println("update succeed!");
		}else System.out.println("update failed!");
	}

	@Override
	public ArrayList<ReceiptPO> show() {
		// TODO Auto-generated method stub
		ArrayList<ReceiptPO> list = new ArrayList<ReceiptPO>();
		list.add(new ReceiptPO("R120151023000001", ReceiptType.ORDER, "2015-10-22 10:23:22"));
		return list;
	}

	@Override
	public ReceiptPO findByID(String names) {
		// TODO Auto-generated method stub
		ReceiptPO receipt = new ReceiptPO("R120151023000001", ReceiptType.ORDER, "2015-10-22 10:23:22");
		return receipt;
	}


	@Override
	public ArrayList<ReceiptPO> findByTime(String startTime, String endTime) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<ReceiptPO> list = new ArrayList<ReceiptPO>();
		list.add(new ReceiptPO("R120151023000001", ReceiptType.ORDER, "2015-10-22 10:23:22"));
		return list;
	}

	@Override
	public ArrayList<ReceiptPO> findByType(ReceiptType type) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<ReceiptPO> list = new ArrayList<ReceiptPO>();
		list.add(new ReceiptPO("R120151023000001", ReceiptType.ORDER, "2015-10-22 10:23:22"));
		return list;
	}

	@Override
	public ArrayList<ReceiptPO> findByTimeAndType(String startTime, String endTime, ReceiptType type)
			throws RemoteException {
		ArrayList<ReceiptPO> list = new ArrayList<ReceiptPO>();
		list.add(new ReceiptPO("R120151023000001", ReceiptType.ORDER, "2015-10-22 10:23:22"));
		return list;
	}

}
