/**
 * 人员管理业务逻辑桩程序
 * @author Polaris Chen
 * @date 2015/10/19
 */
package org.cross.elsclient.blservice.personnelblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elscommon.util.OrganizationType;
import org.cross.elscommon.util.PositionType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elsclient.vo.PersonnelVO;

public class PersonnelBLService_Stub implements PersonnelBLService {

	@Override
	public ResultMessage add(PersonnelVO vo) {
		
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage update(PersonnelVO vo) {
		
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<PersonnelVO> findByName(String name) {
		ArrayList<PersonnelVO> personnelList=new ArrayList<PersonnelVO>();
		personnelList.add(new PersonnelVO("P0000001", name, PositionType.COUNTER, OrganizationType.HEADQUARTERS, "O000001"));
		personnelList.add(new PersonnelVO("P0000001", name, PositionType.COUNTER, OrganizationType.HEADQUARTERS, "O000001"));
		personnelList.add(new PersonnelVO("P0000001", name, PositionType.COUNTER, OrganizationType.HEADQUARTERS, "O000001"));
		personnelList.add(new PersonnelVO("P0000001", name, PositionType.COUNTER, OrganizationType.HEADQUARTERS, "O000001"));
		personnelList.add(new PersonnelVO("P0000001", name, PositionType.COUNTER, OrganizationType.HEADQUARTERS, "O000001"));
		return personnelList;
	}

	@Override
	public ArrayList<PersonnelVO> show() {
		ArrayList<PersonnelVO> personnelList=new ArrayList<PersonnelVO>();
		personnelList.add(new PersonnelVO("P0000001", "汤姆", PositionType.COUNTER, OrganizationType.HEADQUARTERS, "O000001"));
		personnelList.add(new PersonnelVO("P0000001", "汤姆", PositionType.COUNTER, OrganizationType.HEADQUARTERS, "O000001"));
		personnelList.add(new PersonnelVO("P0000001", "汤姆", PositionType.COUNTER, OrganizationType.HEADQUARTERS, "O000001"));
		personnelList.add(new PersonnelVO("P0000001", "汤姆", PositionType.COUNTER, OrganizationType.HEADQUARTERS, "O000001"));
		personnelList.add(new PersonnelVO("P0000001", "汤姆", PositionType.COUNTER, OrganizationType.HEADQUARTERS, "O000001"));
		personnelList.add(new PersonnelVO("P0000001", "汤姆", PositionType.COUNTER, OrganizationType.HEADQUARTERS, "O000001"));
		return personnelList;
	}

	@Override
	public PersonnelVO findById(String id) throws RemoteException {
		
		return new PersonnelVO(id, "汤姆", PositionType.COUNTER, OrganizationType.HEADQUARTERS, "O000001");
	}

	@Override
	public ArrayList<PersonnelVO> findByOrg(String number)
			throws RemoteException {
		ArrayList<PersonnelVO> personnelList=new ArrayList<PersonnelVO>();
		personnelList.add(new PersonnelVO("P0000001", "汤姆", PositionType.COUNTER, OrganizationType.HEADQUARTERS, number));
		personnelList.add(new PersonnelVO("P0000001", "汤姆", PositionType.COUNTER, OrganizationType.HEADQUARTERS, number));
		personnelList.add(new PersonnelVO("P0000001", "汤姆", PositionType.COUNTER, OrganizationType.HEADQUARTERS, number));
		personnelList.add(new PersonnelVO("P0000001", "汤姆", PositionType.COUNTER, OrganizationType.HEADQUARTERS, number));
		personnelList.add(new PersonnelVO("P0000001", "汤姆", PositionType.COUNTER, OrganizationType.HEADQUARTERS, number));
		personnelList.add(new PersonnelVO("P0000001", "汤姆", PositionType.COUNTER, OrganizationType.HEADQUARTERS, number));
		return personnelList;
	}

	@Override
	public ArrayList<PersonnelVO> findByPosition(PositionType position)
			throws RemoteException {
		ArrayList<PersonnelVO> personnelList=new ArrayList<PersonnelVO>();
		personnelList.add(new PersonnelVO("P0000001", "汤姆", position, OrganizationType.HEADQUARTERS, "O000001"));
		personnelList.add(new PersonnelVO("P0000001", "汤姆", position, OrganizationType.HEADQUARTERS, "O000001"));
		personnelList.add(new PersonnelVO("P0000001", "汤姆", position, OrganizationType.HEADQUARTERS, "O000001"));
		personnelList.add(new PersonnelVO("P0000001", "汤姆", position, OrganizationType.HEADQUARTERS, "O000001"));
		personnelList.add(new PersonnelVO("P0000001", "汤姆", position, OrganizationType.HEADQUARTERS, "O000001"));
		personnelList.add(new PersonnelVO("P0000001", "汤姆", position, OrganizationType.HEADQUARTERS, "O000001"));
		return personnelList;
	}

	@Override
	public ResultMessage delete(String id) throws RemoteException {
		return ResultMessage.SUCCESS;
	}

}
