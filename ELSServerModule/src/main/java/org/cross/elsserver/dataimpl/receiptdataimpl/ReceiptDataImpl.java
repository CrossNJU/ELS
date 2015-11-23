package org.cross.elsserver.dataimpl.receiptdataimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.cross.elscommon.dataservice.receiptdataservice.ReceiptDataService;
import org.cross.elscommon.po.ReceiptPO;
import org.cross.elscommon.po.Receipt_OrderPO;
import org.cross.elscommon.util.MySQL;
import org.cross.elscommon.util.ReceiptType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StringToType;

@SuppressWarnings("serial")
public class ReceiptDataImpl extends UnicastRemoteObject implements ReceiptDataService{

	private MySQL mysql;
	private Receipt_OrderDataImpl order;
	
	public ReceiptDataImpl() throws RemoteException {
		super();
		this.order = new Receipt_OrderDataImpl();
		this.mysql = new MySQL();
	}

	@Override
	public ResultMessage insert(ReceiptPO po) throws RemoteException {
		String sql = "insert ignore into `receipt`(`number`, `type`, `time`, `isApproved`) values ('"
				+po.getNumber()+"','"+po.getType().toString()+"','"+po.getTime()+"',"+po.isApproved()+ ")";
		mysql.execute(sql);
		switch (po.getType()) {
		case ORDER:
			return order.insert((Receipt_OrderPO)po);
		default:
			break;
		}
		return ResultMessage.SUCCESS;
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
	public ResultMessage updateCheck(String number) throws RemoteException {
		String sql = "update `receipt` set `isApproved`=true where `number`='"+number+"'";
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

}
