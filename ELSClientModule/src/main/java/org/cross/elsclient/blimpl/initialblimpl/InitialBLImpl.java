package org.cross.elsclient.blimpl.initialblimpl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blservice.initialblservice.InitialBLService;
import org.cross.elsclient.blservice.logblservice.LogBLService;
import org.cross.elsclient.vo.AccountVO;
import org.cross.elsclient.vo.InitialVO;
import org.cross.elsclient.vo.OrganizationVO;
import org.cross.elsclient.vo.PersonnelVO;
import org.cross.elsclient.vo.StockVO;
import org.cross.elsclient.vo.VehicleVO;
import org.cross.elscommon.dataservice.initialdataservice.InitialDataService;
import org.cross.elscommon.dataservice.initialdataservice.InitialDataService_Stub;
import org.cross.elscommon.po.InitialPO;
import org.cross.elscommon.util.ResultMessage;

public class InitialBLImpl implements InitialBLService{

	InitialDataService_Stub initialData;
	InitialInfo initialInfo;
	
	public InitialBLImpl(InitialDataService_Stub initialData,InitialInfo initialInfo){
		this.initialData = initialData;
		this.initialInfo = initialInfo;
	}
	
	@Override
	public ArrayList<InitialVO> show() throws RemoteException {
		ArrayList<InitialVO> initialVOs = new ArrayList<InitialVO>();
		ArrayList<InitialPO> initialPOs = initialData.show();
		if (initialPOs == null) {
			return null;
		}
		int size = initialPOs.size();
		for (int i = 0; i < size; i++) {
			initialVOs.add(initialInfo.toInitialVO(initialPOs.get(i)));
		}
		return initialVOs;
	}

	@Override
	public ResultMessage addInitial(InitialVO vo) throws RemoteException {
		InitialPO po = initialInfo.toInitialPO(vo);
		return initialData.insert(po);
	}

	@Override
	public ArrayList<OrganizationVO> showOrganization(InitialVO vo) throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<PersonnelVO> showPersonnel(InitialVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<VehicleVO> showVehicle(InitialVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<StockVO> showStock(InitialVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<AccountVO> showAccount(InitialVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
