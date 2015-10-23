/**
 * 车辆PO类
 * @author raychen
 * @data 2015/10/21
 */
package org.cross.elsclient.po;

import java.awt.Image;
import java.io.Serializable;

import org.cross.elsclient.util.VehicleType;

public class VehiclePO implements Serializable{
	
	/**
	 * 序列化UID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 车辆代号
	 */
	private String number;
	
	/**
	 * 发动机号
	 */
	private String engineNumber;
	
	/**
	 * 底盘号
	 */
	private String apparatusNumber;
	
	/**
	 * 购买时间
	 */
	private String buyTime;
	
	/**
	 * 服役时间
	 */
	private String lastTime;
	
	/**
	 * 车辆图片
	 */
	private Image image;
	
	/**
	 * 车辆类型，包括汽车、飞机、火车
	 */
	private VehicleType type;
	
	/**
	 * 构造方法
	 * @param number
	 * @param engineNumber
	 * @param apparatusNumber
	 * @param buyTime
	 * @param lastTime
	 * @param image
	 * @param type
	 */
	public VehiclePO(String number, String engineNumber, String apparatusNumber
			, String buyTime, String lastTime, Image image,VehicleType type){
		this.number = number;
		this.engineNumber = engineNumber;
		this.apparatusNumber = apparatusNumber;
		this.buyTime = buyTime;
		this.lastTime = lastTime;
		this.image = image;
		this.type = type;
	}
	
	public VehiclePO(String number){
		this.number = number;
	}
	
	public void setNumber(String number){
		this.number = number;
	}
	
	public String getNumber(){
		return this.number;
	}
	
	public void setEngineNumber(String engineNumber){
		this.engineNumber = engineNumber;
	}
	
	public String getEngineNumber(){
		return this.engineNumber;
	}

	public void setApparatusNumber(String apparatusNumber){
		this.apparatusNumber = apparatusNumber;
	}
	
	public String getApparatusNumber(){
		return this.apparatusNumber;
	}

	public void setBuyTime(String buyTime){
		this.buyTime = buyTime;
	}
	
	public String getBuyTime(){
		return this.buyTime;
	}

	public void setLastTime(String lastTime){
		this.lastTime = lastTime;
	}
	
	public String getLastTime(){
		return this.lastTime;
	}

	public void setImage(Image image){
		this.image = image;
	}
	
	public Image getImage(){
		return this.image;
	}
	
	public void setType(VehicleType type){
		this.type = type;
	}
	
	public VehicleType getType(){
		return this.type;
	}
	
	public static long getSerialversionuid(){
		return serialVersionUID;
	}
}
