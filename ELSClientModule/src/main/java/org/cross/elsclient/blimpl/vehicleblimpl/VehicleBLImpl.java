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

public class VehicleBLImpl implements VehicleBLService,VehicleInfo{

	public VehicleDataService vehicleData;
	
	public VehicleBLImpl(VehicleDataService vehicleData){
		this.vehicleData = vehicleData;
	}
	
	@Override
	public ResultMessage add(VehicleVO vo) throws RemoteException {
		VehiclePO po = toVehiclePO(vo);
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
		VehiclePO po = toVehiclePO(vo);
		System.out.println(po.getNumber());
		return vehicleData.update(po);
	}

	@Override
	public ArrayList<VehicleVO> show() throws RemoteException {
		ArrayList<VehicleVO> vos = new ArrayList<VehicleVO>();
		ArrayList<VehiclePO> pos = vehicleData.show();
		int size = pos.size();
		for (int i = 0; i < size; i++) {
			vos.add(toVehicleVO(pos.get(i)));
		}
		return vos;
	}

	@Override
	public ArrayList<VehicleVO> find(String id) throws RemoteException {
		VehiclePO po = vehicleData.findByID(id);
		VehicleVO vo = toVehicleVO(po);
		ArrayList<VehicleVO> vos = new ArrayList<VehicleVO>();
		vos.add(vo);
		return vos;
	}

	@Override
	public VehicleVO toVehicleVO(VehiclePO po) {
		VehicleVO vo = new VehicleVO(po.getNumber(), po.getEngineNumber(), po.getApparatusNumber(), po.getBuyTime(), po.getLastTime(), po.getImage(), po.getType());
		vo.inUse = po.isInUse();
		return vo;
	}

	@Override
	public VehiclePO toVehiclePO(VehicleVO vo) {
		VehiclePO po = new VehiclePO(vo.number, vo.engineNumber, vo.apparatusNumber, vo.buyTime, vo.lastTime, vo.image, vo.type);
		po.setInUse(vo.inUse);
		return po;
	}

}
