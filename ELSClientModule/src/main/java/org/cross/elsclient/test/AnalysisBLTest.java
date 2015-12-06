package org.cross.elsclient.test;

import java.util.ArrayList;

import org.cross.elsclient.blimpl.analysisblimpl.AnalysisBLImpl;
import org.cross.elsclient.vo.Receipt_MoneyInVO;

public class AnalysisBLTest {
	public static void main(String[] args){
		
//		DataFactoryService dataFactory = new Datafactory();
		AnalysisBLImpl analysisBLImpl = new AnalysisBLImpl();
		
		System.out.println("test ------- showCostBenefitTable");
		double[] res = new double[3];
		res = analysisBLImpl.showCostBenefitTable();
		System.out.println(res[0] + " " + res[1] + " " + res[2]);
		
		System.out.println("test ------- showMoneyInTable");
		ArrayList<Receipt_MoneyInVO> moneyIn = analysisBLImpl.showMoneyinTable("2015-10-01", "2015-10-02");
		System.out.println("test ------- showMoneyOutTable");
		
	}
}
