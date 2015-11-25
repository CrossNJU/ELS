package org.cross.elsclient.test;

import java.rmi.RemoteException;

import org.cross.elsclient.blimpl.blUtility.OrganizationInfo;
import org.cross.elsclient.blimpl.organizationblimpl.OrganizationBLImpl;
import org.cross.elsclient.blimpl.organizationblimpl.OrganizationInfoImpl;
import org.cross.elsclient.network.Datafactory;
import org.cross.elscommon.dataservice.datafactoryservice.DataFactoryService;

public class OrganizationBLTest {
	public static void main(String[] args) throws RemoteException{
		DataFactoryService dataFactory = new Datafactory();
		OrganizationInfo orgInfo = new OrganizationInfoImpl();
		OrganizationBLImpl orgBLImpl = new OrganizationBLImpl(dataFactory.getOrganizationData(), orgInfo);
	}

}
