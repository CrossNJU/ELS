/**
 * 快件信息的VO
 * @author danni
 * @date 2015/10/21
 */
package org.cross.elsclient.vo;

import java.util.ArrayList;

import org.cross.elscommon.po.HistoryPO;
import org.cross.elscommon.util.City;
import org.cross.elscommon.util.GoodsState;
import org.cross.elscommon.util.StockType;

public class GoodsVO {
	/**
	 * 快件类型
	 */
	public StockType goodsType;
	/**
	 * 订单
	 */
	public String orderNumber;
	
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
	public ArrayList<HistoryVO> historyVO;
	
	/**
	 * 构造方法
	 * 
	 */
	public GoodsVO(int weight,int volum,City currentLocate,StockType goodsType){
		this.weightOfGoods = weight;
		this.volumeOfGoods = volum;
		this.currentLocate = currentLocate;
		this.goodsType = goodsType;
		
		this.state = GoodsState.LIVE;
		this.historyVO = new ArrayList<HistoryVO>();
	}

}
