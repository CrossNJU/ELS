package org.cross.elsclient.blimpl.userblimpl;

import org.cross.elsclient.blimpl.blUtility.UserInfo;
import org.cross.elsclient.vo.UserVO;
import org.cross.elscommon.po.UserPO;

public class UserInfoImpl implements UserInfo{

	@Override
	public UserVO toUserVO(UserPO po) {
		UserVO vo = new UserVO(po.getPassword(), po.getName(), po.getType());
		vo.id = po.getId();
		return vo;
	}

	@Override
	public UserPO toUserPO(UserVO vo) {
		UserPO po = new UserPO(vo.password, vo.name, vo.type);
		po.setId(vo.id);
		return po;
	}
}
