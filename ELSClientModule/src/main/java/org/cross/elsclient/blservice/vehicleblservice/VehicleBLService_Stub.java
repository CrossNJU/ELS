/**
 * 车辆服务桩程序
 * @author raychen
 * @date 2015/10/20
 */
package org.cross.elsclient.blservice.vehicleblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elscommon.util.ResultMessage;
import org.cross.elsclient.vo.VehicleVO;

public class VehicleBLService_Stub implements VehicleBLService{

	@Override
	public ResultMessage add(VehicleVO vo) {
		// TODO Auto-generated method stub
		if (vo.number == "00001") {
			return ResultMessage.SUCCESS;
		}else {
			return ResultMessage.FAILED;
		}
	}

	@Override
	public ResultMessage delete(String st) {
		// TODO Auto-generated method stub
		if (st == "00001") {
			return ResultMessage.SUCCESS;
		}else {
			return ResultMessage.FAILED;
		}
	}

	@Override
	public ResultMessage update(VehicleVO vo) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<VehicleVO> show() {
		// TODO Auto-generated method stub
		ArrayList<VehicleVO> list = new ArrayList<VehicleVO>();
		list.add(new VehicleVO("00001"));
		list.add(new VehicleVO("00002"));
		return list;
	}

	@Override
	public ArrayList<VehicleVO> find(String name) {
		// TODO Auto-generated method stub
		ArrayList<VehicleVO> list = new ArrayList<VehicleVO>();
		list.add(new VehicleVO("00001"));
		return list;
	}

	@Override
	public ArrayList<VehicleVO> findByOrg(String orgNum) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
