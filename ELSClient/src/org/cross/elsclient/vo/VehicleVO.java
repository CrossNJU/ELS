package org.cross.elsclient.vo;

import java.awt.Image;

public class VehicleVO {
//•	车辆代号、发动机号、车辆号、底盘号、购买时间、服役时间、车辆图片
	String number;
	String engineNumber;
	String apparatusNumber;
	String buyTime;
	String lastTime;
	Image image;
	
	public VehicleVO(String number, String engineNumber, String apparatusNumber
			, String buyTime, String lastTime, Image image){
		this.number = number;
		this.engineNumber = engineNumber;
		this.apparatusNumber = apparatusNumber;
		this.buyTime = buyTime;
		this.lastTime = lastTime;
		this.image = image;
	}
	
}
