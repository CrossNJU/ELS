/**
 * 历史轨迹PO类
 * @author raychen
 * @date 2015/10/22
 */
package org.cross.elsclient.po;

import java.io.Serializable;

import org.cross.elsclient.vo.HistoryVO;

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
	
	public HistoryVO toVO(){
		HistoryVO vo = new HistoryVO(this.time, this.place);
		return vo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
