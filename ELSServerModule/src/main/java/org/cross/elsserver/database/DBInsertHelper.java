package org.cross.elsserver.database;

import org.cross.elscommon.po.AccountPO;
import org.cross.elscommon.po.ConstantPO;
import org.cross.elscommon.po.DriverPO;
import org.cross.elscommon.po.GoodsPO;
import org.cross.elscommon.po.HistoryPO;
import org.cross.elscommon.po.InitialPO;
import org.cross.elscommon.po.LogPO;
import org.cross.elscommon.po.NumberPO;
import org.cross.elscommon.po.OrganizationPO;
import org.cross.elscommon.po.PersonnelPO;
import org.cross.elscommon.po.ReceiptPO;
import org.cross.elscommon.po.Receipt_ArrivePO;
import org.cross.elscommon.po.Receipt_DeliverPO;
import org.cross.elscommon.po.Receipt_MoneyInPO;
import org.cross.elscommon.po.Receipt_MoneyOutPO;
import org.cross.elscommon.po.Receipt_OrderPO;
import org.cross.elscommon.po.Receipt_StockInPO;
import org.cross.elscommon.po.Receipt_StockOutPO;
import org.cross.elscommon.po.Receipt_TotalMoneyInPO;
import org.cross.elscommon.po.Receipt_TransPO;
import org.cross.elscommon.po.SalaryPO;
import org.cross.elscommon.po.StockAreaPO;
import org.cross.elscommon.po.StockOperationPO;
import org.cross.elscommon.po.StockPO;
import org.cross.elscommon.po.UserPO;
import org.cross.elscommon.po.VehiclePO;
import org.cross.elscommon.util.PositionType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.UserType;

public class DBInsertHelper {
	public static MySQL mysql = MySQL.getMysql();
	
	public static ResultMessage insert_account(AccountPO po){
		String sql = "insert ignore into `account`(`name`, `accountNum`, `balance`) values ('" + po.getName() + "','"
				+ po.getAccountNum() + "'," + po.getBalance() + ")";
		if (!mysql.execute(sql))
			return ResultMessage.FAILED;
		return ResultMessage.SUCCESS;
	}
	
	public static ResultMessage insert_constant(ConstantPO po){
		String sql = "insert ignore into `constant`(`price`, `timeByKilo`, `once`, `num` ,`baseMoneyForDRIVER`, `baseMoneyForADMINITER`, `baseMoneyForBUSINESSHALLCLERK`, `baseMoneyForTRANSITCENTERCLERK`, "
				+ "`baseMoneyForCOUNTER`, `baseMoneyForCOURIER`, `baseMoneyForSTOCKKEEPER`, `baseMoneyForMANGER`, `distance_Beijing_Guangzhou`, `distance_Beijing_Shanghai`, `distance_Beijing_Nanjing`,"
				+ " `distance_Guangzhou_Shanghai`, `distance_Guangzhou_Nanjing`, `distance_Nanjing_Shanghai`) values ("
				+ po.getPrice() + "," + po.getTimeBykilo() + "," + po.getOnce() + "," + po.getNum() + ","
				+ po.getBaseMoneyForDRIVER() + "," + po.getBaseMoney(PositionType.ADMINISTRATOR) + ","
				+ po.getBaseMoney(PositionType.BUSINESSHALLCLERK) + ","
				+ po.getBaseMoney(PositionType.TRANSITCENTERCLERK) + "," + po.getBaseMoney(PositionType.COUNTER) + ","
				+ po.getBaseMoney(PositionType.COURIER) + "," + po.getBaseMoney(PositionType.STOCKKEEPER) + ","
				+ po.getBaseMoney(PositionType.MANAGER) + "," + po.getDistance_Beijing_Guangzhou() + ","
				+ po.getDistance_Beijing_Nanjing() + "," + po.getDistance_Beijing_Shanghai() + ","
				+ po.getDistance_Shanghai_Guangzhou() + "," + po.getDistance_Nanjing_Guangzhou() + ","
				+ po.getDistance_Nanjing_Shanghai() + ")";
		if (!mysql.execute(sql))
			return ResultMessage.FAILED;
		return ResultMessage.SUCCESS;
	}
	
