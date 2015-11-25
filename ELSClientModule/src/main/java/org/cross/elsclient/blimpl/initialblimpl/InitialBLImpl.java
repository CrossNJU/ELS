package org.cross.elsclient.blimpl.initialblimpl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.blUtility.AccountInfo;
import org.cross.elsclient.blimpl.blUtility.OrganizationInfo;
import org.cross.elsclient.blimpl.blUtility.PersonnelInfo;
import org.cross.elsclient.blimpl.blUtility.StockInfo;
import org.cross.elsclient.blimpl.blUtility.VehicleInfo;
import org.cross.elsclient.blservice.initialblservice.InitialBLService;
import org.cross.elsclient.blservice.logblservice.LogBLService;
import org.cross.elsclient.vo.AccountVO;
import org.cross.elsclient.vo.InitialVO;
import org.cross.elsclient.vo.OrganizationVO;
import org.cross.elsclient.vo.PersonnelVO;
import org.cross.elsclient.vo.StockVO;
import org.cross.elsclient.vo.VehicleVO;
import org.cross.elscommon.dataservice.initialdataservice.InitialDataService;
import org.cross.elscommon.dataservice.initialdataservice.InitialDataService_Stub;
import org.cross.elscommon.po.AccountPO;
import org.cross.elscommon.po.InitialPO;
import org.cross.elscommon.po.OrganizationPO;
import org.cross.elscommon.po.PersonnelPO;
import org.cross.elscommon.po.StockPO;
import org.cross.elscommon.po.VehiclePO;
import org.cross.elscommon.util.ResultMessage;

public class InitialBLImpl implements InitialBLService{

	InitialDataService_Stub initialData;
	InitialInfo initialInfo;
	OrganizationInfo orgInfo;
	PersonnelInfo personnelInfo;
	VehicleInfo vehicleInfo;
	StockInfo stockInfo;
	AccountInfo accountInfo;
	
	public InitialBLImpl(InitialDataService_Stub initialData,InitialInfo initialInfo,
			OrganizationInfo organizationInfo,PersonnelInfo personnelInfo,
			VehicleInfo vehicleInfo,StockInfo stockInfo,AccountInfo accountInfo){
		this.initialData = initialData;
		this.initialInfo = initialInfo;
		this.orgInfo = organizationInfo;
		this.personnelInfo = personnelInfo;
		this.vehicleInfo = vehicleInfo;
		this.stockInfo = stockInfo;
		this.accountInfo = accountInfo;
	}
	
	@Override
	public ArrayList<InitialVO> show() throws RemoteException {
		ArrayList<InitialVO> initialVOs = new ArrayList<InitialVO>();
		ArrayList<InitialPO> initialPOs = initialData.show();
		if (initialPOs == null) {
			return null;
		}
		int size = initialPOs.size();
		for (int i = 0; i < size; i++) {
			initialVOs.add(initialInfo.toInitialVO(initialPOs.get(i)));
		}
		return initialVOs;
	}

	@Override
	public ResultMessage addInitial(InitialVO vo) throws RemoteException {
		InitialPO po = initialInfo.toInitialPO(vo);
		return initialData.insert(po);
	}

	@Override
	public ArrayList<OrganizationVO> showOrganization(String initialID)
			throws RemoteException {
		InitialPO po = initialData.findByID(initialID);
		ArrayList<OrganizationVO> orgVOs = new ArrayList<OrganizationVO>();
		ArrayList<OrganizationPO> orgPOs = po.getOrganizations();
		if (orgPOs == null) {
			return null;
		}
		int size = orgPOs.size();
		for (int i = 0; i < size; i++) {
			orgVOs.add(orgInfo.toOrganizationVO(orgPOs.get(i)));
		}
		return orgVOs;
	}

	@Override
	public ArrayList<PersonnelVO> showPersonnel(String initialID) {
		InitialPO po = initialData.findByID(initialID);
		ArrayList<PersonnelVO> personnelVOs = new ArrayList<PersonnelVO>();
		ArrayList<PersonnelPO> personnelPOs = po.getPersonnels();
		if (personnelPOs == null) {
			return null;
		}
		int size = personnelPOs.size();
		for (int i = 0; i < size; i++) {
			personnelVOs.add(personnelInfo.toPersonnelVO(personnelPOs.get(i)));
		}
		return personnelVOs;
	}

	@Override
	public ArrayList<VehicleVO> showVehicle(String initialID) {
		InitialPO po = initialData.findByID(initialID);
		ArrayList<VehicleVO> vehicleVOs = new ArrayList<VehicleVO>();
		ArrayList<VehiclePO> vehiclePOs = po.getVehicles();
		if (vehiclePOs == null) {
			return null;
		}
		int size = vehiclePOs.size();
		for (int i = 0; i < size; i++) {
			vehicleVOs.add(vehicleInfo.toVehicleVO(vehiclePOs.get(i)));
		}
		return vehicleVOs;
	}

	@Override
	public ArrayList<StockVO> showStock(String initialID) {
		InitialPO po = initialData.findByID(initialID);
		ArrayList<StockVO> stockVOs = new ArrayList<StockVO>();
		ArrayList<StockPO> stockPOs = po.getStocks();
		if (stockPOs == null) {
			return null;
		}
		int size = stockPOs.size();
		for (int i = 0; i < size; i++) {
			stockVOs.add(stockInfo.toStockVO(stockPOs.get(i)));
		}
		return stockVOs;
	}

	@Override
	public ArrayList<AccountVO> showAccount(String initialID) {
		InitialPO po = initialData.findByID(initialID);
		ArrayList<AccountVO> accountVOs = new ArrayList<AccountVO>();
		ArrayList<AccountPO> accountPOs = po.getAccounts();
		if (accountPOs == null) {
			return null;
		}
		int size = accountPOs.size();
		for (int i = 0; i < size; i++) {
			accountVOs.add(accountInfo.toAccountVO(accountPOs.get(i)));
		}
		return accountVOs;
	}
	
}
