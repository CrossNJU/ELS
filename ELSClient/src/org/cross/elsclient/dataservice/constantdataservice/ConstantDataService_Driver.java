package org.cross.elsclient.dataservice.constantdataservice;

import org.cross.elsclient.po.ConstantPO;

public class ConstantDataService_Driver {
	public void drive(ConstantDataService constantDataService){
		System.out.println("业务常量：");
		constantDataService.show();
		constantDataService.update(new ConstantPO());
	}
}
