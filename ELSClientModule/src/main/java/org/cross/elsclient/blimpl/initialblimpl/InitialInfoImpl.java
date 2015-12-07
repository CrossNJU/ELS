package org.cross.elsclient.blimpl.initialblimpl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.blUtility.AccountInfo;
import org.cross.elsclient.blimpl.blUtility.OrganizationInfo;
import org.cross.elsclient.blimpl.blUtility.PersonnelInfo;
import org.cross.elsclient.blimpl.blUtility.StockInfo;
import org.cross.elsclient.blimpl.blUtility.VehicleInfo;
import org.cross.elsclient.vo.AccountVO;
import org.cross.elsclient.vo.InitialVO;
import org.cross.elsclient.vo.OrganizationVO;
import org.cross.elsclient.vo.PersonnelVO;
import org.cross.elsclient.vo.StockVO;
import org.cross.elsclient.vo.VehicleVO;
import org.cross.elscommon.po.AccountPO;
import org.cross.elscommon.po.InitialPO;
import org.cross.elscommon.po.OrganizationPO;
import org.cross.elscommon.po.PersonnelPO;
import org.cross.elscommon.po.StockPO;
import org.cross.elscommon.po.VehiclePO;

public class InitialInfoImpl implements InitialInfo {
	public OrganizationInfo organizationInfo;
	public PersonnelInfo personnelInfo;
	public VehicleInfo vehicleInfo;
	public StockInfo stockInfo;
	public AccountInfo accountInfo;

	public InitialInfoImpl() {

	}

	public InitialInfoImpl(OrganizationInfo organizationInfo,
			PersonnelInfo personnelInfo, VehicleInfo vehicleInfo,
			StockInfo stockInfo, AccountInfo accountInfo) {
		this.organizationInfo = organizationInfo;
		this.personnelInfo = personnelInfo;
		this.vehicleInfo = vehicleInfo;
		this.stockInfo = stockInfo;
		this.accountInfo = accountInfo;
	}

	@Override
	public InitialVO toInitialVO(InitialPO po) throws RemoteException {
		if (po == null) {
			return null;
		}
		ArrayList<OrganizationVO> orgVOs = organizationInfo.show();
		ArrayList<PersonnelVO> personnelVOs = personnelInfo.show();
		ArrayList<VehicleVO> vehicleVOs = vehicleInfo.show();
		ArrayList<StockVO> stockVOs = stockInfo.showStockVOs();
		ArrayList<AccountVO> accountVOs = accountInfo.show();
		String perName = personnelInfo.findNameById(po.getPerNum());
		InitialVO vo = new InitialVO(po.getNumber(), po.getName(), orgVOs, personnelVOs, vehicleVOs, stockVOs, accountVOs, po.getTime(), perName, po.getPerNum());
		return vo;
	}

	@Override
	public InitialPO toInitialPO(InitialVO vo) {
		if (vo == null) {
			return null;
		}
		InitialPO po = new InitialPO(vo.id, vo.time, vo.initialName,
				vo.perNumber);
		return po;
	}

}
