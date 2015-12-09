package org.cross.elsclient.ui.counterui.initial;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.cross.elsclient.blservice.initialblservice.InitialBLService;
import org.cross.elsclient.ui.component.ELSButton;
import org.cross.elsclient.ui.component.ELSDialog;
import org.cross.elsclient.ui.component.ELSLabel;
import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.util.ComponentFactory;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.ui.util.UIConstant;
import org.cross.elsclient.util.ConstantVal;
import org.cross.elsclient.vo.AccountVO;
import org.cross.elsclient.vo.InitialVO;
import org.cross.elsclient.vo.OrganizationVO;
import org.cross.elsclient.vo.PersonnelVO;
import org.cross.elsclient.vo.StockVO;
import org.cross.elsclient.vo.VehicleVO;
import org.cross.elscommon.util.NumberType;
import org.cross.elscommon.util.ResultMessage;

public class InitialAddPanel extends InitialManagePanel{
	ELSButton cancelBtn;
	ELSLabel titleLabel;
	
	public InitialAddPanel(InitialBLService initialbl) {
		super(initialbl);
		currentVO = new InitialVO("", "", new ArrayList<OrganizationVO>(), new ArrayList<PersonnelVO>(), 
				new ArrayList<VehicleVO>(), new ArrayList<StockVO>(),new ArrayList<AccountVO>(),"","","");
		init();
	}

	@Override
	public void setSearchPanel() {
		cancelBtn = ComponentFactory.createSearchBtn();
		titleLabel = new ELSLabel("创建新账本");
		
		titleLabel.setMaximumSize(new Dimension(150, 48));
		titleLabel.setPreferredSize(new Dimension(150, 48));
		titleLabel.setMinimumSize(new Dimension(150, 48));
		titleLabel.setOpaque(true);
		titleLabel.setHorizontalAlignment(JLabel.LEFT);
		titleLabel.setForeground(Color.white);
		titleLabel.setBackground(UIConstant.MAINCOLOR);
		
		searchBtn.setText("创建账本");
		searchBtn.addMouseListener(new BtnListener());
		cancelBtn.setText("取消创建");
		cancelBtn.addMouseListener(new BtnListener());
		
		
		searchPanel.add(titleLabel,0);
		searchPanel.remove(modeBox);
		searchPanel.add(Box.createHorizontalStrut(10));
		searchPanel.add(cancelBtn);
		searchPanel.validate();
	}
	
	@Override
	public void setContentPanel() {
		super.setContentPanel();
		for (InitialManageTable initialManageTable : lists) {
			initialManageTable.isAddBtnVisible = true;
			initialManageTable.addBtn.setVisible(true);
		}
		
		currentVO.id = ConstantVal.getNumber().getPostNumber(NumberType.INITIAL);
		infoList.isEditable = true;
		infoList.refresh();
		infoList.addBtn.setVisible(false);
		infoList.validate();
	}
	
	public class BtnListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource()==searchBtn){
				try {
					currentVO.id = infoList.label.labels.get(0).getText();
					currentVO.initialName = infoList.label.labels.get(1).getText();
					currentVO.time = infoList.label.labels.get(2).getText();
					if(initialbl.addInitial(currentVO)==ResultMessage.SUCCESS){
						ELSPanel parent = GetPanelUtil.getSubFunctionPanel(InitialAddPanel.this, 3);
						ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(InitialAddPanel.this), "建账成功");
						InitialCheckPanel checkPanel = (InitialCheckPanel)parent.getComponent(0);
						parent.cl.show(parent, "manage");
						parent.remove(InitialAddPanel.this);
						try {
							checkPanel.initialVOs = initialbl.show();
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						checkPanel.init();
					}else{
						ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(InitialAddPanel.this), "建账失败");
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}else if(e.getSource()==cancelBtn){
				if(ELSDialog.showConfirmDlg(GetPanelUtil.getFunctionPanel(InitialAddPanel.this), "取消创建", "确认取消创建新账本？")){
					ELSPanel parent = GetPanelUtil.getSubFunctionPanel(InitialAddPanel.this, 3);
					parent.cl.show(parent, "manage");
					parent.remove(InitialAddPanel.this);
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
	
}
