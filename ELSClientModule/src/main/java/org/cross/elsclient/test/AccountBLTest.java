package org.cross.elsclient.test;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.accountblimpl.AccountBLImpl;
import org.cross.elsclient.blimpl.accountblimpl.AccountInfoImpl;
import org.cross.elsclient.blimpl.blUtility.AccountInfo;
import org.cross.elsclient.network.Datafactory;
import org.cross.elsclient.vo.AccountVO;
import org.cross.elscommon.dataservice.datafactoryservice.DataFactoryService;
import org.cross.elscommon.util.ResultMessage;

public class AccountBLTest {
	
	public static void main(String[] args) throws RemoteException{
		DataFactoryService dataFactory = new Datafactory();
		AccountInfo accountInfo = new AccountInfoImpl();
		AccountBLImpl accountBLImpl = new AccountBLImpl(dataFactory.getAccountData(), accountInfo);
//		System.out.println("=======测试addAccount=======");
//		AccountVO vo1 = new AccountVO("account2", "325715400099", 367.2);
//		ResultMessage addMessage = accountBLImpl.add(vo1);
//		if (addMessage == ResultMessage.SUCCESS) {
//			System.out.println("增加成功");
//		}else {
//			System.out.println("增加失败");
//		}
//		System.out.println("=======测试deleteAccount=======");
//		ResultMessage deleteMessage = accountBLImpl.delete("325715483999");
//		if (deleteMessage == ResultMessage.SUCCESS) {
//			System.out.println("删除成功");
//		}else {
//			System.out.println("删除失败");
//		}
//		System.out.println("=======测试findByNameAccount=======");
//		ArrayList<AccountVO> accountVOs = accountBLImpl.findByName("account1");
//		if (accountVOs != null) {
//			int size = accountVOs.size();
//			for (int i = 0; i < size; i++) {
//				System.out.println(accountVOs.get(i).name + " " + accountVOs.get(i).balance);
//			}
//		}
		
//		System.out.println("=======测试findByIDAccount=======");
//		AccountVO vo2 = accountBLImpl.findByID("325715483999");
//		if (vo2 != null) {
//			System.out.println(vo2.name + " " + vo2.account + " " + vo2.balance);
//		}else {
//			System.out.println("查找失败");
//		}
//		System.out.println("=======测试updateAccount=======");
//		AccountVO newVo = new AccountVO("account1", "325715483999", 3367.2);
//		ResultMessage updateMessage = accountBLImpl.update(newVo);
//		if (updateMessage == ResultMessage.SUCCESS) {
//			System.out.println("更新成功");
//		}else {
//			System.out.println("更新失败");
//		}
		System.out.println("=======测试showAccount=======");
		ArrayList<AccountVO> showVOs = accountBLImpl.show();
		int size = showVOs.size();
		for (int i = 0; i < size; i++) {
			System.out.println(showVOs.get(i).account + " " + showVOs.get(i).name
					+ " " + showVOs.get(i).balance);
		}
	}
	

}
