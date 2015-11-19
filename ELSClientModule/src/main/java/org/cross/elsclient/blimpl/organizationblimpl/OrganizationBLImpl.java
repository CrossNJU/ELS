package org.cross.elsclient.blimpl.organizationblimpl;

import java.util.ArrayList;

import org.cross.elsclient.blimpl.blUtility.OrganizationInfo;
import org.cross.elsclient.blservice.organizationblservice.OrganizationBLService;
import org.cross.elsclient.vo.OrganizationVO;
import org.cross.elscommon.dataservice.organizationdataservice.OrganizationDataService_Stub;
import org.cross.elscommon.po.OrganizationPO;
import org.cross.elscommon.util.City;
import org.cross.elscommon.util.OrganizationType;
import org.cross.elscommon.util.ResultMessage;

public class OrganizationBLImpl implements OrganizationBLService,OrganizationInfo{

	public OrganizationDataService_Stub organizationData;
	
	public OrganizationBLImpl(OrganizationDataService_Stub organizationData){
		this.organizationData = organizationData;
	}
	
	@Override
	public ResultMessage add(OrganizationVO vo) {
		OrganizationPO po = toOrganizationPO(vo);
		return organizationData.insert(po);
	}

	@Override
	public ResultMessage delete(OrganizationVO vo) {
		OrganizationPO po = toOrganizationPO(vo);
		return organizationData.delete(po);
	}

	@Override
	public ResultMessage update(OrganizationVO vo) {
		OrganizationPO po = toOrganizationPO(vo);
		return organizationData.update(po) ;
	}

	@Override
	public ArrayList<OrganizationVO> show() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrganizationVO> findByCity(City city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrganizationVO> findByType(OrganizationType type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrganizationVO> findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int showDistance(OrganizationVO vo1, OrganizationVO vo2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public OrganizationVO toOrganizationVO(OrganizationPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrganizationPO toOrganizationPO(OrganizationVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
