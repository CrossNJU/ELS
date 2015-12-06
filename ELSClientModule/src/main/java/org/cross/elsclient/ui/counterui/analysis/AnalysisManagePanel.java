package org.cross.elsclient.ui.counterui.analysis;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.Box;

import org.cross.elsclient.blservice.analysisblservice.AnalysisBLService;
import org.cross.elsclient.ui.component.ELSDatePicker;
import org.cross.elsclient.ui.component.ELSDialog;
import org.cross.elsclient.ui.component.ELSManagePanel;
import org.cross.elsclient.ui.component.ELSManageTable;
import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.ui.component.TitlePanel;
import org.cross.elsclient.ui.counterui.account.AccoutAddPanel;
import org.cross.elsclient.ui.counterui.log.LogManagePanel;
import org.cross.elsclient.ui.util.ComponentFactory;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.ui.util.UIConstant;
import org.cross.elsclient.vo.AccountVO;
import org.cross.elsclient.vo.ReceiptVO;

public class AnalysisManagePanel extends ELSManagePanel {
	AnalysisBLService analysisbl;
	ArrayList<ReceiptVO> receiptVOs;
	ELSDatePicker beginDate;
	ELSDatePicker endDate;
	ELSManageTable list1;
	AnalysisManageTable list2;
	TitlePanel title1;
	TitlePanel title2;

	public AnalysisManagePanel(AnalysisBLService analysisbl) {
		super();
		this.analysisbl = analysisbl;
		init();
	}

	@Override
	public void init() {
		super.init();
	}
	
	@Override
	public void setSearchPanel() {
		super.setSearchPanel();
		beginDate = ComponentFactory.createDatePicker();
		endDate = ComponentFactory.createDatePicker();

		searchBtn.setText("查看收/付款单");
		searchBtn.setMaximumSize(new Dimension(250,
				UIConstant.SEARCHPANEL_HEIGHT));
		searchBtn.addMouseListener(new BtnListener());

		beginDate.setMaximumSize(new Dimension(300,
				UIConstant.SEARCHPANEL_HEIGHT));
		endDate.setMaximumSize(new Dimension(300, UIConstant.SEARCHPANEL_HEIGHT));

		searchPanel.setLocation(UIConstant.CONTENTPANEL_MARGIN_LEFT, title2.getLocation().y+title2.getHeight()+15);
		searchPanel.removeAll();
		searchPanel.add(beginDate);
		searchPanel.add(Box.createHorizontalStrut(10));
		searchPanel.add(endDate);
		searchPanel.add(Box.createHorizontalStrut(10));
		searchPanel.add(searchBtn);

		searchPanel.validate();
	}
	
	@Override
	public void setContentPanel() {
		// TODO Auto-generated method stub
		super.setContentPanel();
		String[] name1 = {"总收入", "总支出","总利润"};
		int[] itemWidth1 = {200,200,200};
		list1 = new ELSManageTable(name1, itemWidth1);
		double[] data = analysisbl.showCostBenefitTable();
		String[] item = {data[0]+"",data[1]+"",data[2]+""};
		list1.init();
		list1.setLocation(UIConstant.CONTENTPANEL_MARGIN_LEFT, title1.getHeight()+title1.getLocation().y+15);
		list1.addItemLabel(item);
		
		String[] name2 = {"单据编号","类型","建单时间","金额"};
		int[] itemWidth2 = {150,100,150,100};
		list2 = new AnalysisManageTable(name2, itemWidth2, analysisbl);
		list2.setLocation(UIConstant.CONTENTPANEL_MARGIN_LEFT, searchPanel.getHeight()+searchPanel.getLocation().y+15);
		
		this.container.add(list1);
		this.container.add(list2);
	
	}
	
	public void setTitle(){
		title1 = new TitlePanel();
		title2 = new TitlePanel();
		
		title1.init("成本收益表");
		title1.setLocation(UIConstant.CONTENTPANEL_MARGIN_LEFT, UIConstant.CONTENTPANEL_MARGIN_TOP);
		title1.remove(title1.backBtn);
		
		title2.init("经营情况表");
		title2.setLocation(UIConstant.CONTENTPANEL_MARGIN_LEFT, 200);
		title2.remove(title2.backBtn);
		
		this.container.add(title1);
		this.container.add(title2);
	}
	
	class BtnListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			if(beginDate.getDate().compareTo(endDate.getDate())<1){
				receiptVOs = new ArrayList<>();
				receiptVOs.addAll(analysisbl.showMoneyinTable(beginDate.getDateString(), endDate.getDateString()));
				receiptVOs.addAll(analysisbl.showMoneyoutTable(beginDate.getDateString(), endDate.getDateString()));
				for (ReceiptVO receiptVO : receiptVOs) {
					list2.addItem(receiptVO);
				}
				container.packHeight();
			}else{
				ELSDialog.showConfirmDlg(GetPanelUtil.getMainFrame(AnalysisManagePanel.this), "时间矛盾", "起始时间大于结束时间");
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
