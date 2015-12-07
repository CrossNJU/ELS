package org.cross.elsclient.vo;

public class ConstantVO {
	/**
	 * 价格常量
	 * 单位：每公里公斤
	 */
	public double price;

	/**
	 * 北京到上海的距离
	 */
	public double distance_Beijing_Shanghai;

	/**
	 * 北京到南京的距离
	 */
	public double distance_Beijing_Nanjing;

	/**
	 * 北京到广州的距离
	 */
	public double distance_Beijing_Guangzhou;

	/**
	 * 南京到广州的距离
	 */
	public double distance_Nanjing_Shanghai;

	/**
	 * 南京到上海的距离
	 */
	public double distance_Nanjing_Guangzhou;

	/**
	 * 广州到上海的距离
	 */
	public double distance_Shanghai_Guangzhou;

	/**
	 * 预计每公里时间
	 */
	public double timeBykilo;
	
	/**
	 * 底薪
	 */
	public double baseMoneyForCOURIER;
	
	public double baseMoneyForBUSINESSHALLCLERK;
	
	public double baseMoneyForTRANSITCENTERCLERK;
	
	public double baseMoneyForSTOCKKEEPER;
	
	public double baseMoneyForCOUNTER;
	
	public double baseMoneyForMANAGER;
	
	public double baseMoneyForADMINISTRATOR;
	
	public double baseMoneyForDriver;
	
	public double num;
	
	public double once;
	
	public ConstantVO() {
		price = 23;
		distance_Beijing_Guangzhou = 1888.8;
		distance_Beijing_Nanjing = 900;
		distance_Beijing_Shanghai = 1064.7;
		distance_Nanjing_Guangzhou = 1132;
		distance_Nanjing_Shanghai = 266;
		distance_Shanghai_Guangzhou = 1213;
	}
}
