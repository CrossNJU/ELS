/**
 * 车辆VO类
 * @author raychen
 * @data 2015/10/21
 */
package org.cross.elsclient.vo;

import java.awt.Image;

import org.cross.elscommon.util.VehicleType;

public class VehicleVO {
	
	/**
	 * 车辆代号
	 */
	public String number;
	
	/**
	 * 发动机号
	 */
	public String engineNumber;
	
	/**
	 * 底盘号
	 */
	public String apparatusNumber;
	
	/**
	 * 购买时间
	 */
	public String buyTime;
	
	/**
	 * 服役时间
	 */
	public String lastTime;
	
	/**
	 * 车辆图片
	 */
	public Image image;
	
	/**
	 * 车辆类型，包括汽车、火车、飞机
	 */
	public VehicleType type;
	
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
	public VehicleVO(String number, String engineNumber, String apparatusNumber
			, String buyTime, String lastTime, Image image, VehicleType type){
		this.number = number;
		this.engineNumber = engineNumber;
		this.apparatusNumber = apparatusNumber;
		this.buyTime = buyTime;
		this.lastTime = lastTime;
		this.image = image;
		this.type = type;
	}
	
	/**
	 * 构造方法
	 * @param number
	 */
	public VehicleVO(String number){
		this.number = number;
	}
	
}
