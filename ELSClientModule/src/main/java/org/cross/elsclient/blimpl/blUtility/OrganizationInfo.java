package org.cross.elsclient.blimpl.blUtility;

import org.cross.elsclient.vo.OrganizationVO;
import org.cross.elscommon.po.OrganizationPO;

public interface OrganizationInfo {

	public OrganizationVO toOrganizationVO(OrganizationPO po);
	
	public OrganizationPO toOrganizationPO(OrganizationVO vo);
	
}
