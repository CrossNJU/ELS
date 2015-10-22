/**
 * 单据数据驱动程序
 * @author raychen
 * @date 2015/10/20
 */
package org.cross.elsclient.dataservice.receiptdataservice;

import java.rmi.RemoteException;

import org.cross.elsclient.po.ReceiptPO;
import org.cross.elsclient.util.Type_receipt;

public class ReceiptDataService_Driver {
	public void drive(ReceiptDataService receiptDataService) throws RemoteException{
		System.out.println("单据：");
		receiptDataService.insert(new ReceiptPO("00001", Type_receipt.ORDER));
		receiptDataService.delete(new ReceiptPO("00001", Type_receipt.ORDER));
		receiptDataService.update(new ReceiptPO("00001", Type_receipt.ORDER));
		receiptDataService.find("00001");
		receiptDataService.show();
	}
}
