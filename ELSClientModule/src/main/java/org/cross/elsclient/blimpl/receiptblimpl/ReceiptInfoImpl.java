package org.cross.elsclient.blimpl.receiptblimpl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.blUtility.GoodsInfo;
import org.cross.elsclient.blimpl.blUtility.PersonnelInfo;
import org.cross.elsclient.blimpl.blUtility.ReceiptInfo;
import org.cross.elsclient.blimpl.blUtility.StockInfo;
import org.cross.elsclient.vo.ReceiptVO;
import org.cross.elsclient.vo.Receipt_ArriveVO;
import org.cross.elsclient.vo.Receipt_MoneyInVO;
import org.cross.elsclient.vo.Receipt_MoneyOutVO;
import org.cross.elsclient.vo.Receipt_OrderVO;
import org.cross.elsclient.vo.Receipt_StockInVO;
import org.cross.elsclient.vo.Receipt_StockOutVO;
import org.cross.elsclient.vo.Receipt_TotalMoneyInVO;
import org.cross.elsclient.vo.Receipt_TransVO;
import org.cross.elscommon.dataservice.receiptdataservice.ReceiptDataService;
import org.cross.elscommon.po.GoodsPO;
import org.cross.elscommon.po.ReceiptPO;
import org.cross.elscommon.po.Receipt_ArrivePO;
import org.cross.elscommon.po.Receipt_MoneyInPO;
import org.cross.elscommon.po.Receipt_MoneyOutPO;
import org.cross.elscommon.po.Receipt_OrderPO;
import org.cross.elscommon.po.Receipt_StockInPO;
import org.cross.elscommon.po.Receipt_StockOutPO;
import org.cross.elscommon.po.Receipt_TotalMoneyInPO;
import org.cross.elscommon.po.Receipt_TransPO;
import org.cross.elscommon.util.PositionType;

public class ReceiptInfoImpl implements ReceiptInfo {

	ReceiptDataService receiptdata;
	public StockInfo stockInfo;
	public PersonnelInfo personnelInfo;
	public GoodsInfo goodsInfo;

	public ReceiptInfoImpl(ReceiptDataService receiptdata) {
		this.receiptdata = receiptdata;
	}

