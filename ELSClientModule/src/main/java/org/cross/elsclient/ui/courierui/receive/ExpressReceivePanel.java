package org.cross.elsclient.ui.courierui.receive;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.rmi.RemoteException;
import java.util.Calendar;

import javax.rmi.CORBA.Tie;

import org.cross.elsclient.blservice.goodsblservice.GoodsBLService;
import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.ui.component.ELSDialog;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.ui.util.LogUtil;
import org.cross.elsclient.ui.util.UIConstant;
import org.cross.elsclient.util.CalcuteUtil;
import org.cross.elsclient.util.ConstantVal;
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
import org.cross.elscommon.util.TimeUtil;

public class ExpressReceivePanel extends ELSInfoPanel{
	Receipt_OrderVO orderVO;
	GoodsVO goodsVO;
	ReceiptBLService receiptbl;
	GoodsBLService goodsbl;
	String number;
	
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
		number = ConstantVal.numberbl.getPostNumber(NumberType.RECEIPT);
		addEditableItem("快件单编号",number , false,"id");
		addEditableItem("寄件人姓名", "", true,"sendName");
		addEditableItem("寄件人地址", "", true,"sendAd");
		addEditableItem("寄件人单位", "", true,"sendUnit");
		addEditableItem("寄件人电话", "", true,"sendPhone");
		//5
		addEditableItem("寄件人手机", "", true,"sendCell");
		addEditableItem("收件人姓名", "", true,"reName");
		addEditableItem("收件人地址", "", true,"reAd");
		addEditableItem("收件人单位", "", true,"reUnit");
		addEditableItem("收件人电话", "", true,"rePhone");
		//10
		addEditableItem("收件人手机", "", true,"reCell");
		addComboxItem("出发城市", City.toStrings(), true,"from");
		addComboxItem("到达城市", City.toStrings(), true,"to");
		addComboxItem("快递类型", StockType.toGoodsStrings(), true,"type");
		addEditableItem("货物件数", "1", true,InfoType.NUM,"num");
		//15
		addAutoItem("货物重量(kg)", "", true,InfoType.NUM,"weight");
		addComboxItem("包装类型",packType, true,"pack");
		addEditableItem("价格", "", false,"price");
		addEditableItem("预计到达时间", "", false,"time");
		addEditableItem("建单人编号", UIConstant.CURRENT_USER.number, false,InfoType.ID,"per");
		//20
		addEditableItem("所属机构", UIConstant.CURRENT_USER.orgNameID, false,InfoType.ID,"organ");
		
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
			String number = findItem("id").toString();
			String senderName = findItem("sendName").toString();
			String senderAdd = findItem("sendAd").toString();
			String senderOrg = findItem("sendUnit").toString();
			String senderPhone = findItem("sendPhone").toString();
			String senderMobile = findItem("sendCell").toString();
			String receiverName = findItem("reName").toString();
			String receiverAdd = findItem("reAd").toString();
			String receiverOrg = findItem("reUnit").toString();
			String receiverPhone = findItem("rePhone").toString();
			String receiverMobile = findItem("reCell").toString();
			City startCity = StringToType.toCity(findItem("from").toString());
			City endCity = StringToType.toCity(findItem("to").toString());
			StockType goodsType = StringToType.toGoodsType(findItem("type").toString());
			int volume = Integer.valueOf(findItem("num").toString());
			int weight = Integer.valueOf(findItem("weight").toString());
			int cost = Integer.valueOf(findItem("price").toString());
			String perNum = findItem("per").toString();
			String orgNum = findItem("organ").toString();
			
			
			goodsVO = new GoodsVO(number, goodsType,startCity, OrganizationType.BUSINESSHALL, weight, volume);
			orderVO = new Receipt_OrderVO(number, TimeUtil.getCurrentTime(), cost, TimeUtil.getCurrentTime(), null, senderName, senderMobile, senderPhone, senderAdd, senderOrg, receiverName, receiverOrg, receiverAdd, receiverPhone, receiverMobile, perNum, orgNum);
			goodsVO.history.add(new HistoryVO(TimeUtil.getCurrentTime(), startCity, OrganizationType.BUSINESSHALL, false));
			if(receiptbl.add(orderVO)==ResultMessage.SUCCESS&&goodsbl.addGoods(goodsVO)==ResultMessage.SUCCESS&&goodsbl.updateGoods(goodsVO)==ResultMessage.SUCCESS){
				LogUtil.addLog("揽收快件");
				ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this),"添加成功");
				ConstantVal.numberbl.addone(NumberType.RECEIPT, number);
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
		itemLabels.get(18).inputLabel.setText(TimeUtil.getAfterTime(result));
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
