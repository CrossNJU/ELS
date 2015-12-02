package org.cross.elsclient.ui.businesshallclerkui.trans;

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
import org.cross.elsclient.vo.Receipt_TransVO;
import org.cross.elscommon.util.City;
import org.cross.elscommon.util.OrganizationType;
import org.cross.elscommon.util.PositionType;
import org.cross.elscommon.util.ReceiptType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StringToType;

public class TransAddPanel extends ELSInfoPanel {
	Receipt_TransVO vo;
	ReceiptBLService bl;

	public TransAddPanel(ReceiptBLService receiptbl) {
		this.bl = receiptbl;
		init();
	}

	@Override
	public void init() {
		super.init();
		titlePanel.remove(titlePanel.backBtn);
		String it1[] = { "南京营业厅", "北京营业厅", "上海营业厅", "广州营业厅" };
		String it2[] = { "营业厅", "中转中心" };
		String it3[] = ConstantValue.getUnusedVehicle();
		String it4[] = ConstantValue.getUnusedDriver();
		String it5[] = ConstantValue.getUnusedObserver();

		setTitle("新增装车单");
		/* 0 */addEditableItem("装车单编号", ConstantValue.getReceiptTransNum(), false);
		addEditableItem("快件单编号", "R2000001;R20000002", false);
		addComboxItem("出发地", it1, true);
		addComboxItem("到达城市", it1, true);
		addComboxItem("到达机构", it2, true);
		/* 5 */addEditableItem("装车时间", ConstantValue.getTime(), false);
		addEditableItem("运输编号", ConstantValue.getReceiptTransLocalNum(), false);
		addComboxItem("车辆编号", it3, true);
		addComboxItem("押运员", it4, true);
		addComboxItem("监装员", it5, true);
		addEditableItem("运费($)", String.valueOf(ConstantValue.getTrans(City.NANJING, City.BEIJING)), true);
		addConfirmAndCancelBtn();
		confirmBtn.setText("确认添加");
		cancelBtn.setText("查看单据");
		container.packHeight();
	}

	@Override
	protected void confirm() throws RemoteException {
		ArrayList<String> goods = new ArrayList<String>();
		String[] temp = itemLabels.get(1).toString().split(";");
		for (int i = 0; i < temp.length; i++) {
			goods.add(temp[i]);
		}
		vo = new Receipt_TransVO(itemLabels.get(0).toString(), ReceiptType.TRANS, ConstantValue.getTime(), goods,
				Double.valueOf(itemLabels.get(10).toString()), OrganizationType.BUSINESSHALL,
				itemLabels.get(6).toString(), itemLabels.get(7).toString(),
				StringToType.toCity(itemLabels.get(2).toString()), StringToType.toCity(itemLabels.get(3).toString()),
				new PersonnelVO(itemLabels.get(9).toString(), null, PositionType.DRIVER, OrganizationType.BUSINESSHALL,
						itemLabels.get(6).toString()),
				new PersonnelVO(itemLabels.get(8).toString(), null, PositionType.DRIVER, OrganizationType.BUSINESSHALL,
						itemLabels.get(6).toString()));
		if (bl.add(vo) == ResultMessage.SUCCESS) {
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
