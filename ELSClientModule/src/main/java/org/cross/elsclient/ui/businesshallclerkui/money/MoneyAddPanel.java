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
import org.cross.elsclient.ui.util.LogUtil;
import org.cross.elsclient.util.ConstantVal;
import org.cross.elsclient.vo.PersonnelVO;
import org.cross.elsclient.vo.Receipt_MoneyInVO;
import org.cross.elsclient.vo.Receipt_OrderVO;
import org.cross.elsclient.vo.UserVO;
import org.cross.elscommon.util.NumberType;
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
	String number;

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
		number = ConstantVal.numberbl.getPostNumber(NumberType.RECEIPT);
		/* 0 */addEditableItem("收款单编号", number, false, "number");
		addEditableItem("快件单编号", "", true, "goodsnum");
		addDateItem("收款时间", false, "time");
		/* 3 */addEditableItem("收款快递员ID", "", true, "perid");
		addEditableItem("收款金额", "", true, "money");
		addConfirmAndCancelBtn();
		confirmBtn.setText("确认添加");
		cancelBtn.setText("查看单据");
		container.packHeight();
	}

	@Override
	protected void confirm() throws RemoteException {
		if (isAllLegal()) {
			String cnumber = findItem("number").toString();
			String goodsnum = findItem("goodsnum").toString();
			String time = findItem("time").toString();
			String perid = findItem("perid").toString();
			String money = findItem("money").toString();
			String[] orders = goodsnum.split(";");
			ArrayList<String> orderNums = new ArrayList<String>();
			for (int i = 0; i < orders.length; i++) {
				orderNums.add(orders[i]);
			}
			moneyinvo = new Receipt_MoneyInVO(time,
					Double.valueOf(money), perid, cnumber,
					orderNums, user.orgNameID, user.number);
			for (int i = 0; i < orders.length; i++) {
				Receipt_OrderVO order = (Receipt_OrderVO) bl
						.findByID(orders[i]);
				order.moneyinNum = cnumber;
				bl.update(order);
			}
			if (bl.add(moneyinvo) == ResultMessage.SUCCESS) {
				LogUtil.addLog("新增收款单");
				ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this),
						"添加成功");
				ELSFunctionPanel parent = GetPanelUtil.getFunctionPanel(this);
				ConstantVal.numberbl.addone(NumberType.RECEIPT, number);
				// parent.contentPanel.cl.show(parent.contentPanel, "receipts");
				parent.setChosenFunction("receipts");
			} else {
				ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this),
						"添加失败");
			}
		}
	}

	@Override
	protected void cancel() {
		if (ELSDialog.showConfirmDlg(GetPanelUtil.getFunctionPanel(this),
				"取消新增", "确认放弃新增单据？")) {
			ELSFunctionPanel parent = GetPanelUtil.getFunctionPanel(this);
			// parent.contentPanel.cl.show(parent.contentPanel, "receipts");?
			parent.setChosenFunction("receipts");
		}
	}

}
