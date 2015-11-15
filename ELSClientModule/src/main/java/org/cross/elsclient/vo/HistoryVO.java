/**
 * 历史轨迹VO类
 * @author raychen
 * @date 2015/10/23
 */
package org.cross.elsclient.vo;

import org.cross.elscommon.util.City;

public class HistoryVO {
	/**
	 * 到达某地时间
	 */
	public String time;
	
	/**
	 * 地点
	 */
	public City place;
	
	public HistoryVO(String time, City place){
		this.time = time;
		this.place = place;
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

