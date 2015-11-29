package org.cross.elsclient.ui.businesshallclerkui;

import java.util.ArrayList;

import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.ui.adminui.UserManageTable;
import org.cross.elsclient.ui.businesshallclerkui.trans.TransInfoPanel;
import org.cross.elsclient.ui.component.ELSManageTable;
import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.vo.ReceiptVO;
import org.cross.elsclient.vo.Receipt_TransVO;

public class ReceiptManageTable extends ELSManageTable{
	ReceiptBLService reciptbl;
	ArrayList<ReceiptVO> receiptvos;
	
	public ReceiptManageTable(){super();}
	public ReceiptManageTable(String[] name, int[] itemWidth, ReceiptBLService receiptbl){
		super(name, itemWidth);
		this.reciptbl = receiptbl;
		init();
	}
	
	@Override
	public void init(){
		super.init();
		receiptvos = new ArrayList<ReceiptVO>();
		isUpdateAndDelete = false;
	}
	
	public void addItem(ReceiptVO vo){
		receiptvos.add(vo);
		String[] item = {vo.number,vo.type.toString(),vo.time,vo.approveState.toString()};
		addItemLabel(item);
	}
	
	@Override
	public void infoBtn(int index){
		super.updateBtn(index);
		ELSPanel contentPanel = GetPanelUtil.getSubFunctionPanel(this, 0);
		ReceiptVO vo = receiptvos.get(index);
		contentPanel.add("info", new TransInfoPanel((Receipt_TransVO)vo));
		contentPanel.cl.show(contentPanel, "info");
	}
}
