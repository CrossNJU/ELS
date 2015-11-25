package org.cross.elsclient.blimpl.accountblimpl;

import org.cross.elsclient.blimpl.blUtility.AccountInfo;
import org.cross.elsclient.vo.AccountVO;
import org.cross.elscommon.po.AccountPO;

public class AccountInfoImpl implements AccountInfo{
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
