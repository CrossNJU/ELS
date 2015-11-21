package org.cross.elsclient.blimpl.accountblimpl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.blUtility.AccountInfo;
import org.cross.elsclient.blservice.accountblservice.AccountBLService;
import org.cross.elsclient.demo.StockInfoUI.returnAct;
import org.cross.elsclient.vo.AccountVO;
import org.cross.elscommon.dataservice.accountdataservice.AccountDataService;
import org.cross.elscommon.dataservice.accountdataservice.AccountDataService_Stub;
import org.cross.elscommon.po.AccountPO;
import org.cross.elscommon.util.ResultMessage;

public class AccountBLImpl implements AccountBLService,AccountInfo{

	public AccountDataService_Stub accountData;
	
	public AccountBLImpl(AccountDataService_Stub accountData) {
		this.accountData = accountData;
	}
	
	@Override
	public ArrayList<AccountVO> find(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage add(AccountVO vo) throws RemoteException {
		AccountPO po = toAccountPO(vo);
		return accountData.insert(po);
	}

	@Override
	
	public ResultMessage delete(AccountVO vo) throws RemoteException {
		AccountPO po = toAccountPO(vo);
		return accountData.delete(po);
	}

	@Override
	public ResultMessage update(AccountVO vo) throws RemoteException {
		AccountPO po = toAccountPO(vo);
		return accountData.update(po);
	}

	@Override
	public ArrayList<AccountVO> show() throws RemoteException {
		ArrayList<AccountVO> vos = new ArrayList<AccountVO>();
		ArrayList<AccountPO> pos = accountData.show();
		int size = pos.size();
		for (int i = 0; i < size; i++) {
			vos.add(toAccountVO(pos.get(i)));
		}
		return vos;
	}

	@Override
	public AccountVO toAccountVO(AccountPO po) {
		AccountVO vo = new AccountVO(po.getName(), po.getAccount(), po.getBalance());
		return vo;
	}

	@Override
	public AccountPO toAccountPO(AccountVO vo) {
		AccountPO po = new AccountPO(vo.name, vo.account, vo.balance);
		return po;
	}

}
