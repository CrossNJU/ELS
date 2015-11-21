package org.cross.elsclient.ui.businesshallclerkui.vehicle;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.Box;

import org.cross.elsclient.blservice.vehicleblservice.VehicleBLService;
import org.cross.elsclient.ui.component.ELSButton;
import org.cross.elsclient.ui.component.ELSManageTable;
import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.ui.util.ComponentFactory;
import org.cross.elsclient.vo.VehicleVO;

public class VehicleManageTable extends ELSManageTable{
	VehicleBLService vehiclebl;
	ArrayList<VehicleVO> vos;

	public VehicleManageTable(){
		super();
	}
	
	public VehicleManageTable(String[] name, int[] itemWidth,VehicleBLService vehiclebl) {
		super(name, itemWidth);
		this.vehiclebl = vehiclebl;
		init();
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
		if(getParent() instanceof VehicleManagePanel){
			VehicleManagePanel parent = (VehicleManagePanel) getParent();
			vehiclebl = parent.vehiclebl;
		}
		vos = new ArrayList<>();
	}
	
	public void addItem(VehicleVO vo){
		vos.add(vo);
		int index = vos.indexOf(vo);
		
		String[] item = {vo.number,vo.number,vo.buyTime+"~"+vo.lastTime};
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
		VehicleVO vo;
		Box itemLabel;
		
		public ItemListener(int index) {
			this.index = index;
			vo = vos.get(index);
			itemLabel = itemLabels.get(index);
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			ELSPanel contentPanel  = (ELSPanel)getParent().getParent().getParent();
			
			contentPanel.add(new VehicleInfoPanel(vo),"info");
			contentPanel.cl.show(contentPanel, "info");
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
			itemLabel.getComponent(itemLabel.getComponentCount()-2).setVisible(true);
			itemLabel.getComponent(itemLabel.getComponentCount()-4).setVisible(true);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			itemLabel.getComponent(itemLabel.getComponentCount()-2).setVisible(false);
			itemLabel.getComponent(itemLabel.getComponentCount()-4).setVisible(false);
		}
	}
	
	class BtnListener implements MouseListener{
		VehicleVO vo;
		Box itemLabel;
		
		public BtnListener(int index) {
			this.vo = vos.get(index);
			itemLabel = itemLabels.get(index);
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			ELSButton btn = (ELSButton)e.getSource();
			int index = vos.indexOf(vo);
			
			if(btn.getName()=="update"){
				ELSPanel contentPanel  = (ELSPanel)getParent().getParent().getParent();
				VehicleManagePanel parent = (VehicleManagePanel)getParent().getParent();
				
				contentPanel.add(new VehicleUpdatePanel(vo,parent.vehiclebl),"update");
				contentPanel.cl.show(contentPanel, "update");
				System.out.println("hhhhh");
			}else if(btn.getName()=="delete"){
				VehicleManagePanel parent = (VehicleManagePanel)getParent().getParent();
				parent.vehiclebl.delete(vo);
				itemLabels.remove(index);
				vos.remove(index);
				container.remove(itemLabel);
				container.validate();
				container.repaint();
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
}
