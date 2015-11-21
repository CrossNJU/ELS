/**
 * 历史轨迹VO类
 * @author raychen
 * @date 2015/10/23
 */
package org.cross.elsclient.vo;

import org.cross.elscommon.util.City;
import org.cross.elscommon.util.OrganizationType;

public class HistoryVO {
	/**
	 * 到达某地时间
	 */
	public String time;
	
	/**
	 * 地点
	 */
	public City city;
	
	/**
	 * 机构
	 */
	public OrganizationType organization;
	
	/**
	 * 是到达或发出
	 */
	public boolean isArrive;
	
	public HistoryVO(String time, City city,OrganizationType organization,boolean isArrive){
		this.time = time;
		this.city = city;
		this.organization = organization;
		this.isArrive = isArrive;
	}
	
//	public void setTime(String time){
//		this.time = time;
//	}
//	
//	public String getTime(){
//		return this.time;
//	}
//	
//	public void setPlace(City place){
//		this.place = place;
//	}
//	
//	public City getPlace(){
//		return this.place;
//	}
}

