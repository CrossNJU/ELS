package org.cross.elsclient.blimpl.userblimpl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.blUtility.UserInfo;
import org.cross.elsclient.blservice.userblservice.UserBLService;
import org.cross.elsclient.vo.UserVO;
import org.cross.elscommon.dataservice.userdataservice.UserDataService;
import org.cross.elscommon.po.UserPO;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.UserType;

public class UserBLImpl implements UserBLService{

	public UserDataService userData;
	UserInfo userInfo;
	
	public UserBLImpl(UserDataService userData,UserInfo userInfo){
		this.userData = userData;
		this.userInfo = userInfo;
	}
	
	@Override
	public ResultMessage add(UserVO vo) throws RemoteException {
		UserPO po = userInfo.toUserPO(vo);
		return userData.insert(po);
	}

	@Override
	public ResultMessage delete(String id) throws RemoteException {
		return userData.delete(id);
	}

	@Override
	public ResultMessage update(UserVO vo)throws RemoteException {
		UserPO po = userInfo.toUserPO(vo);
		return userData.update(po);
	}

	@Override
	public ArrayList<UserVO> findByName(String name) throws RemoteException{
		ArrayList<UserVO> vos = new ArrayList<UserVO>();
		ArrayList<UserPO> pos = userData.findByName(name);
		int size = pos.size();
		for (int i = 0; i < size; i++) {
			vos.add(userInfo.toUserVO(pos.get(i)));
		}
		return vos;
	}

	@Override
	public ArrayList<UserVO> findByType(UserType type)throws RemoteException {
		ArrayList<UserVO> vos = new ArrayList<UserVO>();
		ArrayList<UserPO> pos = userData.findByType(type);
		int size = pos.size();
		for (int i = 0; i < size; i++) {
			vos.add(userInfo.toUserVO(pos.get(i)));
		}
		return vos;
	}

	@Override
	public UserVO findById(String id) throws RemoteException{
		UserPO pos = userData.findById(id);
		return userInfo.toUserVO(pos);
	}

	@Override
	public ArrayList<UserVO> show() throws RemoteException{
		ArrayList<UserVO> vos = new ArrayList<UserVO>();
		ArrayList<UserPO> pos = userData.show();
		int size = pos.size();
		for (int i = 0; i < size; i++) {
			vos.add(userInfo.toUserVO(pos.get(i)));
		}
		return vos;
	}

	@Override
	public UserType login(String id, String password) throws RemoteException{
		UserPO pos = userData.findById(id);
		if (pos == null) {
			return null;
		}else {
			if (pos.getPassword().equals(password)) {
				return pos.getType();
			}else
				return null;
		}
	}

	@Override
	public ResultMessage logout()throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
}
