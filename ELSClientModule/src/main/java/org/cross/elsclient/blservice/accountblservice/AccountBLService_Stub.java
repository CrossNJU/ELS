/**
 * 账户管理业务逻辑桩程序
 * @author Polaris Chen
 * @date 2015/10/19
 */
package org.cross.elsclient.blservice.accountblservice;

import java.util.ArrayList;

import org.cross.elscommon.util.ResultMessage;
import org.cross.elsclient.vo.AccountVO;

public class AccountBLService_Stub implements AccountBLService {

	@Override
	public ArrayList<AccountVO> find(String name) {
		ArrayList<AccountVO> list = new ArrayList<AccountVO>();
		list.add(new AccountVO(name, "6222201234567654321", 50000));
		return list;
	}

	@Override
	public ResultMessage add(AccountVO vo) {
		if (vo.name.equals("ICBC账户")) {
			return ResultMessage.FAILED;
		}
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage delete(AccountVO vo) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage update(AccountVO vo) {
		if (vo.name.equals("ICBC账户")) {
			return ResultMessage.SUCCESS;
		}
		return ResultMessage.FAILED;
	}

	@Override
	public ArrayList<AccountVO> show() {
		ArrayList<AccountVO> list = new ArrayList<AccountVO>();
		list.add(new AccountVO("ICBC账户", "6222201234567654321", 50000));
		list.add(new AccountVO("CCB账户", "6222201234567654322", 50000));
		return list;
	}

}
