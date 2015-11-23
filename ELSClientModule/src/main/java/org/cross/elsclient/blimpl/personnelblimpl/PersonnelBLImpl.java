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

public class PersonnelBLImpl implements PersonnelBLService{
	
	public PersonnelDataService_Stub personnelData;
	ReceiptInfo receiptInfo;
	PersonnelInfo personnelInfo;
	
	public PersonnelBLImpl(PersonnelDataService_Stub personnelData,PersonnelInfo personnelInfo,ReceiptInfo receiptInfo){
		this.personnelData = personnelData;
		this.personnelInfo = personnelInfo;
		this.receiptInfo = receiptInfo;
	}
	
	@Override
	public ArrayList<PersonnelVO> findById(String id) throws RemoteException {
		ArrayList<PersonnelVO> vos = new ArrayList<PersonnelVO>();
		ArrayList<PersonnelPO> pos = personnelData.findById(id);
		int size = pos.size();
		for (int i = 0; i < size; i++) {
			vos.add(personnelInfo.toPersonnelVO(pos.get(i)));
		}
		return vos;
	}

	@Override
	public ArrayList<PersonnelVO> findByName(String name) throws RemoteException {
		ArrayList<PersonnelVO> vos = new ArrayList<PersonnelVO>();
		ArrayList<PersonnelPO> pos = personnelData.findByName(name);
		int size = pos.size();
		for (int i = 0; i < size; i++) {
			vos.add(personnelInfo.toPersonnelVO(pos.get(i)));
		}
		return vos;
	}

	@Override
	public ResultMessage add(PersonnelVO vo) throws RemoteException {
		PersonnelPO po = personnelInfo.toPersonnelPO(vo);
		return personnelData.insert(po);
	}

	@Override
	public ResultMessage delete(PersonnelVO vo) throws RemoteException {
		PersonnelPO po = personnelInfo.toPersonnelPO(vo);
		return personnelData.delete(po);
	}

	@Override
	public ResultMessage update(PersonnelVO vo) throws RemoteException {
		PersonnelPO po = personnelInfo.toPersonnelPO(vo);
		return personnelData.update(po);
	}

	@Override
	public ArrayList<PersonnelVO> show() throws RemoteException {
		ArrayList<PersonnelVO> vos = new ArrayList<PersonnelVO>();
		ArrayList<PersonnelPO> pos = personnelData.show();
		int size = pos.size();
		for (int i = 0; i < size; i++) {
			vos.add(personnelInfo.toPersonnelVO(pos.get(i)));
		}
		return vos;
	}

}
