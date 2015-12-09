package org.cross.elsclient.ui.counterui.initial;

import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

import org.cross.elsclient.blservice.initialblservice.InitialBLService;
import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.vo.InitialVO;

public class InitialCheckPanel extends InitialManagePanel {
	ArrayList<InitialVO> initialVOs;
	

	public InitialCheckPanel(InitialBLService initialbl) {
		super(initialbl);
		try {
			initialVOs = initialbl.show();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		init();
	}

	@Override
	public void setSearchPanel() {
		super.setSearchPanel();
		modeBox.setMaximumSize(new Dimension(searchPanel.getWidth(), searchPanel.getHeight()));
		modeBox.setPreferredSize(new Dimension(searchPanel.getWidth(), (int)(searchPanel.getHeight()*0.6)));
		String[] items = new String[initialVOs.size()];
		for(int i = 0;i<initialVOs.size();i++){
			items[i] = initialVOs.get(i).initialName;
		}
		modeBox.setModel(new DefaultComboBoxModel<>(items));
		modeBox.addItemListener(new ModeListener());
		
		searchBtn.setPreferredSize(new Dimension(250, searchPanel.getHeight()));
		searchBtn.setText("期初建账");
		searchBtn.addMouseListener(new BtnListener());
		searchPanel.remove(searchTextField);
		
		currentVO = initialVOs.get(0);
	}
	
	public class ModeListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange()==ItemEvent.SELECTED){
				int index = modeBox.getSelectedIndex();
				currentVO = initialVOs.get(index);
				refresh();
			}
			
		}
	}
	
	public class BtnListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			ELSPanel parent = GetPanelUtil.getSubFunctionPanel(InitialCheckPanel.this, 3);
			parent.add("add",new InitialAddPanel(initialbl));
			parent.cl.show(parent, "add");
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
