/**
 * 用户逻辑接口
 * @author Moo
 * @date 2015年10月19日
 */
package org.cross.elsclient.blservice.userblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.UserType;
import org.cross.elsclient.vo.UserVO;


public interface UserBLService {

	/**
	 * 增加用户
	 * @para vo
	 * @return ResultMessage
	 */
	public ResultMessage add(UserVO vo)throws RemoteException;
	
	/**
	 * 删除用户
	 * @para vo
	 * @return ResultMessage
	 */
	public ResultMessage delete(UserVO vo)throws RemoteException;
	
	/**
	 * 修改用户
	 * @para vo
	 * @return ResultMessage
	 */
	public ResultMessage update(UserVO vo)throws RemoteException;
	
	/**
	 * 根据名字模糊查找
	 * @para name
	 * @return ArrayList<UserVO>
	 */
	public ArrayList<UserVO> findByName(String name)throws RemoteException;
	
	/**
	 * 根据用户类型模糊查找
	 * @para type
	 * @return ArrayList<UserVO>
	 */
	public ArrayList<UserVO> findByType(UserType type)throws RemoteException;
	
	/**
	 * 根据id模糊查找
	 * @para id
	 * @return ArrayList<UserVO>
	 */
	public ArrayList<UserVO> findById(String id)throws RemoteException;
	
	/**
	 * 显示所有用户列表
	 * @para 
	 * @return ArrayList<UserVO>
	 */
	public ArrayList<UserVO> show()throws RemoteException;

	/**
	 * 登录
	 * @para id
	 * @para password
	 * @return ResultMessage
	 */
	public UserType login(String id, String password)throws RemoteException;
	
	/**
	 * 注销
	 * @para 
	 * @return ResultMessage
	 */
	public ResultMessage logout()throws RemoteException;

}
