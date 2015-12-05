package org.cross.elsserver.dataimpl.constantdataimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.cross.elscommon.dataservice.constantdataservice.ConstantDataService;
import org.cross.elscommon.po.ConstantPO;
import org.cross.elscommon.util.MySQL;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.UserType;

public class ConstantDataImpl extends UnicastRemoteObject implements ConstantDataService {

	MySQL mysql;

	// `price`, `timeByKilo`, `baseMoneyForDRIVER`, `baseMoneyForADMINITER`,
	// `baseMoneyForBUSINESSHALLCLERK`, `baseMoneyForTRANSITCENTERCLERK`,
	// `baseMoneyForCOUNTER`, `baseMoneyForCOURIER`, `baseMoneyForSTOCKKEEPER`,
	// `baseMoneyForMANGER`, `distance_Beijing_Guangzhou`,
	// `distance_Beijing_Shanghai`, `distance_Beijing_Nanjing`,
	// `distance_Guangzhou_Shanghai`, `distance_Guangzhou_Nanjing`,
	// `distance_Nanjing_Shanghai`
	public ConstantDataImpl() throws RemoteException {
		super();
		mysql = new MySQL();
	}

	@Override
	public ResultMessage update(ConstantPO po) {
		String sql = "delete from `constant` where 1";
		mysql.execute(sql);
		return insert(po);
	}

	@Override
	public ConstantPO show() {
		ResultSet rs = mysql.query("select * from `constant`");
		return getFromDB(rs);
	}

	public ResultMessage insert(ConstantPO po) {
		String sql = "insert ignore into `constant`(`price`, `timeByKilo`, `baseMoneyForDRIVER`, `baseMoneyForADMINITER`, `baseMoneyForBUSINESSHALLCLERK`, `baseMoneyForTRANSITCENTERCLERK`, "
				+ "`baseMoneyForCOUNTER`, `baseMoneyForCOURIER`, `baseMoneyForSTOCKKEEPER`, `baseMoneyForMANGER`, `distance_Beijing_Guangzhou`, `distance_Beijing_Shanghai`, `distance_Beijing_Nanjing`,"
				+ " `distance_Guangzhou_Shanghai`, `distance_Guangzhou_Nanjing`, `distance_Nanjing_Shanghai`) values ("
				+ po.getPrice() + "," + po.getTimeBykilo() + "," + po.getBaseMoneyForDRIVER() + ","
				+ po.getBaseMoney(UserType.ADMINISTRATOR) + "," + po.getBaseMoney(UserType.BUSINESSHALLCLERK) + ","
				+ po.getBaseMoney(UserType.TRANSITCENTERCLERK) + "," + po.getBaseMoney(UserType.COUNTER) + ","
				+ po.getBaseMoney(UserType.COURIER) + "," + po.getBaseMoney(UserType.STOCKKEEPER) + ","
				+ po.getBaseMoney(UserType.MANAGER) + "," + po.getDistance_Beijing_Guangzhou() + ","
				+ po.getDistance_Beijing_Nanjing() + "," + po.getDistance_Beijing_Shanghai() + ","
				+ po.getDistance_Shanghai_Guangzhou() + "," + po.getDistance_Nanjing_Guangzhou() + ","
				+ po.getDistance_Nanjing_Shanghai() + "')";
		if(!mysql.execute(sql))return ResultMessage.FAILED;
		return ResultMessage.SUCCESS;
	}

	public ConstantPO getFromDB(ResultSet rs){
		ConstantPO po = null;
		try {
			if (rs.next()) {
				po = new ConstantPO();
				po.setBaseMoney(UserType.ADMINISTRATOR, rs.getDouble("baseMoneyForADMINITER"));
				po.setBaseMoney(UserType.BUSINESSHALLCLERK, rs.getDouble("baseMoneyForBUSINESSHALLCLERK"));
				po.setBaseMoney(UserType.COUNTER, rs.getDouble("baseMoneyForCOUNTER"));
				po.setBaseMoney(UserType.COURIER, rs.getDouble("baseMoneyForCOURIER"));
				po.setBaseMoney(UserType.MANAGER, rs.getDouble("baseMoneyForMANGER"));
				po.setBaseMoney(UserType.STOCKKEEPER, rs.getDouble("baseMoneyForSTOCKKEEPER"));
				po.setBaseMoney(UserType.TRANSITCENTERCLERK, rs.getDouble("baseMoneyForTRANSITCENTERCLERK"));
				po.setBaseMoneyForDRIVER(rs.getDouble("baseMoneyForDRIVER"));
				
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
	
}
