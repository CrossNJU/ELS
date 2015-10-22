package org.cross.elsclient.blservice.organizationblservice;

import java.util.ArrayList;

import org.cross.elsclient.util.OrganizationType;
import org.cross.elsclient.util.ResultMessage;
import org.cross.elsclient.vo.OrganizationVO;

public class OrganizationBlservice_Stub implements OrganizationBLService {

	@Override
	public ResultMessage add(OrganizationVO vo) {
		if(vo.city.equals("北京") && vo.type == OrganizationType.BUSINESSHALL){
			return ResultMessage.FAILED;
		}
		return ResultMessage.SUCCESS;
		
	}

	@Override
	public ResultMessage delete(OrganizationVO vo) {
		return ResultMessage.SUCCESS;
		
		}

	@Override
	public ResultMessage update(OrganizationVO vo) {
		if(vo.city.equals("北京") && vo.type == OrganizationType.BUSINESSHALL){
			return ResultMessage.FAILED;
		}
		
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<OrganizationVO> show() {
		ArrayList<OrganizationVO> list = new ArrayList<OrganizationVO>();
		list.add(new OrganizationVO("北京", OrganizationType.BUSINESSHALL,"001" ));
		list.add(new OrganizationVO("上海", OrganizationType.TRANSITCENTER,"002" ));
		list.add(new OrganizationVO("广州", OrganizationType.TRANSITCENTER,"003" ));
		list.add(new OrganizationVO("南京", OrganizationType.TRANSITCENTER,"004" ));
		return list;
	}

	@Override
	public ArrayList<OrganizationVO> findByCity(String city) {
		ArrayList<OrganizationVO> list = new ArrayList<OrganizationVO>();
		list.add(new OrganizationVO(city, OrganizationType.BUSINESSHALL,"001" ));
		return list;
	}

	@Override
	public ArrayList<OrganizationVO> findByType(OrganizationType type) {
		ArrayList<OrganizationVO> list = new ArrayList<OrganizationVO>();
		list.add(new OrganizationVO("北京", type ,"001" ));
		return list;
	}

	@Override
	public ArrayList<OrganizationVO> findById(String id) {
		ArrayList<OrganizationVO> list = new ArrayList<OrganizationVO>();
		list.add(new OrganizationVO("北京", OrganizationType.BUSINESSHALL ,id ));
		return list;
	}

	@Override
	public int showDistance(OrganizationVO vo1, OrganizationVO vo2) {
		// TODO Auto-generated method stub
		return 30;
	}

}
