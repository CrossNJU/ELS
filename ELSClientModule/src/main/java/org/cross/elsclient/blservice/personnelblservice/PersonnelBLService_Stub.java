/**
 * 人员管理业务逻辑桩程序
 * @author Polaris Chen
 * @date 2015/10/19
 */
package org.cross.elsclient.blservice.personnelblservice;

import java.util.ArrayList;

import org.cross.elscommon.util.PositionType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elsclient.vo.PersonnelVO;

public class PersonnelBLService_Stub implements PersonnelBLService {

	@Override
	public ResultMessage add(PersonnelVO vo) {
		
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage delete(PersonnelVO vo) {
		
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage update(PersonnelVO vo) {
		
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<PersonnelVO> findByName(String name) {
		ArrayList<PersonnelVO> personnelList=new ArrayList<PersonnelVO>();
		personnelList.add(new PersonnelVO("00001", name, PositionType.COUNTER));
		return personnelList;
	}

	@Override
	public ArrayList<PersonnelVO> findById(String id) {
		ArrayList<PersonnelVO> personnelList=new ArrayList<PersonnelVO>();
		personnelList.add(new PersonnelVO(id, "杰利", PositionType.COUNTER));
		return personnelList;
	}

	@Override
	public ArrayList<PersonnelVO> show() {
		ArrayList<PersonnelVO> personnelList=new ArrayList<PersonnelVO>();
		personnelList.add(new PersonnelVO("00001", "杰利", PositionType.COUNTER));
		personnelList.add(new PersonnelVO("00002", "汤姆", PositionType.MANAGER));
		return personnelList;
	}

}
