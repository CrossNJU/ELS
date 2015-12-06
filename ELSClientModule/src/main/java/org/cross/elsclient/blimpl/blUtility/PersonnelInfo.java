package org.cross.elsclient.blimpl.blUtility;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.vo.PersonnelVO;
import org.cross.elscommon.po.PersonnelPO;

public interface PersonnelInfo {

	public PersonnelVO toPersonnelVO(PersonnelPO po, String orgNameID,
			double extreMoney);

	public PersonnelPO toPersonnelPO(PersonnelVO vo);

	/**
	 * 显示所有人员信息
	 * 
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<PersonnelVO> show() throws RemoteException;

	/**
	 * 根据人员工号查找姓名
	 * 
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public String findNameById(String id) throws RemoteException;

}
