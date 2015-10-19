/**
 * 库存管理装程序
 */
package org.cross.elsclient.blservice.stockblservice;

import java.util.ArrayList;

import org.cross.elsclient.util.ResultMessage;
import org.cross.elsclient.vo.StockCapacityVO;
import org.cross.elsclient.vo.StockInfoVO;
import org.cross.elsclient.vo.StockVO;

public class StockBLService_Stub implements StockBLService{

	@Override
	public ArrayList<StockVO> showStockCheck() {
		ArrayList<StockVO> list = new ArrayList<StockVO>();
		list.add(new StockVO("特快"));
		return list;
	}

	@Override
	public ArrayList<StockInfoVO> showStockInfo(String time1, String time2) {
		ArrayList<StockInfoVO> list = new ArrayList<StockInfoVO>();
		list.add(new StockInfoVO());
		return list;
	}

	@Override
	public ResultMessage exportStockCheck() {
		return ResultMessage.SUCCESS;
	}

	@Override
	public boolean stockEnough(String stockType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<StockCapacityVO> stockCapacity(String stockType) {
		ArrayList<StockCapacityVO> list = new ArrayList<StockCapacityVO>();
		return list;
	}

	@Override
	public ResultMessage checkGoods(StockVO stock) {
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

}
