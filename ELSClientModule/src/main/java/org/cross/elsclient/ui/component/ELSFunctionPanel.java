package org.cross.elsclient.ui.component;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
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
	
	
	/**
	 * 功能控制面板需要先实例化BL对象再执行init()
	 * @author:Moo
	 * @para:
	 */
	public ELSFunctionPanel() {}
	
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
		
		this.add(contentPanel);
		this.add(logo);
	}
	
	
	/**
	 * 添加功能按钮，functionName要与功能面板中参数的functionName相同
	 * @para text-显示的文字, functionName-功能名称
	 * @return void
	 */
	public void addFunctionBtn(String text,String functionName){
		ELSButton btn = ComponentFactory.createFunctionBtn();
		btn.setText(text);
		btn.setIcon(new ImageIcon("img/testicon.png"));
		btn.setName(functionName);
		
		functionBtns.add(btn);
		
		btn.setBounds(0, 100+54*functionBtns.indexOf(btn), 168, 54);
		btn.addMouseListener(new FuncBtnListener());
		
		this.add(btn);
	}
	
	/**
	 * 添加功能面板，functionName要与功能按钮中参数的functionName相同，默认面板名称为manage,add,update等
	 * @para panel-功能面板,name-默认面板名称, functionName-功能名称
	 * @return void
	 */
	public void addFunctionPanel(Container panel,String name, String functionName){
		ELSPanel container = new ELSPanel();
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
