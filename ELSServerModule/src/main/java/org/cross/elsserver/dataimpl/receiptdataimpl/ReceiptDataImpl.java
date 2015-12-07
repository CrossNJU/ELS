package org.cross.elsserver.dataimpl.receiptdataimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.cross.elscommon.dataservice.receiptdataservice.ReceiptDataService;
import org.cross.elscommon.po.ReceiptPO;
import org.cross.elscommon.util.CompareTime;
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
	private Receipt_StockInDataImpl stockin;
	private Receipt_StockOutDataImpl stockout;
	private Receipt_MoneyInDataImpl moneyin;
	private Receipt_MoneyOutDataImpl moneyout;
	private Receipt_TotalMoneyInDataImpl totalmoneyin;
	private Receipt_DelDataImpl del;
	
	public ReceiptDataImpl() throws RemoteException {
		super();
		this.order = new Receipt_OrderDataImpl();
		this.arri = new Receipt_ArriDataImpl();
		this.trans = new Receipt_TransDataImpl();
		this.stockin = new Receipt_StockInDataImpl();
		this.stockout = new Receipt_StockOutDataImpl();
		this.moneyin = new Receipt_MoneyInDataImpl();
		this.moneyout = new Receipt_MoneyOutDataImpl();
		this.totalmoneyin = new Receipt_TotalMoneyInDataImpl();
		this.del = new Receipt_DelDataImpl();
		this.mysql = new MySQL();
	}

	@Override
	public ResultMessage insert(ReceiptPO po) throws RemoteException {
		String sql = "insert ignore into `receipt`(`number`, `type`, `time`, `approveState`, `perNum`, `orgNum`) values ('"
				+po.getNumber()+"','"+po.getType().toString()+"','"+po.getTime()+"','"+po.getApproveState().toString()+
				po.getPerNum()+"','"+po.getOrgNum()+"')";
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
		case DELIVER:
			return del.insert(po);
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
				if (type == null) {
					return null;
				}
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
				case DELIVER:
					return del.getFromDB(number);
				default:
					return null;
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
		ArrayList<ReceiptPO> receipts = new ArrayList<ReceiptPO>();
		String sql = "select * from `receipt`";
		ResultSet rs = mysql.query(sql);
		try {
			while (rs.next()) {
				String time = rs.getString("time");
				if (CompareTime.compare(time, startTime) == 1 && CompareTime.compare(endTime, time) == 1) {
					ReceiptPO po = findByNum(rs.getString("number"));
					receipts.add(po);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return receipts;
	}

	@Override
	public ArrayList<ReceiptPO> findByType(ReceiptType type) throws RemoteException {
		ArrayList<ReceiptPO> receipts = new ArrayList<ReceiptPO>();
		String sql = "select * from `receipt` where `type`='"+type.toString()+"'";
		ResultSet rs = mysql.query(sql);
		try {
			while (rs.next()) {
				ReceiptPO po = findByNum(rs.getString("number"));
				receipts.add(po);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return receipts;
	}

	@Override
	public ArrayList<ReceiptPO> findByTimeAndType(String startTime, String endTime, ReceiptType type)
			throws RemoteException {
		ArrayList<ReceiptPO> receipts = new ArrayList<ReceiptPO>();
		String sql = "select * from `receipt` where `type`='"+type.toString()+"'";
		ResultSet rs = mysql.query(sql);
		try {
			while (rs.next()) {
				String time = rs.getString("time");
				if (CompareTime.compare(time, startTime) == 1 && CompareTime.compare(endTime, time) == 1) {
					ReceiptPO po = findByNum(rs.getString("number"));
					receipts.add(po);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return receipts;
	}

	@Override
	public ResultMessage update(ReceiptPO po) throws RemoteException {
		if(delete(po.getNumber(), po.getType())==ResultMessage.FAILED) return ResultMessage.FAILED;
		return insert(po);
	}

	@Override
	public ArrayList<ReceiptPO> findByPerNum(String perNum) throws RemoteException {
		String sql = "select * from `receipt` where `perNum`='"+perNum+"'";
		ResultSet rs = mysql.query(sql);
		ArrayList<ReceiptPO> list = new ArrayList<ReceiptPO>();
		try {
			while (rs.next()) {
				ReceiptPO po = findByNum(rs.getString("number"));
				list.add(po);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ArrayList<ReceiptPO> findByOrgNum(String orgNum) throws RemoteException {
		String sql = "select * from `receipt` where `orgNum`='"+orgNum+"'";
		ResultSet rs = mysql.query(sql);
		ArrayList<ReceiptPO> list = new ArrayList<ReceiptPO>();
		try {
			while (rs.next()) {
				ReceiptPO po = findByNum(rs.getString("number"));
				list.add(po);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
