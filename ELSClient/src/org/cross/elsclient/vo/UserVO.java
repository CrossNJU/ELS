package org.cross.elsclient.vo;

import org.cross.elsclient.util.UserType;

public class UserVO {
	/**
	 * 用户id
	 */
	public String id;
	
	/**
	 * 用户姓名
	 */
	public String name;
	
	/**
	 * 用户权限
	 */
	public UserType type;

	/**
	 * 构造方法
	 * @author:Moo
	 * @para:
	 */
	public UserVO(String id,String name, UserType type) {
		this.id = id;
		this.name = name;
		this.type = type;
	}
}
