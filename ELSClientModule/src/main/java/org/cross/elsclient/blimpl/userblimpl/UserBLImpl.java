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

public class UserBLImpl implements UserBLService,UserInfo{

	public UserDataService_Stub userData;
	
	public UserBLImpl(UserDataService_Stub userData){
		this.userData = userData;
	}
	
	@Override
	public ResultMessage add(UserVO vo) {
		UserPO po = toUserPO(vo);
		return userData.insert(po);
	}

	@Override
	public ResultMessage delete(UserVO vo) {
		UserPO po = toUserPO(vo);
		return userData.delete(po);
	}

	@Override
	public ResultMessage update(UserVO vo) {
		UserPO po = toUserPO(vo);
		return userData.update(po);
	}

	@Override
	public ArrayList<UserVO> findByName(String name) {
		ArrayList<UserVO> vos = new ArrayList<UserVO>();
		ArrayList<UserPO> pos = userData.findByName(name);
		int size = pos.size();
		for (int i = 0; i < size; i++) {
			vos.add(toUserVO(pos.get(i)));
		}
		return vos;
	}

	@Override
	public ArrayList<UserVO> findByType(UserType type) {
		ArrayList<UserVO> vos = new ArrayList<UserVO>();
		ArrayList<UserPO> pos = userData.findByType(type);
		int size = pos.size();
		for (int i = 0; i < size; i++) {
			vos.add(toUserVO(pos.get(i)));
		}
		return vos;
	}

	@Override
	public ArrayList<UserVO> findById(String id) {
		ArrayList<UserVO> vos = new ArrayList<UserVO>();
		ArrayList<UserPO> pos = userData.findById(id);
		int size = pos.size();
		for (int i = 0; i < size; i++) {
			vos.add(toUserVO(pos.get(i)));
		}
		return vos;
	}

	@Override
	public ArrayList<UserVO> show() {
		ArrayList<UserVO> vos = new ArrayList<UserVO>();
		ArrayList<UserPO> pos = userData.show();
		int size = pos.size();
		for (int i = 0; i < size; i++) {
			vos.add(toUserVO(pos.get(i)));
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
