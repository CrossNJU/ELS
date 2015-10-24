package org.cross.elsclient.po;

import org.cross.elsclient.util.City;
import org.cross.elsclient.util.OrganizationType;

/**
 * 机构PO类
 * @author Moo
 * @date 2015年10月19日
 */
public class OrganizationPO 
{
	/**
	 * 所在城市
	 */
	private City city;
	
	/**
	 * 机构ID
	 */
	private String id;
	
	/**
	 * 机构类型
	 */
	private OrganizationType type;
	
	
	/**
	 * 构造方法
	 * @author:Moo
	 * @para:city, type, id
	 */
	public OrganizationPO(City city, OrganizationType type, String id) {
		this.city = city;
		this.id = id;
		this.type = type;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public OrganizationType getType() {
		return type;
	}

	public void setType(OrganizationType type) {
		this.type = type;
	}

}
