package org.cross.elsclient.ui.courierui.goodscheck;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;

import org.cross.elsclient.blservice.goodsblservice.GoodsBLService;
import org.cross.elsclient.ui.adminui.UserManageTable;
import org.cross.elsclient.ui.component.ELSManagePanel;
import org.cross.elsclient.ui.util.UIConstant;
import org.cross.elsclient.vo.GoodsVO;

public class GoodsCheckPanel extends ELSManagePanel{
	GoodsBLService goodsbl;
	GoodsVO goodsVo;
	GoodsCheckTable list;
	
	@Override
	public void setContentPanel() {
		super.setContentPanel();
		
		String[] s = {"出发地","出发时间","到达地","到达时间"};
		int[] itemWidth = {100,200,100,200};
		list= new GoodsCheckTable(s, itemWidth);
		list.setLocation(UIConstant.CONTENTPANEL_MARGIN_LEFT,UIConstant.CONTENTPANEL_MARGIN_TOP*2+UIConstant.SEARCHPANEL_HEIGHT);
		container.add(list);
	}
	
	@Override
	public void setSearchPanel() {
		searchPanel.remove(modeBox);
		searchPanel.remove(0);
		
		searchBtn.setText("查询订单状态");
		searchBtn.addMouseListener(new BtnListener());
		
		searchPanel.validate();
	}
	
	class BtnListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
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
