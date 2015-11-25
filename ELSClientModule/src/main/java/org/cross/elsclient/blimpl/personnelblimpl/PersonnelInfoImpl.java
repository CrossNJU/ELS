package org.cross.elsclient.blimpl.personnelblimpl;

import java.util.ArrayList;

import org.cross.elsclient.blimpl.blUtility.PersonnelInfo;
import org.cross.elsclient.blimpl.blUtility.ReceiptInfo;
import org.cross.elsclient.vo.PersonnelVO;
import org.cross.elsclient.vo.ReceiptVO;
import org.cross.elscommon.po.PersonnelPO;
import org.cross.elscommon.po.ReceiptPO;

public class PersonnelInfoImpl implements PersonnelInfo{
	
	public ReceiptInfo receiptInfo;
	
	public PersonnelInfoImpl(){
		
	}
	
	public PersonnelInfoImpl(ReceiptInfo receiptInfo){
		this.receiptInfo = receiptInfo;
	}

	@Override
	public PersonnelVO toPersonnelVO(PersonnelPO po) {
		PersonnelVO vo = new PersonnelVO(po.getId(),po.getName(),po.getPosition(), po.getOrganization(), po.getOrganizationID());
		ArrayList<ReceiptVO> receiptVOs = new ArrayList<ReceiptVO>();
		ArrayList<ReceiptPO> receiptPOs = po.getDealedReceipts();
		int size = po.getDealedReceipts().size();
		for (int i = 0; i < size; i++) {
			receiptVOs.add(receiptInfo.toVO(receiptPOs.get(i)));
		}
		vo.payment = po.getPayment();
		vo.dealedReceipts = receiptVOs;
		return vo;
	}

	@Override
	public PersonnelPO toPersonnelPO(PersonnelVO vo) {
		PersonnelPO po = new PersonnelPO(vo.id, vo.name, vo.position, vo.organization, vo.organizationID);
		ArrayList<ReceiptPO> receiptPOs = new ArrayList<ReceiptPO>();
		ArrayList<ReceiptVO> receiptVOs = vo.dealedReceipts;
		int size = receiptVOs.size();
		for (int i = 0; i < size; i++) {
			receiptPOs.add(receiptInfo.toPO(receiptVOs.get(i)));
		}
		po.setPayment(vo.payment);
		po.setDealedReceipts(receiptPOs);
		return po;
	}
}
