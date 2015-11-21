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
		ArrayList<OrganizationVO> vos = new ArrayList<OrganizationVO>();
		ArrayList<OrganizationPO> pos = organizationData.show();
		int size = pos.size();
		for (int i = 0; i < size; i++) {
			vos.add(toOrganizationVO(pos.get(i)));
		}
		return vos;
	}

	@Override
	public ArrayList<OrganizationVO> findByCity(City city) {
		ArrayList<OrganizationVO> vos = new ArrayList<OrganizationVO>();
		ArrayList<OrganizationPO> pos = organizationData.findByCity(city);
		int size = pos.size();
		for (int i = 0; i < size; i++) {
			vos.add(toOrganizationVO(pos.get(i)));
		}
		return vos;
	}

	@Override
	public ArrayList<OrganizationVO> findByType(OrganizationType type) {
		ArrayList<OrganizationVO> vos = new ArrayList<OrganizationVO>();
		ArrayList<OrganizationPO> pos = organizationData.findByType(type);
		int size = pos.size();
		for (int i = 0; i < size; i++) {
			vos.add(toOrganizationVO(pos.get(i)));
		}
		return vos;
	}

	@Override
	public ArrayList<OrganizationVO> findById(String id) {
		ArrayList<OrganizationVO> vos = new ArrayList<OrganizationVO>();
		ArrayList<OrganizationPO> pos = organizationData.findById(id);
		int size = pos.size();
		for (int i = 0; i < size; i++) {
			vos.add(toOrganizationVO(pos.get(i)));
		}
		return vos;
	}

	@Override
	public int showDistance(OrganizationVO vo1, OrganizationVO vo2) {
		int distance = 0;
		
		return distance;
	}

	@Override
	public OrganizationVO toOrganizationVO(OrganizationPO po) {
		OrganizationVO vo = new OrganizationVO(po.getCity(), po.getType(), po.getId());
		return vo;
	}

	@Override
	public OrganizationPO toOrganizationPO(OrganizationVO vo) {
		OrganizationPO po = new OrganizationPO(vo.city, vo.type, vo.id);
		return po;
	}

	
}
