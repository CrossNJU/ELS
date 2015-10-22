/**
 * 单据服务驱动程序
 * @author raychen
 * @date 2015/10/20
 */
package org.cross.elsclient.blservice.receiptblservice;

import java.util.ArrayList;

import org.cross.elsclient.util.ResultMessage;
import org.cross.elsclient.util.Type_receipt;
import org.cross.elsclient.vo.ReceiptVO;

public class ReceiptBLService_Driver {
	public void drive(ReceiptBLService receiptBLService){
		
		ResultMessage result;
		
		System.out.println("增加单据的返回信息：");
		result = receiptBLService.add(new ReceiptVO("00001", Type_receipt.ORDER));
		if (result == ResultMessage.SUCCESS) {
			System.out.println("添加成功！");
		}else {
			System.out.println("添加失败");
		}
		
		System.out.println("删除单据的返回信息：");
		result = receiptBLService.delete(new ReceiptVO("00001", Type_receipt.ORDER));
		if (result == ResultMessage.SUCCESS) {
			System.out.println("删除成功！");
		}else {
			System.out.println("删除失败");
		}
		
		System.out.println("修改单据的返回信息：");
		result = receiptBLService.update(new ReceiptVO("00001", Type_receipt.ORDER));
		if (result == ResultMessage.SUCCESS) {
			System.out.println("修改成功！");
		}else {
			System.out.println("修改失败");
		}
		
		System.out.println("查找单据信息：");
		ArrayList<ReceiptVO> list = receiptBLService.find("00001");
//		list.add(new Receipt_ArriveVO())
		for (int i = 0; i < list.size(); i++) {
			System.out.println("单据编号："+list.get(i).number);
		}
		
		System.out.println("显示单据信息：");
		ArrayList<ReceiptVO> list2 = receiptBLService.show();
//		list.add(new Receipt_ArriveVO())
		for (int i = 0; i < list2.size(); i++) {
			System.out.println("单据编号："+list2.get(i).number);
		}
		
		System.out.println("审批情况：");
		result = receiptBLService.check(new ReceiptVO("00001", Type_receipt.ORDER));
		if (result ==  ResultMessage.SUCCESS) {
			System.out.println("审批通过！");
		}else {
			System.out.println("审批未通过！");
		}
	}
}
