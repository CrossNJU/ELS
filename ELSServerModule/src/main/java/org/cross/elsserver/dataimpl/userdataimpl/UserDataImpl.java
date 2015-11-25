package org.cross.elsserver.dataimpl.userdataimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.cross.elscommon.dataservice.userdataservice.UserDataService;
import org.cross.elscommon.po.OrganizationPO;
import org.cross.elscommon.po.UserPO;
import org.cross.elscommon.util.MySQL;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StringToType;
import org.cross.elscommon.util.UserType;

public class UserDataImpl extends UnicastRemoteObject implements UserDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	MySQL mysql;

	public UserDataImpl() throws RemoteException {
		super();
		this.mysql = new MySQL();
	}

	@Override
	public ResultMessage insert(UserPO po)  throws RemoteException{
		String sql = "insert ignore into `user`(`number`,`name`,`password`,`type`) values ('" + po.getId() + "','"
				+ po.getName() + "','" + po.getPassword() + "','" + po.getType().toString() + "')";
		if (!mysql.execute(sql)) {
			return ResultMessage.FAILED;
		}
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage delete(String id)  throws RemoteException{
		String sql = "delete from `user` where `number`='" + id + "'";
		if (!mysql.execute(sql)) {
			return ResultMessage.FAILED;
		}
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage update(UserPO po)  throws RemoteException{
		if (delete(po.getId()) == ResultMessage.FAILED)
			return ResultMessage.FAILED;
		return insert(po);
	}

	@Override
	public UserPO findById(String id)  throws RemoteException{
		String sql = "select * from `organization` where `number`='" + id + "'";
		ResultSet rs = mysql.query(sql);
		return getFromDB(rs);
	}

	@Override
	public ArrayList<UserPO> findByType(UserType type)  throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<UserPO> findByName(String name)  throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<UserPO> show()  throws RemoteException{
		String sql = "select * from `user`";
		ResultSet rs = mysql.query(sql);
		ArrayList<UserPO> users = new ArrayList<UserPO>();
		try {
			while (rs.next()) {
				users.add(getFromDB(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}

	public UserPO getFromDB(ResultSet rs) {
		UserPO po = null;
		try {
			if (rs.next()) {
				po = new UserPO(rs.getString("number"), rs.getString("password"), rs.getString("name"),
						StringToType.toUserType(rs.getString("type")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
	}

}
