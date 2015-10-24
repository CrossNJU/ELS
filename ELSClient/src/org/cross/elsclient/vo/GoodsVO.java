/**
 * 快件信息的VO
 * @author danni
 * @date 2015/10/21
 */
package org.cross.elsclient.vo;

import org.cross.elsclient.po.HistoryPO;
import org.cross.elsclient.util.City;
import org.cross.elsclient.util.GoodsState;

public class GoodsVO {
	/**
	 * 订单
	 */
	public Receipt_OrderVO order;
	
	/**
	 * 当前位置
	 */
	public City currentLocate;
	
	/**
	 * 状态
	 */
	public GoodsState state;
	
	/**
	 * 实际重量
	 */
	public int weightOfGoods;
	
	/**
	 * 体积
	 */
	public int volumeOfGoods;
	
	/**
	 * 历史轨迹
	 */
	public HistoryVO historyVO;
	
	/**
	 * 构造方法
	 * 
	 */
	public GoodsVO(int weight,int volum,City currentLocate){
		this.weightOfGoods = weight;
		this.volumeOfGoods = volum;
		this.currentLocate = currentLocate;
		
		this.state = GoodsState.LIVE;
		this.order = null;
		this.historyVO = null;
	}

}
