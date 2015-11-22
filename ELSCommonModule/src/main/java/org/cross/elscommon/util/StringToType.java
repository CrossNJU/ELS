package org.cross.elscommon.util;

public class StringToType {
	
	public static GoodsState toGoodsState(String state){
		switch (state) {
		case "完好":
			return GoodsState.LIVE;
		case "部分损坏":
			return GoodsState.LITTLEDIE;
		case "损坏":
			return GoodsState.DIE;
		case "遗失":
			return GoodsState.MISSING;
		default:
			return null;
		}
	}
	
	public static City toCity(String city){
		switch (city) {
		case "北京":
			return City.BEIJING;
		case "上海":
			return City.SHANGHAI;
		case "南京":
			return City.NANJING;
		case "广州":
			return City.GUANGZHOU;
		default:
			return null;
		}
	}
	
	public static StockType toGoodsType(String goodsType){
		switch (goodsType) {
		case "标准快递仓库":
			return StockType.COMMON;
		case "特快仓库":
			return StockType.Fast;
		case "经济快递仓库":
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
	
	public static OrganizationType toOrg(String org){
		switch (org) {
		case "营业厅":
			return OrganizationType.BUSINESSHALL;
		case "中转中心":
			return OrganizationType.TRANSITCENTER;
		default:
			return null;
		}
	}
	
	public static StockOperationType toStockOperation(String stockop){
		switch (stockop) {
		case "出库":	
			return StockOperationType.STOCKOUT;
		case "入库":
			return StockOperationType.STOCKIN;
		default:
			return null;
		}
	}
}
