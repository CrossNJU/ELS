/**
 * 账户管理数据接口
 * @author Polaris Chen
 * @date 2015/10/19
 */
package org.cross.elsclient.dataservice.accountdataservice;

import java.util.ArrayList;

import org.cross.elsclient.po.AccountPO;

public interface AccountDataService {

	public ArrayList<AccountPO> find(String name);

	public void insert(AccountPO po);

	public void delete(AccountPO po);

	public void update(AccountPO po);

	public ArrayList<AccountPO> show();
}
