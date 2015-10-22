package org.cross.elsclient.util;

public enum OrganizationType {
	BUSINESSHALL, // 营业厅
	TRANSITCENTER, // 中转中心
	STOCK; // 仓库


	public String toString() {
		switch (this) {
		case BUSINESSHALL:
			return "营业厅";
		case TRANSITCENTER:
			return "中转中心";
		default:
			return null;
		}
	} 
}
