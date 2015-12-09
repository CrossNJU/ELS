package org.cross.elsclient.ui.stockkeeperui.instock;

import java.rmi.RemoteException;

import org.cross.elsclient.blservice.goodsblservice.GoodsBLService;
import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.blservice.stockblservice.StockBLService;
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
import org.cross.elsclient.vo.Receipt_StockInVO;
import org.cross.elsclient.vo.StockVO;
import org.cross.elsclient.vo.UserVO;
import org.cross.elscommon.util.InfoType;
import org.cross.elscommon.util.NumberType;
import org.cross.elscommon.util.ResultMessage;

public class StockInAddPanel extends ELSInfoPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Receipt_StockInVO stockinvo;
	StockBLService stockbl;
	ReceiptBLService receiptbl;
	GoodsBLService goodsbl;
	UserVO user;
	StockVO stockvo;

	public StockInAddPanel(StockBLService stockbl, ReceiptBLService receiptbl, UserVO user, StockVO stockvo,
			GoodsBLService goodsbl) {
		this.stockbl = stockbl;
		this.receiptbl = receiptbl;
		this.stockvo = stockvo;
		this.goodsbl = goodsbl;
		this.user = user;
		init();
	}

	@Override
	public void init() {
		super.init();
		titlePanel.remove(titlePanel.backBtn);
		setTitle("新增入库单");
		/* 0 */addEditableItem("入库单编号", ConstantVal.numberbl.getPostNumber(NumberType.RECEIPT), false);
		addEditableItem("快件单编号", "", true, InfoType.NAME);
		addDateItem("入库时间", false);
		addEditableItem("目的地", "", true, InfoType.NAME);
		addEditableItem("仓库区号", "", true, InfoType.NAME);
		addConfirmAndCancelBtn();
		confirmBtn.setText("确认添加");
		cancelBtn.setText("查看单据");
		container.packHeight();
	}

	@Override
	protected void confirm() throws RemoteException {
		stockinvo = new Receipt_StockInVO(itemLabels.get(0).toString(), itemLabels.get(2).toString(),
				itemLabels.get(1).toString(), itemLabels.get(3).toString(), itemLabels.get(4).toString(), user.number,
				user.orgNameID);
		stockbl.intoStock(itemLabels.get(1).toString(), stockvo.number, itemLabels.get(2).toString(),
				itemLabels.get(4).toString());
		GoodsVO goodsvo = goodsbl.searchGoods(itemLabels.get(1).toString());
		HistoryVO newhistory = new HistoryVO(itemLabels.get(2).toString(), UIConstant.CURRENT_ORG.city, UIConstant.CURRENT_ORG.type, true);
		goodsvo.history.add(newhistory);
		goodsvo.stockAreaNum = itemLabels.get(4).toString();
		goodsvo.stockNum = stockvo.number;
		goodsbl.updateGoods(goodsvo);
		if (receiptbl.add(stockinvo) == ResultMessage.SUCCESS) {
			ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this), "添加成功");
			ELSFunctionPanel parent = GetPanelUtil.getFunctionPanel(this);
			// parent.contentPanel.cl.show(parent.contentPanel, "receipts");
			parent.setChosenFunction("receipts");
			init();
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
			init();
		}
	}
	
}
