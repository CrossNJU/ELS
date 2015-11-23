package org.cross.elsclient.blimpl.receiptblimpl;

import org.cross.elsclient.blimpl.blUtility.PersonnelInfo;
import org.cross.elsclient.blimpl.blUtility.ReceiptInfo;
import org.cross.elsclient.blimpl.blUtility.StockInfo;
import org.cross.elsclient.demo.StockInfoUI.returnAct;
import org.cross.elsclient.vo.ReceiptVO;
import org.cross.elsclient.vo.Receipt_ArriveVO;
import org.cross.elsclient.vo.Receipt_MoneyInVO;
import org.cross.elsclient.vo.Receipt_MoneyOutVO;
import org.cross.elsclient.vo.Receipt_OrderVO;
import org.cross.elsclient.vo.Receipt_StockInVO;
import org.cross.elsclient.vo.Receipt_StockOutVO;
import org.cross.elsclient.vo.Receipt_TransVO;
import org.cross.elscommon.dataservice.receiptdataservice.ReceiptDataService;
import org.cross.elscommon.po.ReceiptPO;
import org.cross.elscommon.po.Receipt_ArrivePO;
import org.cross.elscommon.po.Receipt_MoneyInPO;
import org.cross.elscommon.po.Receipt_MoneyOutPO;
import org.cross.elscommon.po.Receipt_OrderPO;
import org.cross.elscommon.po.Receipt_StockInPO;
import org.cross.elscommon.po.Receipt_StockOutPO;
import org.cross.elscommon.po.Receipt_TransPO;

public class ReceiptInfoImpl implements ReceiptInfo {

	ReceiptDataService receiptdata;
	StockInfo stockInfo;
	PersonnelInfo personnelInfo;

	public ReceiptInfoImpl(ReceiptDataService receiptdata, StockInfo stockInfo, PersonnelInfo personnelInfo) {
		this.receiptdata = receiptdata;
		this.stockInfo = stockInfo;
		this.personnelInfo = personnelInfo;
	}

	@Override
	public ReceiptVO toVO(ReceiptPO po) {
		switch (po.getType()) {
		case ORDER:
			Receipt_OrderPO realpo = (Receipt_OrderPO) po;
			Receipt_OrderVO order = new Receipt_OrderVO(realpo.getNumber(), realpo.getType(), realpo.getTime(),
					realpo.getGoodsNum(), realpo.getCost(), realpo.getExpectTime(), realpo.getTargetPlace(),
					realpo.getStartPlace(), realpo.getPushPeople(), realpo.getReceivePeople());
			order.receiveTime = realpo.getReceiveTime();
			return order;
		case ARRIVE:
			Receipt_ArrivePO arripo = (Receipt_ArrivePO) po;
			Receipt_ArriveVO arri = new Receipt_ArriveVO(arripo.getNumber(), arripo.getType(), arripo.getTime(),
					arripo.getStartPlace(), arripo.getTransNum(), arripo.getGoodslist(), arripo.getArriveOrg());
			return arri;
		case TRANS:
			Receipt_TransPO transpo = (Receipt_TransPO) po;
			Receipt_TransVO transvo = new Receipt_TransVO(transpo.getNumber(), transpo.getType(), transpo.getTime(),
					transpo.getOrders(), transpo.getCost(), transpo.getOrg(), transpo.getLocalNum(),
					transpo.getVehicleNum(), transpo.getStartCity(), transpo.getArriveCity(), transpo.getObserver(),
					transpo.getDriver());
			return transvo;
		case STOCKIN:
			Receipt_StockInPO stockinpo = (Receipt_StockInPO) po;
			Receipt_StockInVO stockinvo = new Receipt_StockInVO(stockinpo.getGoodsNumber(), stockinpo.getTime(),
					stockInfo.toStockAreaVO(stockinpo.getPlace()), stockinpo.getNumber());
			return stockinvo;
		case STOCKOUT:
			Receipt_StockOutPO stockoutpo = (Receipt_StockOutPO) po;
			Receipt_StockOutVO stoctoutvo = new Receipt_StockOutVO(stockoutpo.getGoodsNumber(), stockoutpo.getTime(),
					stockoutpo.getCity(), stockoutpo.getVehicle(), stockoutpo.getTransNumber(), stockoutpo.getNumber());
			return stoctoutvo;
		case MONEYIN:
			Receipt_MoneyInPO moneyinpo = (Receipt_MoneyInPO) po;
			Receipt_MoneyInVO moneyinvo = new Receipt_MoneyInVO(moneyinpo.getTime(), moneyinpo.getMoney(),
					personnelInfo.toPersonnelVO(moneyinpo.getPerson()), moneyinpo.getNumber());
			return moneyinvo;
		case MONEYOUT:
			Receipt_MoneyOutPO moneyoutpo = (Receipt_MoneyOutPO) po;
			Receipt_MoneyOutVO moneyoutvo = new Receipt_MoneyOutVO(moneyoutpo.getNumber(), moneyoutpo.getTime(),
					moneyoutpo.getMoney(), personnelInfo.toPersonnelVO(moneyoutpo.getPersonnel()),
					moneyoutpo.getReceiveID(), moneyoutpo.getClause(), moneyoutpo.getComments());
			return moneyoutvo;
		case TOTALMONEYIN
		default:
			return null;
		}
	}

	@Override
	public ReceiptPO toPO(ReceiptVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReceiptVO findByID(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

}
