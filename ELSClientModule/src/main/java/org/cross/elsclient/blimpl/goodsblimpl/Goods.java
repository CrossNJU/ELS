package org.cross.elsclient.blimpl.goodsblimpl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.accountblimpl.MockLog;
import org.cross.elsclient.vo.HistoryVO;
import org.cross.elscommon.util.GoodsState;
import org.cross.elscommon.util.ResultMessage;

public class Goods {

	public ResultMessage updateGoods(String id, HistoryVO nowHistory,
			GoodsState nowState) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<HistoryVO> findGoods(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ResultMessage createLog(String log){
		MockLog mockLog = new MockLog(log);
		return mockLog.createLog();
	}

}
