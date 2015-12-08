package org.cross.elsserver.dataimpl.personneldataimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.cross.elscommon.dataservice.personneldataservice.PersonnelDataService;
import org.cross.elscommon.po.PersonnelPO;
import org.cross.elscommon.util.MySQL;
import org.cross.elscommon.util.PositionType;
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
		String sql = "select * from `personnel` where `number`='" + id + "'";
		ResultSet rs = mysql.query(sql);
		return getFromDB(rs);
	}

	@Override
	public ArrayList<PersonnelPO> findByName(String name) throws RemoteException {
		String sql = "select * from `personnel` where `name`='" + name + "'";
		ResultSet rs = mysql.query(sql);
		ArrayList<PersonnelPO> pos = new ArrayList<PersonnelPO>();
		PersonnelPO po = null;
		while ((po = getFromDB(rs)) != null)
			pos.add(po);
		return pos;
	}

	@Override
	public ResultMessage insert(PersonnelPO po) throws RemoteException {
		String sql = "insert ignore into `personnel`(`number`, `name`, `position`, `orgNum`, `payment`, `sex`, `id`, `phone`, `birth`) values ('"
				+ po.getNumber() + "','" + po.getName() + "','" + po.getPosition().toString() + "','" + po.getOrgNum()
				+ "'," + po.getPayment() + "," + po.getSex() + ",'" + po.getId() + "','" + po.getPhone() + "','"
				+ po.getBirth() + "')";
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
		if (delete(po.getNumber()) == ResultMessage.FAILED)
			return ResultMessage.FAILED;
		System.out.println("con");
		return insert(po);
	}

	@Override
	public ArrayList<PersonnelPO> show() throws RemoteException {
		String sql = "select * from `personnel`";
		ResultSet rs = mysql.query(sql);
		ArrayList<PersonnelPO> pos = new ArrayList<PersonnelPO>();
		PersonnelPO po = null;
		while ((po = getFromDB(rs)) != null)
			pos.add(po);
		return pos;
	}

	public PersonnelPO getFromDB(ResultSet rs) {
		PersonnelPO po = null;
		try {
			if (rs.next()) {
				po = new PersonnelPO(rs.getString("number"), rs.getString("name"),
						StringToType.toPositionType(rs.getString("position")), rs.getString("orgNum"),
						rs.getDouble("payment"), rs.getInt("sex"), rs.getString("id"), rs.getString("phone"),
						rs.getString("birth"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
	}

	@Override
	public ArrayList<PersonnelPO> findByOrg(String orgNum) throws RemoteException {
		String sql = "select * from `personnel` where `orgNum`='" + orgNum + "'";
		ResultSet rs = mysql.query(sql);
		ArrayList<PersonnelPO> pos = new ArrayList<PersonnelPO>();
		PersonnelPO po = null;
		while ((po = getFromDB(rs)) != null)
			pos.add(po);
		return pos;
	}

	@Override
	public ArrayList<PersonnelPO> findByPosition(PositionType position) throws RemoteException {
		String sql = "select * from `personnel` where `position`='" + position + "'";
		ResultSet rs = mysql.query(sql);
		ArrayList<PersonnelPO> pos = new ArrayList<PersonnelPO>();
		PersonnelPO po = null;
		while ((po = getFromDB(rs)) != null)
			pos.add(po);
		return pos;
	}
	
//	public static void main(String[] args) throws RemoteException{
//
//		PersonnelPO updateVO = new PersonnelPO("P29839", "cdn",
//				PositionType.ADMINISTRATOR, "O00932",0, 1, "321287199999378", null, null);
//		PersonnelDataImpl impl = new PersonnelDataImpl();
//		if(impl.update(updateVO) == ResultMessage.SUCCESS) System.out.println("success");
//		else System.out.println("fail");
//	}

}
