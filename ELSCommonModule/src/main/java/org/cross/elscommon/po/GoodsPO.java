/**
 * 快件PO类
 * @author danni
 * @date 2015/10/24
 */
package org.cross.elscommon.po;

import java.io.Serializable;
import java.util.ArrayList;

import org.cross.elscommon.util.City;
import org.cross.elscommon.util.GoodsState;
import org.cross.elscommon.util.StockType;

public class GoodsPO implements Serializable{
	/**
	 * 序列化UID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 快件类型
	 */
	private StockType goodsType;

	/**
	 * 历史轨迹
	 */
	private ArrayList<HistoryPO> historyPO;
	
	/**
	 * 订单
	 */
	private String orderNumber;
	
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
	public GoodsPO(int weight,int volum,City currentLocate,StockType goodsType){
		this.weightOfGoods = weight;
		this.volumeOfGoods = volum;
		this.currentLocate = currentLocate;
		this.goodsType = goodsType;
		
		this.state = GoodsState.LIVE;
		this.historyPO = new ArrayList<HistoryPO>();
	}
	
	/**
	 * get&set
	 */
	public ArrayList<HistoryPO> getHistoryPO(){
		return historyPO;
	}
	public StockType getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(StockType goodsType) {
		this.goodsType = goodsType;
	}

	public void setHistoryPO(HistoryPO histroyPO){
		this.historyPO.add(histroyPO);
	}
	
	public String getOrderNumber(){
		return orderNumber;
	}
	public void setOrderNumber(String order){
		this.orderNumber = order;
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


