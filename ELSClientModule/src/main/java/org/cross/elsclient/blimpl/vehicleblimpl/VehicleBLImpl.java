package org.cross.elsclient.blimpl.vehicleblimpl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.blUtility.VehicleInfo;
import org.cross.elsclient.blservice.vehicleblservice.VehicleBLService;
import org.cross.elsclient.blservice.vehicleblservice.VehicleBLService_Stub;
import org.cross.elsclient.vo.VehicleVO;
import org.cross.elscommon.dataservice.vehicledataservice.VehicleDataService;
import org.cross.elscommon.po.VehiclePO;
import org.cross.elscommon.util.PositionType;
import org.cross.elscommon.util.ResultMessage;

public class VehicleBLImpl implements VehicleBLService{

	public VehicleDataService vehicleData;
	public VehicleInfo vehicleInfo;
	
	public VehicleBLImpl(VehicleDataService vehicleData,VehicleInfo vehicleInfo){
		this.vehicleData = vehicleData;
		this.vehicleInfo = vehicleInfo;
	}
	
	@Override
	public ResultMessage add(VehicleVO vo) throws RemoteException {
		VehiclePO po = vehicleInfo.toVehiclePO(vo);
		System.out.println(po.getNumber());
		return vehicleData.insert(po);
	}

	@Override
	public ResultMessage delete(VehicleVO vo) throws RemoteException {
		String number = vo.number;
		return vehicleData.delete(number);
	}

	@Override
	public ResultMessage update(VehicleVO vo) throws RemoteException {
		VehiclePO po = vehicleInfo.toVehiclePO(vo);
		System.out.println(po.getNumber());
		return vehicleData.update(po);
	}

	@Override
	public ArrayList<VehicleVO> show() throws RemoteException {
		ArrayList<VehicleVO> vos = new ArrayList<VehicleVO>();
		ArrayList<VehiclePO> pos = vehicleData.show();
		System.out.println("in");
		if (pos == null) {
			System.out.println("null");
			return null;
		}else {
			System.out.println("not null");
		}
		int size = pos.size();
		System.out.println(size);
		for (int i = 0; i < size; i++) {
			vos.add(vehicleInfo.toVehicleVO(pos.get(i)));
		}
		return vos;
	}

	@Override
	public ArrayList<VehicleVO> find(String id) throws RemoteException {
		VehiclePO po = vehicleData.findByID(id);
		VehicleVO vo = vehicleInfo.toVehicleVO(po);
		ArrayList<VehicleVO> vos = new ArrayList<VehicleVO>();
		vos.add(vo);
		return vos;
	}

}
