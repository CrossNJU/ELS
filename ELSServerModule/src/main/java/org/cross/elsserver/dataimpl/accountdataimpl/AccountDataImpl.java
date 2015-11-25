package org.cross.elsserver.dataimpl.accountdataimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.cross.elscommon.dataservice.accountdataservice.AccountDataService;
import org.cross.elscommon.po.AccountPO;
import org.cross.elscommon.util.MySQL;
import org.cross.elscommon.util.ResultMessage;

public class AccountDataImpl extends UnicastRemoteObject implements AccountDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	MySQL mysql;

	protected AccountDataImpl() throws RemoteException {
		super();
		this.mysql = new MySQL();
	}

	@Override
	public AccountPO findbyID(String ID) throws RemoteException {
		String sql = "select from `account` where `accountNum`='" + ID + "'";
		ResultSet rs = mysql.query(sql);
		return getFromDB(rs);
	}

	@Override
	public ArrayList<AccountPO> findbyName(String name) throws RemoteException {
		String sql = "select from `account` where `name`='" + name + "'";
		ArrayList<AccountPO> list = new ArrayList<AccountPO>();
		ResultSet rs = mysql.query(sql);
		try {
			while (rs.next()) {
				list.add(getFromDB(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ResultMessage insert(AccountPO po) throws RemoteException {
		String sql = "insert into `account`(`name`, `accountNum`, `balance`) values ('" + po.getName() + "','"
				+ po.getAccount() + "'," + po.getBalance() + ")";
		if (!mysql.execute(sql))
			return ResultMessage.FAILED;
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage delete(String id) throws RemoteException {
		String sql = "delete from `account` where `accountNum`='" + id + "'";
		if (!mysql.execute(sql))
			return ResultMessage.FAILED;
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage update(AccountPO po) throws RemoteException {
		String sql = "update `account` set `name`='" + po.getName() + "', `balance`=" + po.getBalance()
				+ " where `accountNum`='" + po.getAccount() + "'";
		if (!mysql.execute(sql))
			return ResultMessage.FAILED;
		return ResultMessage.SUCCESS;

	}

	@Override
	public ArrayList<AccountPO> show() throws RemoteException {
		String sql = "select * from `account`";
		ArrayList<AccountPO> list = new ArrayList<AccountPO>();
		ResultSet rs = mysql.query(sql);
		try {
			while (rs.next()) {
				list.add(getFromDB(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public AccountPO getFromDB(ResultSet rs) {
		AccountPO po = null;
		try {
			if (rs.next()) {
				po = new AccountPO(rs.getString("name"), rs.getString("accountNum"), rs.getDouble("balance"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
	}

}
