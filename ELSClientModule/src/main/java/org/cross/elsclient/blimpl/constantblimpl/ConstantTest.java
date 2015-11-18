package org.cross.elsclient.blimpl.constantblimpl;

import static org.junit.Assert.*;

import org.cross.elscommon.util.ResultMessage;
import org.junit.Test;

public class ConstantTest {
	@Test
	public void testContanst(){
		Constant constant = new Constant();
		assertEquals(ResultMessage.SUCCESS,constant.createLog("2015/11/16 add constants"));
	}

}
