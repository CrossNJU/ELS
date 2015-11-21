package org.cross.elsserver.dataimpl.vehicledataimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.cross.elscommon.dataservice.vehicledataservice.VehicleDataService;
import org.cross.elscommon.po.VehiclePO;
import org.cross.elscommon.util.MySQL;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StringToType;
import org.cross.elscommon.util.VehicleType;

public class VehicleDataImpl extends UnicastRemoteObject implements VehicleDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	MySQL mysql;

	protected VehicleDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		mysql = new MySQL();
	}

	@Override
	public ResultMessage insert(VehiclePO po) throws RemoteException {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO `vehicle`(`number`, `engineNum`, `baseNum`, `buyTime`, `lastTime`, `state`, `type`) VALUES ('"
				+ po.getNumber() + "','" + po.getEngineNumber() + "','" + po.getApparatusNumber() + "','"
				+ po.getBuyTime() + "','" + po.getLastTime() + "'," + po.isInUse() + ",'" + po.getType().toString()
				+ "')";
		mysql.execute(sql);
		return null;
	}

	@Override
	public ResultMessage delete(String number) throws RemoteException {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM `vehicle` WHERE number = '" + number + "'";
		mysql.execute(sql);
		return null;
	}

	@Override
	public ResultMessage update(VehiclePO po) throws RemoteException {
		// TODO Auto-generated method stub

		String sql = "UPDATE `vehicle` SET `engineNum`='" + po.getEngineNumber() + "',`baseNum`='"
				+ po.getApparatusNumber() + "',`buyTime`='" + po.getBuyTime() + "',`lastTime`='" + po.getLastTime()
				+ "',`state`='" + po.isInUse() + "',`type`='" + po.getType().toString() + "' WHERE number = '"
				+ po.getNumber() + "'";
		mysql.execute(sql);
		return null;
	}

	@Override
	public ArrayList<VehiclePO> show() throws RemoteException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM `vehicle` WHERE 1";
		ResultSet rs = mysql.query(sql);
		ArrayList<VehiclePO> list = new ArrayList<VehiclePO>();
		try {
			while (rs.next()) {
				VehiclePO po = getFromDB(rs);
				if(po!=null) list.add(po);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public VehiclePO findByID(String number) throws RemoteException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM `vehicle` WHERE number = '"+number+"'";
		ResultSet rs = mysql.query(sql);
		return getFromDB(rs);
	}

	public VehiclePO getFromDB(ResultSet rs) {
		VehiclePO po = null;
		try {
			po = new VehiclePO(rs.getString("number"), rs.getString("enginNum"), rs.getString("baseNum"),
					rs.getString("buyTime"), rs.getString("lastTime"), null,
					StringToType.toVehicleType(rs.getString("type")));
			po.setInUse(rs.getBoolean("state"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
	}

	public static void main(String[] args) throws RemoteException {
//		VehiclePO vehiclePO = new VehiclePO("V000001", "EN000002", "BA000002", "2020-01-01", "2032-12-11", null,
//				VehicleType.CAR);
//		VehicleDataImpl vehicleDataImpl = new VehicleDataImpl();
		// vehicleDataImpl.insert(vehiclePO);
		// vehicleDataImpl.delete("V000001");
//		vehicleDataImpl.;
	}

}
