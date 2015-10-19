/**
 * 账户管理业务逻辑接口
 * @author Polaris Chen
 * @date 2015/10/19
 */
package org.cross.elsclient.blservice.accountblservice;

import java.util.ArrayList;

import org.cross.elsclient.util.ResultMessage;
import org.cross.elsclient.vo.AccountVO;

public interface AccountBLService {

	/**
	 * 根据账户名称模糊查找账户
	 * 
	 * @param name
	 * @return
	 */
	public ArrayList<AccountVO> find(String name);

	/**
	 * 增加账户
	 * 
	 * @param vo
	 * @return
	 */
	public ResultMessage add(AccountVO vo);

	/**
	 * 删除账户
	 * 
	 * @param vo
	 * @return
	 */
	public ResultMessage delete(AccountVO vo);

	/**
	 * 更新账户
	 * 
	 * @param vo
	 * @return
	 */
	public ResultMessage update(AccountVO vo);

	/**
	 * 显示所有账户信息
	 * 
	 * @return
	 */
	public ArrayList<AccountVO> show();
}
