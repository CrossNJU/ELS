package org.cross.elsclient.util;

public enum StockType {
	
	Fast, //特快
	COMMON,//标准快递
	ECONOMICAL;//经济快递
	
	public String toString() {
		switch (this) {
		case Fast:
			return "特快";
		case COMMON:
			return "标准快递";
		case ECONOMICAL:
			return "经济快递";
		default:
			return null;
		}
	}

}
