package org.cross.elsclient.blimpl.receiptblimpl;

import java.util.ArrayList;

import org.cross.elscommon.dataservice.receiptdataservice.ReceiptDataService;
import org.cross.elscommon.util.ReceiptType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elsclient.blimpl.blUtility.ReceiptInfo;
import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.vo.ReceiptVO;

public class ReceiptBLImpl implements ReceiptBLService{
	
	ReceiptDataService receiptdata;
	ReceiptInfo receiptInfo;
	
	public ReceiptBLImpl(ReceiptDataService receiptdata, ReceiptInfo receiptInfo){
		this.receiptdata = receiptdata;
		this.receiptInfo = receiptInfo;
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
	
}
