package org.cross.elsclient.dataservice.organizationdataservice;

import org.cross.elsclient.po.OrganizationPO;
import org.cross.elsclient.util.OrganizationType;

public class OrganizationDataService_Driver {
	
	public void drive(OrganizationDataService_Stub organizationDataService_Stub){
		
		organizationDataService_Stub.insert(new OrganizationPO("北京", OrganizationType.BUSINESSHALL, "001"));
		organizationDataService_Stub.delete(new OrganizationPO("北京", OrganizationType.BUSINESSHALL, "001"));
		organizationDataService_Stub.update(new OrganizationPO("北京", OrganizationType.BUSINESSHALL, "001"));
		organizationDataService_Stub.findByCity("北京");
		organizationDataService_Stub.findById("001");
		organizationDataService_Stub.findByType(OrganizationType.BUSINESSHALL);
		organizationDataService_Stub.show();
		
	}
}
