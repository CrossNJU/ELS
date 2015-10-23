/**
 * 期初建账业务逻辑接口
 * @author Polaris Chen
 * @date 2015/10/23
 */
package org.cross.elsclient.blservice.initialblservice;

import java.util.ArrayList;

import org.cross.elsclient.util.ResultMessage;
import org.cross.elsclient.vo.OrganizationVO;
import org.cross.elsclient.vo.PersonnelVO;
import org.cross.elsclient.vo.VehicleVO;
import org.cross.elsclient.vo.StockVO;
import org.cross.elsclient.vo.AccountVO;
import org.cross.elsclient.vo.InitialVO;

public interface InitialBLService {

	/**
	 * 根据编号查找账本
	 * 
	 * @param id
	 * @return 账本列表
	 */
	public ArrayList<InitialVO> findById(String id);

	/**
	 * 返回所有账本
	 * 
	 * @return 账本列表
	 */
	public ArrayList<InitialVO> show();

	/**
	 * 初始化建账
	 * 
	 * @param vo
	 * @return 建账成功与否消息
	 */
	public ResultMessage addInitial(InitialVO vo);

	/**
	 * 返回对应账本机构信息
	 * 
	 * @param vo
	 * @return 机构列表
	 */
	public ArrayList<OrganizationVO> showOrganization(InitialVO vo);

	/**
	 * 返回对应账本人员信息
	 * 
	 * @param vo
	 * @return 人员列表
	 */
	public ArrayList<PersonnelVO> showPersonnel(InitialVO vo);

	/**
	 * 返回对应账本车辆信息
	 * 
	 * @param vo
	 * @return 车辆列表
	 */
	public ArrayList<VehicleVO> showVehicle(InitialVO vo);

	/**
	 * 返回对应账本库存信息
	 * 
	 * @param vo
	 * @return 库存列表
	 */
	public ArrayList<StockVO> showStock(InitialVO vo);

	/**
	 * 返回对应账本账户信息
	 * 
	 * @param vo
	 * @return 账户列表
	 */
	public ArrayList<AccountVO> showAccount(InitialVO vo);
}
