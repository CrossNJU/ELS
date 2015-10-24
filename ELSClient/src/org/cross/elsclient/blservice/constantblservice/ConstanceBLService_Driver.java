package org.cross.elsclient.blservice.constantblservice;

import org.cross.elsclient.util.City;
import org.cross.elsclient.util.ResultMessage;
import org.omg.PortableInterceptor.SUCCESSFUL;

public class ConstanceBLService_Driver {

	public void drive(ConstantBLService constantBLService){
		System.out.println("制定业务常量返回信息：");
		
		System.out.println("更改价格常量：");
		if(constantBLService.updatePrice(2.5) == ResultMessage.SUCCESS){
			System.out.println("更新价格常量成功");
		}else{
			System.out.println("更新价格常量失败");
		}
		
		System.out.println("更新距离（北京，上海）常量返回信息：");
		if(constantBLService.updateDistance(City.BEIJING, City.SHANGHAI, 800) == ResultMessage.SUCCESS){
			System.out.println("更新距离常量成功");
		}else{
			System.out.println("更新距离常量失败");
		}
		
		
	}
}
