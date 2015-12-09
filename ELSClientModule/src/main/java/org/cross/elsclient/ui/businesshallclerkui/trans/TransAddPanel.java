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
import org.cross.elsclient.ui.util.UIConstant;
import org.cross.elsclient.vo.GoodsVO;
import org.cross.elsclient.vo.HistoryVO;
import org.cross.elsclient.vo.PersonnelVO;
import org.cross.elsclient.vo.Receipt_TransVO;
import org.cross.elsclient.vo.UserVO;
import org.cross.elscommon.util.City;
import org.cross.elscommon.util.InfoType;
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
		String it1[] = { "南京", "北京", "上海", "广州" };
//		String it2[] = { "营业厅", "中转中心" };
//		String it3[] = ConstantValue.getUnusedVehicle();
//		String it4[] = ConstantValue.getUnusedDriver();
//		String it5[] = ConstantValue.getUnusedObserver();

		setTitle("新增装车单");
		/* 0 */addEditableItem("装车单编号", numberbl.getPostNumber(NumberType.RECEIPT), false);
		addEditableItem("快件单编号", "", true, InfoType.NAME);
		addEditableItem("出发地", user.orgNameID, false);
		addComboxItem("到达城市", it1, true);
		addEditableItem("到达机构", "", true, InfoType.NAME);
		/* 5 */addDateItem("装车时间", false);
		addEditableItem("运输编号", "", true, InfoType.NAME);
		addEditableItem("车辆编号", "", true, InfoType.NAME);
		addEditableItem("押运员", "", true, InfoType.NAME);
		addEditableItem("监装员", "", true, InfoType.NAME);
		addEditableItem("运费($)", "", true, InfoType.NUM);
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
			HistoryVO historyVO = new HistoryVO(itemLabels.get(5).toString(), UIConstant.CURRENT_ORG.city, UIConstant.CURRENT_ORG.type, true);
			goodsvo.history.add(historyVO);
			goodsvo.placeCity = UIConstant.CURRENT_ORG.city;
			goodsvo.placeOrg = UIConstant.CURRENT_ORG.type;
			goodsvo.transNum = itemLabels.get(0).toString();
			goodsbl.updateGoods(goodsvo);
		}
		if (bl.add(vo) == ResultMessage.SUCCESS) {
			ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this), "添加成功");
			ELSFunctionPanel parent = GetPanelUtil.getFunctionPanel(this);
			// parent.contentPanel.cl.show(parent.contentPanel, "receipts");
			parent.setChosenFunction("receipts");
		} else {
			ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this), "添加失败");
		}
	}

	@Override
	protected void cancel() {
		if (ELSDialog.showConfirmDlg(GetPanelUtil.getFunctionPanel(this), "取消新增", "确认放弃新增单据？")) {
			ELSFunctionPanel parent = GetPanelUtil.getFunctionPanel(this);
			// parent.contentPanel.cl.show(parent.contentPanel, "receipts");
			parent.setChosenFunction("receipts");
		}
	}

}
