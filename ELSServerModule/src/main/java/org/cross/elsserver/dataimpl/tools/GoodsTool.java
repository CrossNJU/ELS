package org.cross.elsserver.dataimpl.tools;

import java.util.ArrayList;

import org.cross.elscommon.po.GoodsPO;

public interface GoodsTool {
	public void addToStock(String number, String stockAreaNum);
	public void deleteFromStock(String number);
	public ArrayList<GoodsPO> findByStockAreaNum(String stockAreaNum);
}
