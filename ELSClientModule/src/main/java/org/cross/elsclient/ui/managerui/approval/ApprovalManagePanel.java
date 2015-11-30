package org.cross.elsclient.ui.managerui.approval;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;

import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.ui.adminui.UserAddPanel;
import org.cross.elsclient.ui.component.ELSButton;
import org.cross.elsclient.ui.component.ELSComboBox;
import org.cross.elsclient.ui.component.ELSManagePanel;
import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.ui.util.ComponentFactory;
import org.cross.elsclient.ui.util.UIConstant;
import org.cross.elsclient.vo.ReceiptVO;
import org.cross.elsclient.vo.UserVO;
import org.cross.elscommon.util.ApproveType;
import org.cross.elscommon.util.UserType;


//完善按建单时间查找
public class ApprovalManagePanel extends ELSManagePanel {
	ReceiptBLService receiptbl;
	ArrayList<ReceiptVO> receiptVOs;
	ApprovalManageTable list;
	ELSButton checkBtn;
	ELSComboBox typeCombobox;

	public ApprovalManagePanel(ReceiptBLService receiptbl) {
		super();
		this.receiptbl = receiptbl;
		init();
	}

	@Override
	public void setContentPanel() {
		// TODO Auto-generated method stub
		super.setContentPanel();
		String name[] = { "单据编号", "单据类型", "建单时间", "状态" };
		int itemWidth[] = { 150, 100, 150, 100 };
		list = new ApprovalManageTable(name, itemWidth, receiptbl);
		list.setLocation(UIConstant.CONTENTPANEL_MARGIN_LEFT,
				UIConstant.CONTENTPANEL_MARGIN_TOP * 2
						+ UIConstant.SEARCHPANEL_HEIGHT);
		container.add(list);
	}

	@Override
	public void setSearchPanel() {
		super.setSearchPanel();
		checkBtn = ComponentFactory.createSearchBtn();
		typeCombobox = ComponentFactory.createSearchBox();

		// 设置搜索模式
		String[] s = { "按单据编号查找", "按单据类型查找", "按建单时间查找" };
		modeBox.setModel(new DefaultComboBoxModel<String>(s));
		modeBox.addItemListener(new ModeBoxItemListener());

		// 设置类型选择的搜索下拉框
		String[] types = { "到达单","收款单","付款单","订单","入库单","出库单","转运单","总收款单"};
		typeCombobox.setModel(new DefaultComboBoxModel<String>(types));

		// 搜索按钮设置文字和监听
		searchBtn.setText("查找单据");
		searchBtn.addMouseListener(new BtnListener());

		// 添加按钮设置文字和监听
		checkBtn.setText("查看未审批");
		checkBtn.addMouseListener(new BtnListener());

		// 添加间隔
		searchPanel.add(Box.createHorizontalStrut(10));
		searchPanel.add(checkBtn);
		
		searchPanel.add(typeCombobox,3);
		searchPanel.validate();
		
	}

	class BtnListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
			if(e.getSource()==searchBtn){
				if(((String)modeBox.getSelectedItem()).equals("按单据编号查找")){
					String id = searchTextField.getText();
					receiptVOs = new ArrayList<>();
					try {
//						userVOs.add(userbl.findById(id));
						receiptVOs.add(receiptbl.findByID(id));
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}
					list.init();
					for (ReceiptVO receiptVO : receiptVOs) {
						list.addItem(receiptVO);
					}
					container.packHeight();
				}else if(((String)modeBox.getSelectedItem()).equals("按时间查询")){
					
				}else if(((String)modeBox.getSelectedItem()).equals("按单据类型查找")){
					String type = (String)typeCombobox.getSelectedItem();
					receiptVOs = new ArrayList<>();
					try {
						receiptVOs = receiptbl.show();
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}
					list.init();
					for (ReceiptVO receiptVO : receiptVOs) {
						list.addItem(receiptVO);
					}
					container.packHeight();
				}
			}
			if (e.getSource() == checkBtn){
				ArrayList<ReceiptVO> tempArray = new ArrayList<>();
				list.init();
				for (ReceiptVO receiptVO : receiptVOs) {
					if(receiptVO.approveState==ApproveType.UNCHECKED){
						tempArray.add(receiptVO);
						list.addItem(receiptVO);
					}
				}
				container.packHeight();
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
	
	
	/**
	 * 搜索模式的监听类
	 * @author Moo
	 * @date 2015年11月26日
	 */
	class ModeBoxItemListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange()==ItemEvent.SELECTED){
				String item = (String)modeBox.getSelectedItem();
				switch (item) {
				case "按单据编号查找":
					searchTextField.setVisible(true);
					typeCombobox.setVisible(false);
					break;
				case "按单据类型查找":
					searchTextField.setVisible(false);
					typeCombobox.setVisible(true);
					break;
				case "按建单时间查找":
					searchTextField.setVisible(false);
					typeCombobox.setVisible(false);
					break;
				default:
					searchTextField.setVisible(false);
					break;
				}
			}
		}
		
	}
}
