package org.cross.elsclient.ui.adminui;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.*;
import javax.xml.bind.Marshaller.Listener;

import org.cross.elsclient.blservice.userblservice.UserBLService;
import org.cross.elsclient.ui.component.ELSButton;
import org.cross.elsclient.ui.component.ELSComboBox;
import org.cross.elsclient.ui.component.ELSDatePicker;
import org.cross.elsclient.ui.component.ELSDialog;
import org.cross.elsclient.ui.component.ELSFunctionPanel;
import org.cross.elsclient.ui.component.ELSManageTable;
import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.ui.component.ELSTextField;
import org.cross.elsclient.ui.component.ELSManagePanel;
import org.cross.elsclient.vo.UserVO;
import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;

public class UserManagePanel extends ELSManagePanel {
	UserBLService userbl;
	ArrayList<UserVO> userVOs;
	UserManageTable list;
	ELSDatePicker datePicker;
	
	public UserManagePanel(){}
	
	public UserManagePanel(UserBLService userbl) {
		super();
		this.userbl = userbl;
		init();
	}

	
	@Override
	public void setContentPanel() {
		// TODO Auto-generated method stub
		super.setContentPanel();
		String[] s = {"编号","姓名","类型"};
		int[] itemWidth = {100,100,200};
		list= new UserManageTable(s,itemWidth,userbl);
		list.setLocation(0, 0);
		contentPanel.add(list);
	}
	
	@Override
	public void setSearchPanel() {
		datePicker = new ELSDatePicker();
		datePicker.setMaximumSize(searchTextField.getMaximumSize());
		datePicker.setMinimumSize(searchTextField.getMinimumSize());
		
		String[] s = {"按ID查询", "按时间查询", "按类型查询"};
		modeBox.setModel(new DefaultComboBoxModel<String>(s));
		modeBox.addItemListener(new ModeBoxItemListener());
		
		btn1.setText("查找用户");
		btn1.addMouseListener(new BtnListener());
		
		btn2.setText("添加用户");
		btn2.addMouseListener(new BtnListener());
		searchPanel.add(Box.createHorizontalStrut(10));
		searchPanel.add(btn2);
		
		datePicker.setVisible(false);
		searchPanel.add(datePicker,3);
		searchPanel.validate();
	}
	
	class BtnListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
			if(e.getSource()==btn1){
				if(((String)modeBox.getSelectedItem()).equals("按ID查询")){
					String id = searchTextField.getText();
					userVOs = new ArrayList<>();
					try {
						userVOs.add(userbl.findById(id));
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					list.init();
					for (UserVO userVO : userVOs) {
						list.addItem(userVO);
					}
				}else if(((String)modeBox.getSelectedItem()).equals("按时间查询")){
					System.out.println(datePicker.getDate());
				}
			}
			if (e.getSource() == btn2){
				UserAddPanel userAddPanel = new UserAddPanel(userbl);
				ELSPanel parent = (ELSPanel) getParent();
				parent.add(userAddPanel,"add");
				parent.cl.show(parent, "add");
			}
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
	
	class ModeBoxItemListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange()==ItemEvent.SELECTED){
				String item = (String)modeBox.getSelectedItem();
				switch (item) {
				case "按ID查询":
					searchTextField.setVisible(true);
					datePicker.setVisible(false);
					break;
				case "按时间查询":
					searchTextField.setVisible(false);
					datePicker.setVisible(true);
					break;
				default:
					searchTextField.setVisible(false);
					break;
				}
			}
		}
		
	}
}
