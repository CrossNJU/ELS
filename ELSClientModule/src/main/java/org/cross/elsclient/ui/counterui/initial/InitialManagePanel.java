package org.cross.elsclient.ui.counterui.initial;

import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

import org.cross.elsclient.blimpl.initialblimpl.InitialBLImpl;
import org.cross.elsclient.blservice.initialblservice.InitialBLService;
import org.cross.elsclient.ui.component.ELSManagePanel;
import org.cross.elsclient.ui.component.ELSManageTable;
import org.cross.elsclient.ui.util.UIConstant;
import org.cross.elsclient.vo.InitialVO;

public class InitialManagePanel extends ELSManagePanel{
	InitialBLService initialbl;
	InitialVO CurrentVO;
	ArrayList<InitialManageTable> lists;
	InitialInfoTable infoList;
	InitialOrganizationTable organList;
	InitialAccountTable accountList;
	InitialPersonnelTable personnelList;
	InitialStockTable stockList;
	InitialVehicleTable veList;
	
	public InitialManagePanel(InitialBLService initialbl) {
		super();
		this.initialbl = initialbl;
	}
	
	@Override
	public void setContentPanel() {
		super.setContentPanel();
		String[] infoName = {"账本编号","建账人","建账时间"};
		int[] infoWidth = {150,200,200}; 
		infoList = new InitialInfoTable(infoName, infoWidth,CurrentVO);
		infoList.init();
		infoList.addItemLabel(new String[]{CurrentVO.id,CurrentVO.name,CurrentVO.year+""});
		infoList.setLocation(UIConstant.CONTENTPANEL_MARGIN_LEFT, searchPanel.getHeight()+searchPanel.getLocation().y+10);
		infoList.addBtn.setVisible(false);
		
		String[] organName = {"机构编号","地区","类型"};
		int[] organWidth = {150,100,100}; 
		organList = new InitialOrganizationTable(organName, organWidth,CurrentVO.organizations);
		organList.setLocation(UIConstant.CONTENTPANEL_MARGIN_LEFT, infoList.getHeight()+infoList.getLocation().y+10);
		
		String[] personName = {"人员编号","姓名","职位","所属机构"};
		int[] personWidth = {100,100,100,200};
		personnelList = new InitialPersonnelTable(personName,personWidth, CurrentVO.personnels);
		personnelList.setLocation(UIConstant.CONTENTPANEL_MARGIN_LEFT, organList.getHeight()+organList.getLocation().y+10);
		
		String[] vehicleName = {"车辆编号","车辆号","服役时间"};
		int[] vehicleWidth = {150,100,200};
		veList = new InitialVehicleTable(vehicleName,vehicleWidth, CurrentVO.vehicles);
		veList.setLocation(UIConstant.CONTENTPANEL_MARGIN_LEFT, personnelList.getHeight()+personnelList.getLocation().y+10);
		
		String[] accountName = {"账户名称","账户卡号","账户余额"};
		int[] accountWidth = {200,300,150};
		accountList = new InitialAccountTable(accountName,accountWidth, CurrentVO.accounts);
		accountList.setLocation(UIConstant.CONTENTPANEL_MARGIN_LEFT, veList.getHeight()+veList.getLocation().y+10);
		
		//库存表待定
//		String[] stockName = {"人员编号","姓名","职位","所属机构"};
//		int[] stockWidth = {100,100,100,200};
//		stockList = new InitialStockTable(stockName,stockWidth, CurrentVO.stocks);
		
		lists = new ArrayList<>();
		
		lists.add(infoList);
		lists.add(organList);
		lists.add(personnelList);
		lists.add(veList);
		lists.add(accountList);
		
		for (int i = 0;i<lists.size();i++){
			lists.get(i).isAddBtnVisible = false;
			lists.get(i).addBtn.setVisible(false);
			container.add(lists.get(i));
		}
		container.packHeight();
	}
	
	public void refresh(){
		infoList.vo = CurrentVO;
		organList.vos = CurrentVO.organizations;
		personnelList.vos = CurrentVO.personnels;
		accountList.vos = CurrentVO.accounts;
		veList.vos = CurrentVO.vehicles;
		
		for (InitialManageTable initialManageTable : lists) {
			initialManageTable.refresh();
		}
		
		organList.setLocation(UIConstant.CONTENTPANEL_MARGIN_LEFT, infoList.getHeight()+infoList.getLocation().y+10);
		personnelList.setLocation(UIConstant.CONTENTPANEL_MARGIN_LEFT, organList.getHeight()+organList.getLocation().y+10);
		veList.setLocation(UIConstant.CONTENTPANEL_MARGIN_LEFT, personnelList.getHeight()+personnelList.getLocation().y+10);
		accountList.setLocation(UIConstant.CONTENTPANEL_MARGIN_LEFT, veList.getHeight()+veList.getLocation().y+10);
		
		container.packHeight();
	}
}