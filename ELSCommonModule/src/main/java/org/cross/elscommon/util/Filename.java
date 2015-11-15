package org.cross.elscommon.util;

public enum Filename {
	HISTORYPO, GOODSPO, RECEIPTPO, STOCKPO;
	public String toString(){
		switch (this) {
		case HISTORYPO:	
			return "HistoryPO.ser";
		case GOODSPO:
			return "GoodsPO.ser";
		case RECEIPTPO:
			return "ReceiptPO.ser";
		case STOCKPO:
			return "StockPO.ser";
		default:
			return null;
		}
	}
}
