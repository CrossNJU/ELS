package org.cross.elsclient.ui.businesshallclerkui.driver;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blservice.personnelblservice.PersonnelBLService;
import org.cross.elsclient.ui.component.ELSManageTable;
import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.vo.PersonnelVO;
import org.cross.elscommon.util.ResultMessage;

public class DriverManageTable extends ELSManageTable{
	PersonnelBLService personnelbl;
	ArrayList<PersonnelVO> vos;

	public DriverManageTable() {
		super();
	}

	public DriverManageTable(String[] name, int[] itemWidth,
			PersonnelBLService personnelBLService) {
		super(name, itemWidth);
		this.personnelbl = personnelBLService;
		init();
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
		vos = new ArrayList<>();
		isUpdateAndDelete = true;
	}

	public void addItem(PersonnelVO vo) {
		vos.add(vo);
		int index = vos.indexOf(vo);

		String[] item = { vo.id, vo.name, "男", "13902918321" + "上海中转中心" };
		addItemLabel(item);
	}

	@Override
	public void infoBtn(int index) {
		super.infoBtn(index);
		ELSPanel contentPanel = (ELSPanel) getParent().getParent().getParent();
		PersonnelVO vo = vos.get(index);
		contentPanel.add(new DriverInfoPanel(vo), "info");
		contentPanel.cl.show(contentPanel, "info");
	}

	@Override
	public void updateBtn(int index) {
		super.updateBtn(index);
		ELSPanel contentPanel = (ELSPanel) getParent().getParent().getParent();
		DriverManagePanel parent = (DriverManagePanel) getParent()
				.getParent();

		contentPanel.add(new DriverUpdatePanel(vos.get(index),
				parent.personnelbl), "update");
		contentPanel.cl.show(contentPanel, "update");
	}

	@Override
	public void deleteBtn(int index) {
		super.deleteBtn(index);
		DriverManagePanel parent = (DriverManagePanel) getParent()
				.getParent();
		try {
			if (parent.personnelbl.delete(vos.get(index).id) == ResultMessage.SUCCESS) {
				container.remove(itemLabels.get(index));
				itemLabels.remove(index);

				vos.remove(index);
				container.validate();
				container.repaint();
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
