package org.cross.elsclient.blimpl.blUtility;

import org.cross.elsclient.vo.VehicleVO;
import org.cross.elscommon.po.VehiclePO;

public interface VehicleInfo {
	
	public VehicleVO toVehicleVO(VehiclePO po);
	
	public VehiclePO toVehiclePO(VehicleVO vo);
	
}
