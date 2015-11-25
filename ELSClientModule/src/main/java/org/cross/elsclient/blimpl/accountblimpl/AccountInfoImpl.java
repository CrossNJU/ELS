package org.cross.elsclient.blimpl.accountblimpl;

import org.cross.elsclient.blimpl.blUtility.AccountInfo;
import org.cross.elsclient.vo.AccountVO;
import org.cross.elscommon.po.AccountPO;

public class AccountInfoImpl implements AccountInfo{
	@Override
	public AccountVO toAccountVO(AccountPO po) {
		if (po == null) {
			return null;
		}
		AccountVO vo = new AccountVO(po.getName(), po.getAccount(), po.getBalance());
		return vo;
	}

	@Override
	public AccountPO toAccountPO(AccountVO vo) {
		if (vo == null) {
			return null;
		}
		AccountPO po = new AccountPO(vo.name, vo.account, vo.balance);
		return po;
	}
}
