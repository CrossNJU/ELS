package org.cross.elsclient.blservice.userblservice;

import java.util.ArrayList;

import org.cross.elsclient.util.ResultMessage;
import org.cross.elsclient.util.UserType;
import org.cross.elsclient.vo.UserVO;

public class UserBLService_Stub implements UserBLService {

	@Override
	public ResultMessage add(UserVO vo) {
		if(vo.name.equals("雷欧奥特曼")){
			return ResultMessage.FAILED;
		}
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage delete(UserVO vo) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage update(UserVO vo) {
		if(vo.name.equals("阿斯特拉奥特曼")&&vo.id.equals("001")){
			return ResultMessage.FAILED;
		}
		
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<UserVO> findByName(String name) {
		ArrayList<UserVO> list = new ArrayList<UserVO>();
		list.add(new UserVO("001", name, UserType.COUNTER));
		return list;
	}

	@Override
	public ArrayList<UserVO> findByType(UserType type) {
		ArrayList<UserVO> list = new ArrayList<UserVO>();
		list.add(new UserVO("001", "赛罗奥特曼", type));
		return list;
	}

	@Override
	public ArrayList<UserVO> findById(String id) {
		ArrayList<UserVO> list = new ArrayList<UserVO>();
		list.add(new UserVO(id, "梦优比斯奥特曼", UserType.COUNTER));
		return list;
	}

	@Override
	public ArrayList<UserVO> show() {
		ArrayList<UserVO> list = new ArrayList<UserVO>();
		list.add(new UserVO("001", "迪迦奥特曼", UserType.COUNTER));
		list.add(new UserVO("002", "戴拿奥特曼", UserType.COUNTER));
		list.add(new UserVO("003", "盖亚奥特曼", UserType.COUNTER));
		return list;
	}

	@Override
	public ResultMessage login(String id, String password) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage logout() {
		return ResultMessage.SUCCESS;
	}

}
