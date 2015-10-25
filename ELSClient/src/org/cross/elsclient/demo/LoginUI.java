package org.cross.elsclient.demo;

import java.awt.BorderLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.cross.elsclient.vo.StockVO;

public class LoginUI {
	
	JFrame logFrame;
	JButton button;
	JTextField name;
	JTextField password;
	JLabel nameLabel;
	JLabel passwordLabel;
	
	
	
	UIFactory uiFactory;
	
	public LoginUI(UIFactory uiFactory){
		
		this.uiFactory = uiFactory;
		
		logFrame = new JFrame("登陆界面");
		button = new JButton("确认登陆");
		name = new JTextField();
		password = new JTextField();
		nameLabel = new JLabel("用户名 ：");
		passwordLabel = new JLabel("密码 ：");
		
		logFrame.setLayout(null);
		
		logFrame.setVisible(true);
		logFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		logFrame.setSize(500, 400);
		
		button.addActionListener(new logListener());
		
		nameLabel.setBounds(10,10,60,20);
		passwordLabel.setBounds(10,25,60,70);
		name.setBounds(65,10,200,20);
		password.setBounds(65,50,200,20);
		button.setBounds(10,100,170,50);
		
		logFrame.getContentPane().add(nameLabel);
		logFrame.getContentPane().add(passwordLabel);
		logFrame.getContentPane().add(name);
		logFrame.getContentPane().add(password);
		logFrame.getContentPane().add(button);
	}
	
	public class logListener implements ActionListener{
		
		String id = name.getText().trim();

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			StockUI select = uiFactory.getStockUI();
			try {
				select.stockbl.findStock(id);
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
//			logFrame.getContentPane().add(select.stockFunctionSelect);
		}
		
	}

}
