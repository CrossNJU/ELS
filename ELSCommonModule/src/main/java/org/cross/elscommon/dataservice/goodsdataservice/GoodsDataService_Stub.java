/**
 * 快件管理数据接口的桩程序
 * @author danni
 * @date 2015/10/22
 */
package org.cross.elscommon.dataservice.goodsdataservice;

import org.cross.elscommon.po.GoodsPO;
import org.cross.elscommon.util.City;

public class GoodsDataService_Stub implements GoodsDataService{

	@Override
	public void update(GoodsPO goods) {
		// TODO Auto-generated method stub
		System.out.println("~~~update goodsPO successfully~~~");
		
	}

	@Override
	public GoodsPO show(String id) {
		// TODO Auto-generated method stub
		GoodsPO po = new GoodsPO(65, 17, City.NANJING);
		System.out.println("快件信息查看成功");
		return po;
	}

}
