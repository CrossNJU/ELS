package org.cross.elsclient.blimpl.personnelblimpl;

import static org.junit.Assert.*;

import org.cross.elscommon.util.ResultMessage;
import org.junit.Test;

public class PersonnelTest {
	@Test
	public void testPersonnel(){
		Personnel personnel = new Personnel();
		assertEquals(ResultMessage.SUCCESS,personnel.createLog("2015/11/16 add a personnel"));
		
	}
}
