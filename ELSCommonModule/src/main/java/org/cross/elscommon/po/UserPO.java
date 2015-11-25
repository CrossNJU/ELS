package org.cross.elscommon.po;

import java.io.Serializable;

import org.cross.elscommon.util.UserType;

public class UserPO implements Serializable{
	/**
	 * 序列化UID
	 */
	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * 用户id
	 * 格式为U00001
	 * 第一位数字代表用户类型：0快递员；1营业厅业务员；2中转中心业务员；3仓库管理员；4财务人员；5总经理；6系统管理员
	 */
	private String id;
	
	/**
	 * 用户姓名
	 */
	private String name;
	
	/**
	 * 用户类型
	 */
	private UserType type;
	
	private String password;
	
	/**
	 * 构造方法
	 * @author:Moo
	 * @para:
	 */
	public UserPO(String id,String password, String name, UserType type) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.type = type;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}
}
