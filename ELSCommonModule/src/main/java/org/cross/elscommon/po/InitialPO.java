/**
 * 期初建账PO
 * @author Polaris Chen
 * @date 2015/10/23
 */
package org.cross.elscommon.po;

import java.io.Serializable;
import java.util.ArrayList;

public class InitialPO implements Serializable {

	/**
	 * 序列化UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 编号
	 */
	private String id;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 机构列表
	 */
	private ArrayList<OrganizationPO> organizations;

	/**
	 * 人员列表
	 */
	private ArrayList<PersonnelPO> personnels;

	/**
	 * 车辆列表
	 */
	private ArrayList<VehiclePO> vehicles;

	/**
	 * 库存列表
	 */
	private ArrayList<StockPO> stocks;

	/**
	 * 账户列表
	 */
	private ArrayList<AccountPO> accounts;

	/**
	 * 构造方法
	 * 
	 * @param id
	 * @param name
	 * @param organizations
	 * @param personnels
	 * @param vehicles
	 * @param stocks
	 * @param accounts
	 */
	public InitialPO(String id, String name,
			ArrayList<OrganizationPO> organizations,
			ArrayList<PersonnelPO> personnels, ArrayList<VehiclePO> vehicles,
			ArrayList<StockPO> stocks, ArrayList<AccountPO> accounts) {
		this.id = id;
		this.name = name;
		this.organizations = organizations;
		this.personnels = personnels;
		this.vehicles = vehicles;
		this.stocks = stocks;
		this.accounts = accounts;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public ArrayList<OrganizationPO> getOrganizations() {
		return organizations;
	}

	public ArrayList<PersonnelPO> getPersonnels() {
		return personnels;
	}

	public ArrayList<VehiclePO> getVehicles() {
		return vehicles;
	}

	public ArrayList<StockPO> getStocks() {
		return stocks;
	}

	public ArrayList<AccountPO> getAccounts() {
		return accounts;
	}

}
