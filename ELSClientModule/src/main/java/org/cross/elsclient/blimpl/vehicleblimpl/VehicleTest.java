package org.cross.elsclient.blimpl.vehicleblimpl;

import static org.junit.Assert.*;

import org.cross.elsclient.vo.VehicleVO;
import org.cross.elscommon.util.ResultMessage;
import org.junit.Test;

public class VehicleTest {

	@Test
	public void testVehicle() {
		Vehicle vehicle = new Vehicle();
		
		assertEquals(ResultMessage.SUCCESS, vehicle.add(
				new VehicleVO("E00001")));
		
		assertEquals(ResultMessage.SUCCESS, vehicle.createLog("add a vehicle"));
	}

}
