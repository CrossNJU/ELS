package org.cross.elsserver.dataimpl.receiptdataimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.cross.elscommon.dataservice.receiptdataservice.ReceiptDataService;
import org.cross.elscommon.po.ReceiptPO;
import org.cross.elscommon.util.MySQL;
import org.cross.elscommon.util.ReceiptType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StringToType;

@SuppressWarnings("serial")
public class ReceiptDataImpl extends UnicastRemoteObject implements ReceiptDataService{

	private MySQL mysql;
	private Receipt_OrderDataImpl order;
	private Receipt_ArriDataImpl arri;
	private Receipt_TransDataImpl trans;
	private Receipt_StockInImpl stockin;
	private Receipt_StockOutDataImpl stockout;
	private Receipt_MoneyInDataImpl moneyin;
	private Receipt_MoneyOutDataImpl moneyout;
	private Receipt_TotalMoneyInDataImpl totalmoneyin;
	
	public ReceiptDataImpl() throws RemoteException {
		super();
		this.order = new Receipt_OrderDataImpl();
		this.arri = new Receipt_ArriDataImpl();
		this.trans = new Receipt_TransDataImpl();
		this.stockin = new Receipt_StockInImpl();
		this.stockout = new Receipt_StockOutDataImpl();
		this.moneyin = new Receipt_MoneyInDataImpl();
		this.moneyout = new Receipt_MoneyOutDataImpl();
		this.totalmoneyin = new Receipt_TotalMoneyInDataImpl();
		this.mysql = new MySQL();
	}

	@Override
	public ResultMessage insert(ReceiptPO po) throws RemoteException {
		String sql = "insert ignore into `receipt`(`number`, `type`, `time`, `approveState`) values ('"
				+po.getNumber()+"','"+po.getType().toString()+"','"+po.getTime()+"','"+po.getApproveState().toString()+ "')";
		if(!mysql.execute(sql)) return ResultMessage.FAILED;
		switch (po.getType()) {
		case ORDER:
			return order.insert(po);
		case TRANS:
			return trans.insert(po);
		case ARRIVE:
			return arri.insert(po);
		case STOCKIN:
			return stockin.insert(po);
		case STOCKOUT:
			return stockout.insert(po);
		case MONEYIN:
			return moneyin.insert(po);
		case MONEYOUT:
			return moneyout.insert(po);
		case TOTALMONEYIN:
			return totalmoneyin.insert(po);
		default:
			break;
		}
		return ResultMessage.FAILED;
	}

	@Override
	public ResultMessage delete(String number, ReceiptType type) throws RemoteException {
		String sql = "delete from `receipt` where `number` = '"+number+"'";
		if(!mysql.execute(sql)) return ResultMessage.FAILED;
		sql = "delete from `"+Typetotable.gettable(type)+"` where `number`='"+number+"'";
		if(!mysql.execute(sql)) return ResultMessage.FAILED;
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage updateCheck(String number, String state) throws RemoteException {
		String sql = "update `receipt` set `approveState`='"+state+"' where `number`='"+number+"'";
		if(mysql.execute(sql)) return ResultMessage.SUCCESS;
		else return ResultMessage.FAILED;
	}

	@Override
	public ArrayList<ReceiptPO> show() throws RemoteException {
		ArrayList<ReceiptPO> list = new ArrayList<ReceiptPO>();
		String sql = "select * from `receipt`";
		ResultSet rs = mysql.query(sql);
		try {
			while (rs.next()) {
				String number = rs.getString("number");
				ReceiptPO po = findByNum(number);
				list.add(po);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ReceiptPO findByNum(String number) throws RemoteException {
		String sql = "select * from `receipt` where `number`='"+number+"'";
		ResultSet rs = mysql.query(sql);
		try {
			if (rs.next()) {
				ReceiptType type = StringToType.toReceiptType(rs.getString("type"));
				switch (type) {
				case ORDER:
					return order.getFromDB(number);
				case TRANS:
					return trans.getFromDB(number);
				case ARRIVE:
					return arri.getFromDB(number);
				case STOCKIN:
					return stockin.getFromDB(number);
				case STOCKOUT:
					return stockout.getFromDB(number);
				case MONEYIN:
					return moneyin.getFromDB(number);
				case MONEYOUT:
					return moneyout.getFromDB(number);
				case TOTALMONEYIN:
					return totalmoneyin.getFromDB(number);
				default:
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<ReceiptPO> findByTime(String startTime, String endTime) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ReceiptPO> findByType(ReceiptType type) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ReceiptPO> findByTimeAndType(String startTime, String endTime, ReceiptType type)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage update(ReceiptPO po) throws RemoteException {
		if(delete(po.getNumber(), po.getType())==ResultMessage.FAILED) return ResultMessage.FAILED;
		return insert(po);
	}

	@Override
	public ArrayList<String> findOrdersByTransNum(String transNum) throws RemoteException {
		String sql = "select * from `goods` where `transNum`='"+transNum+"'";
		ArrayList<String> goods = new ArrayList<String>();
		ResultSet rs = mysql.query(sql);
		try {
			while (rs.next()) {
				goods.add(rs.getString("orderNum"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return goods;
	}

}
