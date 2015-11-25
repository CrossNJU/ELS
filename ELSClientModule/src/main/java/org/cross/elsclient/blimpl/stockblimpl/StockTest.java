//package org.cross.elsclient.blimpl.stockblimpl;
//
//import static org.junit.Assert.*;
//
//import java.rmi.RemoteException;
//
//import org.cross.elscommon.util.ResultMessage;
//import org.junit.Test;
//
//public class StockTest {
//	@Test
//	public void testStock() throws RemoteException{
//		Stock stock = new Stock();
//		assertEquals(ResultMessage.SUCCESS,stock.createLog("2015/11/16 add an stock"));
//		
//		assertEquals(ResultMessage.SUCCESS, stock.checkGoods("0000029", "S0002"));
//		
//		assertEquals(ResultMessage.SUCCESS, stock.intoStock("37846382", "S0002"));
//		
//		assertEquals(ResultMessage.SUCCESS, stock.outStock("37468238", "S0002"));
//		
//	}
//}
