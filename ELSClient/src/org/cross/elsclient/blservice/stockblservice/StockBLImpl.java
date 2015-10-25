package org.cross.elsclient.blservice.stockblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.dataservice.stockdataservice.StockDataService;
import org.cross.elsclient.po.StockPO;
import org.cross.elsclient.util.CompareTime;
import org.cross.elsclient.util.ResultMessage;
import org.cross.elsclient.util.StockType;
import org.cross.elsclient.vo.StockAreaVO;
import org.cross.elsclient.vo.StockOperationVO;
import org.cross.elsclient.vo.StockVO;

public class StockBLImpl implements StockBLService{
	
	StockVO stockvo;
	StockPO stockpo;
	StockDataService stockData;
	String stockManager;
	
	public StockBLImpl(StockDataService stockdata){
		this.stockData = stockdata;
		this.stockManager = null;
	}
	
	@Override
	public ArrayList<StockVO> showStockCheck() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<StockOperationVO> showStockInfo(String time1, String time2) {
		ArrayList<StockOperationVO> ops = new ArrayList<StockOperationVO>();
		for (int i = 0; i < stockvo.stockOperations.size(); i++) {
			StockOperationVO vo = stockvo.stockOperations.get(i);
			if(CompareTime.compare(vo.time, time1)==1 || 
					CompareTime.compare(time2, vo.time)==1){
				ops.add(vo);
			}
		}
		return ops;
	}

	@Override
	public StockVO findStock(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		stockpo = stockData.findStock(ID);
		return stockpo.toVO();
	}

	@Override
	public ResultMessage exportStockCheck() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage stockEnough(StockType type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StockAreaVO stockCapacity(StockType type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage checkGoods(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage intoStock(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage outStock(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
