package org.cross.elsclient.blimpl.organizationblimpl;

import org.cross.elsclient.blimpl.blUtility.OrganizationInfo;
import org.cross.elsclient.vo.OrganizationVO;
import org.cross.elscommon.po.OrganizationPO;

public class OrganizationInfoImpl implements OrganizationInfo{
	
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
