package org.cross.elsclient.blimpl.vehicleblimpl;

import java.util.ArrayList;

import org.cross.elsclient.blimpl.blUtility.VehicleInfo;
import org.cross.elsclient.blservice.vehicleblservice.VehicleBLService;
import org.cross.elsclient.blservice.vehicleblservice.VehicleBLService_Stub;
import org.cross.elsclient.vo.VehicleVO;
import org.cross.elscommon.dataservice.vehicledataservice.VehicleDataService_Stub;
import org.cross.elscommon.po.VehiclePO;
import org.cross.elscommon.util.PositionType;
import org.cross.elscommon.util.ResultMessage;

public class VehicleBLImpl implements VehicleBLService,VehicleInfo{

	public VehicleDataService_Stub vehicleData;
	
	public VehicleBLImpl(VehicleDataService_Stub vehicleData){
		this.vehicleData = vehicleData;
	}
	
	@Override
	public ResultMessage add(VehicleVO vo) {
		VehiclePO po = toVehiclePO(vo);
		return vehicleData.insert(po);
	}

	@Override
	public ResultMessage delete(VehicleVO vo) {
		VehiclePO po = toVehiclePO(vo);
		return vehicleData.delete(po);
	}

	@Override
	public ResultMessage update(VehicleVO vo) {
		VehiclePO po = toVehiclePO(vo);
		return vehicleData.update(po);
	}

	@Override
	public ArrayList<VehicleVO> show() {
		ArrayList<VehicleVO> vos = new ArrayList<VehicleVO>();
		ArrayList<VehiclePO> pos = vehicleData.show();
		int size = pos.size();
		for (int i = 0; i < size; i++) {
			vos.add(toVehicleVO(pos.get(i)));
		}
		return vos;
	}

	@Override
	public ArrayList<VehicleVO> find(String name) {
		ArrayList<VehicleVO> vos = new ArrayList<VehicleVO>();
		ArrayList<VehiclePO> pos = vehicleData.find(name);
		int size = pos.size();
		for (int i = 0; i < size; i++) {
			vos.add(toVehicleVO(pos.get(i)));
		}
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
