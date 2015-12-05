package org.cross.elsclient.blimpl.personnelblimpl;

import java.util.ArrayList;

import org.cross.elsclient.blimpl.blUtility.PersonnelInfo;
import org.cross.elsclient.blimpl.blUtility.ReceiptInfo;
import org.cross.elsclient.vo.PersonnelVO;
import org.cross.elsclient.vo.ReceiptVO;
import org.cross.elscommon.po.PersonnelPO;
import org.cross.elscommon.po.ReceiptPO;
import org.cross.elscommon.po.SalaryPO;
import org.cross.elscommon.util.PositionType;

public class PersonnelInfoImpl implements PersonnelInfo{
	
	public ReceiptInfo receiptInfo;
	
	public PersonnelInfoImpl(){
		
	}
	
	public PersonnelInfoImpl(ReceiptInfo receiptInfo){
		this.receiptInfo = receiptInfo;
	}

	@Override
	public PersonnelVO toPersonnelVO(PersonnelPO po,String orgNameID,double extreMoney) {
		if (po == null) {
			return null;
		}
		String sex = "";
		if (po.getSex() == 1) {
			sex = "男";
		}else {
			sex = "女";
		}
		
		PersonnelVO vo = new 
		
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
		}else {
			s = 0;
		}
		PersonnelPO po = new PersonnelPO(vo.number, vo.name, vo.position, vo.orgNameID, vo.payment, s, vo.id, vo.phone, vo.birthday);
		return po;
	}
}
