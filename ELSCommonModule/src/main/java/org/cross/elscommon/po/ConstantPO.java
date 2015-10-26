package org.cross.elscommon.po;

import java.io.Serializable;

public class ConstantPO implements Serializable{

	/**
	 * 序列化UID
	 */
	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * 价格常量
	 * 单位：每公里公斤
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


	public void setDistance_Shanghai_Guangzhou(double distance_Shanghai_Guangzhou) {
		this.distance_Shanghai_Guangzhou = distance_Shanghai_Guangzhou;
	}


	public ConstantPO() {
		price = 23;
		distance_Beijing_Guangzhou = 1888.8;
		distance_Beijing_Nanjing = 900;
		distance_Beijing_Shanghai = 1064.7;
		distance_Nanjing_Guangzhou = 1132;
		distance_Nanjing_Shanghai = 266;
		distance_Shanghai_Guangzhou = 1213;
	}
}
