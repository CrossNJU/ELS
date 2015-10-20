/**
 * 仓库管理数据接口
 * @author danni
 * @date 2015/10/19
 */
package org.cross.elsclient.dataservice.stockdataservice;

import java.util.ArrayList;

import org.cross.elsclient.po.StockPO;
import org.cross.elsclient.vo.StockInfoVO;
import org.cross.elsclient.vo.StockVO;

public interface StockDataService {
	
	public void insert(StockPO stock);
	
	public ArrayList<StockInfoVO> showStockInfo(String time1,String time2);
	
	public boolean stockEnough(StockPO stock);
	
	public double stockCapacity(StockPO stock);
	
	public boolean checkGoods(StockPO stock);
}
