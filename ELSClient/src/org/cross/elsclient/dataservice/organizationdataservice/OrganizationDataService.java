/**
 * 机构数据接口
 * @author Moo
 * @date 2015年10月20日
 */
package org.cross.elsclient.dataservice.organizationdataservice;


import java.util.ArrayList;

import org.cross.elsclient.po.OrganizationPO;
import org.cross.elsclient.util.City;
import org.cross.elsclient.util.OrganizationType;

public interface OrganizationDataService {
	/**
	 * 增加机构
	 * @para vo
	 * @return ResultMessage
	 */
	public void insert(OrganizationPO po);
	
	/**
	 * 删除机构
	 * @para vo
	 * @return ResultMessage
	 */
	public void delete(OrganizationPO po);

	/**
	 * 修改机构
	 * @para vo
	 * @return ResultMessage
	 */
	public void update(OrganizationPO po);

	/**
	 * 根据所在城市查找机构
	 * @para city
	 * @return ArrayList<OrganizationVO>
	 */
	public ArrayList<OrganizationPO> findByCity(City city);
	
	/**
	 * 根据机构类型查找机构
	 * @para type
	 * @return ArrayList<OrganizationVO>
	 */
	public ArrayList<OrganizationPO> findByType(OrganizationType type);
	
	/**
	 * 根据ID查找机构
	 * @para id
	 * @return ArrayList<OrganizationVO>
	 */
	public ArrayList<OrganizationPO> findById(String id);

	/**
	 * 显示机构列表
	 * @para 
	 * @return ArrayList<OrganizationVO>
	 */
	public ArrayList<OrganizationPO> show();

}
