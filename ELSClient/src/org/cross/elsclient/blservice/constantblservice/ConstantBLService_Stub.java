package org.cross.elsclient.blservice.constantblservice;

import org.cross.elsclient.util.City;
import org.cross.elsclient.util.ResultMessage;

public class ConstantBLService_Stub implements ConstantBLService {

	@Override
	public ResultMessage updatePrice(double newValue) {

		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage updateDistance(City city1, City city2,
			double newValue) {
		return ResultMessage.SUCCESS;
	}

}
