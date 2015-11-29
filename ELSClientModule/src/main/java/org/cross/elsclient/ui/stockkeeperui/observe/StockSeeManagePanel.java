package org.cross.elsclient.ui.stockkeeperui.observe;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;

import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.blservice.stockblservice.StockBLService;
import org.cross.elsclient.ui.businesshallclerkui.ReceiptManageTable;
import org.cross.elsclient.ui.component.ELSButton;
import org.cross.elsclient.ui.component.ELSDatePicker;
import org.cross.elsclient.ui.component.ELSManagePanel;
import org.cross.elsclient.ui.util.ComponentFactory;
import org.cross.elsclient.ui.util.UIConstant;
import org.cross.elsclient.vo.Receipt_TransVO;
import org.cross.elsclient.vo.StockAreaVO;
import org.cross.elsclient.vo.StockVO;

public class StockSeeManagePanel extends ELSManagePanel{
	ReceiptBLService receiptbl;
	StockBLService stockbl;
	StockVO stockvo;
	StockSeeManageTable list;
	ELSDatePicker datePicker1;
	ELSDatePicker datePicker2;
	ELSButton addBtn;
	
	public StockSeeManagePanel(){}
	public StockSeeManagePanel(ReceiptBLService receiptbl){
		super();
		this.receiptbl = receiptbl;
		init();
	}
	
	@Override
	public void setContentPanel(){
		super.setContentPanel();
		String[] s = {"出库数量","出库金额","入库数量","入库金额","库存数量合计"};
		int[] itemWidth = {100,100,100,100,100};
		list = new StockSeeManageTable(s, itemWidth,receiptbl);
		list.setLocation(UIConstant.CONTENTPANEL_MARGIN_LEFT,UIConstant.CONTENTPANEL_MARGIN_TOP*2+UIConstant.SEARCHPANEL_HEIGHT);
		container.add(list);
	}
	
	@Override
	public void setSearchPanel(){
		datePicker1 = ComponentFactory.createDatePicker();
		datePicker2 = ComponentFactory.createDatePicker();

//		String[] s = {"按单据编号查询", "按时间查询"};
//		modeBox.setModel(new DefaultComboBoxModel<String>(s));
//		modeBox.addItemListener(new ModeBoxItemListener());
		
		searchBtn.setText("查看库存情况");
		searchBtn.addMouseListener(new BtnListener());
		
		searchPanel.add(Box.createHorizontalStrut(10));
		
		datePicker1.setVisible(true);
		datePicker2.setVisible(true);
		
		searchPanel.add(datePicker1,3);
		searchPanel.add(datePicker2,3);
		searchPanel.validate();
	}

	class BtnListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			for (int i = 0; i < stockvo.stockAreas.size(); i++) {
				StockAreaVO area  = stockvo.stockAreas.get(i);
				for (int j = 0; j < area.goodsList.size(); j++) {
					list.addItem(area.goodsList.get(j), area.number);
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
