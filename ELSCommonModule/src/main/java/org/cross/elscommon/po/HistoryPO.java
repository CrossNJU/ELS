/**
 * 历史轨迹PO类
 * @author raychen
 * @date 2015/10/22
 */
package org.cross.elscommon.po;

import java.io.Serializable;

import org.cross.elscommon.util.City;
import org.cross.elscommon.util.OrganizationType;


public class HistoryPO implements Serializable{
	
	/**
	 * 序列化UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 到达某地时间
	 */
	private String time;
	
	/**
	 * 地点
	 */
	private City city;
	
	/**
	 * 机构
	 */
	private OrganizationType organization;
	
	/**
	 * 是到达或发出
	 */
	private boolean isArrive;
	
	public HistoryPO(String time, City city,OrganizationType organization,boolean isArrive){
		this.time = time;
		this.city = city;
		this.organization = organization;
		this.isArrive = isArrive;
	}
	
	public OrganizationType getOrganization() {
		return organization;
	}

	public void setOrganization(OrganizationType organization) {
		this.organization = organization;
	}

	public boolean isArrive() {
		return isArrive;
	}

	public void setArrive(boolean isArrive) {
		this.isArrive = isArrive;
	}

	public void setTime(String time){
		this.time = time;
	}
	
	public String getTime(){
		return this.time;
	}
	
	public void setCity(City city){
		this.city = city;
	}
	
	public City getCity(){
		return this.city;
	}
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
