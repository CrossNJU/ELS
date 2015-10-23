/**
 * 期初建账VO
 * @author Polaris Chen
 * @date 2015/10/23
 */
package org.cross.elsclient.vo;

import java.util.ArrayList;

public class InitialVO {

	/**
	 * 编号
	 */
	public String id;

	/**
	 * 名称
	 */
	public String name;

	/**
	 * 机构列表
	 */
	public ArrayList<OrganizationVO> organizations;

	/**
	 * 人员列表
	 */
	public ArrayList<PersonnelVO> personnels;

	/**
	 * 车辆列表
	 */
	public ArrayList<VehicleVO> vehicles;

	/**
	 * 库存列表
	 */
	public ArrayList<StockVO> stocks;

	/**
	 * 账户列表
	 */
	public ArrayList<AccountVO> accounts;

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
	public InitialVO(String id, String name,
			ArrayList<OrganizationVO> organizations,
			ArrayList<PersonnelVO> personnels, ArrayList<VehicleVO> vehicles,
			ArrayList<StockVO> stocks, ArrayList<AccountVO> accounts) {
		this.id = id;
		this.name = name;
		this.organizations = organizations;
		this.personnels = personnels;
		this.vehicles = vehicles;
		this.stocks = stocks;
		this.accounts = accounts;
	}
}
