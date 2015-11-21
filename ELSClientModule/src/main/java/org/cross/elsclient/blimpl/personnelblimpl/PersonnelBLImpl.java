package org.cross.elsclient.blimpl.personnelblimpl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.blUtility.PersonnelInfo;
import org.cross.elsclient.blimpl.blUtility.ReceiptInfo;
import org.cross.elsclient.blservice.personnelblservice.PersonnelBLService;
import org.cross.elsclient.demo.StockInfoUI.returnAct;
import org.cross.elsclient.vo.PersonnelVO;
import org.cross.elsclient.vo.ReceiptVO;
import org.cross.elscommon.dataservice.personneldataservice.PersonnelDataService_Stub;
import org.cross.elscommon.po.PersonnelPO;
import org.cross.elscommon.po.ReceiptPO;
import org.cross.elscommon.util.ResultMessage;

public class PersonnelBLImpl implements PersonnelBLService,PersonnelInfo{
	
	public PersonnelDataService_Stub personnelData;
	ReceiptInfo receiptInfo;
	
	public PersonnelBLImpl(PersonnelDataService_Stub personnelData,ReceiptInfo receiptInfo){
		this.personnelData = personnelData;
		this.receiptInfo = receiptInfo;
	}
	
	@Override
	public ArrayList<PersonnelVO> findById(String id) throws RemoteException {
		ArrayList<PersonnelVO> vos = new ArrayList<PersonnelVO>();
		ArrayList<PersonnelPO> pos = personnelData.findById(id);
		int size = pos.size();
		for (int i = 0; i < size; i++) {
			vos.add(toPersonnelVO(pos.get(i)));
		}
		return vos;
	}

	@Override
	public ArrayList<PersonnelVO> findByName(String name) throws RemoteException {
		ArrayList<PersonnelVO> vos = new ArrayList<PersonnelVO>();
		ArrayList<PersonnelPO> pos = personnelData.findByName(name);
		int size = pos.size();
		for (int i = 0; i < size; i++) {
			vos.add(toPersonnelVO(pos.get(i)));
		}
		return vos;
	}

	@Override
	public ResultMessage add(PersonnelVO vo) throws RemoteException {
		PersonnelPO po = toPersonnelPO(vo);
		return personnelData.insert(po);
	}

	@Override
	public ResultMessage delete(PersonnelVO vo) throws RemoteException {
		PersonnelPO po = toPersonnelPO(vo);
		return personnelData.delete(po);
	}

	@Override
	public ResultMessage update(PersonnelVO vo) throws RemoteException {
		PersonnelPO po = toPersonnelPO(vo);
		return personnelData.update(po);
	}

	@Override
	public ArrayList<PersonnelVO> show() throws RemoteException {
		ArrayList<PersonnelVO> vos = new ArrayList<PersonnelVO>();
		ArrayList<PersonnelPO> pos = personnelData.show();
		int size = pos.size();
		for (int i = 0; i < size; i++) {
			vos.add(toPersonnelVO(pos.get(i)));
		}
		return vos;
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
