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
import org.cross.elsclient.vo.StockCheckVO;
import org.cross.elsclient.vo.StockSeeVO;
import org.cross.elsclient.vo.StockVO;
import org.cross.elsclient.vo.UserVO;

public class StockSeeManagePanel extends ELSManagePanel{
	StockBLService stockbl;
	StockSeeVO stocksee;
	StockVO stock;
	UserVO user;
	
	StockSeeManageTableFirst listFirst;
	StockSeeManageTableSecond listSecond;
	ELSDatePicker datePicker1;
	ELSDatePicker datePicker2;
	ELSButton addBtn;
	
	public StockSeeManagePanel(){}
	public StockSeeManagePanel(StockBLService stockbl, UserVO user){
		super();
		this.stockbl = stockbl;
		this.user = user;
		try {
			stock = stockbl.findStockByOrg(user.orgNameID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		init();
	}
	
	@Override
	public void setContentPanel(){
		super.setContentPanel();
		String[] s = {"出库数量","出库金额","入库数量","入库金额","库存数量合计"};
		int[] itemWidth = {100,100,100,100,100};
		listFirst = new StockSeeManageTableFirst(s, itemWidth);
		listFirst.setLocation(UIConstant.CONTENTPANEL_MARGIN_LEFT,UIConstant.CONTENTPANEL_MARGIN_TOP*2+UIConstant.SEARCHPANEL_HEIGHT);
		container.add(listFirst);
		String[] s2 = {"快件单编号","存放位置"};
		int[] itemWidth2 = {200,200};
		listSecond = new StockSeeManageTableSecond(s2, itemWidth2);
		listFirst.setLocation(UIConstant.CONTENTPANEL_MARGIN_LEFT,UIConstant.CONTENTPANEL_MARGIN_TOP*4+UIConstant.SEARCHPANEL_HEIGHT);
		container.add(listSecond);
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
		
		searchPanel.remove(modeBox);
		searchPanel.remove(searchTextField);
		searchPanel.add(datePicker1,3);
		searchPanel.add(datePicker2,3);
		searchPanel.validate();
	}

	class BtnListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			try {
				stocksee = stockbl.showStockInfo(stock.number, datePicker1.getDateString(), datePicker2.getDateString());
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			listFirst.addItem(stocksee);
			for (int i = 0; i < stocksee.goods.size(); i++) {
				listSecond.addItem(stocksee.goods.get(i));
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
