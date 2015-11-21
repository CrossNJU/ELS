package org.cross.elscommon.po;

import java.io.Serializable;

import org.cross.elscommon.util.City;
import org.cross.elscommon.util.OrganizationType;

/**
 * 机构PO类
 * @author Moo
 * @date 2015年10月19日
 */
public class OrganizationPO implements Serializable{
	/**
	 * 序列化UID
	 */
	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

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