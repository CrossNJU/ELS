package org.cross.elsserver.database;

import java.rmi.RemoteException;

import org.cross.elscommon.po.AccountPO;
import org.cross.elscommon.po.ConstantPO;
import org.cross.elscommon.po.GoodsPO;
import org.cross.elscommon.po.ReceiptPO;
import org.cross.elscommon.po.StockAreaPO;
import org.cross.elscommon.po.StockPO;
import org.cross.elscommon.po.UserPO;
import org.cross.elscommon.po.VehiclePO;
import org.cross.elscommon.util.ReceiptType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elsserver.dataimpl.receiptdataimpl.Typetotable;
import org.cross.elsserver.ui.util.MySQL;

public class DBUpdateHelper {
	public static MySQL mysql = new MySQL();
	public static ResultMessage update_account(AccountPO po) {
		String sql = "update `account` set `name`='" + po.getName() + "', `balance`=" + po.getBalance()
				+ " where `accountNum`='" + po.getAccountNum()+ "'";
		if (!mysql.execute(sql))
			return ResultMessage.FAILED;
		return ResultMessage.SUCCESS;
	}

	public static ResultMessage update_constant(ConstantPO po) {
		String sql = "delete from `constant` where 1";
		mysql.execute(sql);
		return DBInsertHelper.insert_constant(po);
	}
	
	public static ResultMessage update_goods(GoodsPO po) {
		String sql = "update `goods` set `state`='"+po.getState().toString()+"' where `number`='"+po.getOrderNum()+"'";
		if(!mysql.execute(sql)) return ResultMessage.FAILED;
		if (po.getStockAreaNum()!=null) {
			sql = "update `goods` set `stockAreaNum`='"+po.getStockAreaNum()+"' where `number`='"+po.getOrderNum()+"'";
			if(!mysql.execute(sql)) return ResultMessage.FAILED;
		}
		if (po.getStockNum()!=null) {
			sql = "update `goods` set `stockNum`='"+po.getStockNum()+"' where `number`='"+po.getOrderNum()+"'";
			if(!mysql.execute(sql)) return ResultMessage.FAILED;
		}
		if (po.getArriNum()!=null) {
			sql = "update `goods` set `arriNum`='"+po.getArriNum()+"' where `number`='"+po.getOrderNum()+"'";
			if(!mysql.execute(sql)) return ResultMessage.FAILED;
		}
		if (po.getTransNum()!=null) {
			sql = "update `goods` set `transNum`='"+po.getTransNum()+"' where `number`='"+po.getOrderNum()+"'";
			if(!mysql.execute(sql)) return ResultMessage.FAILED;
		}
		if (po.getDelNum()!=null) {
			sql = "update `goods` set `delNum`='"+po.getDelNum()+"' where `number`='"+po.getOrderNum()+"'";
			if(!mysql.execute(sql)) return ResultMessage.FAILED;
		}
		return ResultMessage.SUCCESS;
	}
//	public static ResultMessage deleteReceipt(String number, ReceiptType type) throws RemoteException {
//		String sql = "delete from `receipt` where `number` = '"+number+"'";
//		if(!mysql.execute(sql)) return ResultMessage.FAILED;
//		sql = "delete from `"+Typetotable.gettable(type)+"` where `number`='"+number+"'";
//		if(!mysql.execute(sql)) return ResultMessage.FAILED;
//		return ResultMessage.SUCCESS;
//	}
	public static ResultMessage update_receipt(ReceiptPO po) {
		if(DBDeleteHelper.delete_receipt(po.getNumber(), po.getType())==ResultMessage.FAILED) return ResultMessage.FAILED;
		return DBInsertHelper.insert_receipt(po);
	}

	public static ResultMessage update_salary(String perNum) {
		String sql = "delete from `salary` where `perNum` = '" + perNum + "'";
		if (!mysql.execute(sql))
			return ResultMessage.FAILED;
		return ResultMessage.SUCCESS;
	}
	public static ResultMessage update_stock(StockPO po) {
		String sql = "delete from `stock` where `number` = '" + po.getNumber()+"'";
		if(!mysql.execute(sql)) return ResultMessage.FAILED;
		return DBInsertHelper.insert_stock(po);
	}
	public static ResultMessage update_stockArea(StockAreaPO po) {
		String sql = "delete from `stockArea` where `number`='"+po.getNumber()+"'";
		if(!mysql.execute(sql)) return ResultMessage.FAILED;
		return DBInsertHelper.insert_stockarea(po);
	}
	
	public static ResultMessage update_user(UserPO po) {
		if (DBDeleteHelper.delete_user(po.getNumber()) == ResultMessage.FAILED)
			return ResultMessage.FAILED;
		return DBInsertHelper.insert_user(po);
	}
	public static ResultMessage update_vehicle(VehiclePO po) {
		if(DBDeleteHelper.delete_vehicle(po.getNumber())==ResultMessage.FAILED) return ResultMessage.FAILED;
		return DBInsertHelper.insert_vehicle(po);
	}

}
