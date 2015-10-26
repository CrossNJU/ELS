/**
 * 快件信息管理
 * @author danni
 * @date 2015/10/19
 */
package org.cross.elsclient.blservice.goodsblservice;

import java.util.ArrayList;

import org.cross.elscommon.util.GoodsState;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elsclient.vo.GoodsVO;

public interface GoodsBLService {
//	/**	 增加快件信息
//	 * @return 是否增加成功
//	 */
//	public ResultMessage addGoods(GoodsVO goods);
	
//	/**
//	 * 删除快件信息
//	 * @param id
//	 * @return 是否删除成功
//	 */
//	public ResultMessage deleteGoods(String id);
	
	/**
	 * 更新快件信息
	 * @return 是否跟新成功（当前位置和状态）
	 */
	public ResultMessage updateGoodsLocate(GoodsVO vo);
	
//	/**
//	 * 更新快件状态信息
//	 * @param id
//	 * @param goodsState
//	 * @return 是否更新快件状态信息成功
//	 */
//	public ResultMessage updateGoodsState(String id,GoodsState state);
	
//	/**
//	 * 更新快件入库时间信息
//	 * @param id
//	 * @param inTime
//	 * @return 是否更新快件入库信息成功
//	 */
//	public ResultMessage updateGoodsInTime(String id,String inTime);
	
//	/**
//	 * 更新快件出库时间信息
//	 * @param id
//	 * @param outTime
//	 * @return 是否更新出库事件成功
//	 */
//	public ResultMessage updateGoodsOutTime(String id,String outTime);
	
	/**
	 * 查询快件信息
	 * @param id
	 * @return 快件信息
	 */
	public GoodsVO findGoods(String id);

}
