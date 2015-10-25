package org.cross.elsclient.demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.cross.elsclient.blservice.stockblservice.StockBLService;

public class StockUI {
	
	JFrame stockFunctionSelect;
	JButton button;
	
	StockBLService stockbl;
	
	public StockUI(StockBLService stockbl){
		
		this.stockbl = stockbl;
		
		stockFunctionSelect = new JFrame("仓库管理功能选择");
		button = new JButton("库存查看");
		
		button.addActionListener(new functionSelectListener());
		
		stockFunctionSelect.setSize(500, 400);
		stockFunctionSelect.setVisible(true);
		stockFunctionSelect.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		stockFunctionSelect.getContentPane().add(button);
	}
	
	public class functionSelectListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			TimeInUI timeinUI = new TimeInUI(stockbl);
		}
	}

}
