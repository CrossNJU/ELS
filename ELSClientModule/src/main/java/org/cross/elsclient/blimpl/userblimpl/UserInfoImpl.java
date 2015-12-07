package org.cross.elsclient.blimpl.userblimpl;

import org.cross.elsclient.blimpl.blUtility.UserInfo;
import org.cross.elsclient.vo.UserVO;
import org.cross.elscommon.po.UserPO;
import org.cross.elscommon.util.StringToType;

public class UserInfoImpl implements UserInfo {

	@Override
	public UserVO toUserVO(UserPO po) {
		if (po == null) {
			return null;
		}
		UserVO vo = new UserVO(po.getNumber(), po.getPassword(), po.getName(),
				po.getType(), po.getOrgNum());
		return vo;
	}

	@Override
	public UserPO toUserPO(UserVO vo) {
		if (vo == null) {
			return null;
		}
		UserPO po = new UserPO(vo.number, vo.name,
				vo.userType, vo.password, vo.orgNameID);
		return po;
	}
}
