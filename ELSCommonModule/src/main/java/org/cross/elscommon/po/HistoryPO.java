/**
 * 历史轨迹PO类
 * @author raychen
 * @date 2015/10/22
 */
package org.cross.elscommon.po;

import org.cross.elscommon.util.City;
import org.cross.elscommon.util.OrganizationType;


public class HistoryPO{
	/**
	 * 到达某地/从某地发出的时间
	 */
	private String time;
	
	/**
	 * 地点,城市
	 */
	private City placeCity;
	
	/**
	 * 地点,机构
	 */
	private OrganizationType placeOrg;
	
	/**
	 * 是到达或发出
	 */
	private boolean isArrive;

	/**
	 * 构造方法
	 * @param time
	 * @param placeCity
	 * @param placeOrg
	 * @param isArrive
	 */
	public HistoryPO(String time, City placeCity, OrganizationType placeOrg, boolean isArrive) {
		super();
		this.time = time;
		this.placeCity = placeCity;
		this.placeOrg = placeOrg;
		this.isArrive = isArrive;
	}

	public String getTime() {
		return time;
	}
	

	public void setTime(String time) {
		this.time = time;
	}
	

	public City getPlaceCity() {
		return placeCity;
	}
	

	public void setPlaceCity(City placeCity) {
		this.placeCity = placeCity;
	}
	

	public OrganizationType getPlaceOrg() {
		return placeOrg;
	}
	

	public void setPlaceOrg(OrganizationType placeOrg) {
		this.placeOrg = placeOrg;
	}
	

	public boolean isArrive() {
		return isArrive;
	}
	

	public void setArrive(boolean isArrive) {
		this.isArrive = isArrive;
	}
	
}
