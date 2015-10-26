package org.cross.elsclient.blservice.analysisblservice;

import java.util.ArrayList;

import org.cross.elscommon.util.ReceiptType;
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
		
		table.add(new ReceiptVO("00001", ReceiptType.MONEYIN,"2015-10-10"));
		table.add(new ReceiptVO("00002", ReceiptType.MONEYIN,"2015-10-10"));
		
		return table;
	}

	@Override
	public ArrayList<ReceiptVO> showMoneyoutTable(String beginTime,
			String endTime) {
		ArrayList<ReceiptVO> table = new ArrayList<ReceiptVO>();
		
		table.add(new ReceiptVO("00001", ReceiptType.MONEYOUT,"2015-10-10"));
		table.add(new ReceiptVO("00002", ReceiptType.MONEYOUT,"2015-10-10"));
		return table;
	}

}
