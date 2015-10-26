/**
 * 快件PO类
 * @author danni
 * @date 2015/10/24
 */
package org.cross.elsclient.po;

import java.io.Serializable;

import org.cross.elsclient.util.City;
import org.cross.elsclient.util.GoodsState;
import org.cross.elsclient.vo.GoodsVO;

public class GoodsPO implements Serializable{
	/**
	 * 序列化UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 历史轨迹
	 */
	private HistoryPO historyPO;
	
	/**
	 * 订单
	 */
	private Receipt_OrderPO order;
	
	/**
	 * 当前位置
	 */
	private City currentLocate;
	
	/**
	 * 状态
	 */
	private GoodsState state;
	
	/**
	 * 实际重量
	 */
	private int weightOfGoods;
	
	/**
	 * 体积
	 */
	private int volumeOfGoods;
	
	/**
	 * 构造方法
	 */
	public GoodsPO(int weight,int volum,City currentLocate){
		this.weightOfGoods = weight;
		this.volumeOfGoods = volum;
		this.currentLocate = currentLocate;
		
		this.state = GoodsState.LIVE;
		this.order = null;
		this.historyPO = null;
	}
	
	/**
	 * get&set
	 */
	public HistoryPO getHistoryPO(){
		return historyPO;
	}
	public void setHistoryPO(HistoryPO historyPO){
		this.historyPO = historyPO;
	}
	
	public Receipt_OrderPO getOrderPO(){
		return order;
	}
	public void setOrderPO(Receipt_OrderPO order){
		this.order = order;
	}
	
	public City getCurrentLocate(){
		return currentLocate;
	}
	public void setCurrentLocate(City currentLocate){
		this.currentLocate = currentLocate;
	}
	
	public GoodsState getGoodsState(){
		return state;
	}
	public void setGoodsState(GoodsState state){
		this.state = state;
	}
	
	public int getGoodsWeight(){
		return weightOfGoods;
	}
	public void setGoodsWeight(int weightOfGoods){
		this.weightOfGoods = weightOfGoods;
	}
	
	public int getGoodsVolume(){
		return volumeOfGoods;
	}
	public void setGoodsVolume(int volumeOfGoods){
		this.volumeOfGoods = volumeOfGoods;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
