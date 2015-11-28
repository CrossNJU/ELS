package org.cross.elsclient.ui.counterui.log;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.sound.sampled.AudioFormat.Encoding;
import javax.swing.Box;

import org.cross.elsclient.blservice.logblservice.LogBLService;
import org.cross.elsclient.ui.adminui.UserAddPanel;
import org.cross.elsclient.ui.adminui.UserManageTable;
import org.cross.elsclient.ui.component.ELSDatePicker;
import org.cross.elsclient.ui.component.ELSManagePanel;
import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.ui.util.ComponentFactory;
import org.cross.elsclient.ui.util.UIConstant;
import org.cross.elsclient.vo.LogVO;
import org.cross.elsclient.vo.UserVO;
import org.cross.elscommon.util.UserType;

public class LogManagePanel extends ELSManagePanel{
	LogBLService logbl;
	ArrayList<LogVO> logvos; 
	LogManageTable list;
	ELSDatePicker beginDate;
	ELSDatePicker endDate;
	
	public LogManagePanel(LogBLService logbl) {
		super();
		this.logbl = logbl;
		init();
	}
	
	@Override
	public void setContentPanel() {
		// TODO Auto-generated method stub
		super.setContentPanel();
		String[] s = {"操作时间","操作人员","操作内容"};
		int[] itemWidth = {150,100,200};
		list= new LogManageTable(s,itemWidth,logbl);
		list.setLocation(UIConstant.CONTENTPANEL_MARGIN_LEFT,UIConstant.CONTENTPANEL_MARGIN_TOP*2+UIConstant.SEARCHPANEL_HEIGHT);
		container.add(list);
	}
	
	@Override
	public void setSearchPanel() {
		// TODO Auto-generated method stub
		super.setSearchPanel();
		beginDate = ComponentFactory.createDatePicker();
		endDate = ComponentFactory.createDatePicker();
		
		searchBtn.setText("查看系统日志");
		searchBtn.setMaximumSize(new Dimension(250, UIConstant.SEARCHPANEL_HEIGHT));
		
		beginDate.setMaximumSize(new Dimension(300, UIConstant.SEARCHPANEL_HEIGHT));
		endDate.setMaximumSize(new Dimension(300, UIConstant.SEARCHPANEL_HEIGHT));
		
		searchPanel.removeAll();
		searchPanel.add(beginDate);
		searchPanel.add(Box.createHorizontalStrut(10));
		searchPanel.add(endDate);
		searchPanel.add(Box.createHorizontalStrut(10));
		searchPanel.add(searchBtn);
		
		searchPanel.validate();
		
	}
	
	class BtnListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			logvos = new ArrayList<>();
			try {
				logvos = logbl.show(beginDate.getDate(), endDate.getDate());
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			for (LogVO logVO : logvos) {
				list.addItem(logVO);
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
