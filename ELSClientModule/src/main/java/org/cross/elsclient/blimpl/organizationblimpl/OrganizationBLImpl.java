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

public class OrganizationBLImpl implements OrganizationBLService{

	public OrganizationDataService_Stub organizationData;
	public OrganizationInfo organizationInfo;
	
	public OrganizationBLImpl(OrganizationDataService_Stub organizationData,OrganizationInfo organizationInfo){
		this.organizationData = organizationData;
		this.organizationInfo = organizationInfo;
	}
	
	@Override
	public ResultMessage add(OrganizationVO vo) {
		OrganizationPO po = organizationInfo.toOrganizationPO(vo);
		return organizationData.insert(po);
	}

	@Override
	public ResultMessage delete(OrganizationVO vo) {
		OrganizationPO po = organizationInfo.toOrganizationPO(vo);
		return organizationData.delete(po);
	}

	@Override
	public ResultMessage update(OrganizationVO vo) {
		OrganizationPO po = organizationInfo.toOrganizationPO(vo);
		return organizationData.update(po) ;
	}

	@Override
	public ArrayList<OrganizationVO> show() {
		ArrayList<OrganizationVO> vos = new ArrayList<OrganizationVO>();
		ArrayList<OrganizationPO> pos = organizationData.show();
		int size = pos.size();
		for (int i = 0; i < size; i++) {
			vos.add(organizationInfo.toOrganizationVO(pos.get(i)));
		}
		return vos;
	}

	@Override
	public ArrayList<OrganizationVO> findByCity(City city) {
		ArrayList<OrganizationVO> vos = new ArrayList<OrganizationVO>();
		ArrayList<OrganizationPO> pos = organizationData.findByCity(city);
		int size = pos.size();
		for (int i = 0; i < size; i++) {
			vos.add(organizationInfo.toOrganizationVO(pos.get(i)));
		}
		return vos;
	}

	@Override
	public ArrayList<OrganizationVO> findByType(OrganizationType type) {
		ArrayList<OrganizationVO> vos = new ArrayList<OrganizationVO>();
		ArrayList<OrganizationPO> pos = organizationData.findByType(type);
		int size = pos.size();
		for (int i = 0; i < size; i++) {
			vos.add(organizationInfo.toOrganizationVO(pos.get(i)));
		}
		return vos;
	}

	@Override
	public ArrayList<OrganizationVO> findById(String id) {
		ArrayList<OrganizationVO> vos = new ArrayList<OrganizationVO>();
		ArrayList<OrganizationPO> pos = organizationData.findById(id);
		int size = pos.size();
		for (int i = 0; i < size; i++) {
			vos.add(organizationInfo.toOrganizationVO(pos.get(i)));
		}
		return vos;
	}

	@Override
	public int showDistance(OrganizationVO vo1, OrganizationVO vo2) {
		int distance = 0;
		
		return distance;
	}
}
