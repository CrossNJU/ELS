/**
 * 库存管理业务逻辑接口
 * @author danni
 * @date 2015/10/19
 */
package org.cross.elsclient.blservice.stockblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StockType;
import org.cross.elsclient.vo.StockAreaVO;
import org.cross.elsclient.vo.StockOperationVO;
import org.cross.elsclient.vo.StockVO;

public interface StockBLService {
	
	/**
	 * 根据当前时间生成库存快照
	 * @return 该时间节点的库存快照信息
	 */
	public ArrayList<StockVO> showStockCheck();
	
	/**
	 * 库存查看
	 * @param time1
	 * @param time2
	 * @return 商品库存列表
	 */
	public ArrayList<StockOperationVO> showStockInfo(String time1,String time2);
	
	/**
	 * 寻找仓库
	 * @param ID
	 * @return 该仓库管理人员管理的仓库
	 * @throws RemoteException 
	 */
	public StockVO findStock(String ID) throws RemoteException;
	
	/**
	 * 导出库存盘点信息表格
	 * @return 是否导出成功
	 */
	public ResultMessage exportStockCheck();
	
	/**
	 * 查询特定仓库容量信息，包括总共、已用、已用占的百分比
	 * @param stock
	 * @return 特定仓库已用容量
	 * @throws RemoteException 
	 */
	public ArrayList<StockAreaVO> stockCapacity(String id,StockType type) throws RemoteException;
	
	/**
	 * 核实仓库中快件信息
	 * @param 快件id
	 * @return 快件是否在仓库中
	 * @throws RemoteException 
	 */
	public ResultMessage checkGoods(String goodsID,String stockID) throws RemoteException;
	
	/**
	 * 快件入库
	 * @param 快件id
	 * @return 是否入库称成功
	 * @throws RemoteException 
	 */
	public ResultMessage intoStock(String goodsID,String stockID) throws RemoteException;
	
	/**
	 * 快件出库
	 * @param 快件id
	 * @return 是否出库成功
	 * @throws RemoteException 
	 */
	public ResultMessage outStock(String goodsID,String stockID) throws RemoteException;
	
	/**
	 * 库存报警
	 */
	public ResultMessage stockAlert(String stockID,StockType stockType);
	
	/**
	 * 库存调整
	 */
	public ResultMessage stockAdjust(String stockID,StockType stockType);

}
