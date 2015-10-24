package org.cross.elsclient.demo;

import org.cross.elsclient.blservice.stockblservice.StockBLService;
import org.cross.elsclient.blservice.stockblservice.StockBLService_Stub;

public class Demo {
	
	public static void main(String [] args){
		MainUI ui = new MainUI();
		StockBLService stockbl = new StockBLService_Stub();
		
		System.out.println("1");
	}

}
