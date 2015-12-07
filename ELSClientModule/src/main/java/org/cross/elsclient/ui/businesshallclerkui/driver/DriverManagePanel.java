package org.cross.elsclient.ui.businesshallclerkui.driver;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;

import org.cross.elsclient.blservice.personnelblservice.PersonnelBLService;
import org.cross.elsclient.ui.component.ELSButton;
import org.cross.elsclient.ui.component.ELSManagePanel;
import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.ui.util.UIConstant;
import org.cross.elsclient.vo.DriverVO;
import org.cross.elsclient.vo.PersonnelVO;
import org.cross.elsclient.vo.UserVO;

public class DriverManagePanel extends ELSManagePanel{
	PersonnelBLService personnelbl;
	ArrayList<DriverVO> drivers;
	DriverManageTable list;
	ELSButton addBtn;
	UserVO user;
	
	public DriverManagePanel(){}
	
	public DriverManagePanel(PersonnelBLService personnelbl, UserVO user) {
		super();
		this.personnelbl = personnelbl;
		init();
	}
	
	@Override
	public void setContentPanel() {
		// TODO Auto-generated method stub
		super.setContentPanel();
		String[] s = {"司机编号","姓名","性别","手机","车辆单位"};
		int[] itemWidth = {100,200,100,200,200};
		list= new DriverManageTable(s,itemWidth,personnelbl, user);
		list.setLocation(UIConstant.CONTENTPANEL_MARGIN_LEFT,UIConstant.CONTENTPANEL_MARGIN_TOP*2+UIConstant.SEARCHPANEL_HEIGHT);
		container.add(list);
	}
	
	@Override
	public void setSearchPanel() {
		String[] s = {"按司机姓名查询"};
		modeBox.setModel(new DefaultComboBoxModel<String>(s));
		modeBox.addItemListener(new ModeBoxItemListener());
		
		searchBtn.setText("查找司机");
		searchBtn.addMouseListener(new BtnListener());
		
		addBtn = new ELSButton();
		addBtn.setText("添加司机");
		addBtn.addMouseListener(new BtnListener());
		
		searchPanel.add(Box.createHorizontalStrut(10));
		searchPanel.add(addBtn);
		
		searchPanel.validate();
	}
	
	class BtnListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
			if(((String)modeBox.getSelectedItem()).equals("按司机姓名查询")){
				if(e.getSource()==searchBtn){
					String name = searchTextField.getText();
					drivers = new ArrayList<>();
					try {
						ArrayList<PersonnelVO> personnels = personnelbl.findByName(name);
						for (int i = 0; i < personnels.size(); i++) {
							drivers.add((DriverVO)personnels.get(i));
						}
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					list.init();
					for (DriverVO  driver: drivers) {
						list.addItem(driver);
					}
				}else if (e.getSource() == addBtn){
					DriverAddPanel driveradd = new DriverAddPanel(personnelbl, user);
					ELSPanel parent = (ELSPanel) getParent();
					parent.add(driveradd,"add");
					parent.cl.show(parent, "add");
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
				case "按司机姓名查询":
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
