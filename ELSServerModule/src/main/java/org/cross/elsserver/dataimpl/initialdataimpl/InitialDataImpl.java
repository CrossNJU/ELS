package org.cross.elsserver.dataimpl.initialdataimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.cross.elscommon.dataservice.initialdataservice.InitialDataService;
import org.cross.elscommon.po.AccountPO;
import org.cross.elscommon.po.InitialPO;
import org.cross.elscommon.po.OrganizationPO;
import org.cross.elscommon.po.PersonnelPO;
import org.cross.elscommon.po.StockPO;
import org.cross.elscommon.po.VehiclePO;
import org.cross.elscommon.util.MySQL;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StringToType;

public class InitialDataImpl extends UnicastRemoteObject implements InitialDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	MySQL mysql;

	public InitialDataImpl() throws RemoteException {
		super();
		mysql = new MySQL();
	}

	@Override
	public ResultMessage insert(InitialPO po) throws RemoteException {
		String sql = "insert igore into `initial`(`number`, `time`, `name`) values('" + po.getId() + "'," + po.getYear()
				+ ",'" + po.getName() + "')";
		if (!mysql.execute(sql))
			return ResultMessage.FAILED;
		ArrayList<OrganizationPO> init_org = po.getOrganizations();
		for (int i = 0; i < init_org.size(); i++) {
			OrganizationPO org = init_org.get(i);
			sql = "insert ignore into `initial_organization`(`number`, `city`, `type`, `initialNum`) values ('"
					+ org.getId() + "','" + org.getCity().toString() + "','" + org.getType().toString() + "','"
					+ po.getId() + "')";
			if (!mysql.execute(sql))
				return ResultMessage.FAILED;
		}
		ArrayList<PersonnelPO> init_per = po.getPersonnels();
		for (int i = 0; i < init_per.size(); i++) {
			PersonnelPO per = init_per.get(i);
			sql = "insert ignore into `initial_personnel`(`number`, `name`, `position`, `orgType`, `orgNum`, `payment`,`initialNum`) values ('"
					+ per.getId() + "','" + per.getName() + "','" + per.getPosition().toString() + "','"
					+ per.getOrganization().toString() + "','" + per.getOrganizationID() + "'," + per.getPayment()
					+ ",'" + po.getId() + "')";
			if (!mysql.execute(sql))
				return ResultMessage.FAILED;
		}
		ArrayList<VehiclePO> init_veh = po.getVehicles();
		for (int i = 0; i < init_veh.size(); i++) {
			VehiclePO veh = init_veh.get(i);
			sql = "insert ignore into `initial_vehicle`(`number`, `engineNum`, `baseNum`, `buyTime`, `lastTime`, `type`, `initialNum`) values ('"
					+ veh.getNumber() + "','" + veh.getEngineNumber() + "','" + veh.getApparatusNumber()
					+ veh.getBuyTime() + "','" + veh.getLastTime() + "','" + veh.getType().toString() + "','"
					+ po.getId() + "')";
			if (!mysql.execute(sql))
				return ResultMessage.FAILED;
		}
		ArrayList<StockPO> init_sto = po.getStocks();
		for (int i = 0; i < init_sto.size(); i++) {
			StockPO sto = init_sto.get(i);
			sql = "insert ignore into `initial_stock`(`number`, `numInStock`, `initialNum`) values ('" + sto.getNumber()
					+ "','" + sto.getNumInStock() + "','" + po.getId() + "')";
			if (!mysql.execute(sql))
				return ResultMessage.FAILED;
		}
		ArrayList<AccountPO> init_acc = po.getAccounts();
		for (int i = 0; i < init_acc.size(); i++) {
			AccountPO acc = init_acc.get(i);
			sql = "insert ignore into `initial_account`(`number`, `name`, `balance`, `initialNum`) values ('"
					+ acc.getAccount() + "','" + acc.getName() + "'," + acc.getBalance() + ",'" + po.getId() + "')";
			if (!mysql.execute(sql))
				return ResultMessage.FAILED;
		}
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<InitialPO> show() throws RemoteException {
		String sql = "select * from `initial`";
		ResultSet rs = mysql.query(sql);
		ArrayList<InitialPO> list = new ArrayList<InitialPO>();
		try {
			while (rs.next()) {
				InitialPO po = findByID(rs.getString("number"));
				list.add(po);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public InitialPO findByID(String initialID) {
		String sql = "select * from `initial` where `number`='"+initialID+"'";
		ResultSet rs = mysql.query(sql);
		InitialPO po = null;
		try {
			if (rs.next()) {
				po = new InitialPO(initialID, rs.getString("name"), rs.getInt("year"),
						showInit_org(initialID), showInit_per(initialID), showInit_veh(initialID), 
						showInit_sto(initialID), showInit_acc(initialID));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
	}

	public ArrayList<OrganizationPO> showInit_org(String initialNum) {
		ArrayList<OrganizationPO> orgs = new ArrayList<OrganizationPO>();
		String sql = "select * from `initial_organization` where `inititalNum`='" + initialNum + "'";
		ResultSet rs = mysql.query(sql);
		try {
			while (rs.next()) {
				OrganizationPO org = new OrganizationPO(StringToType.toCity("city"),
						StringToType.toOrg(rs.getString("number")), rs.getString("number"));
				orgs.add(org);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orgs;
	}

	public ArrayList<VehiclePO> showInit_veh(String initialNum) {
		ArrayList<VehiclePO> vehs = new ArrayList<VehiclePO>();
		String sql = "select * from `initial_vehicle` where `inititalNum`='" + initialNum + "'";
		ResultSet rs = mysql.query(sql);
		try {
			while (rs.next()) {
				VehiclePO veh = new VehiclePO(rs.getString("number"), rs.getString("engineNum"),
						rs.getString("baseNum"), rs.getString("buyTime"), rs.getString("lastTime"), null,
						StringToType.toVehicleType(rs.getString("type")));
				vehs.add(veh);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vehs;
	}

	public ArrayList<PersonnelPO> showInit_per(String initialNum) {
		ArrayList<PersonnelPO> pers = new ArrayList<PersonnelPO>();
		String sql = "select * from `initial_personnel` where `inititalNum`='" + initialNum + "'";
		ResultSet rs = mysql.query(sql);
		try {
			while (rs.next()) {
				PersonnelPO per = new PersonnelPO(rs.getString("number"), rs.getString("name"),
						StringToType.toPositionType(rs.getString("position")),
						StringToType.toOrg(rs.getString("orgType")), rs.getString("orgNum"));
				per.setPayment(rs.getDouble("payment"));
				pers.add(per);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pers;
	}

	public ArrayList<StockPO> showInit_sto(String initialNum) {
		ArrayList<StockPO> stos = new ArrayList<StockPO>();
		String sql = "select * from `initial_stock` where `inititalNum`='" + initialNum + "'";
		ResultSet rs = mysql.query(sql);
		try {
			while (rs.next()) {
				StockPO sto = new StockPO(rs.getString("number"), rs.getInt("numInStock"));
				stos.add(sto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stos;
	}

	public ArrayList<AccountPO> showInit_acc(String initialNum) {
		ArrayList<AccountPO> accs = new ArrayList<AccountPO>();
		String sql = "select * from `initial_account` where `inititalNum`='" + initialNum + "'";
		ResultSet rs = mysql.query(sql);
		try {
			while (rs.next()) {
				AccountPO acc = new AccountPO(rs.getString("name"), rs.getString("number"), rs.getDouble("balance"));
				accs.add(acc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return accs;
	}
}
