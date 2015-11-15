package org.cross.elsserver.dataimpl.stockdataimpl;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import org.cross.elscommon.dataservice.stockdataservice.StockDataService;
import org.cross.elscommon.po.StockOperationPO;
import org.cross.elscommon.po.StockPO;
import org.cross.elscommon.util.Filename;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.SerIO;

public class StockDataImpl extends UnicastRemoteObject implements StockDataService,Serializable{
	public StockDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<StockPO> stockList;
	static String filename = Filename.STOCKPO.toString();
	
	@SuppressWarnings("unchecked")
	@Override
	public ResultMessage insert(StockPO po) throws RemoteException {
		// TODO Auto-generated method stub
		stockList = (ArrayList<StockPO>)SerIO.readPO(filename);
//		System.out.println("in");
		if(stockList==null) stockList = new ArrayList<StockPO>();
		stockList.add(po);
		SerIO.writePO(stockList, filename);
//		stockList = (ArrayList<StockPO>)SerIO.readPO("StockPO.ser");
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ResultMessage delete(String id) throws RemoteException {
		// TODO Auto-generated method stub
		stockList = (ArrayList<StockPO>)SerIO.readPO(filename);
		for (int i = 0; i < stockList.size(); i++) {
			if (stockList.get(i).getStockID().equals(id)) {
				stockList.remove(i);
				return ResultMessage.SUCCESS;
			}
		}
		return ResultMessage.FAILED;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ResultMessage update(StockPO stocks) throws RemoteException {
		// TODO Auto-generated method stub
		stockList = (ArrayList<StockPO>)SerIO.readPO(filename);
		if (stockList == null) {
			stockList = new ArrayList<StockPO>();
		}
		int find = -1;
		for (int i = 0; i < stockList.size(); i++) {
			if (stocks.getStockID().equals(stockList.get(i).getStockID())) {
				find = i;
				break;
			}
		}
		if (find >= 0) {
			stockList.remove(find);
			stockList.add(stocks);
		}else {
//			stockList.add(stocks);
			return ResultMessage.FAILED;
		}
		SerIO.writePO(stockList, filename);
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<StockOperationPO> show(String startTime, String endTime)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public StockPO findStock(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		stockList = (ArrayList<StockPO>)SerIO.readPO("StockPO.ser");
		for (int i = 0; i < stockList.size();i++) {
			if (stockList.get(i).getStockID().equals(ID)) {
				return stockList.get(i);
			}
		}
		return null;
	}

	@Override
	public boolean find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

}
