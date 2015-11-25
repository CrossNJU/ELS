/**
 * 机构逻辑接口
 * @author Moo
 * @date 2015年10月19日
 */

package org.cross.elsclient.blservice.organizationblservice;


import java.util.ArrayList;

import org.cross.elscommon.util.City;
import org.cross.elscommon.util.OrganizationType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elsclient.vo.OrganizationVO;



public interface OrganizationBLService {
	/**
	 * 增加机构
	 * @para vo
	 * @return ResultMessage
	 */
	public ResultMessage add(OrganizationVO vo);
	
	/**
	 * 删除机构
	 * @para vo
	 * @return ResultMessage
	 */
	public ResultMessage delete(String number);
	
	/**
	 * 修改机构
	 * @para vo
	 * @return ResultMessage
	 */
	public ResultMessage update(OrganizationVO vo);
	
	/**
	 * 显示机构列表
	 * @para 
	 * @return ArrayList<OrganizationVO>
	 */
	public ArrayList<OrganizationVO> show();
	
	/**
	 * 根据所在城市查找机构
	 * @para city
	 * @return ArrayList<OrganizationVO>
	 */
	public ArrayList<OrganizationVO> findByCity(City city);
	
	/**
	 * 根据机构类型查找机构
	 * @para type
	 * @return ArrayList<OrganizationVO>
	 */
	public ArrayList<OrganizationVO> findByType(OrganizationType type);
	
	/**
	 * 根据ID查找机构
	 * @para id
	 * @return ArrayList<OrganizationVO>
	 */
	public ArrayList<OrganizationVO> findById(String id);
	
	/**
	 * 显示两个机构间的距离
	 * @para vo1 vo2
	 * @return int
	 */
	public int showDistance(OrganizationVO vo1, OrganizationVO vo2);
	
}
