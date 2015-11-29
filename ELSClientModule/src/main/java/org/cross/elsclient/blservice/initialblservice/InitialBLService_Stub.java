/**
 * 期初建账业务逻辑桩程序
 * @author Polaris Chen
 * @date 2015/10/23
 */
package org.cross.elsclient.blservice.initialblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elscommon.util.City;
import org.cross.elscommon.util.OrganizationType;
import org.cross.elscommon.util.PositionType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elsclient.vo.OrganizationVO;
import org.cross.elsclient.vo.PersonnelVO;
import org.cross.elsclient.vo.VehicleVO;
import org.cross.elsclient.vo.StockVO;
import org.cross.elsclient.vo.AccountVO;
import org.cross.elsclient.vo.InitialVO;

public class InitialBLService_Stub implements InitialBLService {

	@Override
	public ArrayList<InitialVO> show() {
		ArrayList<OrganizationVO> organizations = new ArrayList<OrganizationVO>();
		organizations.add(new OrganizationVO(City.BEIJING, OrganizationType.BUSINESSHALL, "O01001"));
		
		ArrayList<PersonnelVO> personnels = new ArrayList<PersonnelVO>();
		personnels.add(new PersonnelVO("P000001", "汤姆", PositionType.ADMINISTRATOR, OrganizationType.BUSINESSHALL, "O000001"));
		personnels.add(new PersonnelVO("P000001", "汤姆", PositionType.ADMINISTRATOR, OrganizationType.BUSINESSHALL, "O000001"));
		personnels.add(new PersonnelVO("P000001", "汤姆", PositionType.ADMINISTRATOR, OrganizationType.BUSINESSHALL, "O000001"));
		personnels.add(new PersonnelVO("P000001", "汤姆", PositionType.ADMINISTRATOR, OrganizationType.BUSINESSHALL, "O000001"));
		
		
		ArrayList<VehicleVO> vehicles = new ArrayList<VehicleVO>();
		vehicles.add(new VehicleVO("V0100001"));
		vehicles.add(new VehicleVO("V0100001"));
		vehicles.add(new VehicleVO("V0100001"));
		
		ArrayList<StockVO> stocks = new ArrayList<StockVO>();
		stocks.add(new StockVO("S00001", 5));
		stocks.add(new StockVO("S00001", 5));
		stocks.add(new StockVO("S00001", 5));
		
		ArrayList<AccountVO> accounts = new ArrayList<AccountVO>();
		accounts.add(new AccountVO("ICBC账户", "6222201234567654321", 500000));
		accounts.add(new AccountVO("ICBC账户", "6222201234567654321", 500000));
		accounts.add(new AccountVO("ICBC账户", "6222201234567654321", 500000));
		
		ArrayList<OrganizationVO> organizations1 = new ArrayList<OrganizationVO>();
		organizations1.add(new OrganizationVO(City.BEIJING, OrganizationType.BUSINESSHALL, "O01001"));
		organizations1.add(new OrganizationVO(City.BEIJING, OrganizationType.BUSINESSHALL, "O01001"));
		organizations1.add(new OrganizationVO(City.BEIJING, OrganizationType.BUSINESSHALL, "O01001"));
		organizations1.add(new OrganizationVO(City.BEIJING, OrganizationType.BUSINESSHALL, "O01001"));
		
		
		ArrayList<PersonnelVO> personnels1 = new ArrayList<PersonnelVO>();
		personnels1.add(new PersonnelVO("P000001", "汤姆", PositionType.ADMINISTRATOR, OrganizationType.BUSINESSHALL, "O000001"));
		personnels1.add(new PersonnelVO("P000001", "汤姆", PositionType.ADMINISTRATOR, OrganizationType.BUSINESSHALL, "O000001"));
		personnels1.add(new PersonnelVO("P000001", "汤姆", PositionType.ADMINISTRATOR, OrganizationType.BUSINESSHALL, "O000001"));
		
		ArrayList<VehicleVO> vehicles1 = new ArrayList<VehicleVO>();
		vehicles1.add(new VehicleVO("V0100001"));
		vehicles1.add(new VehicleVO("V0100001"));
		vehicles1.add(new VehicleVO("V0100001"));
		vehicles1.add(new VehicleVO("V0100001"));
		
		ArrayList<StockVO> stocks1 = new ArrayList<StockVO>();
		stocks1.add(new StockVO("S00001", 5));
		stocks1.add(new StockVO("S00001", 5));
		stocks1.add(new StockVO("S00001", 5));
		stocks1.add(new StockVO("S00001", 5));
		
		ArrayList<AccountVO> accounts1 = new ArrayList<AccountVO>();
		accounts1.add(new AccountVO("ICBC账户", "6222201234567654321", 500000));
		
		ArrayList<InitialVO> list = new ArrayList<InitialVO>();
		list.add(new InitialVO("I20141", "2014年期初",2014, organizations, personnels, vehicles, stocks, accounts));
		list.add(new InitialVO("I20140", "2013年期初",2013, organizations1, personnels1, vehicles1, stocks1, accounts1));
		return list;
	}
	
	@Override
	public ResultMessage addInitial(InitialVO vo) {
		return ResultMessage.SUCCESS;
	}

//	@Override
//	public ArrayList<OrganizationVO> showOrganization(InitialVO vo) {
//		ArrayList<OrganizationVO> organizations = new ArrayList<OrganizationVO>();
//		organizations.add(new OrganizationVO(City.BEIJING, OrganizationType.BUSINESSHALL, "O01001"));
//		return organizations;
//	}
//
//	@Override
//	public ArrayList<PersonnelVO> showPersonnel(InitialVO vo) {
//		ArrayList<PersonnelVO> personnels = new ArrayList<PersonnelVO>();
//		personnels.add(new PersonnelVO("P0100001", "杰利", PositionType.COUNTER));
//		return personnels;
//	}
//
//	@Override
//	public ArrayList<VehicleVO> showVehicle(InitialVO vo) {
//		ArrayList<VehicleVO> vehicles = new ArrayList<VehicleVO>();
//		vehicles.add(new VehicleVO("V0100001"));
//		return vehicles;
//	}
//
//	@Override
//	public ArrayList<StockVO> showStock(InitialVO vo) {
//		ArrayList<StockVO> stocks = new ArrayList<StockVO>();
//		stocks.add(new StockVO("S00001", 5));
//		return stocks;
//	}
//
//	@Override
//	public ArrayList<AccountVO> showAccount(InitialVO vo) {
//		ArrayList<AccountVO> accounts = new ArrayList<AccountVO>();
//		accounts.add(new AccountVO("ICBC账户", "6222201234567654321", 500000));
//		return accounts;
//	}

	@Override
	public ArrayList<OrganizationVO> showOrganization(String initialID)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PersonnelVO> showPersonnel(String initialID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<VehicleVO> showVehicle(String initialID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<StockVO> showStock(String initialID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<AccountVO> showAccount(String initialID) {
		// TODO Auto-generated method stub
		return null;
	}

}
