package org.cross.elsclient.util;

import java.rmi.RemoteException;

import org.cross.elsclient.blimpl.blUtility.ConstantInfo;
import org.cross.elsclient.blimpl.constantblimpl.ConstantBLImpl;
import org.cross.elsclient.blimpl.constantblimpl.ConstantInfoImpl;
import org.cross.elsclient.blservice.constantblservice.ConstantBLService;
import org.cross.elsclient.network.Datafactory;
import org.cross.elsclient.vo.ConstantVO;
import org.cross.elscommon.dataservice.datafactoryservice.DataFactoryService;

public class ConstantVal {
	public static ConstantVO CONSTANT;
	public static ConstantBLService constantbl;
	
	public static ConstantBLService getConstant(){
		DataFactoryService dataFactoryService = new Datafactory();
		ConstantInfo info = new ConstantInfoImpl();
		ConstantBLImpl cons =  null;
		try {
			cons = new ConstantBLImpl(dataFactoryService.getConstantData(), info);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cons;
	}
}
