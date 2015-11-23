package org.cross.elsclient.blimpl.blUtility;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.vo.GoodsVO;
import org.cross.elsclient.vo.HistoryVO;
import org.cross.elscommon.po.GoodsPO;
import org.cross.elscommon.po.HistoryPO;
import org.cross.elscommon.util.ResultMessage;

public interface GoodsInfo {
	public GoodsVO toGoodsVO(GoodsPO po);

	public HistoryVO toHistroyVO(HistoryPO po);

	public GoodsPO toGoodsPO(GoodsVO vo);

	public HistoryPO toHistroyPO(HistoryVO vo);

	public ArrayList<GoodsVO> findByStockAreaNum(String stockAreaNum) throws RemoteException;

	/**
	 * 根据单号查快件
	 * 
	 * @throws RemoteException
	 */
	public GoodsVO searchGoods(String goodsID) throws RemoteException;

	/**
	 * 把快件更新到stockArea中
	 * 
	 * @throws RemoteException
	 */
	public ResultMessage updateToArea(String goodsID, String stockNum, String stockAreaNum) throws RemoteException;

	/**
	 * 从仓库中删除快件
	 * 
	 * @throws RemoteException
	 */
	public ResultMessage deleteFromStock(String goodsID) throws RemoteException;

	/**
	 * 查找快件所在的stockArea编号
	 * 
	 * @throws RemoteException
	 */
	public String findStockAreaNum(String goodsID) throws RemoteException;

	/**
	 * goods中设置orderNum
	 * 
	 * @param goodsNum
	 * @param orderNum
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage addToOrder(String goodsNum, String orderNum) throws RemoteException;

	public ResultMessage deleteFromOrder(String goodsNum) throws RemoteException;

	public ResultMessage addToTrans(String goodsNum, String transNum) throws RemoteException;
	public ResultMessage deleteFromTrans(String goodsNum) throws RemoteException;

	public ResultMessage addToArri(String goodsNum, String arriNum) throws RemoteException;
	public ResultMessage deleteFromArri(String goodsNum) throws RemoteException;
}