	public static ResultMessage insert_driver(PersonnelPO po){
		DriverPO dpo = (DriverPO) po;
		String sql = "insert ignore into `driver`(`number`, `liceneStart`, `liceneEnd`) values ('"
				+ dpo.getNumber() + "','" + dpo.getLicenceStart() + "','" + dpo.getLicenceEnd()
				+ "')";
		if (!mysql.execute(sql))
			return ResultMessage.FAILED;
		return ResultMessage.SUCCESS;
	}
	
	public static ResultMessage insert_goods(GoodsPO po){
		String sql = "insert ignore into `goods`(`number`, `type`, `placeCity`, `placeOrg`, `state`, `weight`, `volume`) values ('"
				+ po.getOrderNum() + "','" + po.getGoodsType().toString() + "','" + po.getPlaceCity().toString() + "','"+po.getPlaceOrg().toString()+"','"
				+ po.getState().toString() + "'," + po.getWeight() + "," + po.getVolume() + ")";
		if (mysql.execute(sql)) {
			return ResultMessage.SUCCESS;
		}else return ResultMessage.FAILED;
	}
	
	public static ResultMessage insert_history(HistoryPO po, String orderNum){
		String sql = "insert ignore into `history`(`time`,`placeCity`,`placeOrg`,`isArrive`,`orderNum`) values ('"
				+po.getTime()+"','"
				+po.getPlaceCity().toString()+"','"
				+po.getPlaceOrg().toString()+"',"
				+po.isArrive()+",'"
				+orderNum+"')";
		if (mysql.execute(sql)) {
			return ResultMessage.SUCCESS;
		}else return ResultMessage.FAILED;
	}
	
	public static ResultMessage insert_initial(InitialPO po){
		String sql = "insert ignore into `initial`(`number`, `time`, `name`, `perNum`) values('" + po.getNumber() + "','"
				+ po.getTime() + "','" + po.getName() +"','"+po.getPerNum()+ "')";
		if (!mysql.execute(sql))
			return ResultMessage.FAILED;
		return ResultMessage.SUCCESS;
	}
	
	public static ResultMessage insert_initial_account(AccountPO acc, String initNum){
		String sql = "insert ignore into `initial_account`(`name`, `accountNum`, `balance`, `initialNum`) values ('"
				+ acc.getName() + "','" + acc.getAccountNum() + "'," + acc.getBalance() + ",'" + initNum + "')";
		if (!mysql.execute(sql))
			return ResultMessage.FAILED;
		return ResultMessage.SUCCESS;
	}
	
	public static ResultMessage insert_initial_organization(OrganizationPO po, String initNum){
		String sql = "insert ignore into `initial_organization`(`number`, `city`, `type`, `initialNum`) values ('"
				+ po.getNumber() + "','" + po.getCity().toString() + "','" + po.getType().toString() + "','" + initNum
				+ "')";
		if (!mysql.execute(sql))
			return ResultMessage.FAILED;
		return ResultMessage.SUCCESS;
	}
	
	public static ResultMessage insert_initial_personnel(PersonnelPO per, String initNum){
		String sql = "insert ignore into `initial_personnel`(`number`, `name`, `position`, `orgNum`, `payment`,`sex`,`id`,`phone`,`birth`,`initialNum`) values ('"
				+ per.getNumber() + "','" + per.getName() + "','" + per.getPosition().toString() + "','"
				+ per.getOrgNum() + "'," + per.getPayment() + "," + per.getSex() + ",'" + per.getId() + "','"
				+ per.getPhone() + "','" + per.getBirth() + "','" + initNum + "')";
		if (!mysql.execute(sql))
			return ResultMessage.FAILED;
		return ResultMessage.SUCCESS;
	}
	
	public static ResultMessage insert_initial_stock(StockPO sto, String initNum){
		String sql = "insert ignore into `initial_stock`(`number`, `numInStock`, `orgNum`, `initialNum`) values ('"
				+ sto.getNumber() + "','" + sto.getNumInStock() + "','" + sto.getOrgNum() + "','" + initNum + "')";
		if (!mysql.execute(sql))
			return ResultMessage.FAILED;
		return ResultMessage.SUCCESS;
	}
	
