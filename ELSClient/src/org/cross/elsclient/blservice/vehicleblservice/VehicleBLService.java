/**
 * 车辆管理服务接口
 * @author raychen
 * @date 2015/10/19
 */
package org.cross.elsclient.blservice.vehicleblservice;

import java.util.ArrayList;

import org.cross.elsclient.util.ResultMessage;
import org.cross.elsclient.vo.VehicleVO;

public interface VehicleBLService {
	
	/**
	 * 增加车辆信息
	 * @param vo
	 * @return
	 */
	public ResultMessage add(VehicleVO vo);
	
	/**
	 * 删除车辆信息
	 * @param vo
	 * @return
	 */
	public ResultMessage delete(VehicleVO vo);
	
	/**
	 * 更新车辆信息
	 * @param vo
	 * @return
	 */
	public ResultMessage update(VehicleVO vo);
	
	/**
	 * 显示车辆信息
	 * @return
	 */
	public ArrayList<VehicleVO> show();
	
	/**
	 * 根据名称模糊查找
	 * @param name
	 * @return
	 */
	public ArrayList<VehicleVO> find(String name);
}
