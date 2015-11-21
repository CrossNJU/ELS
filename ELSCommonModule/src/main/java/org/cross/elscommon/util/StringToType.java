package org.cross.elscommon.util;

public class StringToType {
	
	public static GoodsState toGoodsState(String state){
		switch (state) {
		case "完好":
			return GoodsState.LIVE;
		case "bad":
			return GoodsState.LITTLEDIE;
		case "lost":
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
	
	public static VehicleType toVehicleType(String vehicle){
		switch (vehicle) {
		case "汽车":
			return VehicleType.CAR;
		case "飞机":
			return VehicleType.PLANE;
		case "火车":
			return VehicleType.TRAIN;
		default:
			return null;
		}
	}
}
