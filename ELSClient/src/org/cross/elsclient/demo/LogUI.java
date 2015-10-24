package org.cross.elsclient.demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class LogUI {
	
	JFrame logFrame;
	JButton button;
	
	
	public LogUI(){
		logFrame = new JFrame("登陆界面");
		button = new JButton("确认登陆");
		
		
		logFrame.setVisible(true);
		logFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		logFrame.setSize(500, 400);
		
		button.addActionListener(new logListener());
		
		logFrame.getContentPane().add(button);
	}
	
	public class logListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

}
