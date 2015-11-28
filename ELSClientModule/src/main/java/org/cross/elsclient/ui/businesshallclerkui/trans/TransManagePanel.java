package org.cross.elsclient.ui.businesshallclerkui.trans;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;

import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.ui.component.ELSButton;
import org.cross.elsclient.ui.component.ELSComboBox;
import org.cross.elsclient.ui.component.ELSDatePicker;
import org.cross.elsclient.ui.component.ELSManagePanel;
import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.ui.util.ComponentFactory;
import org.cross.elsclient.ui.util.UIConstant;
import org.cross.elsclient.vo.ReceiptVO;
import org.cross.elsclient.vo.Receipt_TransVO;
import org.cross.elsclient.vo.UserVO;
import org.cross.elscommon.util.ReceiptType;
import org.cross.elscommon.util.UserType;

public class TransManagePanel extends ELSManagePanel{
	ReceiptBLService receiptbl;
	ArrayList<Receipt_TransVO> transvos;
	TransManageTable list;
	ELSDatePicker datePicker;
	ELSButton addBtn;
	
	public TransManagePanel(){}
	public TransManagePanel(ReceiptBLService receiptbl){
		super();
		this.receiptbl = receiptbl;
		init();
	}
	
	@Override
	public void setContentPanel(){
		super.setContentPanel();
		String[] s = {"单据编号","单据类型","建单时间","单据状态"};
		int[] itemWidth = {200,100,200,100};
		list = new TransManageTable(s, itemWidth,receiptbl);
		list.setLocation(UIConstant.CONTENTPANEL_MARGIN_LEFT,UIConstant.CONTENTPANEL_MARGIN_TOP*2+UIConstant.SEARCHPANEL_HEIGHT);
		container.add(list);
	}
	
	@Override
	public void setSearchPanel(){
		datePicker = ComponentFactory.createDatePicker();
		addBtn = ComponentFactory.createSearchBtn();

		String[] s = {"按单据编号查询", "按时间查询"};
		modeBox.setModel(new DefaultComboBoxModel<String>(s));
		modeBox.addItemListener(new ModeBoxItemListener());
		
		searchBtn.setText("查找单据");
		searchBtn.addMouseListener(new BtnListener());
		
		addBtn.setText("新增单据");
		addBtn.addMouseListener(new BtnListener());
		
		searchPanel.add(Box.createHorizontalStrut(10));
		searchPanel.add(addBtn);
		
		datePicker.setVisible(false);
		
		searchPanel.add(datePicker,3);
		searchPanel.validate();
	}

	class BtnListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
			if(e.getSource()==searchBtn){
				if(((String)modeBox.getSelectedItem()).equals("按单据编号查询")){
					String id = searchTextField.getText();
					Receipt_TransVO vo = null;
					try {
						vo = (Receipt_TransVO)receiptbl.findByID(id);
						
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}
					list.init();
					list.addItem(vo);
					container.packHeight();
				}else if(((String)modeBox.getSelectedItem()).equals("按时间查询")){
					
				}
			}
			if (e.getSource() == addBtn){
				//界面统一添加到功能界面(managePanel的父容器)
				TransAddPanel transAddPanel = new TransAddPanel(receiptbl);
				ELSPanel parent = (ELSPanel) getParent();
				parent.add("add",transAddPanel);
				parent.cl.show(parent, "add");
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
				case "按单据编号查询":
					searchTextField.setVisible(true);
					datePicker.setVisible(false);
					break;
				case "按时间查询":
					searchTextField.setVisible(false);
					datePicker.setVisible(true);
					break;
				default:
					searchTextField.setVisible(false);
					break;
				}
			}
		}
	}
}
