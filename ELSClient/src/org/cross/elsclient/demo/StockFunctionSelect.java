package org.cross.elsclient.demo;

import javax.swing.JFrame;

public class StockFunctionSelect {
	
	JFrame stockFunctionSelect;
	
	public StockFunctionSelect(){
		stockFunctionSelect = new JFrame("仓库管理功能选择");
		
		stockFunctionSelect.setSize(500, 400);
		stockFunctionSelect.setVisible(true);
		stockFunctionSelect.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
