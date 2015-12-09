package org.cross.elsclient.ui.businesshallclerkui.arri;

import java.rmi.RemoteException;

import org.cross.elsclient.blservice.goodsblservice.GoodsBLService;
import org.cross.elsclient.blservice.organizationblservice.OrganizationBLService;
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
import org.cross.elsclient.util.ConstantVal;
import org.cross.elsclient.vo.GoodsVO;
import org.cross.elsclient.vo.HistoryVO;
import org.cross.elsclient.vo.Receipt_ArriveVO;
import org.cross.elsclient.vo.Receipt_TransVO;
import org.cross.elsclient.vo.UserVO;
import org.cross.elscommon.util.City;
import org.cross.elscommon.util.GoodsState;
import org.cross.elscommon.util.InfoType;
import org.cross.elscommon.util.NumberType;
import org.cross.elscommon.util.OrganizationType;
import org.cross.elscommon.util.ReceiptType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StringToType;

public class ArriAddPanel extends ELSInfoPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Receipt_ArriveVO arrivo;
	ReceiptBLService receiptbl;
	GoodsBLService goodsbl;
	UserVO user;

	public ArriAddPanel(ReceiptBLService receiptbl, UserVO user, GoodsBLService goodsbl) {
		this.receiptbl = receiptbl;
		this.user = user;
		this.goodsbl = goodsbl;
		init();
	}

	@Override
	public void init() {
		super.init();

		titlePanel.remove(titlePanel.backBtn);

		String it1[] = { "南京", "北京", "上海", "广州" };

		setTitle("新增到达单");
		/* 0 */addEditableItem("到达单编号", ConstantVal.numberbl.getPostNumber(NumberType.RECEIPT), false);
		/* 1 */addEditableItem("装车/中转单号", "", true, InfoType.NAME);
		/* 2 */addEditableItem("出发机构", "", true, InfoType.NAME);
		/* 3 */addDateItem("出发时间", true);
		/* 4 */addEditableItem("到达机构", user.orgNameID, false);
		/* 5 */addDateItem("到达时间", false);
		/* 6 */addConfirmAndCancelBtn();
		confirmBtn.setText("确认添加");
		cancelBtn.setText("查看单据");
		container.packHeight();
	}

	@Override
	protected void confirm() throws RemoteException {
		arrivo = new Receipt_ArriveVO(itemLabels.get(0).toString(), itemLabels.get(5).toString(),
				itemLabels.get(2).toString(), itemLabels.get(1).toString(), itemLabels.get(3).toString(),
				user.orgNameID, user.number);
		Receipt_TransVO transvo = (Receipt_TransVO) receiptbl.findByID(itemLabels.get(1).toString());
		
		for (int i = 0; i < transvo.goodsID.size(); i++) {
			GoodsVO goods = goodsbl.searchGoods(transvo.goodsID.get(i));
			//更新goods
			HistoryVO historyVO = new HistoryVO(itemLabels.get(5).toString(), UIConstant.CURRENT_ORG.city, UIConstant.CURRENT_ORG.type, true);
			goods.history.add(historyVO);
			goods.placeCity = UIConstant.CURRENT_ORG.city;
			goods.placeOrg = UIConstant.CURRENT_ORG.type;
			goods.arriNum = itemLabels.get(0).toString();
			goodsbl.updateGoods(goods);
		}
		if (receiptbl.add(arrivo) == ResultMessage.SUCCESS) {
			ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this), "添加成功");
			ELSFunctionPanel parent = GetPanelUtil.getFunctionPanel(this);
//			parent.contentPanel.cl.show(parent.contentPanel, "receipts");
			parent.setChosenFunction("receipts");
		} else {
			ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this), "添加失败");
		}
	}

	@Override
	protected void cancel() {
		if (ELSDialog.showConfirmDlg(GetPanelUtil.getFunctionPanel(this), "取消新增", "确认放弃新增单据？")) {
			ELSFunctionPanel parent = GetPanelUtil.getFunctionPanel(this);
//			parent.contentPanel.cl.show(parent.contentPanel, "receipts");
			parent.setChosenFunction("receipts");
		}
	}

}
