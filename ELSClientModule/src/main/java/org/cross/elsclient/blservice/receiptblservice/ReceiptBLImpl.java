package org.cross.elsclient.blservice.receiptblservice;

import java.util.ArrayList;

import org.cross.elscommon.dataservice.receiptdataservice.ReceiptDataService;
import org.cross.elscommon.po.Receipt_OrderPO;
import org.cross.elscommon.util.ReceiptType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elsclient.vo.ReceiptVO;
import org.cross.elsclient.vo.Receipt_OrderVO;

public class ReceiptBLImpl implements ReceiptBLService{
	
	ReceiptDataService receiptDataService;
	
	public ReceiptBLImpl(ReceiptDataService receiptDataService){
		this.receiptDataService = receiptDataService;
	}

	@Override
	public ResultMessage add(ReceiptVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage delete(ReceiptVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage update(ReceiptVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ReceiptVO> show() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReceiptVO findByID(String names) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage check(ReceiptVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ReceiptVO> findByTime(String startTime, String endTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ReceiptVO> findByType(ReceiptType type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ReceiptVO> findByTimeAndType(String startTime, String endTime, ReceiptType type) {
		// TODO Auto-generated method stub
		return null;
	}

	public Receipt_OrderVO toVOsimple(Receipt_OrderPO po){
		Receipt_OrderVO vo = new Receipt_OrderVO(po.getNumber(), po.getExpectTime());
		return vo;
	}
}
