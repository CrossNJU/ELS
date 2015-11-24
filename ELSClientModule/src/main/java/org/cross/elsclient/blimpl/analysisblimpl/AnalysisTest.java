//package org.cross.elsclient.blimpl.analysisblimpl;
//
//import static org.junit.Assert.*;
//
//import org.cross.elscommon.util.ResultMessage;
//import org.junit.Test;
//
//public class AnalysisTest {
//	
//	@Test
//	public void testAnalysis(){
//		Analysis analysis = new Analysis();
//		assertEquals(ResultMessage.SUCCESS, analysis.createLog("2015/11/16 add an analysis"));
//		
//		ResultMessage showCostBenefitTableMessage = ResultMessage.FAILED;
//		int[] a = analysis.showCostBenefitTable();
//		if(a != null)
//			showCostBenefitTableMessage = ResultMessage.SUCCESS;
//		assertEquals(ResultMessage.SUCCESS, showCostBenefitTableMessage);
//		
//		ResultMessage moneyInMessage = ResultMessage.FAILED;
//		if(analysis.showMoneyinTable("2015/11/16", "2015/11/17") != null)
//			moneyInMessage = ResultMessage.SUCCESS;
//		assertEquals(ResultMessage.SUCCESS, moneyInMessage);
//		
//		ResultMessage moneyOutMessage = ResultMessage.FAILED;
//		if(analysis.showMoneyoutTable("2015/11/16", "2015/11/17") != null)
//			moneyOutMessage = ResultMessage.SUCCESS;
//		assertEquals(ResultMessage.SUCCESS, moneyOutMessage);
//		
//	}
//
//}
