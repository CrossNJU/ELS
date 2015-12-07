package org.cross.elsclient.ui.businesshallclerkui.money;

import java.rmi.RemoteException;
import java.util.ArrayList;

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
import org.cross.elsclient.vo.Receipt_MoneyInVO;
import org.cross.elsclient.vo.UserVO;
import org.cross.elscommon.util.OrganizationType;
import org.cross.elscommon.util.PositionType;
import org.cross.elscommon.util.ReceiptType;
import org.cross.elscommon.util.ResultMessage;

public class MoneyAddPanel extends ELSInfoPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Receipt_MoneyInVO moneyinvo;
	ReceiptBLService bl;
	UserVO user;

	public MoneyAddPanel(ReceiptBLService receiptbl, UserVO user) {
		this.bl = receiptbl;
		this.user = user;
		init();
	}

	@Override
	public void init() {
		super.init();
		titlePanel.remove(titlePanel.backBtn);
		setTitle("新增收款单");
		/* 0 */addEditableItem("收款单编号", ConstantValue.getReceiptNum(ReceiptType.MONEYIN), false);
		addEditableItem("快件单编号", "", true);
		addEditableItem("收款时间", "", true);
		/*3*/addEditableItem("收款快递员", "", true);
		addEditableItem("收款金额", "", true);
		addConfirmAndCancelBtn();
		confirmBtn.setText("确认添加");
		cancelBtn.setText("查看单据");
		container.packHeight();
	}

	@Override
	protected void confirm() throws RemoteException {
		String[] orders = itemLabels.get(1).toString().split(";");
		ArrayList<String> orderNums = new ArrayList<String>();
		for (int i = 0; i < orders.length; i++) {
			orderNums.add(orders[i]);
		}
		moneyinvo = new Receipt_MoneyInVO(itemLabels.get(2).toString(), Double.valueOf(itemLabels.get(4).toString()),
				itemLabels.get(3).toString(), itemLabels.get(0).toString(), 
				orderNums, user.orgNameID, user.number);
		if (bl.add(moneyinvo) == ResultMessage.SUCCESS) {
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