	public static ResultMessage insert_initial_vehicle(VehiclePO veh, String initNum){
		String sql = "insert ignore into `initial_vehicle`(`number`, `engineNum`, `baseNum`, `buyTime`, `lastTime`, `state`, `licence`, `orgNum`, `initialNum`) values ('"
				+ veh.getNumber() + "','" + veh.getEngineNum() + "','" + veh.getBaseNum() +"','"+ veh.getBuyTime() + "','"
				+ veh.getLastTime() + "'," + veh.isState() + ",'" + veh.getLicence() + "','" + veh.getOrgNum() + "','"
				+ initNum + "')";
		if (!mysql.execute(sql))
			return ResultMessage.FAILED;
		return ResultMessage.SUCCESS;
	}
	
	public static ResultMessage insert_log(LogPO po){
		String sql = "insert ignore into `log`(`number`, `time`, `operator`, `operation`) values ('" + po.getNumber()
				+ "','" + po.getTime() + "','" + po.getOperator() + "','" + po.getOperation() + "')";
		if (!mysql.execute(sql))
			return ResultMessage.FAILED;
		return ResultMessage.SUCCESS;
	}
	
	public static ResultMessage insert_number(NumberPO po){
		String sql = "insert into `number`(`goodsNum`, `initNum`, `logNum`, `orgNum`, `perNum`, `userNum`, `receiptNum`, `stockNum`, `stockAreaNum`, `vehicleNum`) values ('"
				+ po.getGoodsNum() + "','" + po.getInitNum() + "','" + po.getLogNum() + "','" + po.getOrgNum() + "','"
				+ po.getPerNum() + "','" + po.getUserNum() + "','" + po.getReceiptNum() + "','" + po.getStockNum()
				+ "','" + po.getStockAreaNum() + "','" + po.getVehicleNum() + "')";
		if (!mysql.execute(sql))
			return ResultMessage.FAILED;
		return ResultMessage.SUCCESS;
	}
	
	public static ResultMessage insert_organization(OrganizationPO po){
		String sql = "insert ignore into `organization`(`number`,`city`,`type`) values ('" + po.getNumber() + "','"
				+ po.getCity().toString() + "','" + po.getType().toString() + "')";
		if (!mysql.execute(sql)) {
			return ResultMessage.FAILED;
		}
		return ResultMessage.SUCCESS;
	}
	
	public static ResultMessage insert_personnel(PersonnelPO po){
		String sql = "insert ignore into `personnel`(`number`, `name`, `position`, `orgNum`, `payment`, `sex`, `id`, `phone`, `birth`) values ('"
				+ po.getNumber() + "','" + po.getName() + "','" + po.getPosition().toString() + "','" + po.getOrgNum()
				+ "'," + po.getPayment() + "," + po.getSex() + ",'" + po.getId() + "','" + po.getPhone() + "','"
				+ po.getBirth() + "')";
		if (!mysql.execute(sql)) {
			return ResultMessage.FAILED;
		}
		return ResultMessage.SUCCESS;
	}
	
	public static ResultMessage insert_receipt(ReceiptPO po){
		String sql = "insert ignore into `receipt`(`number`, `type`, `time`, `approveState`, `perNum`, `orgNum`) values ('"
				+po.getNumber()+"','"+po.getType().toString()+"','"+po.getTime()+"','"+po.getApproveState().toString()+
				"','"+po.getPerNum()+"','"+po.getOrgNum()+"')";
		if(!mysql.execute(sql)) return ResultMessage.FAILED;
		return ResultMessage.SUCCESS;
	}
	
	public static ResultMessage insert_receipt_arrive(Receipt_ArrivePO arrivePO){
		String sql = "insert ignore into `receiptArrive`(`time`, `number`, `startCity`, `transNum`, `startTime`) values ('"
				+ arrivePO.getTime() + "','" + arrivePO.getNumber() + "','" + arrivePO.getStartPlace()
				+ "','" + arrivePO.getTransNum() + "','" + arrivePO.getStartTime()
				+ "')";
		if (!mysql.execute(sql))
			return ResultMessage.FAILED;
		return ResultMessage.SUCCESS;
	}
	
	public static ResultMessage insert_receipt_deliver(Receipt_DeliverPO delpo){
		String sql = "insert ignore into `receiptDeliver`(`number`, `orderNum`, `name`, `posterNum`, `time`) values ('"
				+ delpo.getNumber() + "','" + delpo.getOrderNum() + "','" + delpo.getName() + "','"
				+ delpo.getPosterNum() + "','" + delpo.getTime() + "')";
		if (!mysql.execute(sql))
			return ResultMessage.FAILED;
		return ResultMessage.SUCCESS;
	}
	
