package org.cross.elsclient.blservice.constantblservice;

import org.cross.elsclient.util.City;
import org.cross.elsclient.util.ResultMessage;

public interface ConstantBLService {
	
	/**
	 * 更新价格常量
	 * @para newValue
	 * @return ResultMessage
	 */
	public ResultMessage updatePrice(double newValue);
	
	/**
	 * 更新城市距离
	 * @para city1,city2,newValue
	 * @return ResultMessage
	 */
	public ResultMessage updateDistance(City city1, City city2, double newValue);
	
}
