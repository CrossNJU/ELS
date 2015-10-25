package org.cross.elsclient.demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.cross.elsclient.demo.LoginUI.logListener;

public class TimeInUI {
	JFrame timeIn;
	JButton button;
	JTextField startTime;
	JTextField endTime;
	JLabel startTimeLabel;
	JLabel endTimeLabel;
	
	public TimeInUI(){
		timeIn = new JFrame("起止时间输入界面");
		button = new JButton("确认");
		startTime = new JTextField();
		endTime = new JTextField();
		startTimeLabel = new JLabel("startTime ：");
		endTimeLabel = new JLabel("endTime ：");
		
		timeIn.setLayout(null);
		
		timeIn.setVisible(true);
		timeIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		timeIn.setSize(500, 400);
		
		button.addActionListener(new timeInListener());
		
		startTimeLabel.setBounds(10,10,75,20);
		endTimeLabel.setBounds(10,25,70,70);
		startTime.setBounds(75,10,210,20);
		endTime.setBounds(75,50,210,20);
		button.setBounds(10,100,170,50);
		
		timeIn.getContentPane().add(startTimeLabel);
		timeIn.getContentPane().add(endTimeLabel);
		timeIn.getContentPane().add(startTime);
		timeIn.getContentPane().add(endTime);
		timeIn.getContentPane().add(button);
	}
	public class timeInListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
}
