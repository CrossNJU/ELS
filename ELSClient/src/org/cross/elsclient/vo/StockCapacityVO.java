/**
 * 仓库容量信息的VO
 * @author danni
 * @date 2015/10/19
 */
package org.cross.elsclient.vo;

public class StockCapacityVO {
	/**
	 * 仓库类型
	 */
	public String stockType = "特快";
	
	/**
	 * 特定仓库总容量
	 */
	public int totalCapacity = 1000;
	
	/**
	 * 特定仓库已用容量
	 */
	public int usedCapacity = 0;
	
	/**
	 * 特定仓库已用容量所占总容量的百分比
	 */
	public double usedPercent = 0;
	
	
}
