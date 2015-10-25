/**
 * 库存PO类
 * @author danni
 * @date 2015/10/24
 */
package org.cross.elsclient.po;

import java.io.Serializable;
import java.util.ArrayList;

public class StockPO implements Serializable{
	
	/**
	 * 序列化UID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 仓库编号
	 */
	private String stockIdentifier;
	
	/**
	 * 仓库中的不同类型仓库(不同区)
	 */
	private ArrayList<StockAreaPO> specialStockPOs;
	
	/**
	 * 仓库操作
	 */
	private ArrayList<StockOperationPO> stockOperations;
	
	/**
	 * 仓库总间数
	 */
	private int numOfBooths;
	
	/**
	 * 仓库已用间数
	 */
	private int usedBooths;
	
	/**
	 * 出库数量
	 */
	private int numOut;
	
	/**
	 * 入库数量
	 */
	private int numIn;
	
	/**
	 * 出库金额
	 */
	private int moneyOut;
	
	/**
	 * 入库金额
	 */
	private int moneyIn;
	
	/**
	 * 库存数量
	 */
	private int numInStock;

	
	/**
	 * 构造函数
	 * 
	 */
	public StockPO(String id,int numOfBooth){
		this.stockIdentifier = id;
		this.numOfBooths = numOfBooth;
		
		this.specialStockPOs = new ArrayList<StockAreaPO>();
		this.stockOperations = new ArrayList<StockOperationPO>();
		this.usedBooths = 0;
		this.numOut = 0;
		this.numIn = 0;
		this.moneyOut = 0;
		this.moneyIn = 0;
		this.numInStock = 0;
	}
	public String getStockID(){
		return stockIdentifier;
	}
	public void setStockID(String stockIdentifier){
		this.stockIdentifier = stockIdentifier;
	}
	
	public ArrayList<StockAreaPO> getSpecialStockPOs(){
		return specialStockPOs;
	}
	public void setSpecialStockPOs(ArrayList<StockAreaPO> specialStockPO){
		this.specialStockPOs = specialStockPO;
	}
	
	public int getNumOfBooths(){
		return numOfBooths;
	}
	public void setNumOfBooths(int numOfBooths){
		this.numOfBooths = numOfBooths;
	}
	
	public int getUsedBooths(){
		return usedBooths;
	}
	public void setUsedBooths(int usedBooths){
		this.usedBooths = usedBooths;
	}
	
	public int getNumOut(){
		return numOut;
	}
	public void setNumOut(int numOut){
		this.numOut = numOut;
	}
	
	public int getNumIn(){
		return numIn;
	}
	public void setNumIn(int numIn){
		this.numIn = numIn;
	}
	
	public int getMoneyOut(){
		return moneyOut;
	}
	public void setMoneyOut(int moneyOut){
		this.moneyOut = moneyOut;
	}
	
	public int getMoneyIn(){
		return moneyIn;
	}
	public void setMoneyIn(int moneyIn){
		this.moneyIn = moneyIn;
	}
	
	public int getNumInStock(){
		return numInStock;
	}
	public void setNumInStock(int numInStock){
		this.numInStock = numInStock;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public ArrayList<StockOperationPO> getStockOperations() {
		return stockOperations;
	}
	
	public void setStockOperations(ArrayList<StockOperationPO> stockOperations) {
		this.stockOperations = stockOperations;
	}
}
