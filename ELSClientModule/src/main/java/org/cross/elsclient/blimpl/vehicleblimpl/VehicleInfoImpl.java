package org.cross.elsclient.blimpl.vehicleblimpl;

import org.cross.elsclient.blimpl.blUtility.VehicleInfo;
import org.cross.elsclient.vo.VehicleVO;
import org.cross.elscommon.po.VehiclePO;

public class VehicleInfoImpl implements VehicleInfo{

	@Override
	public VehicleVO toVehicleVO(VehiclePO po) {
		if (po == null) {
			return null;
		}
		VehicleVO vo = new VehicleVO(po.getNumber(), po.getEngineNumber(), po.getApparatusNumber(), po.getBuyTime(), po.getLastTime(), po.getImage(), po.getType());
		vo.inUse = po.isInUse();
		return vo;
	}

	@Override
	public VehiclePO toVehiclePO(VehicleVO vo) {
		if (vo == null) {
			return null;
		}
		VehiclePO po = new VehiclePO(vo.number, vo.engineNumber, vo.apparatusNumber, vo.buyTime, vo.lastTime, vo.image, vo.type);
		po.setInUse(vo.inUse);
		return po;
	}

}
