package org.cross.elsserver.dataimpl.receiptdataimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import org.cross.elscommon.dataservice.receiptdataservice.ReceiptDataService;
import org.cross.elscommon.po.ReceiptPO;
import org.cross.elscommon.po.Receipt_DeliverPO;
import org.cross.elscommon.po.Receipt_OrderPO;
import org.cross.elscommon.po.Receipt_StockOutPO;
import org.cross.elscommon.po.Receipt_TransPO;
import org.cross.elscommon.util.CompareTime;
import org.cross.elscommon.util.ReceiptType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StringToType;
import org.cross.elsserver.database.MySQL;

@SuppressWarnings("serial")
public class ReceiptDataImpl extends UnicastRemoteObject implements
		ReceiptDataService {

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
		this.mysql = MySQL.getMysql();
	}

	@Override
	public ResultMessage insert(ReceiptPO po) throws RemoteException {
		String sql = "insert ignore into `receipt`(`number`, `type`, `time`, `approveState`, `perNum`, `orgNum`) values ('"
				+ po.getNumber()
				+ "','"
				+ po.getType().toString()
				+ "','"
				+ po.getTime()
				+ "','"
				+ po.getApproveState().toString()
				+ "','" + po.getPerNum() + "','" + po.getOrgNum() + "')";
		if (!mysql.execute(sql))
			return ResultMessage.FAILED;
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
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage delete(String number, ReceiptType type)
			throws RemoteException {
		String sql = "delete from `receipt` where `number` = '" + number + "'";
		if (!mysql.execute(sql))
			return ResultMessage.FAILED;
		sql = "delete from `" + Typetotable.gettable(type)
				+ "` where `number`='" + number + "'";
		if (!mysql.execute(sql))
			return ResultMessage.FAILED;
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage updateCheck(String number, String state)
			throws RemoteException {
		String sql = "update `receipt` set `approveState`='" + state
				+ "' where `number`='" + number + "'";
		if (mysql.execute(sql))
			return ResultMessage.SUCCESS;
		else
			return ResultMessage.FAILED;
	}

	@Override
	public ArrayList<ReceiptPO> show() throws RemoteException {
		ArrayList<ReceiptPO> list = new ArrayList<ReceiptPO>();
		list = findreceipts("", "", true);
//		String sql = "select * from `receipt`";
//		ResultSet rs = mysql.query(sql);
//		try {
//			while (rs.next()) {
//				String number = rs.getString("number");
//				ReceiptPO po = findByNum(number);
//				list.add(po);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return list;
	}

	@Override
	public ReceiptPO findByNum(String number) throws RemoteException {
		ArrayList<ReceiptPO> list = new ArrayList<ReceiptPO>();
		list = findreceipts("number", number, false);
		return list.get(0);
	}

	@Override
	public ArrayList<ReceiptPO> findByTime(String startTime, String endTime)
			throws RemoteException {
		ArrayList<ReceiptPO> receipts = new ArrayList<ReceiptPO>();
		receipts = show();
		for (ReceiptPO po: receipts) {
			if (CompareTime.compare(po.getTime(), startTime) != 1
					|| CompareTime.compare(endTime, po.getTime()) != 1) {
//				ReceiptPO po = findByNum(rs.getString("number"));
				receipts.remove(po);
			}
			
		}
//		String sql = "select * from `receipt`";
//		ResultSet rs = mysql.query(sql);
//		try {
//			while (rs.next()) {
//				String time = rs.getString("time");
//				if (CompareTime.compare(time, startTime) == 1
//						&& CompareTime.compare(endTime, time) == 1) {
//					ReceiptPO po = findByNum(rs.getString("number"));
//					receipts.add(po);
//				}
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return receipts;
	}

	@Override
	public ArrayList<ReceiptPO> findByType(ReceiptType type)
			throws RemoteException {
		ArrayList<ReceiptPO> receipts = new ArrayList<ReceiptPO>();
		receipts = findreceipts("type", type.toString(), false);
//		String sql = "select * from `receipt` where `type`='" + type.toString()
//				+ "'";
//		ResultSet rs = mysql.query(sql);
//		try {
//			while (rs.next()) {
//				ReceiptPO po = findByNum(rs.getString("number"));
//				receipts.add(po);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return receipts;
	}

	@Override
	public ArrayList<ReceiptPO> findByTimeAndType(String startTime,
			String endTime, ReceiptType type) throws RemoteException {
		ArrayList<ReceiptPO> receipts = new ArrayList<ReceiptPO>();
		receipts = findByTime(startTime, endTime);
		for (ReceiptPO receiptPO : receipts) {
			if (receiptPO.getType()!=type) {
				receipts.remove(receiptPO);
			}
		}
//		String sql = "select * from `receipt` where `type`='" + type.toString()
//				+ "'";
//		ResultSet rs = mysql.query(sql);
//		try {
//			while (rs.next()) {
//				String time = rs.getString("time");
//				if (CompareTime.compare(time, startTime) == 1
//						&& CompareTime.compare(endTime, time) == 1) {
//					ReceiptPO po = findByNum(rs.getString("number"));
//					receipts.add(po);
//				}
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return receipts;
	}

	@Override
	public ResultMessage update(ReceiptPO po) throws RemoteException {
		if (delete(po.getNumber(), po.getType()) == ResultMessage.FAILED)
			return ResultMessage.FAILED;
		return insert(po);
	}

	@Override
	public ArrayList<ReceiptPO> findByPerNum(String perNum)
			throws RemoteException {
		ArrayList<ReceiptPO> list = new ArrayList<ReceiptPO>();
		list = findreceipts("perNum", perNum, false);
//		String sql = "select * from `receipt` where `perNum`='" + perNum + "'";
//		ResultSet rs = mysql.query(sql);
//		try {
//			while (rs.next()) {
//				ReceiptPO po = findByNum(rs.getString("number"));
//				list.add(po);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return list;
	}

	@Override
	public ArrayList<ReceiptPO> findByOrgNum(String orgNum)
			throws RemoteException {
		ArrayList<ReceiptPO> list = new ArrayList<ReceiptPO>();
		list = findreceipts("orgNum", orgNum, false);
//		String sql = "select * from `receipt` where `orgNum`='" + orgNum + "'";
//		ResultSet rs = mysql.query(sql);
//		try {
//			while (rs.next()) {
//				ReceiptPO po = findByNum(rs.getString("number"));
//				list.add(po);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return list;
	}

	public ArrayList<ReceiptPO> findreceipts(String table, String num, boolean show){
		String sql = "select * from receipt,receiptarrive,receiptdeliver,receiptmoneyin,"
				+ "receiptmoneyout,receiptorder,receiptstockin,receiptstockout,receipttotalmoneyin,receipttrans"
				+ " where receipt."+table+"= '"+num+"' and ( "
				+ " receiptarrive.number = receipt.number or "
				+ " receiptdeliver.number = receipt.number or "
				+ " receiptmoneyin.number = receipt.number or "
				+ " receiptmoneyout.number = receipt.number or "
				+ " receiptorder.number = receipt.number or "
				+ " receiptstockin.number = receipt.number or "
				+ " receiptstockout.number = receipt.number or "
				+ " receipttotalmoneyin.number = receipt.number or "
				+ " receipttrans.number = receipt.number )";
		if (show) {
			sql = "select * from receipt,receiptarrive,receiptdeliver,receiptmoneyin,"
					+ "receiptmoneyout,receiptorder,receiptstockin,receiptstockout,receipttotalmoneyin,receipttrans";
		}
		ResultSet rs = mysql.query(sql);
		ArrayList<ReceiptPO> list = new ArrayList<ReceiptPO>();
		try {
			while (rs.next()) {
				ReceiptType type = StringToType.toReceiptType(rs
						.getString("type"));
				if (type == null) {
					return null;
				}
				ReceiptPO po = null;
				switch (type) {
				case ORDER:
					po = order.getFromDB(rs);
				case TRANS:
					po = trans.getFromDB(rs);
				case ARRIVE:
					po = arri.getFromDB(rs);
				case STOCKIN:
					po = stockin.getFromDB(rs);
				case STOCKOUT:
					po = stockout.getFromDB(rs);
				case MONEYIN:
					po = moneyin.getFromDB(rs);
				case MONEYOUT:
					po = moneyout.getFromDB(rs);
				case TOTALMONEYIN:
					po = totalmoneyin.getFromDB(rs);
				case DELIVER:
					po = del.getFromDB(rs);
				default:
				}
				boolean has = false;
				for (ReceiptPO receiptPO : list) {
					if (receiptPO.getNumber().equals(po.getNumber())) {
						has = true;
					}
				}
				if(!has) list.add(po);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public static void main(String[] args) throws RemoteException {
		ReceiptDataImpl impl = new ReceiptDataImpl();
		// Receipt_OrderPO order1 = new
		// Receipt_OrderPO("R0000001",ReceiptType.ORDER, "2015-10-01 19:30",
		// "O001","P001", 20,
		// "2015-10-03", "陈丹妮", "陈睿", "南京大学", "南京大学","江苏省南京市南京大学仙林校区",
		// "江苏省南京市南京大学仙林校区",
		// "934782738", "83247376", "13333333333", "18351000000");
		// Receipt_DeliverPO delpo = new Receipt_DeliverPO("R0000017",
		// ReceiptType.DELIVER, "time", "org", "per", "order", "cr", "cdn");
		// if(impl.insert(delpo) == ResultMessage.SUCCESS)
		// System.out.println("su");
		// else System.out.println("fail");
		// Receipt_TransPO po = (Receipt_TransPO)impl.findByNum("R0000011");
//		Receipt_StockOutPO po = (Receipt_StockOutPO) impl.findByNum("R0000013");
//		System.out.println(po.getNumber());
		ArrayList<ReceiptPO> list = impl.findreceipts("number", "R0000002", false);
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i).getType());
//		}
		System.out.println(list.size());
	}

}
