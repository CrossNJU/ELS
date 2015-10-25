/**
 * 库存的VO
 * @author danni
 * @date 2015/10/19
 */
package org.cross.elsclient.vo;

import java.util.ArrayList;

import org.cross.elsclient.po.StockAreaPO;

public class StockVO {
	/**
	 * 仓库编号
	 */
	public String stockIdentifier;
	
	/**
	 * 仓库中的不同类型仓库
	 */
	public ArrayList<StockAreaPO> specialStockPOs;
	
	/**
	 * 仓库操作
	 */
	public ArrayList<StockOperationVO> stockOperations;
	
	/**
	 * 仓库总间数
	 */
	public int numOfBooths;
	
	/**
	 * 仓库已用间数
	 */
	public int usedBooths;
	
	/**
	 * 出库数量
	 */
	public int numOut;
	
	/**
	 * 入库数量
	 */
	public int numIn;
	
	/**
	 * 出库金额
	 */
	public int moneyOut;
	
	/**
	 * 入库金额
	 */
	public int moneyIn;
	
	/**
	 * 库存数量
	 */
	public int numInStock;

	
	/**
	 * 构造方法
	 * @param numOfBooth
	 */
	
	public StockVO(String stockID,int numOfBooth){
		this.stockIdentifier = stockID;
		this.numOfBooths = numOfBooth;
		
		this.specialStockPOs = new ArrayList<StockAreaPO>();
		this.stockOperations = new ArrayList<StockOperationVO>();
		this.usedBooths = 0;
		this.numOut = 0;
		this.numIn = 0;
		this.moneyOut = 0;
		this.moneyIn = 0;
		this.numInStock = 0;
	}
}
