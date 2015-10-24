package org.cross.elsclient.dataservice.userdataservice;

import java.util.ArrayList;

import org.cross.elsclient.po.UserPO;
import org.cross.elsclient.util.UserType;

public class UserDataService_Stub implements UserDataService {

	@Override
	public void insert(UserPO po) {
		System.out.println("Insert Succeed!\n");
	}

	@Override
	public void delete(UserPO po) {
		System.out.println("Delete Succeed!\n");
	}

	@Override
	public void update(UserPO po) {
		System.out.println("Update Succeed!\n");
	}

	@Override
	public ArrayList<UserPO> findById(String id) {
		System.out.println("FindById Succeed!\n");
		ArrayList<UserPO> list = new ArrayList<UserPO>();
		list.add(new UserPO("12345678","艾斯奥特曼", UserType.BUSINESSHALLCLERK));
		return list;
	}

	@Override
	public ArrayList<UserPO> findByType(UserType type) {
		System.out.println("FindById Succeed!\n");
		ArrayList<UserPO> list = new ArrayList<UserPO>();
		list.add(new UserPO("12345678", "泰罗奥特曼", type));
		return list;
	}

	@Override
	public ArrayList<UserPO> findByName(String name) {
		System.out.println("FindById Succeed!\n");
		ArrayList<UserPO> list = new ArrayList<UserPO>();
		list.add(new UserPO("12345678", name, UserType.BUSINESSHALLCLERK));
		return list;
	}

	@Override
	public ArrayList<UserPO> show() {
		System.out.println("FindById Succeed!\n");
		ArrayList<UserPO> list = new ArrayList<UserPO>();
		list.add(new UserPO("12345678","佐菲奥特曼", UserType.BUSINESSHALLCLERK));
		return list;
	}

}
