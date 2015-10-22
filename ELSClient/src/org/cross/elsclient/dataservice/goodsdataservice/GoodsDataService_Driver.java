/**
 * 快件管理数据接口的驱动程序
 * @author danni
 * @date 2015/10/22
 */
package org.cross.elsclient.dataservice.goodsdataservice;

import java.rmi.RemoteException;

import org.cross.elsclient.po.GoodsPO;

public class GoodsDataService_Driver {
	public void driver(GoodsDataService goodsDataService) throws RemoteException{
		
		GoodsPO goods = new GoodsPO(45, 43, "南大仙林校区");
		
		System.out.println("更新快件信息");
		goodsDataService.update(goods);
		
		System.out.println("按编号查找并显示快件信息");
		goodsDataService.show(goods.getOrderPO().getNumber());
	}

}
