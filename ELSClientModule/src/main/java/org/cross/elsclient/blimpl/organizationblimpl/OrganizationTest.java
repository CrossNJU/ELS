package org.cross.elsclient.blimpl.organizationblimpl;

import static org.junit.Assert.*;

import org.cross.elscommon.util.ResultMessage;
import org.junit.Test;

public class OrganizationTest {
	@Test
	public void testOrganziation(){
		Organization organization = new Organization();
		assertEquals(ResultMessage.SUCCESS,organization.createLog("2015/11/16 add an organization"));
	}
}
