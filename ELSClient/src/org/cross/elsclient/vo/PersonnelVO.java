/**
 * 人员VO
 * @author Polaris Chen
 * @date 2015/10/19
 */
package org.cross.elsclient.vo;

import org.cross.elsclient.util.PositionType;

public class PersonnelVO {

	/**
	 * 人员工号
	 */
	public String id;
	/**
	 * 人员姓名
	 */
	public String name;
	/**
	 * 人员职位
	 */
	public PositionType position;

	/**
	 * 构造方法
	 * 
	 * @param id
	 * @param name
	 * @param position
	 */
	public PersonnelVO(String id, String name, PositionType position) {
		this.id = id;
		this.name = name;
		this.position = position;
	}
}
