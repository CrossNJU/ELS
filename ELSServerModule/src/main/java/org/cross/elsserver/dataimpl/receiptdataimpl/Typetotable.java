package org.cross.elsserver.dataimpl.receiptdataimpl;

import org.cross.elscommon.util.ReceiptType;

public class Typetotable {
	public static String gettable(ReceiptType type){
		switch (type) {
		case ORDER:	
			return "receiptOrder";
		default:
			return null;
		}
	}
}
