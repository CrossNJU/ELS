package org.cross.elscommon.po;

import java.io.Serializable;

import org.cross.elscommon.util.City;
import org.cross.elscommon.util.UserType;

public class ConstantPO implements Serializable {

	/**
	 * 价格常量 单位：每公里公斤
	 */
	private double price;

	/**
	 * 北京到上海的距离
	 */
	private double distance_Beijing_Shanghai;

	/**
	 * 北京到南京的距离
	 */
	private double distance_Beijing_Nanjing;

	/**
	 * 北京到广州的距离
	 */
	private double distance_Beijing_Guangzhou;

	/**
	 * 南京到广州的距离
	 */
	private double distance_Nanjing_Shanghai;

	/**
	 * 南京到上海的距离
	 */
	private double distance_Nanjing_Guangzhou;

	/**
	 * 广州到上海的距离
	 */
	private double distance_Shanghai_Guangzhou;

	/**
	 * 每公里预计时间
	 */
	private double timeBykilo;

	/**
	 * 底薪
	 */
	private double baseMoneyForCOURIER;

	private double baseMoneyForBUSINESSHALLCLERK;

	private double baseMoneyForTRANSITCENTERCLERK;

	private double baseMoneyForSTOCKKEEPER;

	private double baseMoneyForCOUNTER;

	private double baseMoneyForMANAGER;

	private double baseMoneyForADMINISTRATOR;

	private double baseMoneyForDRIVER;

	public double getTimeBykilo() {
		return timeBykilo;
	}

	public void setTimeBykilo(double timeBykilo) {
		this.timeBykilo = timeBykilo;
	}

	public double getDistance(City c1, City c2) {
		if (c1 == City.BEIJING && c2 == City.GUANGZHOU || c2 == City.BEIJING
				&& c1 == City.GUANGZHOU)
			return distance_Beijing_Guangzhou;
		if (c1 == City.BEIJING && c2 == City.SHANGHAI || c2 == City.BEIJING
				&& c1 == City.SHANGHAI)
			return distance_Beijing_Shanghai;
		if (c1 == City.BEIJING && c2 == City.NANJING || c2 == City.BEIJING
				&& c1 == City.NANJING)
			return distance_Beijing_Nanjing;
		if (c1 == City.NANJING && c2 == City.GUANGZHOU || c2 == City.NANJING
				&& c1 == City.GUANGZHOU)
			return distance_Nanjing_Guangzhou;
		if (c1 == City.SHANGHAI && c2 == City.GUANGZHOU || c2 == City.SHANGHAI
				&& c1 == City.GUANGZHOU)
			return distance_Shanghai_Guangzhou;
		if (c1 == City.NANJING && c2 == City.SHANGHAI || c2 == City.NANJING
				&& c1 == City.SHANGHAI)
			return distance_Nanjing_Shanghai;
		return 0;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDistance_Beijing_Shanghai() {
		return distance_Beijing_Shanghai;
	}

	public void setDistance_Beijing_Shanghai(double distance_Beijing_Shanghai) {
		this.distance_Beijing_Shanghai = distance_Beijing_Shanghai;
	}

	public double getDistance_Beijing_Nanjing() {
		return distance_Beijing_Nanjing;
	}

	public void setDistance_Beijing_Nanjing(double distance_Beijing_Nanjing) {
		this.distance_Beijing_Nanjing = distance_Beijing_Nanjing;
	}

	public double getDistance_Beijing_Guangzhou() {
		return distance_Beijing_Guangzhou;
	}

	public void setDistance_Beijing_Guangzhou(double distance_Beijing_Guangzhou) {
		this.distance_Beijing_Guangzhou = distance_Beijing_Guangzhou;
	}

	public double getDistance_Nanjing_Shanghai() {
		return distance_Nanjing_Shanghai;
	}

	public void setDistance_Nanjing_Shanghai(double distance_Nanjing_Shanghai) {
		this.distance_Nanjing_Shanghai = distance_Nanjing_Shanghai;
	}

	public double getDistance_Nanjing_Guangzhou() {
		return distance_Nanjing_Guangzhou;
	}

	public void setDistance_Nanjing_Guangzhou(double distance_Nanjing_Guangzhou) {
		this.distance_Nanjing_Guangzhou = distance_Nanjing_Guangzhou;
	}

	public double getDistance_Shanghai_Guangzhou() {
		return distance_Shanghai_Guangzhou;
	}

	public void setDistance_Shanghai_Guangzhou(
			double distance_Shanghai_Guangzhou) {
		this.distance_Shanghai_Guangzhou = distance_Shanghai_Guangzhou;
	}

	public void setBaseMoney(UserType user, double money) {
		if (user == UserType.ADMINISTRATOR)
			baseMoneyForADMINISTRATOR = money;
		if (user == UserType.BUSINESSHALLCLERK)
			baseMoneyForBUSINESSHALLCLERK = money;
		if (user == UserType.COUNTER)
			baseMoneyForCOUNTER = money;
		if (user == UserType.COURIER)
			baseMoneyForCOURIER = money;
		if (user == UserType.MANAGER)
			baseMoneyForMANAGER = money;
		if (user == UserType.STOCKKEEPER)
			baseMoneyForSTOCKKEEPER = money;
		if (user == UserType.TRANSITCENTERCLERK)
			baseMoneyForTRANSITCENTERCLERK = money;
	}

	public double getBaseMoney(UserType user) {
		if (user == UserType.ADMINISTRATOR)
			return baseMoneyForADMINISTRATOR;
		if (user == UserType.BUSINESSHALLCLERK)
			return baseMoneyForBUSINESSHALLCLERK;
		if (user == UserType.COUNTER)
			return baseMoneyForCOUNTER;
		if (user == UserType.COURIER)
			return baseMoneyForCOURIER;
		if (user == UserType.MANAGER)
			return baseMoneyForMANAGER;
		if (user == UserType.STOCKKEEPER)
			return baseMoneyForSTOCKKEEPER;
		if (user == UserType.TRANSITCENTERCLERK)
			return baseMoneyForTRANSITCENTERCLERK;
		return 0;
	}

	public ConstantPO() {
		price = 23;
		timeBykilo = 100;
		baseMoneyForADMINISTRATOR = 4000;
		baseMoneyForBUSINESSHALLCLERK = 5000;
		baseMoneyForCOUNTER = 6000;
		baseMoneyForCOURIER = 3000;
		baseMoneyForMANAGER = 8000;
		baseMoneyForSTOCKKEEPER = 4000;
		baseMoneyForTRANSITCENTERCLERK = 6000;
		setBaseMoneyForDRIVER(3000);
		distance_Beijing_Guangzhou = 1888.8;
		distance_Beijing_Nanjing = 900;
		distance_Beijing_Shanghai = 1064.7;
		distance_Nanjing_Guangzhou = 1132;
		distance_Nanjing_Shanghai = 266;
		distance_Shanghai_Guangzhou = 1213;
	}

	public double getBaseMoneyForDRIVER() {
		return baseMoneyForDRIVER;
	}

	public void setBaseMoneyForDRIVER(double baseMoneyForDRIVER) {
		this.baseMoneyForDRIVER = baseMoneyForDRIVER;
	}
}
