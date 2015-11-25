package org.cross.elsclient.test;

import java.rmi.RemoteException;

import org.cross.elsclient.blimpl.blUtility.OrganizationInfo;
import org.cross.elsclient.blimpl.organizationblimpl.OrganizationBLImpl;
import org.cross.elsclient.blimpl.organizationblimpl.OrganizationInfoImpl;
import org.cross.elsclient.network.Datafactory;
import org.cross.elsclient.vo.OrganizationVO;
import org.cross.elscommon.dataservice.datafactoryservice.DataFactoryService;
import org.cross.elscommon.util.City;
import org.cross.elscommon.util.OrganizationType;
import org.cross.elscommon.util.ResultMessage;

public class OrganizationBLTest {
	public static void main(String[] args) throws RemoteException{
		DataFactoryService dataFactory = new Datafactory();
		OrganizationInfo orgInfo = new OrganizationInfoImpl();
		OrganizationBLImpl orgBLImpl = new OrganizationBLImpl(dataFactory.getOrganizationData(), orgInfo);
		
		System.out.println("========测试addOrg=======");
		OrganizationVO newOrg = new OrganizationVO(City.BEIJING, OrganizationType.BUSINESSHALL, "002378");
		ResultMessage addMessage = orgBLImpl.add(newOrg);
		if (addMessage == ResultMessage.SUCCESS) {
			System.out.println("增加成功");
		}else {
			System.out.println("增加失败");
		}
//		System.out.println("========测试deleteOrg=======");
//		ResultMessage delMessage = orgBLImpl.delete("002378");
//		if (delMessage == ResultMessage.SUCCESS) {
//			System.out.println("删除成功");
//		}else {
//			System.out.println("删除失败");
//		}
//		System.out.println("========测试updateOrg=======");
//		OrganizationVO updateOrg = new OrganizationVO(City.GUANGZHOU, OrganizationType.STOCK, "002378");
//		ResultMessage updateMessage = orgBLImpl.update(updateOrg);
//		if (updateMessage == ResultMessage.SUCCESS) {
//			System.out.println("更新成功");
//		}else {
//			System.out.println("更新失败");
//		}
//		System.out.println("========测试showOrg=======");
//		System.out.println("========测试addOrg=======");
//		System.out.println("========测试addOrg=======");
//		System.out.println("========测试addOrg=======");
	}

}
