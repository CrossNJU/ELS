package org.cross.elsserver.dataTest;

import java.rmi.RemoteException;

import org.cross.elsserver.dataimpl.goodsdataimpl.GoodsDataImpl;
import org.cross.elsserver.dataimpl.goodsdataimpl.GoodsInfoImpl;
import org.cross.elsserver.dataimpl.goodsdataimpl.HistoryDataImpl;
import org.cross.elsserver.dataimpl.stockdataimpl.StockDataImpl;
import org.cross.elsserver.dataimpl.tools.GoodsTool;
import org.cross.elsserver.dataimpl.tools.HistoryTool;

public class TestStock {
	public static void main(String[] args) throws RemoteException{
		GoodsTool goodsTool = new GoodsInfoImpl();
		StockDataImpl impl = new StockDataImpl(goodsTool);
		
	}
}
