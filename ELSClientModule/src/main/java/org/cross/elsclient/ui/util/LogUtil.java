package org.cross.elsclient.ui.util;

import java.rmi.RemoteException;
import java.util.concurrent.TimeUnit;

import org.cross.elsclient.blimpl.blfactoryimpl.BLFactoryImpl;
import org.cross.elsclient.blservice.blfactoryservice.BLFactoryService;
import org.cross.elsclient.blservice.logblservice.LogBLService;
import org.cross.elsclient.util.ConstantVal;
import org.cross.elsclient.util.TimeUtil;
import org.cross.elsclient.vo.LogVO;
import org.cross.elscommon.util.NumberType;
import org.junit.experimental.theories.Theories;

public class LogUtil {
	public static LogBLService LOGBL;
	
	public static void initLogBl(){
		try {
			BLFactoryService blFactory = new BLFactoryImpl();
			LOGBL = blFactory.logBLService();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void addLog(String operation){
		try {
			LOGBL.add(new LogVO(ConstantVal.numberbl.getPostNumber(NumberType.LOG), TimeUtil.getCurrentTime(), UIConstant.CURRENT_USER.number, operation));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
