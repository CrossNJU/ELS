package org.cross.elsclient.dataservice.organizationdataservice;

import java.util.ArrayList;

import org.cross.elsclient.po.OrganizationPO;
import org.cross.elsclient.util.OrganizationType;
import org.cross.elsclient.util.ResultMessage;

public class OrganizationDataService_Stub implements OrganizationDataService{

	@Override
	public void insert(OrganizationPO po) {
		System.out.println("Insert Succeed!\n");
		
	}

	@Override
	public void delete(OrganizationPO po) {
		System.out.println("Delete Succeed!\n");
	}

	@Override
	public void update(OrganizationPO po) {
		System.out.println("Update Succeed!\n");
	}

	@Override
	public ArrayList<OrganizationPO> findByCity(String city) {
		System.out.println("FindByCity Succeed!\n");
		ArrayList<OrganizationPO> list = new ArrayList<OrganizationPO>();
		list.add(new OrganizationPO(city, OrganizationType.BUSINESSHALL, "001"));
		return list;
	}

	@Override
	public ArrayList<OrganizationPO> findByType(OrganizationType type) {
		System.out.println("FindByType Succeed!\n");
		ArrayList<OrganizationPO> list = new ArrayList<OrganizationPO>();
		list.add(new OrganizationPO("北京", type, "001"));
		return list;
	}

	@Override
	public ArrayList<OrganizationPO> findById(String id) {
		System.out.println("FindById Succeed!\n");
		ArrayList<OrganizationPO> list = new ArrayList<OrganizationPO>();
		list.add(new OrganizationPO("北京", OrganizationType.BUSINESSHALL, id));
		return list;
	}

	@Override
	public ArrayList<OrganizationPO> show() {
		System.out.println("Show Succeed!\n");
		ArrayList<OrganizationPO> list = new ArrayList<OrganizationPO>();
		list.add(new OrganizationPO("北京", OrganizationType.BUSINESSHALL, "001"));
		return list;
	}

}