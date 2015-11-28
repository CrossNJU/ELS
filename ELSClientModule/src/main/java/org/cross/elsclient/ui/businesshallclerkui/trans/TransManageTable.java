package org.cross.elsclient.ui.businesshallclerkui.trans;

import java.util.ArrayList;

import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.ui.adminui.UserManageTable;
import org.cross.elsclient.ui.component.ELSManageTable;
import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.vo.Receipt_TransVO;

public class TransManageTable extends ELSManageTable{
	ReceiptBLService reciptbl;
	ArrayList<Receipt_TransVO> transVOs;
	
	public TransManageTable(){super();}
	public TransManageTable(String[] name, int[] itemWidth, ReceiptBLService receiptbl){
		super(name, itemWidth);
		this.reciptbl = receiptbl;
		init();
	}
	
	@Override
	public void init(){
		super.init();
		transVOs = new ArrayList<Receipt_TransVO>();
		isUpdateAndDelete = false;
	}
	
	public void addItem(Receipt_TransVO vo){
		transVOs.add(vo);
		String[] item = {vo.number,vo.type.toString(),vo.time,vo.approveState.toString()};
		addItemLabel(item);
	}
	
	@Override
	public void infoBtn(int index){
		super.updateBtn(index);
		ELSPanel contentPanel = GetPanelUtil.getSubFunctionPanel(this, 0);
		Receipt_TransVO vo = transVOs.get(index);
		contentPanel.add("info", new TransInfoPanel(vo));
		contentPanel.cl.show(contentPanel, "info");
	}
}
