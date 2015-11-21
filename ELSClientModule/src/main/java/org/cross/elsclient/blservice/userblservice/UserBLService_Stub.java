package org.cross.elsclient.blservice.userblservice;

import java.util.ArrayList;

import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.UserType;
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
		list.add(new UserVO("12345678", name, UserType.COUNTER));
		return list;
	}

	@Override
	public ArrayList<UserVO> findByType(UserType type) {
		ArrayList<UserVO> list = new ArrayList<UserVO>();
		list.add(new UserVO("12345678","赛罗奥特曼", type));
		return list;
	}

	@Override
	public ArrayList<UserVO> findById(String id) {
		ArrayList<UserVO> list = new ArrayList<UserVO>();
		list.add(new UserVO("12345678", "杰克奥特曼", UserType.COUNTER));
		list.add(new UserVO("12345678", "雷欧奥特曼", UserType.COURIER));
		list.add(new UserVO("12345678", "爱迪奥特曼", UserType.STOCKKEEPER));
		list.add(new UserVO("12345678", "爱迪奥特曼", UserType.STOCKKEEPER));
		list.add(new UserVO("12345678", "爱迪奥特曼", UserType.STOCKKEEPER));
		list.add(new UserVO("12345678", "爱迪奥特曼", UserType.STOCKKEEPER));
//		list.add(new UserVO("12345678", "爱迪奥特曼", UserType.STOCKKEEPER));
//		list.add(new UserVO("12345678", "爱迪奥特曼", UserType.STOCKKEEPER));
//		list.add(new UserVO("12345678", "爱迪奥特曼", UserType.STOCKKEEPER));
//		list.add(new UserVO("12345678", "爱迪奥特曼", UserType.STOCKKEEPER));
//		list.add(new UserVO("12345678", "爱迪奥特曼", UserType.STOCKKEEPER));
//		list.add(new UserVO("12345678", "爱迪奥特曼", UserType.STOCKKEEPER));
//		list.add(new UserVO("12345678", "爱迪奥特曼", UserType.STOCKKEEPER));
		return list;
	}

	@Override
	public ArrayList<UserVO> show() {
		ArrayList<UserVO> list = new ArrayList<UserVO>();
		list.add(new UserVO("12345678", "迪迦奥特曼", UserType.COUNTER));
		list.add(new UserVO("12345678","戴拿奥特曼", UserType.COUNTER));
		list.add(new UserVO("12345678", "盖亚奥特曼", UserType.COUNTER));
		list.add(new UserVO("12345678", "盖亚奥特曼", UserType.COUNTER));
		list.add(new UserVO("12345678", "盖亚奥特曼", UserType.COUNTER));
		list.add(new UserVO("12345678", "盖亚奥特曼", UserType.COUNTER));
		list.add(new UserVO("12345678", "盖亚奥特曼", UserType.COUNTER));
		list.add(new UserVO("12345678", "盖亚奥特曼", UserType.COUNTER));
		list.add(new UserVO("12345678", "盖亚奥特曼", UserType.COUNTER));
		list.add(new UserVO("12345678", "盖亚奥特曼", UserType.COUNTER));
		list.add(new UserVO("12345678", "盖亚奥特曼", UserType.COUNTER));
		list.add(new UserVO("12345678", "盖亚奥特曼", UserType.COUNTER));
		
		return list;
	}

	@Override
	public UserType login(String id, String password) {
		if(id.equals("1")){
			return UserType.ADMINISTRATOR;
		}else if(id.equals("2")){
			return UserType.BUSINESSHALLCLERK;
		}
		
		return UserType.ADMINISTRATOR;
	}

	@Override
	public ResultMessage logout() {
		return ResultMessage.SUCCESS;
	}

}
