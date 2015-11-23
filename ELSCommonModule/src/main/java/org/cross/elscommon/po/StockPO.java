/**
 * 库存PO类
 * @author danni
 * @date 2015/10/24
 */
package org.cross.elscommon.po;

import java.io.Serializable;
import java.util.ArrayList;

public class StockPO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	/**
	 * 仓库编号
	 */
	private String number;

	/**
	 * 仓库中的不同类型仓库(不同区)
	 */
	private ArrayList<StockAreaPO> stockAreas;

	/**
	 * 仓库操作
	 */
	private ArrayList<StockOperationPO> stockOPs;

	/**
	 * 仓库总间数
	 */
	private int totalAreas;

	/**
	 * 仓库已用间数
	 */
	private int usedAreas;

	/**
	 * 出库数量
	 */
	private int outNum;

	/**
	 * 入库数量
	 */
	private int inNum;

	/**
	 * 出库金额
	 */
	private double outMoney;

	/**
	 * 入库金额
	 */
	private double inMoney;

	/**
	 * 库存数量
	 */
	private int numInStock;

	public StockPO(String number, int totalAreas) {
		super();
		this.number = number;
		this.totalAreas = totalAreas;

		this.stockAreas = new ArrayList<StockAreaPO>();
		this.stockOPs = new ArrayList<StockOperationPO>();
		this.usedAreas = 0;
		this.outNum = 0;
		this.inNum = 0;
		this.outMoney = 0;
		this.inMoney = 0;
		this.numInStock = 0;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public ArrayList<StockAreaPO> getStockAreas() {
		return stockAreas;
	}

	public void setStockAreas(ArrayList<StockAreaPO> stockAreas) {
		this.stockAreas = stockAreas;
	}

	public ArrayList<StockOperationPO> getStockOPs() {
		return stockOPs;
	}

	public void setStockOPs(ArrayList<StockOperationPO> stockOPs) {
		this.stockOPs = stockOPs;
	}

	public int getTotalAreas() {
		return totalAreas;
	}

	public void setTotalAreas(int totalAreas) {
		this.totalAreas = totalAreas;
	}

	public int getUsedAreas() {
		return usedAreas;
	}

	public void setUsedAreas(int usedAreas) {
		this.usedAreas = usedAreas;
	}

	public int getOutNum() {
		return outNum;
	}

	public void setOutNum(int outNum) {
		this.outNum = outNum;
	}

	public int getInNum() {
		return inNum;
	}

	public void setInNum(int inNum) {
		this.inNum = inNum;
	}

	public double getOutMoney() {
		return outMoney;
	}

	public void setOutMoney(double outMoney) {
		this.outMoney = outMoney;
	}

	public double getInMoney() {
		return inMoney;
	}

	public void setInMoney(double inMoney) {
		this.inMoney = inMoney;
	}

	public int getNumInStock() {
		return numInStock;
	}

	public void setNumInStock(int numInStock) {
		this.numInStock = numInStock;
	}

}