	public static ResultMessage insert_receipt_moneyin(Receipt_MoneyInPO realpo){
		String sql = "insert ignore into `receiptMoneyIn`(`number`, `time`, `money`, `totalMoneyInNum`, `person`) values ('"
				+ realpo.getNumber() + "','" + realpo.getTime() + "'," + realpo.getMoney() + ",'"
				+ realpo.getTotalMoneyInNum() +"','"+ realpo.getPerson()+"')";
		if (!mysql.execute(sql))
			return ResultMessage.FAILED;
		return ResultMessage.SUCCESS;
	}
	
	public static ResultMessage insert_receipt_moneyout(Receipt_MoneyOutPO realpo){
		String sql = "insert ignore into `receiptMoneyOut`(`number`, `time`, `money`, `accountNum`, `clause`, `comments`, `sender`) values ('"
				+ realpo.getNumber() + "','" + realpo.getTime() + "'," + realpo.getMoney() + ",'"
				+ realpo.getAccountNum() + "','" + realpo.getClause() + "','" + realpo.getComments() +"','"+realpo.getSenderNum()+ "')";
		if (!mysql.execute(sql))
			return ResultMessage.FAILED;
		else
			return ResultMessage.SUCCESS;
	}
	
	public static ResultMessage insert_receipt_order(Receipt_OrderPO po){
		String sql = "insert ignore into `receiptOrder`(`number`, `time`, `price`, `receiveTime`, `expectTime`, `moneyInNum`, `senderName`, `receiverName`, `senderAdd`, `receiverAdd`, `senderOrg`, `receiverOrg`, `senderPhone`, `receiverPhone`, `senderMobile`, `receiverMobile`) values ('"
				+ po.getNumber() + "','" + po.getTime() + "'," + po.getPrice() + ",'" 
				+ po.getReceiveTime() + "','" + po.getExpectTime() + "','" + po.getMoneyInNum() + "','"
				+ po.getSenderName() + "','" + po.getReceiverName() + "','" + po.getSenderAdd() + "','"
				+ po.getReceiverAdd() + "','" + po.getSenderOrg() + "','" + po.getReceiverOrg() + "','"
				+ po.getSenderPhone() + "','" +po.getReceiverPhone()+"','"+ po.getSenderMobile() + "','" + po.getReceiverMobile() + "')";
		if (!mysql.execute(sql)) {
			return ResultMessage.FAILED;
		} else
			return ResultMessage.SUCCESS;
	}
	
	public static ResultMessage insert_receipt_stockin(Receipt_StockInPO po){
		String sql = "insert ignore into `receiptStockIn`(`number`, `time`,`orderNum`, `stockAreaNum`, `destination`) values ('"
				+ po.getNumber() + "','" + po.getTime() + "','" + po.getOrderNum() + "','" + po.getStockNum() + "','"
				+ po.getDestination() + "')";
		if (!mysql.execute(sql))
			return ResultMessage.FAILED;
		return ResultMessage.SUCCESS;
	}
	
	public static ResultMessage insert_receipt_stockout(Receipt_StockOutPO realpo){
		String sql = "insert ignore into `receiptStockOut`(`number`, `time`, `orderNum`, `transNum`, `transType`, `destination`) values ('"
				+ realpo.getNumber() + "','" + realpo.getTime() + "','" + realpo.getOrderNum() + "','"
				+ realpo.getTransNumber() + "','" + realpo.getTransType().toString() + "','" + realpo.getDestination()
				+ "')";
		if (!mysql.execute(sql))
			return ResultMessage.FAILED;
		else
			return ResultMessage.SUCCESS;
	}
	
	public static ResultMessage insert_receipt_totalmoneyin(Receipt_TotalMoneyInPO realpo){
		String sql = "insert ignore into `receiptTotalMoneyIn`(`number`, `time`, `money`, `accountNum`) values ('"
				+ realpo.getNumber() + "','" + realpo.getTime() + "'," + realpo.getMoney() + ",'"
				+ realpo.getAccountNum() + "')";
		if (!mysql.execute(sql))
			return ResultMessage.FAILED;
		return ResultMessage.SUCCESS;
	}
	
