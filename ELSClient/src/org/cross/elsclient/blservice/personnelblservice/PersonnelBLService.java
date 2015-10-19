/**
 * 人员管理业务逻辑接口
 * @author Polaris Chen
 * @date 2015/10/19
 */
package org.cross.elsclient.blservice.personnelblservice;

import java.util.ArrayList;

import org.cross.elsclient.util.ResultMessage;
import org.cross.elsclient.vo.PersonnelVO;

public interface PersonnelBLService {

	/**
	 * 根据人员工号查找
	 * 
	 * @param id
	 * @return
	 */
	public ArrayList<PersonnelVO> findById(String id);

	/**
	 * 根据人员姓名查找
	 * 
	 * @param name
	 * @return
	 */
	public ArrayList<PersonnelVO> findByName(String name);

	/**
	 * 增加人员
	 * 
	 * @param vo
	 * @return
	 */
	public ResultMessage add(PersonnelVO vo);

	/**
	 * 删除人员
	 * 
	 * @param vo
	 * @return
	 */
	public ResultMessage delete(PersonnelVO vo);

	/**
	 * 更新人员信息
	 * 
	 * @param vo
	 * @return
	 */
	public ResultMessage update(PersonnelVO vo);

	/**
	 * 显示所有人员信息
	 * 
	 * @return
	 */
	public ArrayList<PersonnelVO> show();
}
