package org.cross.elsclient.ui.courierui.receive;

import java.rmi.RemoteException;

import javax.rmi.CORBA.Tie;

import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.ui.component.ELSDialog;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.util.CalcuteUtil;
import org.cross.elsclient.util.ConstantVal;
import org.cross.elsclient.vo.GoodsVO;
import org.cross.elsclient.vo.Receipt_OrderVO;
import org.cross.elscommon.util.City;
import org.cross.elscommon.util.InfoType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StockType;
import org.cross.elscommon.util.StringToType;

public class ExpressReceivePanel extends ELSInfoPanel{
	Receipt_OrderVO vo;
	ReceiptBLService bl;
	
	public ExpressReceivePanel(ReceiptBLService receiptbl) {
		this.bl = receiptbl;
		init();
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
		String packType[] = {"纸箱(5元)","木箱(10元)","快递袋(1元)"};
		
		setTitle("创建快件单");
		addEditableItem("快件单编号", "R000001", false);
		addEditableItem("寄件人姓名", "", true);
		addEditableItem("寄件人地址", "", true);
		addEditableItem("寄件人单位", "", true);
		addEditableItem("寄件人电话", "", true);
		//5
		addEditableItem("寄件人手机", "", true);
		addEditableItem("收件人姓名", "", true);
		addEditableItem("收件人地址", "", true);
		addEditableItem("收件人单位", "", true);
		addEditableItem("收件人电话", "", true);
		//10
		addEditableItem("收件人手机", "", true);
		addComboxItem("出发城市", City.toStrings(), true);
		addComboxItem("到达城市", City.toStrings(), true);
		addComboxItem("快递类型", StockType.toStrings(), true);
		addEditableItem("货物件数", "1", true,InfoType.NUM);
		//15
		addAutoItem("货物重量(kg)", "", true,InfoType.NUM);
		addComboxItem("包装类型",packType, true);
		addEditableItem("价格", "", false);
		addEditableItem("预计到达时间", "", false);
		
		titlePanel.remove(titlePanel.backBtn);
		addConfirmAndCancelBtn();
		confirmBtn.setText("确认创建");
		cancelBtn.setText("取消创建");
		
	}
	
	@Override
	protected void confirm() throws RemoteException {
		if(isAllLegal()){
			if(bl.add(vo)==ResultMessage.SUCCESS){
				ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this),"添加成功");
				init();
			}else{
				ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this),"添加失败");
			}
		}
	}
	
	@Override
	protected void cancel() {
		if(ELSDialog.showConfirmDlg(GetPanelUtil.getFunctionPanel(this), "取消新增", "确认退出新增界面？")){
			init();
		}
	}
	@Override
	public void auto(String text) {
		super.auto(text);
		StockType goodsType = StringToType.toGoodsType(itemLabels.get(13).toString());
		City startCity = StringToType.toCity(itemLabels.get(11).toString());
		City endCity = StringToType.toCity(itemLabels.get(12).toString());
		double weight = Double.valueOf(text);
		String packCost = itemLabels.get(16).toString();
		double result = CalcuteUtil.calcutePrice(goodsType, ConstantVal.CONSTANT.getDistance(startCity, endCity), weight, packCost);
		itemLabels.get(17).inputLabel.setText(result+"");
	}
	
	
	
}
