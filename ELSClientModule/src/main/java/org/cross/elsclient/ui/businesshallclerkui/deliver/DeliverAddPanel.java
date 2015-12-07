package org.cross.elsclient.ui.businesshallclerkui.deliver;

import java.awt.Window.Type;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.receiptblimpl.Receipt_Order;
import org.cross.elsclient.blimpl.userblimpl.User;
import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.ui.businesshallclerkui.ReceiptManagePanel;
import org.cross.elsclient.ui.component.ELSDialog;
import org.cross.elsclient.ui.component.ELSFunctionPanel;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.util.ConstantValue;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.vo.PersonnelVO;
import org.cross.elsclient.vo.Receipt_ArriveVO;
import org.cross.elsclient.vo.Receipt_DeliverVO;
import org.cross.elsclient.vo.Receipt_OrderVO;
import org.cross.elsclient.vo.Receipt_TransVO;
import org.cross.elsclient.vo.UserVO;
import org.cross.elscommon.util.OrganizationType;
import org.cross.elscommon.util.PositionType;
import org.cross.elscommon.util.ReceiptType;
import org.cross.elscommon.util.ResultMessage;

public class DeliverAddPanel extends ELSInfoPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Receipt_DeliverVO delvo;
	ReceiptBLService receiptbl;
	UserVO user;

	public DeliverAddPanel(ReceiptBLService receiptbl, UserVO user) {
		this.receiptbl = receiptbl;
		this.user = user;
		init();
	}

	@Override
	public void init() {
		super.init();
		titlePanel.remove(titlePanel.backBtn);
		setTitle("新增派件单");
		/* 0 */addEditableItem("派件单编号", ConstantValue.getReceiptNum(ReceiptType.TRANS), false);
		addDateItem("派件时间", false);
		addEditableItem("快件单编号", "", true);
		addEditableItem("快递员工号", "", true);
		addEditableItem("快递员姓名", "", true);
		addConfirmAndCancelBtn();
		confirmBtn.setText("确认添加");
		cancelBtn.setText("查看单据");
		container.packHeight();
	}

	@Override
	protected void confirm() throws RemoteException {
		delvo = new Receipt_DeliverVO(itemLabels.get(0).toString(), itemLabels.get(1).toString(), itemLabels.get(2).toString(), itemLabels.get(4).toString(),
				itemLabels.get(3).toString(),user.number, user.orgNameID);
		if (receiptbl.add(delvo) == ResultMessage.SUCCESS) {
			ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this), "添加成功");
			ELSFunctionPanel parent = GetPanelUtil.getFunctionPanel(this);
			parent.contentPanel.cl.show(parent.contentPanel, "receipts");
		} else {
			ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this), "添加失败");
		}
	}

	@Override
	protected void cancel() {
		if (ELSDialog.showConfirmDlg(GetPanelUtil.getFunctionPanel(this), "取消新增", "确认放弃新增单据？")) {
			ELSFunctionPanel parent = GetPanelUtil.getFunctionPanel(this);
			parent.contentPanel.cl.show(parent.contentPanel, "receipts");
		}
	}

}
