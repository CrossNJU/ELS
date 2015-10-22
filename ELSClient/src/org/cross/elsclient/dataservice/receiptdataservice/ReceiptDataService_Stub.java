/**
 * 单据数据桩程序
 * @author raychen
 * @date 2015/10/20
 */
package org.cross.elsclient.dataservice.receiptdataservice;

import java.util.ArrayList;

import org.cross.elsclient.po.ReceiptPO;
import org.cross.elsclient.util.Type_receipt;

public class ReceiptDataService_Stub implements ReceiptDataService{

	@Override
	public void insert(ReceiptPO po) {
		// TODO Auto-generated method stub
		if (po.getNumber() == "00001") {
			System.out.println("insert succeed!");
		}else System.out.println("insert failed!");
	}

	@Override
	public void delete(ReceiptPO po) {
		// TODO Auto-generated method stub
		if (po.getNumber() == "00001") {
			System.out.println("delete succeed!");
		}else System.out.println("delete failed!");
		
	}

	@Override
	public void update(ReceiptPO po) {
		// TODO Auto-generated method stub
		if (po.getNumber() == "00001") {
			System.out.println("update succeed!");
		}else System.out.println("update failed!");
		
	}

	@Override
	public ArrayList<ReceiptPO> show() {
		// TODO Auto-generated method stub
		ArrayList<ReceiptPO> list = new ArrayList<ReceiptPO>();
		list.add(new ReceiptPO("00001", Type_receipt.ORDER));
		return list;
	}

	@Override
	public ArrayList<ReceiptPO> find(String names) {
		// TODO Auto-generated method stub
		ArrayList<ReceiptPO> list = new ArrayList<ReceiptPO>();
		list.add(new ReceiptPO("00001", Type_receipt.ORDER));
		return list;
	}

}
