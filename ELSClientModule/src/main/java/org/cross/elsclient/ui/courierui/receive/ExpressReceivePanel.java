package org.cross.elsclient.ui.courierui.receive;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.rmi.RemoteException;

import javax.rmi.CORBA.Tie;

import org.cross.elsclient.blservice.goodsblservice.GoodsBLService;
import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.ui.component.ELSDialog;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.ui.util.UIConstant;
import org.cross.elsclient.util.CalcuteUtil;
import org.cross.elsclient.util.ConstantVal;
import org.cross.elsclient.util.TimeUtil;
import org.cross.elsclient.vo.GoodsVO;
import org.cross.elsclient.vo.HistoryVO;
import org.cross.elsclient.vo.Receipt_OrderVO;
import org.cross.elscommon.util.City;
import org.cross.elscommon.util.InfoType;
import org.cross.elscommon.util.NumberType;
import org.cross.elscommon.util.OrganizationType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StockType;
import org.cross.elscommon.util.StringToType;

public class ExpressReceivePanel extends ELSInfoPanel{
	Receipt_OrderVO orderVO;
	GoodsVO goodsVO;
	ReceiptBLService receiptbl;
	GoodsBLService goodsbl;
	
	public ExpressReceivePanel(ReceiptBLService receiptbl,GoodsBLService goodsbl) {
		this.receiptbl = receiptbl;
		this.goodsbl = goodsbl;
		init();
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
		String packType[] = {"纸箱(5元)","木箱(10元)","快递袋(1元)"};
		
		setTitle("创建快件单");
		addEditableItem("快件单编号", ConstantVal.numberbl.getPostNumber(NumberType.RECEIPT), false);
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
		addEditableItem("建单人编号", UIConstant.CURRENT_USER.number, false,InfoType.ID);
		//20
		addEditableItem("所属机构", UIConstant.CURRENT_USER.orgNameID, false,InfoType.ID);
		
		itemLabels.get(15).inputLabel.addFocusListener(new PriceListener());
		itemLabels.get(11).comboBox.addItemListener(new PriceItemListener());
		itemLabels.get(12).comboBox.addItemListener(new PriceItemListener());
		itemLabels.get(13).comboBox.addItemListener(new PriceItemListener());
		itemLabels.get(16).comboBox.addItemListener(new PriceItemListener());
		
		titlePanel.remove(titlePanel.backBtn);
		addConfirmAndCancelBtn();
		confirmBtn.setText("确认创建");
		cancelBtn.setText("取消创建");
		container.packHeight();
	}
	
	@Override
	protected void confirm() throws RemoteException {
		if(isAllLegal()){
			String number = itemLabels.get(0).toString();
			String senderName = itemLabels.get(1).toString();
			String senderAdd = itemLabels.get(2).toString();
			String senderOrg = itemLabels.get(3).toString();
			String senderPhone = itemLabels.get(4).toString();
			String senderMobile = itemLabels.get(5).toString();
			String receiverName = itemLabels.get(6).toString();
			String receiverAdd = itemLabels.get(7).toString();
			String receiverOrg = itemLabels.get(8).toString();
			String receiverPhone = itemLabels.get(9).toString();
			String receiverMobile = itemLabels.get(10).toString();
			City startCity = StringToType.toCity(itemLabels.get(11).toString());
			City endCity = StringToType.toCity(itemLabels.get(12).toString());
			StockType goodsType = StringToType.toGoodsType(itemLabels.get(13).toString());
			int volume = Integer.valueOf(itemLabels.get(14).toString());
			int weight = Integer.valueOf(itemLabels.get(15).toString());
			int cost = Integer.valueOf(itemLabels.get(17).toString());
			String perNum = itemLabels.get(19).toString();
			String orgNum = itemLabels.get(20).toString();
			
			
			goodsVO = new GoodsVO(number, goodsType,startCity, OrganizationType.BUSINESSHALL, weight, volume);
			orderVO = new Receipt_OrderVO(number, TimeUtil.getCurrentTime(), cost, TimeUtil.getCurrentTime(), null, senderName, senderMobile, senderPhone, senderAdd, senderOrg, receiverName, receiverOrg, receiverAdd, receiverPhone, receiverMobile, perNum, orgNum);
			goodsVO.history.add(new HistoryVO(TimeUtil.getCurrentTime(), startCity, OrganizationType.BUSINESSHALL, false));
			if(receiptbl.add(orderVO)==ResultMessage.SUCCESS&&goodsbl.addGoods(goodsVO)==ResultMessage.SUCCESS){
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
	
	public void price() {
		if(itemLabels.get(15).checkFormat()){
			StockType goodsType = StringToType.toGoodsType(itemLabels.get(13).toString());
			City startCity = StringToType.toCity(itemLabels.get(11).toString());
			City endCity = StringToType.toCity(itemLabels.get(12).toString());
			double weight = Double.valueOf(itemLabels.get(15).toString());
			String packCost = itemLabels.get(16).toString();
			int result = (int)CalcuteUtil.calcutePrice(goodsType, ConstantVal.CONSTANT.getDistance(startCity, endCity), weight, packCost);
			itemLabels.get(17).inputLabel.setText(result+"");
		}
	}
	public void time(){
		City startCity = StringToType.toCity(itemLabels.get(11).toString());
		City endCity = StringToType.toCity(itemLabels.get(12).toString());
		int result = (int)(ConstantVal.CONSTANT.getDistance(startCity, endCity)*ConstantVal.CONSTANT.timeBykilo);
		itemLabels.get(18).inputLabel.setText(result+" 小时后");
	}
	
	class PriceListener implements FocusListener{

		@Override
		public void focusGained(FocusEvent e) {}

		@Override
		public void focusLost(FocusEvent e) {
			price();
		}
	}
	class PriceItemListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange()==e.SELECTED){
				price();
			}
			if(e.getSource()==itemLabels.get(11).comboBox||e.getSource()==itemLabels.get(12).comboBox){
				time();
			}
		}
		
	}
	
}
