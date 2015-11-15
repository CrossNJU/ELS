package org.cross.elsclient.blservice.analysisblservice;

import java.util.ArrayList;

import org.cross.elsclient.vo.ReceiptVO;

public interface AnalysisBLService {
	
	/**
	 * 展示成本收益表
	 * @param 
	 * @return 成本收益表（依次为成本，收益，利润）
	 */
	public double[] showCostBenefitTable();
	
	/**
	 * 展示收款单
	 * @param beginTime, endTime
	 * @return 收款单
	 */
	public ArrayList<ReceiptVO> showMoneyinTable(String beginTime, String endTime);
	
	/**
	 * 展示付款单
	 * @param beginTime, endTime
	 * @return 付款单
	 */
	public ArrayList<ReceiptVO> showMoneyoutTable(String beginTime, String endTime);
	
}
