package org.cross.elsclient.ui.managerui.organizationui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.Box;

import org.cross.elsclient.blservice.organizationblservice.OrganizationBLService;
import org.cross.elsclient.ui.component.ELSButton;
import org.cross.elsclient.ui.component.ELSManageTable;
import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.ui.util.ComponentFactory;
import org.cross.elsclient.vo.OrganizationVO;

public class OrganizationManageTable extends ELSManageTable {
	OrganizationBLService organizationbl;
	ArrayList<OrganizationVO> vos;
	
	public OrganizationManageTable(){
		super();
	}
	
	public OrganizationManageTable(String[] name, int[] itemWidth,OrganizationBLService organizationbl) {
		super(name, itemWidth);
		this.organizationbl = organizationbl;
		init();
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
		vos = new ArrayList<>();
	}
	
	public void addItem(OrganizationVO vo){
		vos.add(vo);
		int index = vos.indexOf(vo);
		
		String[] item = {vo.id,vo.city.toString(),vo.type.toString()};
		addItemLabel(item);
		
		ELSButton updateBtn = ComponentFactory.createUpdateBtn();
		ELSButton deleteBtn = ComponentFactory.createDeleteBtn();
		
		updateBtn.setVisible(false);
		updateBtn.addMouseListener(new BtnListener(index));
		
		deleteBtn.setVisible(false);
		deleteBtn.addMouseListener(new BtnListener(index));
		
		itemLabels.get(index).add(Box.createHorizontalGlue());
		itemLabels.get(index).add(updateBtn);
		itemLabels.get(index).add(Box.createHorizontalStrut(gap));
		itemLabels.get(index).add(deleteBtn);
		itemLabels.get(index).add(Box.createHorizontalStrut(gap));
		itemLabels.get(index).validate();
		itemLabels.get(index).addMouseListener(new ItemListener(index));
		repaint();
	}
	
	class ItemListener implements MouseListener{
		int index;
		OrganizationVO vo;
		Box itemLabel;
		
		public ItemListener(int index) {
			this.index = index;
			vo = vos.get(index);
			itemLabel = itemLabels.get(index);
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
//			ELSPanel contentPanel  = (ELSPanel)getParent().getParent().getParent();
//			
//			contentPanel.add(new OrganizationVOInfoPanel(vo),"info");
//			contentPanel.cl.show(contentPanel, "info");
//			System.out.println("hhhhh");
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
			itemLabel.getComponent(itemLabel.getComponentCount()-2).setVisible(true);
			itemLabel.getComponent(itemLabel.getComponentCount()-4).setVisible(true);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			itemLabel.getComponent(itemLabel.getComponentCount()-2).setVisible(false);
			itemLabel.getComponent(itemLabel.getComponentCount()-4).setVisible(false);
		}
	}
	
	class BtnListener implements MouseListener{
		OrganizationVO vo;
		Box itemLabel;
		
		public BtnListener(int index) {
			this.vo = vos.get(index);
			itemLabel = itemLabels.get(index);
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			ELSButton btn = (ELSButton)e.getSource();
			int index = vos.indexOf(vo);
			
//			if(btn.getName()=="update"){
//				ELSPanel contentPanel  = (ELSPanel)getParent().getParent().getParent();
//				UserManagePanel parent = (UserManagePanel)getParent().getParent();
//				
//				contentPanel.add(new OrganizationUpdatePanel(vo,parent.userbl),"update");
//				contentPanel.cl.show(contentPanel, "update");
//				System.out.println("hhhhh");
//			}else if(btn.getName()=="delete"){
//				UserManagePanel parent = (UserManagePanel)getParent().getParent();
//				parent.organizationbl.delete(vo);
//				itemLabels.remove(index);
//				vos.remove(index);
//				container.remove(itemLabel);
//				container.validate();
//				container.repaint();
//			}
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
			itemLabel.getComponent(itemLabel.getComponentCount()-2).setVisible(true);
			itemLabel.getComponent(itemLabel.getComponentCount()-4).setVisible(true);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			itemLabel.getComponent(itemLabel.getComponentCount()-2).setVisible(false);
			itemLabel.getComponent(itemLabel.getComponentCount()-4).setVisible(false);
		}
		
	}
}
