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

public class VehicleDataImpl extends UnicastRemoteObject implements VehicleDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MySQL mysql;

	public VehicleDataImpl() throws RemoteException {
		super();
		mysql = new MySQL();
	}

	@Override
	public ResultMessage insert(VehiclePO po) throws RemoteException {
		String sql = "INSERT IGNORE INTO `vehicle`(`number`, `engineNum`, `baseNum`, `buyTime`, `lastTime`, `state`, `type`) VALUES ('"
				+ po.getNumber() + "','" + po.getEngineNumber() + "','" + po.getApparatusNumber() + "','"
				+ po.getBuyTime() + "','" + po.getLastTime() + "'," + po.isInUse() + ",'" + po.getType().toString()
				+ "')";
		if(mysql.execute(sql)) return ResultMessage.SUCCESS;
		else return ResultMessage.FAILED;
	}

	@Override
	public ResultMessage delete(String number) throws RemoteException {
		String sql = "DELETE FROM `vehicle` WHERE number = '" + number + "'";
		if (mysql.execute(sql)) {
			return ResultMessage.SUCCESS;
		}else {
			return ResultMessage.FAILED;
		}
	}

	public int boolToInt(boolean state){
		if (state) {
			return 1;
		}else {
			return 0;
		}
	}
	@Override
	public ResultMessage update(VehiclePO po) throws RemoteException {

		String sql = "UPDATE `vehicle` SET `engineNum`='" + po.getEngineNumber() + "',`baseNum`='"
				+ po.getApparatusNumber() + "',`buyTime`='" + po.getBuyTime() + "',`lastTime`='" + po.getLastTime()
				+ "',`state`='" + boolToInt(po.isInUse()) + "',`type`='" + po.getType().toString() + "' WHERE number = '"
				+ po.getNumber() + "'";
		if (mysql.execute(sql)) {
			return ResultMessage.SUCCESS;
		}else {
			return ResultMessage.FAILED;
		}
	}

	@Override
	public ArrayList<VehiclePO> show() throws RemoteException {
		String sql = "SELECT * FROM `vehicle` WHERE 1";
		ResultSet rs = mysql.query(sql);
		ArrayList<VehiclePO> list = new ArrayList<VehiclePO>();
		try {
			while (rs.next()) {
				VehiclePO po = getFromDB(rs);
				if(po!=null) list.add(po);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public VehiclePO findByID(String number) throws RemoteException {
		String sql = "SELECT * FROM `vehicle` WHERE number = '"+number+"'";
		ResultSet rs = mysql.query(sql);
		return getFromDB(rs);
	}

	public VehiclePO getFromDB(ResultSet rs) throws RemoteException{
		VehiclePO po = null;
		try {
			if(rs.next()){
			po = new VehiclePO(rs.getString("number"), rs.getString("engineNum"), rs.getString("baseNum"),
					rs.getString("buyTime"), rs.getString("lastTime"), null,
					StringToType.toVehicleType(rs.getString("type")));
			po.setInUse(rs.getBoolean("state"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return po;
	}

	public static void main(String[] args) throws RemoteException {
//		VehiclePO vehiclePO = new VehiclePO("000000003", "EN000002", "BA000002", "2020-01-01", "2032-12-11", null,VehicleType.CAR);
//		
		VehicleDataImpl vehicleDataImpl = new VehicleDataImpl();
		 VehiclePO po = vehicleDataImpl.findByID("V000001");
		 System.out.println(po.getApparatusNumber());
		// vehicleDataImpl.delete("V000001");
//		vehicleDataImpl.;
	}

}
