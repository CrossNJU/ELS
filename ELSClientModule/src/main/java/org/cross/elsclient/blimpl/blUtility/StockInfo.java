package org.cross.elsclient.blimpl.blUtility;

import org.cross.elsclient.vo.StockAreaVO;
import org.cross.elsclient.vo.StockOperationVO;
import org.cross.elsclient.vo.StockVO;
import org.cross.elscommon.po.StockAreaPO;
import org.cross.elscommon.po.StockOperationPO;
import org.cross.elscommon.po.StockPO;

public interface StockInfo {
	public StockVO toStockVO(StockPO po);
	
	public StockPO toStockPO(StockVO vo);
	
	public StockAreaVO toStockAreaVO(StockAreaPO po);
	
	public StockAreaPO toStockAreaPO(StockAreaVO vo);
	
	public StockOperationVO toStockOperationVO(StockOperationPO po);

	public StockOperationPO toStockOperationPO(StockOperationVO vo);
}
