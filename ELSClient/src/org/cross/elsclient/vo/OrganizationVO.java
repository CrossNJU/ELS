package org.cross.elsclient.vo;

import org.cross.elsclient.util.OrganizationType;

/**
 * 机构VO类
 * @author Moo
 * @date 2015年10月19日
 */
public class OrganizationVO {
	/**
	 * 所在城市
	 */
	public String city;
	
	/**
	 * 机构ID
	 */
	public String id;
	
	/**
	 * 机构类型 
	 */
	public OrganizationType type;
	

	/**
	 * 构造方法
	 * @author:Moo
	 * @para:city, type, id
	 */
	public OrganizationVO(String city, OrganizationType type, String id) {
		this.city = city;
		this.id = id;
		this.type = type;
	}
}