/**
 * 快件信息管理
 * @author danni
 * @date 2015/10/19
 */
package org.cross.elsclient.blservice.goodsblservice;

import org.cross.elsclient.util.ResultMessage;
import org.cross.elsclient.vo.GoodsVO;

public interface GoodsBLService {
	/**
	 * 增加快件信息
	 * @param goods
	 * @return 是否增加成功
	 */
	public ResultMessage addGoods(GoodsVO goods);
	
	/**
	 * 删除快件信息
	 * @param goods
	 * @return 是否删除成功
	 */
	public ResultMessage deleteGoods(GoodsVO goods);
	
	/**
	 * 更改快件信息
	 * @param goods
	 * @return 是否更新成功
	 */
	public ResultMessage updateGoods(GoodsVO goods);
	
	/**
	 * 查询快件信息
	 * @param id
	 * @return 快件信息
	 */
	public GoodsVO requireGoods(String id);

}
