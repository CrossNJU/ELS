/**
 * 用户数据接口
 * @author Moo
 * @date 2015年10月19日
 */
package org.cross.elscommon.dataservice.userdataservice;

import java.util.ArrayList;

import org.cross.elscommon.po.UserPO;
import org.cross.elscommon.util.UserType;


public interface UserDataService 
{
	/**
	 * 增加用户
	 * @para vo
	 * @return ResultMessage
	 */
	public void insert(UserPO po);
	
	/**
	 * 删除用户
	 * @para vo
	 * @return ResultMessage
	 */
	public void delete(UserPO po);
	
	/**
	 * 修改用户
	 * @para vo
	 * @return ResultMessage
	 */
	public void update(UserPO po);
	
	/**
	 * 根据ID模糊查找
	 * @para name
	 * @return ArrayList<UserVO>
	 */
	public ArrayList<UserPO> findById(String id);
	
	/**
	 * 根据用户类型模糊查找
	 * @para type
	 * @return ArrayList<UserVO>
	 */
	public ArrayList<UserPO> findByType(UserType type);
	
	/**
	 * 根据名字模糊查找
	 * @para name
	 * @return ArrayList<UserVO>
	 */
	public ArrayList<UserPO> findByName(String name);
	
	/**
	 * 显示所有用户列表
	 * @para 
	 * @return ArrayList<UserVO>
	 */
	public ArrayList<UserPO> show();

}
