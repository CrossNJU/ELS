package org.cross.elsclient.ui.util;

import org.cross.elscommon.util.City;

public class ConstantValue {
	public static String getReceiptTransNum(){
		return "R01000001";
	}
	public static String getTime(){
		return "2015-11-26 11:11:11";
	}
	public static String getReceiptTransLocalNum(){
		return "O025001";
	}
	public static String[] getUnusedVehicle(){
		String[] s = {"V023001","V023002","V023003"};
		return s;
	}
	public static String[] getUnusedDriver(){
		String[] s = {"灿海","沐恩","睿"};
		return s;
	}
	public static String[] getUnusedObserver(){
		String[] s = {"灿海","沐恩","睿"};
		return s;
	}
	public static double getTrans(City c1, City c2){
		return 20.2;
	}
}
