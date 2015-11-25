package org.cross.elsclient.ui.component;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;

import org.cross.elsclient.ui.adminui.UserManagePanel;
import org.cross.elsclient.ui.util.ComponentFactory;
import org.cross.elsclient.ui.util.UIConstant;

public class ELSFunctionPanel extends ELSPanel {
	ELSPanel contentPanel;
	ArrayList<ELSButton> functionBtns = new ArrayList<>();
	ArrayList<JPanel> functionPanels = new ArrayList<>();
	ELSLabel logo;
	
//	public ELSFunctionPanel() {
//		init();
//	}
	
	public void init(){
		setSize(UIConstant.WINDOW_WIDTH,UIConstant.WINDOW_HEIGHT);
		setLayout(null);
		setBackground(Color.LIGHT_GRAY);
		
		contentPanel = new ELSPanel();
		contentPanel.setBounds(168, 100, 856, 668);
		
		logo = new ELSLabel("ELS");
		logo.setSize(new Dimension(150,100));
		logo.setLocation(0,0);
//		logo.setFont(logo.getFont().deriveFont(Font.BOLD));
//		logo.setFont(logo.getFont().deriveFont(100f));
		logo.setFont(new Font("Yahei", Font.PLAIN, 60));
		
		this.add(logo);
		this.add(contentPanel);
	}
	
	
	public void addFunctionBtn(String text,String functionName){
		ELSButton btn = ComponentFactory.createFunctionBtn();
		btn.setText(text);
		btn.setName(functionName);
		
		functionBtns.add(btn);
		
		btn.setBounds(0, 100+54*functionBtns.indexOf(btn), 168, 54);
		btn.addMouseListener(new FuncBtnListener());
		
		this.add(btn);
	}
	
	public void addFunctionPanel(JPanel panel,String name, String functionName){
		ELSPanel container = ComponentFactory.createNormalPanel();
		container.setBackground(Color.white);
		
		functionPanels.add(container);
		container.add(panel,name);
		contentPanel.add(container,functionName);
	}
	
	
	class FuncBtnListener implements MouseListener{
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			ELSButton btn = (ELSButton)e.getSource();
			String text = btn.getName();
			contentPanel.cl.show(contentPanel, text);
		}
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
}
