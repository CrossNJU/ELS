package org.cross.elsclient.util;

public enum UserType {
	COURIER, // 快递员
	BUSINESSHALLCLERK, // 营业厅业务员
	TRANSITCENTERCLERK, // 中转中心业务员
	STOCKKEEPER, // 仓库管理人员
	COUNTER, // 财务人员
	MANAGER, // 总经理
	ADMINISTRATOR; // 系统管理员

	public String toString() {
		switch (this) {
		case COURIER:
			return "快递员";
		case BUSINESSHALLCLERK:
			return "营业厅业务员";
		case TRANSITCENTERCLERK:
			return "中转中心业务员";
		case STOCKKEEPER:
			return "仓库管理人员";
		case COUNTER:
			return "财务人员";
		case MANAGER:
			return "总经理";
		case ADMINISTRATOR:
			return "系统管理员";
		default:
			return null;
		}
	}
}
