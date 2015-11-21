package org.cross.elsclient.test;

import java.rmi.RemoteException;

import org.cross.elsclient.blimpl.blUtility.VehicleInfo;
import org.cross.elsclient.blimpl.vehicleblimpl.VehicleBLImpl;
import org.cross.elsclient.network.Datafactory;
import org.cross.elsclient.vo.VehicleVO;
import org.cross.elscommon.dataservice.datafactoryservice.DataFactoryService;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.VehicleType;

public class VehicleBLTest {
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws RemoteException{
		DataFactoryService dataFactory = new Datafactory();
		@SuppressWarnings("unused")
		VehicleInfo vehicleInfo = new VehicleBLImpl(dataFactory.getVehicleData());
		VehicleBLImpl vehicleBLImpl = new VehicleBLImpl(dataFactory.getVehicleData());
		
		System.out.println("=======测试增加车辆信息（add）=======");
		VehicleVO vehicleVO = new VehicleVO("000000004", "000022", "1234", "2015-10-10", "2015-11-11", null, VehicleType.CAR);
		ResultMessage resultMessage1 = vehicleBLImpl.add(vehicleVO);
		if (resultMessage1 == resultMessage1.SUCCESS) {
			System.out.println("添加成功");
		}else {
			System.out.println("添加失败");
		}
		System.out.println("=======测试删除车辆信息（delete）=======");
		VehicleVO vehicleVO2 = new VehicleVO("000000001", "000022", "1234", "2015-10-10", "2015-11-11", null, VehicleType.CAR);
		ResultMessage resultMessage2 = vehicleBLImpl.delete(vehicleVO2);
		if (resultMessage2 == ResultMessage.SUCCESS) {
			System.out.println("删除成功");
		}else {
			System.out.println("删除失败");
		}
		System.out.println("=======测试更新车辆信息（update）=======");
		VehicleVO vehicleVO3 = new VehicleVO("000000001", "000022", "1234", "2015-10-10", "2015-11-21", null, VehicleType.PLANE);
		ResultMessage resultMessage3 = vehicleBLImpl.update(vehicleVO3);
		if (resultMessage3 == ResultMessage.SUCCESS) {
			System.out.println("更新成功");
		}else {
			System.out.println("更新失败");
		}
		System.out.println("=======测试显示车辆信息（show）=======");
		System.out.println("=======测试查找车辆信息（find）=======");
	}

}
