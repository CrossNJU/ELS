package org.cross.elsclient.po;

import org.cross.elsclient.util.UserType;

public class UserPO {
	/**
	 * 用户id
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
	
	/**
	 * 构造方法
	 * @author:Moo
	 * @para:
	 */
	public UserPO(String id,String name, UserType type) {
		this.id = id;
		this.name = name;
		this.type = type;
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
