package org.cross.elsclient.blimpl.userblimpl;

import java.util.ArrayList;

import org.cross.elsclient.blimpl.blUtility.UserInfo;
import org.cross.elsclient.blservice.userblservice.UserBLService;
import org.cross.elsclient.demo.StockInfoUI.returnAct;
import org.cross.elsclient.vo.UserVO;
import org.cross.elscommon.dataservice.userdataservice.UserDataService_Stub;
import org.cross.elscommon.po.UserPO;
import org.cross.elscommon.util.PositionType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.UserType;

public class UserBLImpl implements UserBLService{

	public UserDataService_Stub userData;
	UserInfo userInfo;
	
	public UserBLImpl(UserDataService_Stub userData,UserInfo userInfo){
		this.userData = userData;
		this.userInfo = userInfo;
	}
	
	@Override
	public ResultMessage add(UserVO vo) {
		UserPO po = userInfo.toUserPO(vo);
		return userData.insert(po);
	}

	@Override
	public ResultMessage delete(UserVO vo) {
		UserPO po = userInfo.toUserPO(vo);
		return userData.delete(po);
	}

	@Override
	public ResultMessage update(UserVO vo) {
		UserPO po = userInfo.toUserPO(vo);
		return userData.update(po);
	}

	@Override
	public ArrayList<UserVO> findByName(String name) {
		ArrayList<UserVO> vos = new ArrayList<UserVO>();
		ArrayList<UserPO> pos = userData.findByName(name);
		int size = pos.size();
		for (int i = 0; i < size; i++) {
			vos.add(userInfo.toUserVO(pos.get(i)));
		}
		return vos;
	}

	@Override
	public ArrayList<UserVO> findByType(UserType type) {
		ArrayList<UserVO> vos = new ArrayList<UserVO>();
		ArrayList<UserPO> pos = userData.findByType(type);
		int size = pos.size();
		for (int i = 0; i < size; i++) {
			vos.add(userInfo.toUserVO(pos.get(i)));
		}
		return vos;
	}

	@Override
	public ArrayList<UserVO> findById(String id) {
		ArrayList<UserVO> vos = new ArrayList<UserVO>();
		ArrayList<UserPO> pos = userData.findById(id);
		int size = pos.size();
		for (int i = 0; i < size; i++) {
			vos.add(userInfo.toUserVO(pos.get(i)));
		}
		return vos;
	}

	@Override
	public ArrayList<UserVO> show() {
		ArrayList<UserVO> vos = new ArrayList<UserVO>();
		ArrayList<UserPO> pos = userData.show();
		int size = pos.size();
		for (int i = 0; i < size; i++) {
			vos.add(userInfo.toUserVO(pos.get(i)));
		}
		return vos;
	}

	@Override
	public UserType login(String id, String password) {
		ArrayList<UserPO> pos = userData.findById(id);
		if (pos == null) {
			return null;
		}else {
			if (pos.get(0).getPassword().equals(password)) {
				return pos.get(0).getType();
			}else
				return null;
		}
	}

	@Override
	public ResultMessage logout() {
		// TODO Auto-generated method stub
		return null;
	}
}
