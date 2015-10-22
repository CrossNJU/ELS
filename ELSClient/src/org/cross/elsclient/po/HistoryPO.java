/**
 * 历史轨迹PO类
 * @author raychen
 * @date 2015/10/22
 */
package org.cross.elsclient.po;

public class HistoryPO {
	/**
	 * 到达某地时间
	 */
	private String time;
	
	/**
	 * 地点
	 */
	private String place;
	
	public HistoryPO(String time, String place){
		this.time = time;
		this.place = place;
	}
	
	public void setTime(String time){
		this.time = time;
	}
	
	public String getTime(){
		return this.time;
	}
	
	public void setPlace(String place){
		this.place = place;
	}
	
	public String getPlace(){
		return this.place;
	}
}
