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
import org.cross.elscommon.util.OrganizationType;
import org.cross.elscommon.util.StockType;

public class GoodsPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 快件类型
	 */
	private StockType goodsType;

	/**
	 * 快件编号
	 */
	private String number;

	/**
	 * 当前位置,城市
	 */
	private City placeCity;

	/**
	 * 当前位置,机构
	 */
	private OrganizationType placeOrg;

	/**
	 * 状态
	 */
	private GoodsState state;

	/**
	 * 实际重量
	 */
	private int weight;

	/**
	 * 体积
	 */
	private int volume;

	/**
	 * 历史轨迹
	 */
	private ArrayList<HistoryPO> history;

	// 不知道要不要
	/**
	 * 订单编号
	 */
	private String orderNum;

	/**
	 * 构造方法
	 * 
	 * @param goodsType
	 * @param number
	 * @param placeCity
	 * @param placeOrg
	 * @param state
	 * @param weight
	 * @param volume
	 * @param history
	 */
	public GoodsPO(StockType goodsType, String number, City placeCity, OrganizationType placeOrg, int weight,
			int volume) {
		super();
		this.goodsType = goodsType;
		this.number = number;
		this.placeCity = placeCity;
		this.placeOrg = placeOrg;
		this.weight = weight;
		this.volume = volume;

		this.state = GoodsState.LIVE;
		this.history = new ArrayList<HistoryPO>();
	}

	public StockType getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(StockType goodsType) {
		this.goodsType = goodsType;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public City getPlaceCity() {
		return placeCity;
	}

	public void setPlaceCity(City placeCity) {
		this.placeCity = placeCity;
	}

	public OrganizationType getPlaceOrg() {
		return placeOrg;
	}

	public void setPlaceOrg(OrganizationType placeOrg) {
		this.placeOrg = placeOrg;
	}

	public GoodsState getState() {
		return state;
	}

	public void setState(GoodsState state) {
		this.state = state;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public ArrayList<HistoryPO> getHistory() {
		return history;
	}

	public void addHistory(HistoryPO newhistory) {
		this.history.add(newhistory);
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

}
