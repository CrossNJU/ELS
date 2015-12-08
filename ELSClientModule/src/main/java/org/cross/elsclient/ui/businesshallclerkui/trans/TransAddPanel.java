package org.cross.elsclient.ui.businesshallclerkui.trans;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blservice.goodsblservice.GoodsBLService;
import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.ui.businesshallclerkui.ReceiptManagePanel;
import org.cross.elsclient.ui.component.ELSDialog;
import org.cross.elsclient.ui.component.ELSFunctionPanel;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.util.ConstantValue;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.vo.GoodsVO;
import org.cross.elsclient.vo.HistoryVO;
import org.cross.elsclient.vo.PersonnelVO;
import org.cross.elsclient.vo.Receipt_TransVO;
import org.cross.elsclient.vo.UserVO;
import org.cross.elscommon.util.City;
import org.cross.elscommon.util.NumberType;
import org.cross.elscommon.util.OrganizationType;
import org.cross.elscommon.util.PositionType;
import org.cross.elscommon.util.ReceiptType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StringToType;

public class TransAddPanel extends ELSInfoPanel {
	Receipt_TransVO vo;
	ReceiptBLService bl;
	GoodsBLService goodsbl;
	UserVO user;

	public TransAddPanel(ReceiptBLService receiptbl, UserVO user, GoodsBLService goodsbl) {
		this.bl = receiptbl;
		this.user = user;
		this.goodsbl = goodsbl;
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
		/* 0 */addEditableItem("装车单编号", numberbl.getNumber(NumberType.RECEIPT), false);
		addEditableItem("快件单编号", "", true);
		addComboxItem("出发地", it1, true);
		addComboxItem("到达城市", it1, true);
		addComboxItem("到达机构", it2, true);
		/* 5 */addDateItem("装车时间", false);
		addEditableItem("运输编号", "", true);
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
		vo = new Receipt_TransVO(itemLabels.get(0).toString(), itemLabels.get(5).toString(), goods,
				Double.valueOf(itemLabels.get(10).toString()), itemLabels.get(6).toString(),
				itemLabels.get(7).toString(), itemLabels.get(2).toString(), itemLabels.get(3).toString(),
				itemLabels.get(9).toString(), itemLabels.get(8).toString(), user.number);
		for (int i = 0; i < goods.size(); i++) {
			GoodsVO goodsvo = goodsbl.searchGoods(goods.get(i));
			HistoryVO historyVO = new HistoryVO(itemLabels.get(5).toString(), City.BEIJING, OrganizationType.BUSINESSHALL, true);
			goodsvo.history.add(historyVO);
			goodsbl.updateGoods(goodsvo);
		}
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
