package org.cross.elsserver.dataimpl.vehicledataimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import org.cross.elscommon.dataservice.vehicledataservice.VehicleDataService;
import org.cross.elscommon.po.VehiclePO;
import org.cross.elscommon.util.MySQL;
import org.cross.elscommon.util.ResultMessage;
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
		String sql = "DELETE FROM `vehicle` WHERE number = '"+number+"'";
		mysql.execute(sql);
		return null;
	}

	@Override
	public ResultMessage update(VehiclePO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<VehiclePO> show() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VehiclePO findByID(String number) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) throws RemoteException{
		VehiclePO vehiclePO = new VehiclePO("V000001", "EN000001", "BA000001", "2000-01-01", "2012-12-11", null, VehicleType.CAR);
		VehicleDataImpl vehicleDataImpl = new VehicleDataImpl();
//		vehicleDataImpl.insert(vehiclePO);
		vehicleDataImpl.delete("V000001");
	}

}