	public static ResultMessage insert_receipt_trans(Receipt_TransPO pos){
		String sql = "insert ignore into `receiptTrans`(`number`, `time`, `transNum`, `veNum`, `startPlace`, `endPlace`, `observer`, `driver`, `cost`) values ('"
				+ pos.getNumber() + "','" + pos.getTime() + "','" + pos.getTransNum() + "','" + pos.getVeNum() + "','"
				+ pos.getStartPlace() + "','" + pos.getArrivePlace() + "','" + pos.getObserver() + "','"
				+ pos.getDriver() + "'," + pos.getCost() + ")";
		if (!mysql.execute(sql))
			return ResultMessage.FAILED;
		return ResultMessage.SUCCESS;
	}
	
	public static ResultMessage insert_salary(SalaryPO po){
		String sql = "insert ignore into `salary`(`type`, `salaryByMonth`, `addOnce`, `addNum`, `perNum`) values ('"
				+ po.getType().toString() + "'," + po.getSalaryByMonth() + "," + po.getAddOnce() + "," + po.getAddNum()
				+ ",'" + po.getPerNum() + "')";
		if (!mysql.execute(sql))
			return ResultMessage.FAILED;
		return ResultMessage.SUCCESS;
	}
	
	public static ResultMessage insert_stock(StockPO po){
		String sql = "insert ignore into `stock`(`number`, `totalAreas`, `usedAreas`, `numOut`, `numIn`, `moneyOut`, `moneyIn`, `numInStock`, `orgNum`) values ('"
				+ po.getNumber() + "'," + po.getTotalAreas() + "," + po.getUsedAreas() + "," + po.getNumOut() + ","
				+ po.getNumIn() + "," + po.getMoneyOut() + "," + po.getMoneyIn() + "," + po.getNumInStock() + ",'"
				+ po.getOrgNum() + "')";
		if (!mysql.execute(sql))
			return ResultMessage.FAILED;
		return ResultMessage.SUCCESS;
	}
	
	public static ResultMessage insert_stockarea(StockAreaPO po){
		String sql = "insert ignore into `stockArea`(`number`, `totalCapacity`, `usedCapacity`, `type`, `stockNum`) values ('"
				+ po.getNumber() + "'," + po.getTotalCapacity() + "," + po.getUsedCapacity() + ",'"
				+ po.getStockType().toString() + "','" + po.getStockNum() + "')";
		if (!mysql.execute(sql))
			return ResultMessage.FAILED;
		return ResultMessage.SUCCESS;
	}
	
	public static ResultMessage insert_stockOperation(StockOperationPO po){
		String sql = "insert ignore into `stockOperation`(`time`, `opType`, `goodsNum`, `money`, `stockType`, `stockAreaNum`,`stockNum`) values ('"
				+ po.getTime() + "','" + po.getOpType().toString() + "','" + po.getGoodsNum() + "'," + po.getMoney()
				+ ",'" + po.getStockType().toString() + "','" + po.getStockAreaNum() + "','" + po.getStockNum() + "')";
		if(!mysql.execute(sql)) return ResultMessage.FAILED;
		return ResultMessage.SUCCESS;
	}
	
	public static ResultMessage insert_user(UserPO po){
		String sql = "insert ignore into `user`(`number`,`name`,`password`,`type`,`orgNum`) values ('" + po.getNumber()
				+ "','" + po.getName() + "','" + po.getPassword() + "','" + po.getType().toString() + "','"
				+ po.getOrgNum() + "')";
		if (!mysql.execute(sql)) {
			return ResultMessage.FAILED;
		}
		return ResultMessage.SUCCESS;
	}
	
	public static ResultMessage insert_vehicle(VehiclePO po){
		String sql = "insert ignore into `vehicle`(`number`, `engineNum`, `baseNum`, `buyTime`, `lastTime`, `state`, `licence`, `orgNum`) values ('"
				+ po.getNumber() + "','" + po.getEngineNum() + "','" + po.getBaseNum() + "','"+po.getBuyTime() + "','"
				+ po.getLastTime() + "',"+po.isState()+",'" + po.getLicence() + "','" + po.getOrgNum() +"')";
		if(mysql.execute(sql)) return ResultMessage.SUCCESS;
		else return ResultMessage.FAILED;
	}
	
}
