package org.cross.elsclient.blimpl.goodsblimpl;

import static org.junit.Assert.*;

import org.cross.elscommon.util.ResultMessage;
import org.junit.Test;

public class GoodsTest {
	@Test
	public void testGoods(){
		Goods goods = new Goods();
		assertEquals(ResultMessage.SUCCESS,goods.createLog("2015/11/16 add an goods"));
	}
}
