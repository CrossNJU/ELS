package org.cross.elsclient.blimpl.personnelblimpl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.blUtility.PersonnelInfo;
import org.cross.elsclient.blimpl.blUtility.ReceiptInfo;
import org.cross.elsclient.blimpl.blUtility.SalaryInfo;
import org.cross.elsclient.vo.DriverVO;
import org.cross.elsclient.vo.PersonnelVO;
import org.cross.elscommon.dataservice.personneldataservice.PersonnelDataService;
import org.cross.elscommon.po.DriverPO;
import org.cross.elscommon.po.PersonnelPO;
import org.cross.elscommon.po.SalaryPO;
import org.cross.elscommon.util.PositionType;

public class PersonnelInfoImpl implements PersonnelInfo {

	public ReceiptInfo receiptInfo;
	public PersonnelDataService persinnelData;
	public SalaryInfo salaryInfo;

	public PersonnelInfoImpl(PersonnelDataService persinnelData,
			SalaryInfo salaryInfo) {
		this.persinnelData = persinnelData;
		this.salaryInfo = salaryInfo;
	}

	public PersonnelInfoImpl(ReceiptInfo receiptInfo,
			PersonnelDataService persinnelData) {
		this.receiptInfo = receiptInfo;
		this.persinnelData = persinnelData;
	}

	@Override
	public PersonnelVO toPersonnelVO(PersonnelPO po, SalaryPO salary) {
		if (po == null) {
			return null;
		}
		String sex = "";
		if (po.getSex() == 1) {
			sex = "男";
		} else {
			sex = "女";
		}
		PersonnelVO vo = new PersonnelVO(po.getNumber(), po.getName(),
				po.getPosition(), po.getOrgNum(), sex, po.getId(),
				po.getPhone(), po.getBirth());
		vo.salary = salary;
		if (po.getPosition() == PositionType.DRIVER) {
			DriverVO driverVO = (DriverVO)vo;
			DriverPO driverPO = (DriverPO)po;
			driverVO.licenceStart = driverPO.getLicenceStart();
			driverVO.licenceEnd = driverPO.getLicenceEnd();
			return driverVO;
		}
		return vo;
	}

	@Override
	public PersonnelPO toPersonnelPO(PersonnelVO vo) {
		if (vo == null) {
			return null;
		}
		int s = 1;
		if (vo.sex.equals("男")) {
			s = 1;
		} else {
			s = 0;
		}
		PersonnelPO po = new PersonnelPO(vo.number, vo.name, vo.position,
				vo.orgNum, vo.salary.getSalaryByMonth(), s, vo.id, vo.phone,
				vo.birthday);
		if (po.getPosition() == PositionType.DRIVER) {
			DriverVO driverVO = (DriverVO)vo;
			DriverPO driverPO = (DriverPO)po;
			driverPO.setLicenceEnd(driverVO.licenceEnd);
			driverPO.setLicenceStart(driverVO.licenceStart);
			return driverPO;
		}
		return po;
	}

	@Override
	public ArrayList<PersonnelVO> show() throws RemoteException {
		ArrayList<PersonnelPO> pos = persinnelData.show();
		ArrayList<PersonnelVO> vos = new ArrayList<PersonnelVO>();
		int size = pos.size();
		for (int i = 0; i < size; i++) {
			SalaryPO salary = salaryInfo.findbyPerNum(pos.get(i).getNumber());
			vos.add(toPersonnelVO(pos.get(i), salary));
		}
		return vos;
	}

	@Override
	public String findNameById(String id) throws RemoteException {
		PersonnelPO po = persinnelData.findById(id);
		String name = po.getName();
		return name;
	}
}
