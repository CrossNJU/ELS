package org.cross.elsclient.vo;

import org.cross.elscommon.util.UserType;

public class UserVO {
	/**
	 * 用户id
	 * 格式为U00001
	 * 第一位数字代表用户类型：0快递员；1营业厅业务员；2中转中心业务员；3仓库管理员；4财务人员；5总经理；6系统管理员
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
	
	public String password;

	/**
	 * 构造方法
	 * @author:Moo
	 * @para:
	 */
	public UserVO(String id,String password, String name, UserType type) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.type = type;
	}
}
