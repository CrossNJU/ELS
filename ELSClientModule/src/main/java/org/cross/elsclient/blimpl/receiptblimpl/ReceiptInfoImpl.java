package org.cross.elsclient.blimpl.receiptblimpl;

import java.rmi.RemoteException;
import java.util.ArrayList;

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
import org.cross.elscommon.po.ReceiptPO;
import org.cross.elscommon.po.Receipt_ArrivePO;
import org.cross.elscommon.po.Receipt_MoneyInPO;
import org.cross.elscommon.po.Receipt_MoneyOutPO;
import org.cross.elscommon.po.Receipt_OrderPO;
import org.cross.elscommon.po.Receipt_StockInPO;
import org.cross.elscommon.po.Receipt_StockOutPO;
import org.cross.elscommon.po.Receipt_TotalMoneyInPO;
import org.cross.elscommon.po.Receipt_TransPO;
import org.cross.elscommon.util.AnalyseID;
import org.cross.elscommon.util.PositionType;

public class ReceiptInfoImpl implements ReceiptInfo {

	ReceiptDataService receiptdata;
	public StockInfo stockInfo;
	public PersonnelInfo personnelInfo;

	public ReceiptInfoImpl() {

	}

	public ReceiptInfoImpl(ReceiptDataService receiptdata, StockInfo stockInfo,
			PersonnelInfo personnelInfo) {
		this.receiptdata = receiptdata;
		this.stockInfo = stockInfo;
		this.personnelInfo = personnelInfo;
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
					realpo.getType(), realpo.getTime(), realpo.getGoodsNum(),
					realpo.getPrice(), realpo.getReceiveTime(),
					realpo.getExpectTime(), realpo.getSenderName(),
					realpo.getSenderMobile(), realpo.getSenderPhone(),
					realpo.getSenderAdd(), realpo.getSenderOrg(),
					realpo.getReceiverName(), realpo.getReceiverOrg(),
					realpo.getReceiverAdd(), realpo.getReceiverPhone(),
					realpo.getReceiverMobile());
			return order;
		case ARRIVE:
			Receipt_ArrivePO arripo = (Receipt_ArrivePO) po;
			Receipt_ArriveVO arri = new Receipt_ArriveVO(arripo.getNumber(),
					arripo.getType(), arripo.getTime(), startOrgName,
					startOrgID, arripo.getTransNum(), arripo.getStartTime(),
					time2, goods, arriveOrgName, arripo.getOrgNum());
			return arri;
		case TRANS:
			Receipt_TransPO transpo = (Receipt_TransPO) po;
			Receipt_TransVO transvo = new Receipt_TransVO(transpo.getNumber(),
					transpo.getType(), transpo.getTime(), transpo.getOrders(),
					transpo.getCost(), transpo.getOrg(), transpo.getLocalNum(),
					transpo.getVehicleNum(), transpo.getStartCity(),
					transpo.getArriveCity(),
					personnelInfo.toPersonnelVO(transpo.getObserver()),
					personnelInfo.toPersonnelVO(transpo.getDriver()));
			transvo.approveState = transpo.getApproveState();
			return transvo;
		case STOCKIN:
			Receipt_StockInPO stockinpo = (Receipt_StockInPO) po;
			Receipt_StockInVO stockinvo = new Receipt_StockInVO(
					stockinpo.getNumber(), stockinpo.getType(),
					stockinpo.getTime(), stockinpo.getOrderNum(),
					stockinpo.getorgname AnalyseID.idToName(stockinpo.getOrgNum()), stockinpo.getDestination(),
					stockinpo.getstockareanum);
			return stockinvo;
		case STOCKOUT:
			Receipt_StockOutPO stockoutpo = (Receipt_StockOutPO) po;
			Receipt_StockOutVO stockoutvo = new Receipt_StockOutVO(
					stockoutpo.getGoodsNumber(), stockoutpo.getTime(),
					stockoutpo.getCity(), stockoutpo.getVehicle(),
					stockoutpo.getTransNumber(), stockoutpo.getNumber());
			stockoutvo.approveState = stockoutpo.getApproveState();
			return stockoutvo;
		case MONEYIN:
			Receipt_MoneyInPO moneyinpo = (Receipt_MoneyInPO) po;
			Receipt_MoneyInVO moneyinvo = new Receipt_MoneyInVO(
					moneyinpo.getTime(), moneyinpo.getMoney(),
					personnelInfo.toPersonnelVO(moneyinpo.getPerson()),
					moneyinpo.getNumber());
			moneyinvo.orderNumbers = moneyinpo.getOrderNumbers();
			moneyinvo.approveState = moneyinpo.getApproveState();
			return moneyinvo;
		case MONEYOUT:
			Receipt_MoneyOutPO moneyoutpo = (Receipt_MoneyOutPO) po;
			Receipt_MoneyOutVO moneyoutvo = new Receipt_MoneyOutVO(
					moneyoutpo.getNumber(), moneyoutpo.getTime(),
					moneyoutpo.getMoney(),
					personnelInfo.toPersonnelVO(moneyoutpo.getPersonnel()),
					moneyoutpo.getReceiveID(), moneyoutpo.getClause(),
					moneyoutpo.getComments());
			moneyoutvo.approveState = moneyoutpo.getApproveState();
			return moneyoutvo;
		case TOTALMONEYIN:
			Receipt_TotalMoneyInPO totalmoneyinpo = (Receipt_TotalMoneyInPO) po;
			Receipt_TotalMoneyInVO totalMoneyInvo = new Receipt_TotalMoneyInVO(
					totalmoneyinpo.getTime(),
					personnelInfo.toPersonnelVO(totalmoneyinpo.getPerson()),
					totalmoneyinpo.getCity(), totalmoneyinpo.getNumber());
			totalMoneyInvo.sum = totalmoneyinpo.getSum();
			totalMoneyInvo.approveState = totalmoneyinpo.getApproveState();
			ArrayList<Receipt_MoneyInVO> receipt_MoneyInVOs = new ArrayList<Receipt_MoneyInVO>();
			ArrayList<Receipt_MoneyInPO> receipt_MoneyInPOs = totalmoneyinpo
					.getReceipt_Moneyins();
			int size = receipt_MoneyInPOs.size();
			for (int i = 0; i < size; i++) {
				receipt_MoneyInVOs
						.add((Receipt_MoneyInVO) toVO(receipt_MoneyInPOs.get(i)));
			}
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
		switch (vo.type) {
		case ORDER:
			Receipt_OrderVO ordervo = (Receipt_OrderVO) vo;
			Receipt_OrderPO orderpo = new Receipt_OrderPO(ordervo.number,
					ordervo.type, ordervo.time, ordervo.goodsNum, ordervo.cost,
					ordervo.expectTime, ordervo.targetPlace,
					ordervo.startPlace, ordervo.pushPeople,
					ordervo.receivePeople);
			orderpo.setReceiveTime(ordervo.receiveTime);
			orderpo.setApproveState(vo.approveState);
			return orderpo;
		case TRANS:
			Receipt_TransVO transvo = (Receipt_TransVO) vo;
			Receipt_TransPO transpo = new Receipt_TransPO(transvo.number,
					transvo.type, transvo.time, transvo.orders, transvo.cost,
					transvo.org, transvo.localNum, transvo.vehicleNum,
					transvo.startCity, transvo.arriveCity,
					personnelInfo.toPersonnelPO(transvo.observer),
					personnelInfo.toPersonnelPO(transvo.driver));
			transpo.setApproveState(vo.approveState);
			return transpo;
		case ARRIVE:
			Receipt_ArriveVO arrivo = (Receipt_ArriveVO) vo;
			Receipt_ArrivePO arripo = new Receipt_ArrivePO(arrivo.number,
					arrivo.type, arrivo.time, arrivo.startPlace,
					arrivo.transNum, arrivo.orders, arrivo.arriveOrg);
			arripo.setApproveState(vo.approveState);
			return arripo;
		case STOCKIN:
			Receipt_StockInVO stockinvo = (Receipt_StockInVO) vo;
			Receipt_StockInPO stockinpo = new Receipt_StockInPO(
					stockinvo.goodsNumber, stockinvo.time,
					stockInfo.toStockAreaPO(stockinvo.place), stockinvo.number);
			stockinpo.setApproveState(vo.approveState);
			return stockinpo;
		case STOCKOUT:
			Receipt_StockOutVO stockoutvo = (Receipt_StockOutVO) vo;
			Receipt_StockOutPO stockoutpo = new Receipt_StockOutPO(
					stockoutvo.goodsNumber, stockoutvo.time, stockoutvo.city,
					stockoutvo.vehicle, stockoutvo.transNumber,
					stockoutvo.number);
			stockoutpo.setApproveState(vo.approveState);
			return stockoutpo;
		case MONEYIN:
			Receipt_MoneyInVO moneyinvo = (Receipt_MoneyInVO) vo;
			Receipt_MoneyInPO moneyinpo = new Receipt_MoneyInPO(moneyinvo.time,
					moneyinvo.money,
					personnelInfo.toPersonnelPO(moneyinvo.person),
					moneyinvo.number);
			moneyinpo.setOrderNumbers(moneyinvo.orderNumbers);
			moneyinpo.setApproveState(vo.approveState);
			return moneyinpo;
		case MONEYOUT:
			Receipt_MoneyOutVO moneyoutvo = (Receipt_MoneyOutVO) vo;
			Receipt_MoneyOutPO moneyoutpo = new Receipt_MoneyOutPO(
					moneyoutvo.number, moneyoutvo.time, moneyoutvo.money,
					personnelInfo.toPersonnelPO(moneyoutvo.personnel),
					moneyoutvo.receiveID, moneyoutvo.clause,
					moneyoutvo.comments);
			moneyoutpo.setApproveState(vo.approveState);
			return moneyoutpo;
		case TOTALMONEYIN:
			Receipt_TotalMoneyInVO totalmoneyinvo = (Receipt_TotalMoneyInVO) vo;
			Receipt_TotalMoneyInPO totalMoneyInpo = new Receipt_TotalMoneyInPO(
					totalmoneyinvo.time,
					personnelInfo.toPersonnelPO(totalmoneyinvo.person),
					totalmoneyinvo.city, totalmoneyinvo.number);
			totalMoneyInpo.setSum(totalmoneyinvo.sum);
			totalMoneyInpo.setApproveState(vo.approveState);
			ArrayList<Receipt_MoneyInVO> receipt_MoneyInVOs = totalmoneyinvo.receipt_Moneyins;
			ArrayList<Receipt_MoneyInPO> receipt_MoneyInPOs = new ArrayList<Receipt_MoneyInPO>();
			int size = receipt_MoneyInVOs.size();
			for (int i = 0; i < size; i++) {
				receipt_MoneyInPOs
						.add((Receipt_MoneyInPO) toPO(receipt_MoneyInVOs.get(i)));
			}
			totalMoneyInpo.setReceipt_Moneyins(receipt_MoneyInPOs);
			return totalMoneyInpo;
		default:
			return null;
		}
	}

	@Override
	public ReceiptVO findByID(String names) throws RemoteException {
		ReceiptPO po = receiptdata.findByNum(names);
		return toVO(po);
	}
}
