/**
 * 历史轨迹PO类
 * @author raychen
 * @date 2015/10/22
 */
package org.cross.elscommon.po;

import java.io.Serializable;

import org.cross.elscommon.util.City;


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
	private City place;
	
	public HistoryPO(String time, City place){
		this.time = time;
		this.place = place;
	}
	
	public void setTime(String time){
		this.time = time;
	}
	
	public String getTime(){
		return this.time;
	}
	
	public void setPlace(City place){
		this.place = place;
	}
	
	public City getPlace(){
		return this.place;
	}
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
