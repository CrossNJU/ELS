package org.cross.elsclient.blimpl.analysisblimpl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.blUtility.ReceiptInfo;
import org.cross.elsclient.blservice.analysisblservice.AnalysisBLService;
import org.cross.elsclient.vo.ReceiptVO;
import org.cross.elsclient.vo.Receipt_MoneyInVO;
import org.cross.elsclient.vo.Receipt_MoneyOutVO;
import org.cross.elscommon.po.Receipt_MoneyInPO;
import org.cross.elscommon.util.ReceiptType;

public class AnalysisBLImpl implements AnalysisBLService {

	ReceiptInfo receiptInfo;

	public AnalysisBLImpl(ReceiptInfo receiptInfo) {
		this.receiptInfo = receiptInfo;
	}

	@Override
	public double[] showCostBenefitTable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Receipt_MoneyInVO> showMoneyinTable(String beginTime,
			String endTime) throws RemoteException {
		ArrayList<ReceiptVO> receiptVOs = receiptInfo.findByTimeAndType(
				ReceiptType.MONEYIN, beginTime, endTime);
		int size = receiptVOs.size();
		ArrayList<Receipt_MoneyInVO> moneyInVOs = new ArrayList<Receipt_MoneyInVO>();
		for (int i = 0; i < size; i++) {
			moneyInVOs.add((Receipt_MoneyInVO) receiptVOs.get(i));
		}
		return moneyInVOs;
	}

	@Override
	public ArrayList<Receipt_MoneyOutVO> showMoneyoutTable(String beginTime,
			String endTime) {
		// TODO Auto-generated method stub
		return null;
	}

}
