/**
 * 仓库管理数据接口的驱动程序
 * @author danni
 * @date 2015/10/22
 */
package org.cross.elsclient.dataservice.stockdataservice;

import java.rmi.RemoteException;

import org.cross.elsclient.po.StockPO;
import org.omg.CORBA.PUBLIC_MEMBER;

public class StockDataService_Driver {
	public void driver(StockDataService stockDataService) throws RemoteException{
		
		StockPO stockPO = new StockPO("S00001",30);
		
		System.out.println("增加仓库");
		stockDataService.insert(stockPO);
		
		System.out.println("删除仓库");
		stockDataService.delete(stockPO);
		
		System.out.println("更新仓库");
		stockDataService.update(stockPO);
		
		System.out.println("显示仓库信息");
		stockDataService.show();
		
		System.out.println("模糊查找快件");
		stockDataService.find("63247893");
		
	}

}
