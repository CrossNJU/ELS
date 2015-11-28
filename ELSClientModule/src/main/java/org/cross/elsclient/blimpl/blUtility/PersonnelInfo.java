package org.cross.elsclient.blimpl.blUtility;

import org.cross.elsclient.vo.PersonnelVO;
import org.cross.elscommon.po.PersonnelPO;

public interface PersonnelInfo {
	
	public PersonnelVO toPersonnelVO(PersonnelPO po);
	
	public PersonnelPO toPersonnelPO(PersonnelVO vo);
	
}
