package org.cross.elsclient.blimpl.initialblimpl;

import java.util.ArrayList;

import org.cross.elsclient.blimpl.blUtility.AccountInfo;
import org.cross.elsclient.blimpl.blUtility.OrganizationInfo;
import org.cross.elsclient.blimpl.blUtility.PersonnelInfo;
import org.cross.elsclient.blimpl.blUtility.StockInfo;
import org.cross.elsclient.blimpl.blUtility.VehicleInfo;
import org.cross.elsclient.vo.AccountVO;
import org.cross.elsclient.vo.InitialVO;
import org.cross.elsclient.vo.OrganizationVO;
import org.cross.elsclient.vo.PersonnelVO;
import org.cross.elsclient.vo.StockVO;
import org.cross.elsclient.vo.VehicleVO;
import org.cross.elscommon.po.AccountPO;
import org.cross.elscommon.po.InitialPO;
import org.cross.elscommon.po.OrganizationPO;
import org.cross.elscommon.po.PersonnelPO;
import org.cross.elscommon.po.StockPO;
import org.cross.elscommon.po.VehiclePO;

public class InitialInfoImpl implements InitialInfo{
	public OrganizationInfo organizationInfo;
	public PersonnelInfo personnelInfo;
	public VehicleInfo vehicleInfo;
	public StockInfo stockInfo;
	public AccountInfo accountInfo;
	
	public InitialInfoImpl(){
		
	}
	
	public InitialInfoImpl(OrganizationInfo organizationInfo,PersonnelInfo personnelInfo,
	VehicleInfo vehicleInfo,StockInfo stockInfo,AccountInfo accountInfo){
		this.organizationInfo = organizationInfo;
		this.personnelInfo = personnelInfo;
		this.vehicleInfo = vehicleInfo;
		this.stockInfo = stockInfo;
		this.accountInfo = accountInfo;
	}

	@Override
	public InitialVO toInitialVO(InitialPO po) {
		if (po == null) {
			return null;
		}
		ArrayList<OrganizationVO> orgVOs = new ArrayList<OrganizationVO>();
		ArrayList<OrganizationPO> orgPOs = po.getOrganizations();
		ArrayList<PersonnelVO> personnelVOs = new ArrayList<PersonnelVO>();
		ArrayList<PersonnelPO> personnelPOs = po.getPersonnels();
		ArrayList<VehicleVO> vehicleVOs = new ArrayList<VehicleVO>();
		ArrayList<VehiclePO> vehiclePOs = po.getVehicles();
		ArrayList<StockVO> stockVOs = new ArrayList<StockVO>();
		ArrayList<StockPO> stockPOs = po.getStocks();
		ArrayList<AccountVO> accountVOs = new ArrayList<AccountVO>();
		ArrayList<AccountPO> accountPOs = po.getAccounts();
		
		for (int i = 0; i < orgPOs.size(); i++) 
			orgVOs.add(organizationInfo.toOrganizationVO(orgPOs.get(i)));
		for (int i = 0; i < personnelPOs.size(); i++) 
			personnelVOs.add(personnelInfo.toPersonnelVO(personnelPOs.get(i)));
		for (int i = 0; i < vehiclePOs.size(); i++) 
			vehicleVOs.add(vehicleInfo.toVehicleVO(vehiclePOs.get(i)));
		for (int i = 0; i < stockPOs.size(); i++) 
			stockVOs.add(stockInfo.toStockVO(stockPOs.get(i)));
		for (int i = 0; i < accountPOs.size(); i++) 
			accountVOs.add(accountInfo.toAccountVO(accountPOs.get(i)));
		
		InitialVO vo = new InitialVO(po.getId(), po.getName(),po.getYear(), 
				orgVOs,personnelVOs,vehicleVOs, stockVOs, accountVOs);
		return vo;
	}

	@Override
	public InitialPO toInitialPO(InitialVO vo) {
		if (vo == null) {
			return null;
		}
		ArrayList<OrganizationVO> orgVOs = vo.organizations;
		ArrayList<OrganizationPO> orgPOs = new ArrayList<OrganizationPO>();
		ArrayList<PersonnelVO> personnelVOs = vo.personnels;
		ArrayList<PersonnelPO> personnelPOs = new ArrayList<PersonnelPO>();
		ArrayList<VehicleVO> vehicleVOs = vo.vehicles;
		ArrayList<VehiclePO> vehiclePOs = new ArrayList<VehiclePO>();
		ArrayList<StockVO> stockVOs = vo.stocks;
		ArrayList<StockPO> stockPOs = new ArrayList<StockPO>();
		ArrayList<AccountVO> accountVOs = vo.accounts;
		ArrayList<AccountPO> accountPOs = new ArrayList<AccountPO>();
		
		for (int i = 0; i < orgVOs.size(); i++) 
			orgPOs.add(organizationInfo.toOrganizationPO(orgVOs.get(i)));
		for (int i = 0; i < personnelVOs.size(); i++) 
			personnelPOs.add(personnelInfo.toPersonnelPO(personnelVOs.get(i)));
		for (int i = 0; i < vehicleVOs.size(); i++) 
			vehiclePOs.add(vehicleInfo.toVehiclePO(vehicleVOs.get(i)));
		for (int i = 0; i < stockVOs.size(); i++) 
			stockPOs.add(stockInfo.toStockPO(stockVOs.get(i)));
		for (int i = 0; i < accountVOs.size(); i++) 
			accountPOs.add(accountInfo.toAccountPO(accountVOs.get(i)));
		
		InitialPO po = new InitialPO(vo.id, vo.name,vo.year, orgPOs, personnelPOs, vehiclePOs, stockPOs, accountPOs);
		return po;
	}

}
