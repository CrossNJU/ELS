//package org.cross.elsserver.database;
//
//import org.cross.elscommon.po.AccountPO;
//import org.cross.elscommon.po.ConstantPO;
//import org.cross.elscommon.po.DriverPO;
//import org.cross.elscommon.po.GoodsPO;
//import org.cross.elscommon.po.HistoryPO;
//import org.cross.elscommon.po.InitialPO;
//import org.cross.elscommon.po.LogPO;
//import org.cross.elscommon.po.NumberPO;
//import org.cross.elscommon.po.OrganizationPO;
//import org.cross.elscommon.po.PersonnelPO;
//import org.cross.elscommon.po.StockPO;
//import org.cross.elscommon.po.VehiclePO;
//import org.cross.elscommon.util.MySQL;
//import org.cross.elscommon.util.ResultMessage;
//import org.cross.elscommon.util.UserType;
//
//public class DBInsertHelper {
//	public static MySQL mysql = new MySQL();
//	
//	public static ResultMessage insert_account(AccountPO po){
//		String sql = "insert into `account`(`name`, `accountNum`, `balance`) values ('" + po.getName() + "','"
//				+ po.getAccountNum() + "'," + po.getBalance() + ")";
//		return mysql.execute(sql);
//	}
//	
//	public static ResultMessage insert_constant(ConstantPO po){
//		String sql = "insert ignore into `constant`(`price`, `timeByKilo`, `baseMoneyForDRIVER`, `baseMoneyForADMINITER`, `baseMoneyForBUSINESSHALLCLERK`, `baseMoneyForTRANSITCENTERCLERK`, "
//				+ "`baseMoneyForCOUNTER`, `baseMoneyForCOURIER`, `baseMoneyForSTOCKKEEPER`, `baseMoneyForMANGER`, `distance_Beijing_Guangzhou`, `distance_Beijing_Shanghai`, `distance_Beijing_Nanjing`,"
//				+ " `distance_Guangzhou_Shanghai`, `distance_Guangzhou_Nanjing`, `distance_Nanjing_Shanghai`) values ("
//				+ po.getPrice() + "," + po.getTimeBykilo() + "," + po.getBaseMoneyForDRIVER() + ","
//				+ po.getBaseMoney(UserType.ADMINISTRATOR) + "," + po.getBaseMoney(UserType.BUSINESSHALLCLERK) + ","
//				+ po.getBaseMoney(UserType.TRANSITCENTERCLERK) + "," + po.getBaseMoney(UserType.COUNTER) + ","
//				+ po.getBaseMoney(UserType.COURIER) + "," + po.getBaseMoney(UserType.STOCKKEEPER) + ","
//				+ po.getBaseMoney(UserType.MANAGER) + "," + po.getDistance_Beijing_Guangzhou() + ","
//				+ po.getDistance_Beijing_Nanjing() + "," + po.getDistance_Beijing_Shanghai() + ","
//				+ po.getDistance_Shanghai_Guangzhou() + "," + po.getDistance_Nanjing_Guangzhou() + ","
//				+ po.getDistance_Nanjing_Shanghai() + "')";
//		return mysql.execute(sql);
//	}
//	
//	public static ResultMessage insert_driver(DriverPO po){
//		return mysql.execute("");
//	}
//	
//	public static ResultMessage insert_goods(GoodsPO po){
//		String sql = "insert ignore into `goods`(`number`, `type`, `placeCity`, `placeOrg`, `state`, `weight`, `volume`) values ('"
//				+ po.getOrderNum() + "','" + po.getGoodsType().toString() + "','" + po.getPlaceCity().toString() + "','"
//				+ po.getState().toString() + "'," + po.getWeight() + "," + po.getVolume() + ")";
//		return mysql.execute(sql);
//	}
//	
//	public static ResultMessage insert_history(HistoryPO po, String orderNum){
//		String sql = "insert ignore into `history`(`time`,`placeCity`,`placeOrg`,`isArrive`,`orderNum`) values ('"
//				+po.getTime()+"','"
//				+po.getPlaceCity().toString()+"','"
//				+po.getPlaceOrg().toString()+"',"
//				+po.isArrive()+",'"
//				+orderNum+"')";
//		return mysql.execute(sql);
//	}
//	
//	public static ResultMessage insert_initial(InitialPO po){
//		String sql = "insert igore into `initial`(``number`, `time`, `name`, `perNum`) values('" + po.getNumber() + "',"
//				+ po.getTime() + ",'" + po.getName() +"','"+po.getPerNum()+ "')";
//		return mysql.execute(sql);
//	}
//	
//	public static ResultMessage insert_initial_account(AccountPO acc, String initNum){
//		String sql = "insert ignore into `initial_account`(`name`, `accountNum`, `balance`, `initialNum`) values ('"
//				+ acc.getName() + "','" + acc.getAccountNum() + "'," + acc.getBalance() + ",'" + initNum + "')";
//		return mysql.execute(sql);
//	}
//	
//	public static ResultMessage insert_initial_organization(OrganizationPO po, String initNum){
//		String sql = "insert ignore into `initial_organization`(`number`, `city`, `type`, `initialNum`) values ('"
//				+ po.getNumber() + "','" + po.getCity().toString() + "','" + po.getType().toString() + "','" + initNum
//				+ "')";
//		return mysql.execute(sql);
//	}
//	
//	public static ResultMessage insert_initial_personnel(PersonnelPO per, String initNum){
//		String sql = "insert ignore into `initial_personnel`(`number`, `name`, `position`, `orgNum`, `payment`,`sex`,`id`,`phone`,`birth`,`initialNum`) values ('"
//				+ per.getNumber() + "','" + per.getName() + "','" + per.getPosition().toString() + "','"
//				+ per.getOrgNum() + "'," + per.getPayment() + "," + per.getSex() + ",'" + per.getId() + "','"
//				+ per.getPhone() + "','" + per.getBirth() + "','" + initNum + "')";
//		return mysql.execute(sql);
//	}
//	
//	public static ResultMessage insert_initial_stock(StockPO sto, String initNum){
//		String sql = "insert ignore into `initial_stock`(`number`, `numInStock`, `orgNum`, `initialNum`) values ('"
//				+ sto.getNumber() + "','" + sto.getNumInStock() + "','" + sto.getOrgNum() + "','" + initNum + "')";
//		return mysql.execute(sql);
//	}
//	
//	public static ResultMessage insert_initial_vehicle(VehiclePO veh, String initNum){
//		String sql = "insert ignore into `initial_vehicle`(`number`, `engineNum`, `baseNum`, `buyTime`, `lastTime`, `state`, `licence`, `orgNum`, `initialNum`) values ('"
//				+ veh.getNumber() + "','" + veh.getEngineNum() + "','" + veh.getBaseNum() + veh.getBuyTime() + "','"
//				+ veh.getLastTime() + "'," + veh.isState() + ",'" + veh.getLicence() + "','" + veh.getOrgNum() + "','"
//				+ initNum + "')";
//		return mysql.execute(sql);
//	}
//	
//	public static ResultMessage insert_log(LogPO po){
//		String sql = "insert ignore into `log`(`number`, `time`, `operator`, `operation`) values ('" + po.getNumber()
//				+ "','" + po.getTime() + "','" + po.getOperator() + "','" + po.getOperation() + "')";
//		return mysql.execute(sql);
//	}
//	
//	public static ResultMessage insert_number(NumberPO po){
//		String sql = "insert into `number`(`goodsNum`, `initNum`, `logNum`, `orgNum`, `perNum`, `userNum`, `receiptNum`, `stockNum`, `stockAreaNum`, `vehicleNum`) values ('"
//				+ po.getGoodsNum() + "','" + po.getInitNum() + "','" + po.getLogNum() + "','" + po.getOrgNum() + "','"
//				+ po.getPerNum() + "','" + po.getUserNum() + "','" + po.getReceiptNum() + "','" + po.getStockNum()
//				+ "','" + po.getStockAreaNum() + "','" + po.getVehicleNum() + "')";
//		return mysql.execute(sql);
//	}
//	
//	public static ResultMessage insert_organization(OrganizationPO po){
//		String sql = "insert ignore into `organization`(`number`,`city`,`type`) values ('" + po.getNumber() + "','"
//				+ po.getCity().toString() + "','" + po.getType().toString() + "')";
//		return mysql.execute(sql);
//	}
//	
//	public static ResultMessage insert_constant(ConstantPO po){
//		return mysql.execute(sql);
//	}
//	
//	public static ResultMessage insert_constant(ConstantPO po){
//		return mysql.execute(sql);
//	}
//	
//	public static ResultMessage insert_constant(ConstantPO po){
//		return mysql.execute(sql);
//	}
//	
//	public static ResultMessage insert_constant(ConstantPO po){
//		return mysql.execute(sql);
//	}
//	
//	public static ResultMessage insert_constant(ConstantPO po){
//		return mysql.execute(sql);
//	}
//	
//	public static ResultMessage insert_constant(ConstantPO po){
//		return mysql.execute(sql);
//	}
//	
//	public static ResultMessage insert_constant(ConstantPO po){
//		return mysql.execute(sql);
//	}
//	
//	public static ResultMessage insert_constant(ConstantPO po){
//		return mysql.execute(sql);
//	}
//	
//	public static ResultMessage insert_constant(ConstantPO po){
//		return mysql.execute(sql);
//	}
//	
//	public static ResultMessage insert_constant(ConstantPO po){
//		return mysql.execute(sql);
//	}
//	
//	public static ResultMessage insert_constant(ConstantPO po){
//		return mysql.execute(sql);
//	}
//	
//	public static ResultMessage insert_constant(ConstantPO po){
//		return mysql.execute(sql);
//	}
//	
//	public static ResultMessage insert_constant(ConstantPO po){
//		return mysql.execute(sql);
//	}
//	
//	public static ResultMessage insert_constant(ConstantPO po){
//		return mysql.execute(sql);
//	}
//	
//	public static ResultMessage insert_constant(ConstantPO po){
//		return mysql.execute(sql);
//	}
//	
//	public static ResultMessage insert_constant(ConstantPO po){
//		return mysql.execute(sql);
//	}
//	
//	public static ResultMessage insert_constant(ConstantPO po){
//		return mysql.execute(sql);
//	}
//}
