package org.cross.elsclient.demo;

import javax.swing.JFrame;

import org.cross.elsclient.blservice.stockblservice.StockBLService;

public class StockFunctionSelect {
	
	JFrame stockFunctionSelect;
	
	StockBLService stockbl;
	
	public StockFunctionSelect(StockBLService stockbl){
		
		this.stockbl = stockbl;
		
		stockFunctionSelect = new JFrame("仓库管理功能选择");
		
		stockFunctionSelect.setSize(500, 400);
		stockFunctionSelect.setVisible(true);
		stockFunctionSelect.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
