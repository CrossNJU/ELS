package org.cross.elsserver.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
import org.cross.elscommon.util.ReceiptType;
import org.cross.elscommon.util.StringToType;
import org.cross.elsserver.dataimpl.receiptdataimpl.Receipt_DelDataImpl;
import org.cross.elsserver.ui.util.MySQL;

public class DBQueryHelper {
	public static MySQL mysql = new MySQL();

	public static AccountPO getAccount(ResultSet rs) {
		AccountPO po = null;
		try {
			if (rs.next()) {
				po = new AccountPO(rs.getString("name"), rs.getString("accountNum"), rs.getDouble("balance"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
	}

	public static ConstantPO getConstant(ResultSet rs) {
		ConstantPO po = null;
		try {
			if (rs.next()) {
				po = new ConstantPO();
				po.setBaseMoney(PositionType.ADMINISTRATOR, rs.getDouble("baseMoneyForADMINITER"));
				po.setBaseMoney(PositionType.BUSINESSHALLCLERK, rs.getDouble("baseMoneyForBUSINESSHALLCLERK"));
				po.setBaseMoney(PositionType.COUNTER, rs.getDouble("baseMoneyForCOUNTER"));
				po.setBaseMoney(PositionType.COURIER, rs.getDouble("baseMoneyForCOURIER"));
				po.setBaseMoney(PositionType.MANAGER, rs.getDouble("baseMoneyForMANGER"));
				po.setBaseMoney(PositionType.STOCKKEEPER, rs.getDouble("baseMoneyForSTOCKKEEPER"));
				po.setBaseMoney(PositionType.TRANSITCENTERCLERK, rs.getDouble("baseMoneyForTRANSITCENTERCLERK"));
				po.setBaseMoneyForDRIVER(rs.getDouble("baseMoneyForDRIVER"));

				po.setOnce(rs.getDouble("once"));
				po.setNum(rs.getDouble("num"));

				po.setPrice(rs.getDouble("price"));
				po.setTimeBykilo(rs.getDouble("timeByKilo"));

				po.setDistance_Beijing_Guangzhou(rs.getDouble("distance_Beijing_Guangzhou"));
				po.setDistance_Beijing_Nanjing(rs.getDouble("distance_Beijing_Nanjing"));
				po.setDistance_Beijing_Shanghai(rs.getDouble("distance_Beijing_Shanghai"));
				po.setDistance_Nanjing_Guangzhou(rs.getDouble("distance_Guangzhou_Nanjing"));
				po.setDistance_Nanjing_Shanghai(rs.getDouble("distance_Nanjing_Shanghai"));
				po.setDistance_Shanghai_Guangzhou(rs.getDouble("distance_Guangzhou_Shanghai"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
	}

	public static DriverPO getDriver(String number) {
		String sql = "select * from `personnel` where `number`='" + number + "'";
		DriverPO po = null;
		ResultSet rs = mysql.query(sql);
		try {
			if (rs.next()) {
				po = new DriverPO(rs.getString("number"), rs.getString("name"),
						StringToType.toPositionType(rs.getString("position")), rs.getString("orgNum"),
						rs.getDouble("payment"), rs.getInt("sex"), rs.getString("id"), rs.getString("phone"),
						rs.getString("birth"), null, null);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sql = "select * from `driver` where `number`='" + number + "'";
		rs = mysql.query(sql);
		try {
			if (rs.next()) {
				po.setLicenceStart(rs.getString("liceneStart"));
				po.setLicenceEnd(rs.getString("liceneEnd"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
	}

	public static GoodsPO getGoods(ResultSet rs) {
		GoodsPO po = null;
		try {
			if (rs.next()) {
				po = new GoodsPO(StringToType.toGoodsType(rs.getString("type")),
						StringToType.toCity(rs.getString("placeCity")), StringToType.toOrg(rs.getString("placeOrg")),
						StringToType.toGoodsState(rs.getString("state")), rs.getInt("weight"), rs.getInt("volume"),
						rs.getString("number"));
				po.setArriNum(rs.getString("arriNum"));
				po.setDelNum(rs.getString("delNum"));
				po.setTransNum(rs.getString("transNum"));
				po.setStockAreaNum(rs.getString("stockAreaNum"));
				po.setStockNum(rs.getString("stockNum"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
	}

	public static ArrayList<HistoryPO> getHistory(String number) {
		ArrayList<HistoryPO> list = new ArrayList<HistoryPO>();
		String sql = "select * from `history` where `orderNum` = '" + number + "'";
		ResultSet rs = mysql.query(sql);
		try {
			while (rs.next()) {
				HistoryPO po = new HistoryPO(rs.getString("time"), StringToType.toCity(rs.getString("placeCity")),
						StringToType.toOrg(rs.getString("placeOrg")), rs.getBoolean("isArrive"), number);
				list.add(po);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public static InitialPO getInitial(String initialID) {
		String sql = "select * from `initial` where `number`='" + initialID + "'";
		ResultSet rs = mysql.query(sql);
		InitialPO po = null;
		try {
			if (rs.next()) {
				po = new InitialPO(initialID, rs.getString("time"), rs.getString("name"), rs.getString("perNum"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
	}

	public static ArrayList<OrganizationPO> getInitialOrg(String initialNum) {
		ArrayList<OrganizationPO> orgs = new ArrayList<OrganizationPO>();
		String sql = "select * from `initial_organization` where `initialNum`='" + initialNum + "'";
		ResultSet rs = mysql.query(sql);
		try {
			while (rs.next()) {
				OrganizationPO org = new OrganizationPO(StringToType.toCity(rs.getString("city")),
						rs.getString("number"), StringToType.toOrg(rs.getString("type")));
				orgs.add(org);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orgs;
	}

	public static ArrayList<VehiclePO> getInitialVeh(String initialNum) {
		ArrayList<VehiclePO> vehs = new ArrayList<VehiclePO>();
		String sql = "select * from `initial_vehicle` where `initialNum`='" + initialNum + "'";
		ResultSet rs = mysql.query(sql);
		try {
			while (rs.next()) {
				VehiclePO veh = new VehiclePO(rs.getString("number"), rs.getString("engineNum"),
						rs.getString("baseNum"), rs.getString("buyTime"), rs.getString("lastTime"), null,
						rs.getBoolean("state"), rs.getString("licence"), rs.getString("orgNum"));
				vehs.add(veh);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vehs;
	}

	public static ArrayList<PersonnelPO> getInitialPer(String initialNum) {
		ArrayList<PersonnelPO> pers = new ArrayList<PersonnelPO>();
		String sql = "select * from `initial_personnel` where `initialNum`='" + initialNum + "'";
		ResultSet rs = mysql.query(sql);
		try {
			while (rs.next()) {
				PersonnelPO per = new PersonnelPO(rs.getString("number"), rs.getString("name"),
						StringToType.toPositionType(rs.getString("position")), rs.getString("orgNum"),
						rs.getDouble("payment"), rs.getInt("sex"), rs.getString("id"), rs.getString("phone"),
						rs.getString("birth"));
				pers.add(per);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pers;
	}

	public static ArrayList<StockPO> getInitialStock(String initialNum) {
		ArrayList<StockPO> stos = new ArrayList<StockPO>();
		String sql = "select * from `initial_stock` where `initialNum`='" + initialNum + "'";
		ResultSet rs = mysql.query(sql);
		try {
			while (rs.next()) {
				StockPO sto = new StockPO(rs.getString("number"), rs.getInt("numInStock"), rs.getString("orgNum"));
				stos.add(sto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stos;
	}

	public static ArrayList<AccountPO> getInitialAcc(String initialNum) {
		ArrayList<AccountPO> accs = new ArrayList<AccountPO>();
		String sql = "select * from `initial_account` where `initialNum`='" + initialNum + "'";
		ResultSet rs = mysql.query(sql);
		try {
			while (rs.next()) {
				AccountPO acc = new AccountPO(rs.getString("name"), rs.getString("accountNum"),
						rs.getDouble("balance"));
				accs.add(acc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return accs;
	}

	public static LogPO getLog(ResultSet rs) {
		LogPO po = null;
		try {
			if (rs.next()) {
				po = new LogPO(rs.getString("number"), rs.getString("time"), rs.getString("operator"),
						rs.getString("operation"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
	}

	public static NumberPO getNumber() {
		String sql = "select * from `number`";
		ResultSet rs = mysql.query(sql);
		NumberPO po = null;
		try {
			if (rs.next()) {
				po = new NumberPO(rs.getString("goodsNum"), rs.getString("initNum"), rs.getString("logNum"),
						rs.getString("orgNum"), rs.getString("perNum"), rs.getString("userNum"),
						rs.getString("receiptNum"), rs.getString("stockNum"), rs.getString("stockAreaNum"),
						rs.getString("vehicleNum"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
	}

	public static OrganizationPO getOrg(ResultSet rs) {
		OrganizationPO po = null;
		try {
			if (rs.next()) {
				po = new OrganizationPO(StringToType.toCity(rs.getString("city")), rs.getString("number"),
						StringToType.toOrg(rs.getString("type")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
	}

	public static PersonnelPO getPer(ResultSet rs) {
		PersonnelPO po = null;
		try {
			if (rs.next()) {
				po = new PersonnelPO(rs.getString("number"), rs.getString("name"),
						StringToType.toPositionType(rs.getString("position")), rs.getString("orgNum"),
						rs.getDouble("payment"), rs.getInt("sex"), rs.getString("id"), rs.getString("phone"),
						rs.getString("birth"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;

	}

	public static Receipt_ArrivePO getReceipt_Arri(String number) {
		String sql = "select * from `receiptArrive` where `number`='" + number + "'";
		Receipt_ArrivePO po = null;
		ResultSet rs = mysql.query(sql);
		try {
			if (rs.next()) {
				po = new Receipt_ArrivePO(rs.getString("number"), ReceiptType.ARRIVE, rs.getString("time"), null, null,
						rs.getString("startCity"), rs.getString("startTime"), rs.getString("transNum"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sql = "select * from `receipt` where `number`='" + number + "'";
		rs = mysql.query(sql);
		try {
			if (rs.next()) {
				po.setApproveState(StringToType.toApproveType(rs.getString("approveState")));
				po.setOrgNum(rs.getString("orgNum"));
				po.setPerNum(rs.getString("perNum"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
	}

	public static Receipt_DeliverPO getReceipt_Del(String number) {
		String sql = "select * from `receiptDeliver` where `number`='" + number + "'";
		Receipt_DeliverPO po = null;
		ResultSet rs = mysql.query(sql);
		try {
			if (rs.next()) {
				po = new Receipt_DeliverPO(number, ReceiptType.DELIVER, rs.getString("time"), null, null,
						rs.getString("orderNum"), rs.getString("name"), rs.getString("posterNum"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sql = "select * from `receipt` where `number`='" + number + "'";
		rs = mysql.query(sql);
		try {
			if (rs.next()) {
				po.setApproveState(StringToType.toApproveType(rs.getString("approveState")));
				po.setOrgNum(rs.getString("orgNum"));
				po.setPerNum(rs.getString("perNum"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
	}

	public static Receipt_MoneyInPO getReceipt_Moneyin(String number) {
		Receipt_MoneyInPO po = null;
		String sql = "select * from `receiptMoneyIn` where `number`='" + number + "'";
		ResultSet rs = mysql.query(sql);
		try {
			if (rs.next()) {
				po = new Receipt_MoneyInPO(rs.getString("number"), ReceiptType.MONEYIN, rs.getString("time"), null,
						null, rs.getDouble("money"), rs.getString("totalMoneyInNum"), rs.getString("person"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sql = "select * from `receipt` where `number`='" + number + "'";
		rs = mysql.query(sql);
		try {
			if (rs.next()) {
				po.setApproveState(StringToType.toApproveType(rs.getString("approveState")));
				po.setOrgNum(rs.getString("orgNum"));
				po.setPerNum(rs.getString("perNum"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;

	}

	public static Receipt_MoneyOutPO getReceipt_Moneyout(String number) {
		Receipt_MoneyOutPO po = null;
		String sql = "select * from `receiptMoneyOut` where `number`='" + number + "'";
		ResultSet rs = mysql.query(sql);
		try {
			if (rs.next()) {
				po = new Receipt_MoneyOutPO(rs.getString("number"), ReceiptType.MONEYOUT, rs.getString("time"), null,
						null, rs.getDouble("money"), rs.getString("accountNum"), rs.getString("clause"),
						rs.getString("comments"), rs.getString("sender"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sql = "select * from `receipt` where `number`='" + number + "'";
		rs = mysql.query(sql);
		try {
			if (rs.next()) {
				po.setApproveState(StringToType.toApproveType(rs.getString("approveState")));
				po.setOrgNum(rs.getString("orgNum"));
				po.setPerNum(rs.getString("perNum"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;

	}

	public static Receipt_OrderPO getReceipt_Order(String number) {
		Receipt_OrderPO po = null;
		String sql = "select * from `receiptOrder` where `number`='" + number + "'";
		ResultSet rs = mysql.query(sql);
		try {
			if (rs.next()) {
				po = new Receipt_OrderPO(rs.getString("number"), ReceiptType.ORDER, rs.getString("time"), null, null,
						rs.getDouble("price"), rs.getString("expectTime"), rs.getString("senderName"),
						rs.getString("receiverName"), rs.getString("senderOrg"), rs.getString("receiverOrg"),
						rs.getString("senderAdd"), rs.getString("receiverAdd"), rs.getString("senderPhone"),
						rs.getString("receiverPhone"), rs.getString("senderMobile"), rs.getString("receiverMobile"));
				po.setReceiveTime(rs.getString("receiveTime"));
				po.setMoneyInNum(rs.getString("moneyInNum"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sql = "select * from `receipt` where `number`='" + number + "'";
		rs = mysql.query(sql);
		try {
			if (rs.next()) {
				po.setApproveState(StringToType.toApproveType(rs.getString("approveState")));
				po.setOrgNum(rs.getString("orgNum"));
				po.setPerNum(rs.getString("perNum"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;

	}

	public static Receipt_StockInPO getReceipt_stockin(String number) {
		Receipt_StockInPO po = null;
		String sql = "select * from `receiptStockIn` where `number`='" + number + "'";
		ResultSet rs = mysql.query(sql);
		try {
			if (rs.next()) {
				po = new Receipt_StockInPO(number, ReceiptType.STOCKIN, rs.getString("time"), null, null,
						rs.getString("orderNum"), rs.getString("stockAreaNum"), rs.getString("destination"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sql = "select * from `receipt` where `number`='" + number + "'";
		rs = mysql.query(sql);
		try {
			if (rs.next()) {
				po.setApproveState(StringToType.toApproveType(rs.getString("approveState")));
				po.setOrgNum(rs.getString("orgNum"));
				po.setPerNum(rs.getString("perNum"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;

	}

	public static Receipt_StockOutPO getReceipt_stockout(String number) {
		Receipt_StockOutPO po = null;
		String sql = "select * from `receiptStockOut` where `number`='" + number + "'";
		ResultSet rs = mysql.query(sql);
		try {
			if (rs.next()) {
				po = new Receipt_StockOutPO(number, ReceiptType.STOCKOUT, rs.getString("time"), null, null,
						rs.getString("orderNum"), rs.getString("destination"),
						StringToType.toVehicleType(rs.getString("transType")), rs.getString("transNum"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sql = "select * from `receipt` where `number`='" + number + "'";
		rs = mysql.query(sql);
		try {
			if (rs.next()) {
				po.setApproveState(StringToType.toApproveType(rs.getString("approveState")));
				po.setOrgNum(rs.getString("orgNum"));
				po.setPerNum(rs.getString("perNum"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;

	}

	public static Receipt_TotalMoneyInPO getReceipt_totalmoneyin(String number) {
		Receipt_TotalMoneyInPO po = null;
		String sql = "select * from `receiptTotalMoneyIn` where `number`='" + number + "'";
		ResultSet rs = mysql.query(sql);
		try {
			if (rs.next()) {
				po = new Receipt_TotalMoneyInPO(number, ReceiptType.TOTALMONEYIN, rs.getString("time"), null, null,
						rs.getDouble("money"), rs.getString("accountNum"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sql = "select * from `receipt` where `number`='" + number + "'";
		rs = mysql.query(sql);
		try {
			if (rs.next()) {
				po.setApproveState(StringToType.toApproveType(rs.getString("approveState")));
				po.setOrgNum(rs.getString("orgNum"));
				po.setPerNum(rs.getString("perNum"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
	}

	public static Receipt_TransPO getReceipt_trans(String number) {
		Receipt_TransPO po = null;
		String sql = "select * from `receiptTrans` where `number`='" + number + "'";
		ResultSet rs = mysql.query(sql);
		try {
			if (rs.next()) {
				po = new Receipt_TransPO(number, ReceiptType.TRANS, rs.getString("time"), null, null,
						rs.getDouble("cost"), rs.getString("transNum"), rs.getString("veNum"),
						rs.getString("startPlace"), rs.getString("endPlace"), rs.getString("observer"),
						rs.getString("driver"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sql = "select * from `receipt` where `number`='" + number + "'";
		rs = mysql.query(sql);
		try {
			if (rs.next()) {
				po.setApproveState(StringToType.toApproveType(rs.getString("approveState")));
				po.setOrgNum(rs.getString("orgNum"));
				po.setPerNum(rs.getString("perNum"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;

	}

	public static SalaryPO getSalary(ResultSet rs) {
		SalaryPO po = null;
		try {
			if (rs.next()) {
				po = new SalaryPO(StringToType.toSalaryType(rs.getString("type")), rs.getDouble("salaryByMonth"),
						rs.getDouble("addOnce"), rs.getDouble("addNum"), rs.getString("perNum"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;

	}

	public static StockPO getStock(ResultSet rs) {
		StockPO po = null;
		try {
			if (rs.next()) {
				po = new StockPO(rs.getString("number"), rs.getInt("totalAreas"), rs.getString("orgNum"));
				po.setMoneyIn(rs.getDouble("moneyIn"));
				po.setMoneyOut(rs.getDouble("moneyOut"));
				po.setNumIn(rs.getInt("numIn"));
				po.setNumOut(rs.getInt("numOut"));
				po.setUsedAreas(rs.getInt("usedAreas"));
				po.setNumInStock(rs.getInt("numInStock"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;

	}

	public static StockAreaPO getStockArea(ResultSet rs) {
		StockAreaPO po = null;
		try {
			if (rs.next()) {
				po = new StockAreaPO(rs.getString("number"), StringToType.toGoodsType(rs.getString("type")),
						rs.getInt("totalCapacity"), rs.getString("stockNum"));
				po.setUsedCapacity(rs.getInt("usedCapacity"));
				// System.out.println(po.getStockType());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;

	}

	public static StockOperationPO getStockOperation(ResultSet rs) {
		StockOperationPO po = null;
		try {
			if (rs.next()) {
				po = new StockOperationPO(rs.getString("time"), StringToType.toStockOperation(rs.getString("opType")),
						rs.getString("goodsNum"), rs.getDouble("money"),
						StringToType.toGoodsType(rs.getString("stockType")), rs.getString("stockNum"),
						rs.getString("stockAreaNum"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;

	}

	public static UserPO getUser(ResultSet rs) {
		UserPO po = null;
		try {
			if (rs.next()) {
				po = new UserPO(rs.getString("number"), rs.getString("name"),
						StringToType.toUserType(rs.getString("type")), rs.getString("password"),
						rs.getString("orgNum"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;

	}

	public static VehiclePO getVehicle(ResultSet rs) {
		VehiclePO po = null;
		try {
			if (rs.next()) {
				po = new VehiclePO(rs.getString("number"), rs.getString("engineNum"), rs.getString("baseNum"),
						rs.getString("buyTime"), rs.getString("lastTime"), null, rs.getBoolean("state"),
						rs.getString("licence"), rs.getString("orgNum"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return po;

	}
}
