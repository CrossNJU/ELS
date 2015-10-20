package org.cross.elsclient.vo;

import org.cross.elsclient.util.UserType;

public class UserVO {
	public String id;
	public String name;
	public UserType type;
	
	public UserVO(String id,String name, UserType type) {
		this.id = id;
		this.name = name;
		this.type = type;
	}
}
