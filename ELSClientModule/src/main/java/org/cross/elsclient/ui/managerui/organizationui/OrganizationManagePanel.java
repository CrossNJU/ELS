package org.cross.elsclient.ui.managerui.organizationui;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;

import org.cross.elsclient.blservice.organizationblservice.OrganizationBLService;
import org.cross.elsclient.ui.component.ELSButton;
import org.cross.elsclient.ui.component.ELSManagePanel;
import org.cross.elsclient.ui.component.ELSManageTable;
import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.ui.util.UIConstant;
import org.cross.elsclient.vo.OrganizationVO;

public class OrganizationManagePanel extends ELSManagePanel{
	OrganizationBLService organizationbl;
	ArrayList<OrganizationVO> organizationVOs;
	OrganizationManageTable list;
	ELSButton addBtn;
	
	public OrganizationManagePanel(){}
	
	public OrganizationManagePanel(OrganizationBLService organizationbl) {
		super();
		this.organizationbl = organizationbl;
		init();
	}

	
	@Override
	public void setContentPanel() {
		// TODO Auto-generated method stub
		super.setContentPanel();
		String[] s = {"机构编号","地区","类型"};
		int[] itemWidth = {200,100,100};
		list= new OrganizationManageTable(s,itemWidth,organizationbl);
		list.setLocation(UIConstant.CONTENTPANEL_MARGIN_LEFT,UIConstant.CONTENTPANEL_MARGIN_TOP*2+UIConstant.SEARCHPANEL_HEIGHT);
		container.add(list);
	}
	
	@Override
	public void setSearchPanel() {
		String[] s = {"按机构地区查询", "按时间查询", "按类型查询"};
		modeBox.setModel(new DefaultComboBoxModel<String>(s));
		modeBox.addItemListener(new ModeBoxItemListener());
		
		searchBtn.setText("查找用户");
		searchBtn.addMouseListener(new BtnListener());
		
		addBtn = new ELSButton();
		addBtn.setText("添加用户");
		addBtn.addMouseListener(new BtnListener());
		searchPanel.add(Box.createHorizontalStrut(10));
		searchPanel.add(addBtn);
		
		searchPanel.validate();
	}
	
	class BtnListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
			if(((String)modeBox.getSelectedItem()).equals("按机构地区查询")){
				if(e.getSource()==searchBtn){
					String id = searchTextField.getText();
					organizationVOs = new ArrayList<>();
					try {
						organizationVOs.add(organizationbl.findById(id));
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					list.init();
					for (OrganizationVO organizationVO : organizationVOs) {
						list.addItem(organizationVO);
					}
				}else if (e.getSource() == addBtn){
//					OrganizationAddPanel userAddPanel = new OrganizationAddPanel(userbl);
//					ELSPanel parent = (ELSPanel) getParent();
//					parent.add(userAddPanel,"add");
//					parent.cl.show(parent, "add");
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
