package org.cross.elsclient.demo;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import org.cross.elsclient.vo.StockOperationVO;

public class StockInfoUI {
	
	JFrame stockInfo;
	ArrayList<StockOperationVO> ops;
	
	JLabel head;
	JTextArea textArea;
	JButton returnButton;
	
	public StockInfoUI(ArrayList<StockOperationVO> ops){
		this.ops = ops;
		
		stockInfo = new JFrame("库存查看");
		stockInfo.setLocation(200, 300);
		stockInfo.setSize(500,600);
		stockInfo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		stockInfo.setVisible(true);
		
		head = new JLabel("快件信息：");
		stockInfo.add(head, BorderLayout.NORTH);
		
		textArea = new JTextArea("sample");
		stockInfo.add(textArea, BorderLayout.CENTER);
		
		returnButton = new JButton("return");
		stockInfo.add(returnButton, BorderLayout.SOUTH);
		returnButton.addActionListener(new returnAct());
		
		show();
	}

	public void show(){
		for (int i = 0; i < ops.size(); i++) {
			StockOperationVO vo = ops.get(i);
			textArea.append(vo.time+"  "+vo.money+"  "+vo.good.order.number+" "+vo.place.toString()+"\n");
		}
	}
	
	public class returnAct implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			stockInfo.setVisible(false);
		}
		
	}
}
