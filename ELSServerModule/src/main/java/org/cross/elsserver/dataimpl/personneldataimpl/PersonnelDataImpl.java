package org.cross.elsserver.dataimpl.personneldataimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.cross.elscommon.dataservice.personneldataservice.PersonnelDataService;
import org.cross.elscommon.po.PersonnelPO;
import org.cross.elscommon.util.MySQL;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StringToType;

public class PersonnelDataImpl extends UnicastRemoteObject implements PersonnelDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	MySQL mysql;

	public PersonnelDataImpl() throws RemoteException {
		super();
		this.mysql = new MySQL();
	}

	@Override
	public PersonnelPO findById(String id) throws RemoteException {
		String sql = "select * from `personnel` where `number`='"+id+"'";
		ResultSet rs = mysql.query(sql);
		return getFromDB(rs);
	}

	@Override
	public ArrayList<PersonnelPO> findByName(String name) throws RemoteException {
		String sql = "select * from `personnel` where `name`='"+name+"'";
		ResultSet rs = mysql.query(sql);
		ArrayList<PersonnelPO> pos = new ArrayList<PersonnelPO>();
		PersonnelPO po = null;
		while((po=getFromDB(rs))!=null) pos.add(po);
		return pos;
	}

	@Override
	public ResultMessage insert(PersonnelPO po) throws RemoteException {
		String sql = "insert ignore into `personnel`(`number`, `name`, `position`, `orgType`, `orgNum`, `payment`) values ('"
				+ po.getId()+"','"+po.getName()+"','"+po.getPosition().toString()+"','"+po.getOrganization().toString()+"','"+
				po.getOrganizationID()+"',"+po.getPayment()+")";
		if (!mysql.execute(sql)) {
			return ResultMessage.FAILED; 
		}
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage delete(String id) throws RemoteException {
		String sql = "delete from `personnel` where `number`='" + id + "'";
		if (!mysql.execute(sql)) {
			return ResultMessage.FAILED;
		}
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage update(PersonnelPO po) throws RemoteException {
		if(delete(po.getId())==ResultMessage.FAILED) return ResultMessage.FAILED;
		return insert(po);
	}

	@Override
	public ArrayList<PersonnelPO> show() throws RemoteException {
		String sql = "select * from `personnel`";
		ResultSet rs = mysql.query(sql);
		ArrayList<PersonnelPO> pos = new ArrayList<PersonnelPO>();
		PersonnelPO po = null;
		while((po=getFromDB(rs))!=null) pos.add(po);
		return pos;
	}

	public PersonnelPO getFromDB(ResultSet rs) {
		PersonnelPO po = null;
		try {
			if (rs.next()) {
				po = new PersonnelPO(rs.getString("number"), rs.getString("name"),
						StringToType.toPositionType(rs.getString("position")),
						StringToType.toOrg(rs.getString("orgType")), rs.  getString("orgNum"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
	}

}
