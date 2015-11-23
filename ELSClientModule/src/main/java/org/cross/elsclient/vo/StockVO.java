/**
 * 库存的VO
 * @author danni
 * @date 2015/10/19
 */
package org.cross.elsclient.vo;

import java.util.ArrayList;

import org.cross.elscommon.po.StockAreaPO;
import org.cross.elscommon.po.StockOperationPO;

public class StockVO {
	/**
	 * 仓库编号
	 */
	public String number;

	/**
	 * 仓库中的不同类型仓库(不同区)
	 */
	public ArrayList<StockAreaVO> stockAreas;

	/**
	 * 仓库操作
	 */
	public ArrayList<StockOperationVO> stockOPs;

	/**
	 * 仓库总间数
	 */
	public int totalAreas;

	/**
	 * 仓库已用间数
	 */
	public int usedAreas;

	/**
	 * 出库数量
	 */
	public int outNum;

	/**
	 * 入库数量
	 */
	public int inNum;

	/**
	 * 出库金额
	 */
	public double outMoney;

	/**
	 * 入库金额
	 */
	public double inMoney;

	/**
	 * 库存数量
	 */
	public int numInStock;

	public StockVO(String number, int totalAreas) {
		super();
		this.number = number;
		this.totalAreas = totalAreas;

		this.stockAreas = new ArrayList<StockAreaVO>();
		this.stockOPs = new ArrayList<StockOperationVO>();
		this.usedAreas = 0;
		this.outNum = 0;
		this.inNum = 0;
		this.outMoney = 0;
		this.inMoney = 0;
		this.numInStock = 0;
	}

}
