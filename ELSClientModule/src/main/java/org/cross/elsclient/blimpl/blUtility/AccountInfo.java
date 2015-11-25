package org.cross.elsclient.blimpl.blUtility;

import org.cross.elsclient.vo.AccountVO;
import org.cross.elscommon.po.AccountPO;

public interface AccountInfo {
	public AccountVO toAccountVO(AccountPO po);
	
	public AccountPO toAccountPO(AccountVO vo);

}