	@Override
	public ReceiptVO toVO(ReceiptPO po) {
		if (po == null) {
			return null;
		}
		switch (po.getType()) {
		case ORDER:
			Receipt_OrderPO realpo = (Receipt_OrderPO) po;
			Receipt_OrderVO order = new Receipt_OrderVO(realpo.getNumber(),
realpo.getTime(), realpo.getGoodsNum(), realpo.getPrice(), realpo.getReceiveTime(), realpo.getExpectTime(), 
realpo.getSenderName(), realpo.getSenderMobile(), realpo.getSenderPhone(), 
realpo.getSenderAdd(), realpo.getSenderOrg(), realpo.getReceiverName(), realpo.getReceiverOrg(), 
realpo.getReceiverAdd(), realpo.getReceiverPhone(), realpo.getReceiverMobile(), realpo.getPerNum(), realpo.getOrgNum());
			order.approveState = realpo.getApproveState();
			return order;
		case ARRIVE:
			Receipt_ArrivePO arripo = (Receipt_ArrivePO) po;
			Receipt_ArriveVO arri = new Receipt_ArriveVO(arripo.getNumber(), arripo.getTime(), arripo.getStartPlace(), arripo.getTransNum(), arripo.getStartTime(), arripo.getArriPlace(), arripo.getPerNum());
			arri.approveState = arripo.getApproveState();
			return arri;
		case TRANS:
			Receipt_TransPO transpo = (Receipt_TransPO) po;
			ArrayList<String> goodslist = new ArrayList<String>();
			ArrayList<GoodsPO> goodspo = new ArrayList<GoodsPO>();
			try {
				goodspo = goodsInfo.findByTransNum(transpo.getNumber());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (int i = 0; i < goodspo.size(); i++) {
				goodslist.add(goodspo.get(i).getOrderNum());
			}
			Receipt_TransVO transvo = new Receipt_TransVO(transpo.getNumber(), transpo.getTime(), goodslist, transpo.getCost(), transpo.getTransNum(), transpo.getVeNum(), transpo.getStartPlace(), transpo.getArrivePlace(), transpo.getObserver(), transpo.getDriver(), transpo.getPerNum());
			transvo.approveState = transpo.getApproveState();
			return transvo;
		case STOCKIN:
			Receipt_StockInPO stockinpo = (Receipt_StockInPO) po;
			Receipt_StockInVO stockinvo = new Receipt_StockInVO(stockinpo.getNumber(), stockinpo.getTime(), stockinpo.getOrderNum(), stockinpo.getDestination(), stockinpo.getStockNum(), stockinpo.getPerNum(), stockinpo.getOrgNum());
			stockinvo.approveState = stockinpo.getApproveState();
			return stockinvo;
		case STOCKOUT:
			Receipt_StockOutPO stockoutpo = (Receipt_StockOutPO) po;
			Receipt_StockOutVO stockoutvo = null;
			stockoutvo.approveState = stockoutpo.getApproveState();
			return stockoutvo;
		case MONEYIN:
			Receipt_MoneyInPO moneyinpo = (Receipt_MoneyInPO) po;
			Receipt_MoneyInVO moneyinvo = null;
//			moneyinvo.orderNumbers = moneyinpo.getOrderNumbers();
			moneyinvo.approveState = moneyinpo.getApproveState();
			return moneyinvo;
		case MONEYOUT:
			Receipt_MoneyOutPO moneyoutpo = (Receipt_MoneyOutPO) po;
			Receipt_MoneyOutVO moneyoutvo = null;
			moneyoutvo.approveState = moneyoutpo.getApproveState();
			return moneyoutvo;
		case TOTALMONEYIN:
			Receipt_TotalMoneyInPO totalmoneyinpo = (Receipt_TotalMoneyInPO) po;
			Receipt_TotalMoneyInVO totalMoneyInvo = null;
//			totalMoneyInvo.sum = totalmoneyinpo.getSum();
			totalMoneyInvo.approveState = totalmoneyinpo.getApproveState();
			ArrayList<Receipt_MoneyInVO> receipt_MoneyInVOs = new ArrayList<Receipt_MoneyInVO>();
//			ArrayList<Receipt_MoneyInPO> receipt_MoneyInPOs = totalmoneyinpo
//					.getReceipt_Moneyins();
//			int size = receipt_MoneyInPOs.size();
//			for (int i = 0; i < size; i++) {
//				receipt_MoneyInVOs
//						.add((Receipt_MoneyInVO) toVO(receipt_MoneyInPOs.get(i)));
//			}
			totalMoneyInvo.receipt_Moneyins = receipt_MoneyInVOs;
			return totalMoneyInvo;
		default:
			return null;
		}
	}

	@Override
	public ReceiptPO toPO(ReceiptVO vo) {
		if (vo == null) {
			return null;
		}
//		switch (vo.type) {
//		case ORDER:
//			Receipt_OrderVO ordervo = (Receipt_OrderVO) vo;
//			Receipt_OrderPO orderpo = new Receipt_OrderPO(ordervo.number, ordervo.type, ordervo.time, ordervo.goodsNum,
//					ordervo.cost, ordervo.expectTime, ordervo.targetPlace, ordervo.startPlace, ordervo.pushPeople,
//					ordervo.receivePeople);
//			orderpo.setReceiveTime(ordervo.receiveTime);
//			orderpo.setApproveState(vo.approveState);
//			return orderpo;
//		case TRANS:
//			Receipt_TransVO transvo = (Receipt_TransVO) vo;
//			Receipt_TransPO transpo = new Receipt_TransPO(transvo.number, transvo.type, transvo.time, transvo.orders,
//					transvo.cost, transvo.org, transvo.localNum, transvo.vehicleNum, transvo.startCity,
//					transvo.arriveCity, personnelInfo.toPersonnelPO(transvo.observer),
//					personnelInfo.toPersonnelPO(transvo.driver));
//			transpo.setApproveState(vo.approveState);
//			return transpo;
//		case ARRIVE:
//			Receipt_ArriveVO arrivo = (Receipt_ArriveVO) vo;
//			Receipt_ArrivePO arripo = new Receipt_ArrivePO(arrivo.number, arrivo.type, arrivo.time, arrivo.startPlace,
//					arrivo.transNum, arrivo.orders, arrivo.arriveOrg);
//			arripo.setApproveState(vo.approveState);
//			return arripo;
//		case STOCKIN:
//			Receipt_StockInVO stockinvo = (Receipt_StockInVO) vo;
//			Receipt_StockInPO stockinpo = new Receipt_StockInPO(stockinvo.goodsNumber, stockinvo.time,
//					stockInfo.toStockAreaPO(stockinvo.place), stockinvo.number);
//			stockinpo.setApproveState(vo.approveState);
//			return stockinpo;
//		case STOCKOUT:
//			Receipt_StockOutVO stockoutvo = (Receipt_StockOutVO) vo;
//			Receipt_StockOutPO stockoutpo = new Receipt_StockOutPO(stockoutvo.goodsNumber, stockoutvo.time,
//					stockoutvo.city, stockoutvo.vehicle, stockoutvo.transNumber, stockoutvo.number);
//			stockoutpo.setApproveState(vo.approveState);
//			return stockoutpo;
//		case MONEYIN:
//			Receipt_MoneyInVO moneyinvo = (Receipt_MoneyInVO) vo;
//			Receipt_MoneyInPO moneyinpo = new Receipt_MoneyInPO(moneyinvo.time, moneyinvo.money,
//					personnelInfo.toPersonnelPO(moneyinvo.person), moneyinvo.number);
//			moneyinpo.setOrderNumbers(moneyinvo.orderNumbers);
//			moneyinpo.setApproveState(vo.approveState);
//			return moneyinpo;
//		case MONEYOUT:
//			Receipt_MoneyOutVO moneyoutvo = (Receipt_MoneyOutVO) vo;
//			Receipt_MoneyOutPO moneyoutpo = new Receipt_MoneyOutPO(moneyoutvo.number, moneyoutvo.time, moneyoutvo.money,
//					personnelInfo.toPersonnelPO(moneyoutvo.personnel), moneyoutvo.receiveID, moneyoutvo.clause,
//					moneyoutvo.comments);
//			moneyoutpo.setApproveState(vo.approveState);
//			return moneyoutpo;
//		case TOTALMONEYIN:
//			Receipt_TotalMoneyInVO totalmoneyinvo = (Receipt_TotalMoneyInVO) vo;
//			Receipt_TotalMoneyInPO totalMoneyInpo = new Receipt_TotalMoneyInPO(totalmoneyinvo.time,
//					personnelInfo.toPersonnelPO(totalmoneyinvo.person), totalmoneyinvo.city, totalmoneyinvo.number);
//			totalMoneyInpo.setSum(totalmoneyinvo.sum);
//			totalMoneyInpo.setApproveState(vo.approveState);
//			ArrayList<Receipt_MoneyInVO> receipt_MoneyInVOs = totalmoneyinvo.receipt_Moneyins;
//			ArrayList<Receipt_MoneyInPO> receipt_MoneyInPOs = new ArrayList<Receipt_MoneyInPO>();
//			int size = receipt_MoneyInVOs.size();
//			for (int i = 0; i < size; i++) {
//				receipt_MoneyInPOs.add((Receipt_MoneyInPO) toPO(receipt_MoneyInVOs.get(i)));
//			}
//			totalMoneyInpo.setReceipt_Moneyins(receipt_MoneyInPOs);
//			return totalMoneyInpo;
//		default:
//			return null;
//		}
		return null;
	}

	@Override
	public ReceiptVO findByID(String names) throws RemoteException {
		ReceiptPO po = receiptdata.findByNum(names);
		return toVO(po);
	}
}
