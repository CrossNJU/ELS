package org.cross.elsclient.blservice.analysisblservice;

import java.util.ArrayList;

import org.cross.elsclient.util.Type_receipt;
import org.cross.elsclient.vo.ReceiptVO;

public class AnalysisBLService_Stub implements AnalysisBLService {

	@Override
	public int[] showCostBenefitTable() {
		int result[] = {40000,80000,40000};
		
		return result;
	}


	@Override
	public ArrayList<ReceiptVO> showMoneyinTable(String beginTime,
			String endTime) {
		ArrayList<ReceiptVO> table = new ArrayList<ReceiptVO>();
		
		table.add(new ReceiptVO("00001", Type_receipt.MONEYIN));
		table.add(new ReceiptVO("00002", Type_receipt.MONEYIN));
		
		return table;
	}

	@Override
	public ArrayList<ReceiptVO> showMoneyoutTable(String beginTime,
			String endTime) {
		ArrayList<ReceiptVO> table = new ArrayList<ReceiptVO>();
		
		table.add(new ReceiptVO("00001", Type_receipt.MONEYOUT));
		table.add(new ReceiptVO("00002", Type_receipt.MONEYOUT));
		
		return table;
	}

}
