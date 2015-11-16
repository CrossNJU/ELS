package org.cross.elsclient.blimpl.receiptblimpl;

import static org.junit.Assert.*;

import org.cross.elsclient.vo.PersonnelVO;
import org.cross.elsclient.vo.Receipt_MoneyInVO;
import org.cross.elsclient.vo.Receipt_OrderVO;
import org.cross.elscommon.util.OrganizationType;
import org.cross.elscommon.util.PositionType;
import org.cross.elscommon.util.ResultMessage;
import org.junit.Test;

public class ReceiptTest {

	@Test
	public void testReceipt() {
		Receipt receipt = new Receipt();
		PersonnelVO person = new PersonnelVO("P00001", "cch", PositionType.BUSINESSHALLCLERK, 
				OrganizationType.BUSINESSHALL, "O00001");
		
		assertEquals(ResultMessage.SUCCESS, receipt.add("P00001", 
				new Receipt_MoneyInVO("2015-10-25 01:10:10", 2000, person, "R120151023000001")));
		
		assertEquals(ResultMessage.SUCCESS, receipt.update(
				new Receipt_OrderVO("R120151023000001", "2015-10-25 01:10:10")));
		
		assertEquals(ResultMessage.SUCCESS, "");
	}

}
