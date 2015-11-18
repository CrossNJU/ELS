package org.cross.elsclient.ui.userUI;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.xml.bind.Marshaller.Listener;

import org.cross.elsclient.blservice.userblservice.UserBLService;
import org.cross.elsclient.blservice.userblservice.UserBLService_Stub;
import org.cross.elsclient.ui.component.ELSButton;
import org.cross.elsclient.ui.component.ELSComboBox;
import org.cross.elsclient.ui.component.ELSManageTable;
import org.cross.elsclient.ui.component.ELSTextField;
import org.cross.elsclient.ui.component.ELSManagePanel;
import org.cross.elsclient.vo.UserVO;
import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;

public class UserManagePanel extends ELSManagePanel {
	UserBLService userbl;
	ArrayList<UserVO> userVOs;
	UserManageTable list;
	ELSTextField searchTextField;
	ELSComboBox modeBox;
	ELSButton searchBtn;

	
	@Override
	public void setContentPanel() {
		// TODO Auto-generated method stub
		super.setContentPanel();
		String[] s = {"编号","姓名","类型"};
		int[] itemWidth = {100,100,100};
		list= new UserManageTable(s,itemWidth,getWidth(),50);
		list.setLocation(0, 0);
		contentPanel.add(list);
	}
	
	@Override
	public void setSearchPanel() {
		userbl = new UserBLService_Stub();
		
		searchTextField = new ELSTextField();
		searchBtn = new ELSButton("Search");
		modeBox = new ELSComboBox();
		
		String[] s = {"按ID查询", "按时间查询", "按类型查询"};
		modeBox.setModel(new DefaultComboBoxModel<String>(s));
		modeBox.setSize((int)(getWidth()*0.15),30);
		modeBox.setLocation(0,50);
		modeBox.addItemListener(new ModeBoxItemListener());
		
		
		searchTextField.setSize((int)(getWidth()*0.7),30);
		searchTextField.setLocation(modeBox.getLocation().x+modeBox.getWidth()+10,50);
		
		searchBtn.setSize((int)(getWidth()*0.13),30);
		searchBtn.setLocation(searchTextField.getLocation().x+searchTextField.getWidth()+10,50);
		searchBtn.addMouseListener(new SearchBtnListener());
		
		searchPanel.add(searchBtn);
		searchPanel.add(searchTextField);
		searchPanel.add(modeBox);
	}
	
	class SearchBtnListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(((String)modeBox.getSelectedItem()).equals("按ID查询")){
				String id = searchTextField.getText();
				userVOs = new ArrayList<>();
				userVOs = userbl.findById(id);
				list.init();
				
				for (UserVO userVO : userVOs) {
					list.addItem(userVO);
				}
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
					break;
				default:
					searchTextField.setVisible(false);
					break;
				}
			}
		}
		
	}
}
