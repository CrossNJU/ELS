package org.cross.elsclient.blimpl.blUtility;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.vo.GoodsVO;
import org.cross.elsclient.vo.HistoryVO;
import org.cross.elscommon.po.GoodsPO;
import org.cross.elscommon.po.HistoryPO;

public interface GoodsInfo {
	public GoodsVO toGoodsVO(GoodsPO po);
	
	public HistoryVO toHistroyVO(HistoryPO po);
	
	public GoodsPO toGoodsPO(GoodsVO vo);
	
	public HistoryPO toHistroyPO(HistoryVO vo);
	
	/**
	 *根据单号查快件
	 * @throws RemoteException 
	 */
	public GoodsVO searchGoods(String goodsID) throws RemoteException;
}
