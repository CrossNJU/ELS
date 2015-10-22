/**
 * 单据服务桩程序
 * @author raychen
 * @date 2015/10/20
 */
package org.cross.elsclient.blservice.receiptblservice;

import java.util.ArrayList;

import org.cross.elsclient.util.ResultMessage;
import org.cross.elsclient.util.Type_receipt;
import org.cross.elsclient.vo.ReceiptVO;

public class ReceiptBLService_Stub implements ReceiptBLService{

	@Override
	public ResultMessage add(ReceiptVO vo) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage delete(ReceiptVO vo) {
		// TODO Auto-generated method stub
		if (vo.number == "00001") {
			return ResultMessage.SUCCESS;
		}else return ResultMessage.FAILED;
	}

	@Override
	public ResultMessage update(ReceiptVO vo) {
		// TODO Auto-generated method stub
		if (vo.number == "00001") {
			return ResultMessage.SUCCESS;
		}else return ResultMessage.FAILED;
	}

	@Override
	public ArrayList<ReceiptVO> show() {
		// TODO Auto-generated method stub
		ArrayList<ReceiptVO> list = new ArrayList<ReceiptVO>();
		list.add(new ReceiptVO("00001", Type_receipt.ORDER));
		list.add(new ReceiptVO("00002", Type_receipt.ORDER));
		return list;
	}

	@Override
	public ArrayList<ReceiptVO> find(String names) {
		// TODO Auto-generated method stub
		ArrayList<ReceiptVO> list = new ArrayList<ReceiptVO>();
		list.add(new ReceiptVO("00001", Type_receipt.ORDER));
		return list;
	}

	@Override
	public ResultMessage check(ReceiptVO vo) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

}
