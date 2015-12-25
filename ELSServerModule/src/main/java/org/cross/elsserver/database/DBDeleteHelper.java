package org.cross.elsserver.database;

import org.cross.elscommon.po.LogPO;
import org.cross.elscommon.util.ReceiptType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elsserver.dataimpl.receiptdataimpl.Typetotable;

public class DBDeleteHelper {
	
	public static MySQL mysql = MySQL.getMysql();

	public static ResultMessage delete_account(String id) {
		String sql = "delete from `account` where `accountNum`='" + id + "'";
		if (!mysql.execute(sql))
			return ResultMessage.FAILED;
//		LogPO log = new LogPO(, time, operator, operation)
//		DBInsertHelper.insert_log(log);
//		LogPO newlog = new LogPO(number, time, operator, operation)
		return ResultMessage.SUCCESS;
	}

//	public static ResultMessage delete_constant() {
//
//	}

	public static ResultMessage delete_driver(String number) {
		String sql = "delete from `driver` where `number`='"+number+"'";
		if (!mysql.execute(sql)) {
			return ResultMessage.FAILED;
		}
		return ResultMessage.SUCCESS;
	}

//	public static ResultMessage delete_goods() {
//
//	}

//	public static ResultMessage delete_histroy() {
//
//	}

//	public static ResultMessage delete_initial() {
//
//	}

//	public static ResultMessage delete_initial_account() {
//
//	}
//
//	public static ResultMessage delete_initial_organiation() {
//
//	}
//
//	public static ResultMessage delete_initial_personnel() {
//
//	}
//
//	public static ResultMessage delete_initial_stock() {
//
//	}
//
//	public static ResultMessage delete_initial_vehicle() {
//
//	}

	public static ResultMessage delete_receipt(String number, ReceiptType type) {
		String sql = "delete from `receipt` where `number` = '"+number+"'";
		if(!mysql.execute(sql)) return ResultMessage.FAILED;
		sql = "delete from `"+Typetotable.gettable(type)+"` where `number`='"+number+"'";
		if(!mysql.execute(sql)) return ResultMessage.FAILED;
		return ResultMessage.SUCCESS;
	}

//	public static ResultMessage delete_receipt_arrive() {
//
//	}
//	public static ResultMessage delete_receipt_deliver() {
//
//	}
//	public static ResultMessage delete_receipt_moneyin() {
//
//	}
//	public static ResultMessage delete_receipt_moneyout() {
//
//	}
//	public static ResultMessage delete_receipt_order() {
//
//	}
//	public static ResultMessage delete_receipt_stockin() {
//
//	}
//	public static ResultMessage delete_receipt_stockout() {
//
//	}
//	public static ResultMessage delete_receipt_totalmoneyin() {
//
//	}
//	public static ResultMessage delete_receipt_trans() {
//
//	}
	public static ResultMessage delete_salary(String perNum) {
		String sql = "delete from `salary` where `perNum` = '" + perNum + "'";
		if (!mysql.execute(sql))
			return ResultMessage.FAILED;
		return ResultMessage.SUCCESS;

	}
//	public static ResultMessage delete_stock() {
//
//	}
//	public static ResultMessage delete_stockArea() {
//
//	}
//	public static ResultMessage delete_stockOperation() {
//
//	}
	public static ResultMessage delete_user(String id) {
		String sql = "delete from `user` where `number`='" + id + "'";
		if (!mysql.execute(sql)) {
			return ResultMessage.FAILED;
		}
		return ResultMessage.SUCCESS;

	}
	public static ResultMessage delete_vehicle(String number) {
		String sql = "DELETE FROM `vehicle` WHERE number = '" + number + "'";
		if (mysql.execute(sql)) {
			return ResultMessage.SUCCESS;
		}else {
			return ResultMessage.FAILED;
		}

	}

}
