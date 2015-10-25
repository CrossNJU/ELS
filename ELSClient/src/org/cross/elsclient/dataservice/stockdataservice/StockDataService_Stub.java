package org.cross.elsclient.dataservice.stockdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.po.StockOperationPO;
import org.cross.elsclient.po.StockPO;
import org.cross.elsclient.util.ResultMessage;

public class StockDataService_Stub implements StockDataService{

	@Override
	public ResultMessage insert(StockPO po) {
		// TODO Auto-generated method stub
		System.out.println("~~~insert successfully~~~");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage delete(StockPO po) {
		// TODO Auto-generated method stub
		System.out.println("~~~delete successfully~~~");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage update(StockPO po) {
		// TODO Auto-generated method stub
		System.out.println("~~~update successfully~~~");
		return ResultMessage.SUCCESS;
	}

	@Override
	public boolean find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public ArrayList<StockOperationPO> show(String startTime, String endTime) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StockPO findStock(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
