package org.cross.elsclient.ui.businesshallclerkui.vehicle;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;

import org.cross.elsclient.blservice.userblservice.UserBLService;
import org.cross.elsclient.blservice.userblservice.UserBLService_Stub;
import org.cross.elsclient.blservice.vehicleblservice.VehicleBLService;
import org.cross.elsclient.ui.adminui.AdminFunctionPanel;
import org.cross.elsclient.ui.businesshallclerkui.BusinessFunctionPanel;
import org.cross.elsclient.ui.component.ELSManagePanel;
import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.vo.UserVO;
import org.cross.elsclient.vo.VehicleVO;


public class VehicleManagePanel extends ELSManagePanel{
	VehicleBLService vehiclebl;
	ArrayList<VehicleVO> vehicleVOs;
	VehicleManageTable list;
	
	public VehicleManagePanel(){}
	
	public VehicleManagePanel(VehicleBLService vehiclebl) {
		super();
		this.vehiclebl = vehiclebl;
		init();
	}
	
//	@Override
//	public void init() {
//		// TODO Auto-generated method stub
//		super.init();
//		if(getParent() instanceof AdminFunctionPanel){
//			BusinessFunctionPanel parent = (BusinessFunctionPanel) getParent();
//			vehiclebl = parent.vehiclebl;
//		}
//	}
	
	@Override
	public void setContentPanel() {
		// TODO Auto-generated method stub
		super.setContentPanel();
		String[] s = {"车辆编号","车牌号","服役时间"};
		int[] itemWidth = {100,100,200};
		list= new VehicleManageTable(s,itemWidth,vehiclebl);
		list.setLocation(0, 0);
		contentPanel.add(list);
	}
	
	@Override
	public void setSearchPanel() {
		String[] s = {"按车辆编号查询"};
		modeBox.setModel(new DefaultComboBoxModel<String>(s));
		modeBox.addItemListener(new ModeBoxItemListener());
		
		btn1.setText("查找车辆");
		btn1.addMouseListener(new BtnListener());
		
		btn2.setText("添加车辆");
		btn2.addMouseListener(new BtnListener());
		searchPanel.add(Box.createHorizontalStrut(10));
		searchPanel.add(btn2);
		
		searchPanel.validate();
	}
	
	class BtnListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
			if(((String)modeBox.getSelectedItem()).equals("按车辆编号查询")){
				if(e.getSource()==btn1){
					String id = searchTextField.getText();
					vehicleVOs = new ArrayList<>();
					vehicleVOs = vehiclebl.find(id);
					list.init();
					for (VehicleVO  vehicleVO: vehicleVOs) {
						list.addItem(vehicleVO);
					}
				}else if (e.getSource() == btn2){
					VehicleAddPanel vehicleAddPanel = new VehicleAddPanel(vehiclebl);
					ELSPanel parent = (ELSPanel) getParent();
					parent.add(vehicleAddPanel,"add");
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
				case "按车辆编号查询":
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
	
