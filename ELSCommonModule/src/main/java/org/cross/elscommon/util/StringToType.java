package org.cross.elscommon.util;

public class StringToType {
	
	public static GoodsState toGoodsState(String state){
		switch (state) {
		case "完好":
			return GoodsState.LIVE;
		case "部分损坏":
			return GoodsState.LITTLEDIE;
		case "遗失":
			return GoodsState.MISSING;
		case "损坏":
			return GoodsState.DIE;
		default:
			return null;
		}
	}
	
	public static City toCity(String city){
		switch (city) {
		case "beijing":
			return City.BEIJING;
		case "shanghai":
			return City.SHANGHAI;
		case "nanjing":
			return City.NANJING;
		case "guangzhou":
			return City.GUANGZHOU;
		default:
			return null;
		}
	}
	
	public static StockType toGoodsType(String goodsType){
		switch (goodsType) {
		case "common":
			return StockType.COMMON;
		case "fase":
			return StockType.Fast;
		case "economical":
			return StockType.ECONOMICAL;
		default:
			return null;
		}
	}
}
