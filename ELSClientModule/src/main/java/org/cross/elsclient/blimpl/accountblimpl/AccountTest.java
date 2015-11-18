package org.cross.elsclient.blimpl.accountblimpl;

import static org.junit.Assert.*;

import org.cross.elsclient.vo.AccountVO;
import org.cross.elscommon.util.ResultMessage;
import org.junit.Test;

public class AccountTest {

	@Test
	public void testAccount() {
		Account account = new Account();
		assertEquals(ResultMessage.SUCCESS, account.createLog("2015/11/16 add an account"));
		
		assertEquals(ResultMessage.SUCCESS, account.add(new AccountVO("cch", "809382873637484", 20000)));
	}

}
