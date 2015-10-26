/**
 * 人员PO
 * @author Polaris Chen
 * @date 2015/10/19
 */
package org.cross.elscommon.po;

import java.io.Serializable;

import org.cross.elscommon.util.PositionType;

public class PersonnelPO implements Serializable {

	/**
	 * 序列化UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 人员工号
	 */
	private String id;
	/**
	 * 人员姓名
	 */
	private String name;
	/**
	 * 人员职位
	 */
	private PositionType position;

	/**
	 * 构造方法
	 * 
	 * @param id
	 * @param name
	 * @param position
	 */
	public PersonnelPO(String id, String name, PositionType position) {
		this.id = id;
		this.name = name;
		this.position = position;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PositionType getPosition() {
		return position;
	}

	public void setPosition(PositionType position) {
		this.position = position;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
