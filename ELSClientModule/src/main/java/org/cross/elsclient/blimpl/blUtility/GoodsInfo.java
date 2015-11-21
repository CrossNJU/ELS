package org.cross.elsclient.blimpl.blUtility;

import java.util.ArrayList;

import org.cross.elsclient.vo.GoodsVO;
import org.cross.elsclient.vo.HistoryVO;
import org.cross.elscommon.po.GoodsPO;
import org.cross.elscommon.po.HistoryPO;

public interface GoodsInfo {
	public GoodsVO toGoodsVO(GoodsPO po);
	
	public ArrayList<HistoryVO> toHistroyVO(ArrayList<HistoryPO> po);
	
	public GoodsPO toGoodsPO(GoodsVO vo);
	
	public HistoryPO toHistroyPO(HistoryVO vo);
}