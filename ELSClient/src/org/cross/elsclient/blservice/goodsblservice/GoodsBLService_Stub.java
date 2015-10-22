/**
 * 快件信息管理的桩程序
 * @author danni
 * @date 2015/10/20
 */
package org.cross.elsclient.blservice.goodsblservice;

import java.util.ArrayList;

import org.cross.elsclient.util.GoodsState;
import org.cross.elsclient.util.ResultMessage;
import org.cross.elsclient.vo.GoodsVO;

public class GoodsBLService_Stub implements GoodsBLService{

	@Override
	public ResultMessage updateGoodsLocate(GoodsVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GoodsVO findGoods(String id) {
		// TODO Auto-generated method stub
		GoodsVO goods = new GoodsVO(33, 50,"南大仙林校区");
		return goods;
	}
	
}
