/**
 * 人员PO
 * @author Polaris Chen
 * @date 2015/10/19
 */
package org.cross.elsclient.po;

import java.io.Serializable;

import org.cross.elsclient.util.PositionType;

public class PersonnelPO implements Serializable {

	/**
	 * 序列化UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 人员姓名
	 */
	private String name;
	/**
	 * 人员工号
	 */
	private String id;
	/**
	 * 人员职位
	 */
	private PositionType position;

	/**
	 * 构造方法
	 * 
	 * @param name
	 * @param id
	 * @param position
	 */
	public PersonnelPO(String name, String id, PositionType position) {
		this.name = name;
		this.id = id;
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
