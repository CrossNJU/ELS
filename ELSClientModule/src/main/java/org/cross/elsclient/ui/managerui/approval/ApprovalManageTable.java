package org.cross.elsclient.ui.managerui.approval;

import java.util.ArrayList;

import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.ui.adminui.UserInfoPanel;
import org.cross.elsclient.ui.component.ELSManageTable;
import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.vo.ReceiptVO;
import org.cross.elsclient.vo.UserVO;

public class ApprovalManageTable extends ELSManageTable {
	ReceiptBLService receiptbl;
	ArrayList<ReceiptVO> vos;

	public ApprovalManageTable(String name[],int itemWidth[],ReceiptBLService receiptbl) {
		super(name, itemWidth);
		this.receiptbl = receiptbl;
		init();
	}
	
	@Override
	public void init() {
		super.init();
		vos = new ArrayList<>();
		isUpdateAndDelete = false;
	}
	
	public void addItem(ReceiptVO vo){
		vos.add(vo);
		
		String[] item = {vo.number,vo.type.toString(),vo.time,vo.approveState.toString()};
		addItemLabel(item);
	}
	
	@Override
	public void infoBtn(int index) {
		super.infoBtn(index);
		ELSPanel contentPanel  = GetPanelUtil.getSubFunctionPanel(this, "receiptApproval");
		ReceiptVO vo = vos.get(index);
		contentPanel.add("info",new ApprovalInfoPanel(vo,receiptbl));
		contentPanel.cl.show(contentPanel, "info");
	}
}
