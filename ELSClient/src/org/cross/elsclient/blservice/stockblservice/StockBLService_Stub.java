/**
 * 库存管理桩程序
 * @author danni
 * @date 2015/10/21
 */
package org.cross.elsclient.blservice.stockblservice;

import java.util.ArrayList;

import org.cross.elsclient.util.ResultMessage;
import org.cross.elsclient.util.StockType;
import org.cross.elsclient.vo.StockAreaVO;
import org.cross.elsclient.vo.StockVO;

public class StockBLService_Stub implements StockBLService{

	@Override
	public ArrayList<StockVO> showStockCheck() {
		ArrayList<StockVO> list = new ArrayList<StockVO>();
		list.add(new StockVO("S00001",30));
		return list;
	}

	@Override
	public ArrayList<StockVO> showStockInfo(String time1, String time2) {
		ArrayList<StockVO> list = new ArrayList<StockVO>();
		list.add(new StockVO("S00001",30));
		return list;
	}

	@Override
	public ResultMessage exportStockCheck() {
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage stockEnough(StockType stockType) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage checkGoods(String id) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage intoStock(String id) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage outStock(String id) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public StockAreaVO stockCapacity(StockType type) {
		// TODO Auto-generated method stub
		return null;
	}
}
