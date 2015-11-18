package org.cross.elsclient.ui.userUI;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

import org.cross.elsclient.blservice.userblservice.UserBLService;
import org.cross.elsclient.blservice.userblservice.UserBLService_Stub;
import org.cross.elsclient.ui.component.ELSButton;
import org.cross.elsclient.ui.component.ELSManageTable;
import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.vo.UserVO;

public class UserManageTable extends ELSManageTable{
	UserBLService userbl;
	ArrayList<UserVO> vos;
	
	public UserManageTable(String[] name, int[] itemWidth, int tableWidth,
			int tableHeight) {
		super(name, itemWidth, tableWidth, tableHeight);
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
		userbl = new UserBLService_Stub();
		vos = new ArrayList<>();
	}

	
	public void addItem(UserVO vo){
		vos.add(vo);
		int index = vos.indexOf(vo);
		
		String[] item = {vo.name,vo.id,vo.type.toString()};
		addItemLabel(item);
		
		ELSButton updateBtn = new ELSButton("改");
		ELSButton deleteBtn = new ELSButton("删");
		
		updateBtn.setPreferredSize(new Dimension(30, 30));
		updateBtn.setMaximumSize(new Dimension(30, 30));
		updateBtn.setMinimumSize(new Dimension(30, 30));
//		updateBtn.setVisible(false);
		updateBtn.addMouseListener(new UpdateBtnListener(index));
		
		deleteBtn.setPreferredSize(new Dimension(30, 30));
		deleteBtn.setMaximumSize(new Dimension(30, 30));
		deleteBtn.setMinimumSize(new Dimension(30, 30));
//		deleteBtn.setVisible(false);
		itemLabels.get(index).add(Box.createHorizontalGlue());
		itemLabels.get(index).add(updateBtn);
		itemLabels.get(index).add(Box.createHorizontalStrut(20));
		itemLabels.get(index).add(deleteBtn);
		itemLabels.get(index).add(Box.createHorizontalStrut(20));
		itemLabels.get(index).validate();
		itemLabels.get(index).addMouseListener(new ItemListener(index));
		repaint();
	}
	
	class ItemListener implements MouseListener{
		int index;
		UserVO vo;
		Box itemLabel;
		
		public ItemListener(int index) {
			this.index = index;
			vo = vos.get(index);
			itemLabel = itemLabels.get(index);
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			ELSPanel contentPanel  = (ELSPanel)getParent().getParent().getParent();
			
			contentPanel.add(new UserInfoPanel(vo),"userInfoPanel");
			contentPanel.cl.show(contentPanel, "userInfoPanel");
			System.out.println("hhhhh");
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
//			if(!itemLabel.getComponent(itemLabel.getComponentCount()-2).isVisible()){
//				itemLabel.getComponent(itemLabel.getComponentCount()-2).setVisible(true);
//				itemLabel.getComponent(itemLabel.getComponentCount()-4).setVisible(true);
//			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
//			if(itemLabel.getComponent(itemLabel.getComponentCount()-2).isVisible()){
//			itemLabel.getComponent(itemLabel.getComponentCount()-2).setVisible(false);
//			itemLabel.getComponent(itemLabel.getComponentCount()-4).setVisible(false);
//			}
		}
	}
	
	class UpdateBtnListener implements MouseListener{
		int index;
		UserVO vo;
		Box itemLabel;
		
		public UpdateBtnListener(int index) {
			this.index = index;
			vo = vos.get(index);
			itemLabel = itemLabels.get(index);
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			ELSPanel contentPanel  = (ELSPanel)getParent().getParent().getParent();
			UserManagePanel parent = (UserManagePanel)getParent().getParent();
			
			contentPanel.add(new UserUpdatePanel(vo,parent.userbl),"userInfoPanel");
			contentPanel.cl.show(contentPanel, "userInfoPanel");
			System.out.println("hhhhh");
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
