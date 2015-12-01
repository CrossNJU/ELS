package org.cross.elsclient.ui.util;

import org.cross.elscommon.util.City;
import org.cross.elscommon.util.ReceiptType;

public class ConstantValue {
	static int transNum = 0;
	static int arriNum = 0;
	public static String getReceiptNum(ReceiptType type){
		switch (type) {
		case ARRIVE:
			arriNum ++;
			return "R010000"+String.valueOf(arriNum);

		default:
			return "0000000";
		}
	}
	public static String getReceiptTransNum(){
		transNum ++;
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
