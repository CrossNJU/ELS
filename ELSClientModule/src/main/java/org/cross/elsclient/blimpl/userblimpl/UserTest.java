package org.cross.elsclient.blimpl.userblimpl;

import static org.junit.Assert.assertEquals;

import org.cross.elscommon.util.ResultMessage;
import org.junit.Test;

public class UserTest {
	@Test
	public void testUser(){
		User user = new User();
		assertEquals(ResultMessage.SUCCESS,user.createLog("2015/11/16 add an user"));
	}


}
