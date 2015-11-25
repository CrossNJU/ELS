/**
 * personnel全部写好了
 */
package org.cross.elsclient.test;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.blUtility.PersonnelInfo;
import org.cross.elsclient.blimpl.blUtility.ReceiptInfo;
import org.cross.elsclient.blimpl.personnelblimpl.PersonnelBLImpl;
import org.cross.elsclient.blimpl.personnelblimpl.PersonnelInfoImpl;
import org.cross.elsclient.blimpl.receiptblimpl.ReceiptInfoImpl;
import org.cross.elsclient.network.Datafactory;
import org.cross.elsclient.vo.PersonnelVO;
import org.cross.elscommon.dataservice.datafactoryservice.DataFactoryService;
import org.cross.elscommon.util.OrganizationType;
import org.cross.elscommon.util.PositionType;
import org.cross.elscommon.util.ResultMessage;

public class PersonnelBLTest {
	
	public static void main(String[] args) throws RemoteException{
		DataFactoryService dataFactory = new Datafactory();
		PersonnelInfoImpl personnelInfo = new PersonnelInfoImpl();
		ReceiptInfoImpl receiptInfo = new ReceiptInfoImpl();
		personnelInfo.receiptInfo = receiptInfo;
		receiptInfo.personnelInfo = personnelInfo;
		PersonnelBLImpl personnelBLImpl = new PersonnelBLImpl(dataFactory.getPersonnelData(), personnelInfo, receiptInfo);
		
		System.out.println("---test-add---");
		PersonnelVO newVO = new PersonnelVO("P0003", "crr", PositionType.BUSINESSHALLCLERK, OrganizationType.BUSINESSHALL, "O0001");
		ResultMessage addMessage = personnelBLImpl.add(newVO);
		if (addMessage == ResultMessage.SUCCESS) {
			System.out.println("增加成功");
		}else {
			System.out.println("增加失败");
		}
//		System.out.println("---test-delete---");
//		ResultMessage deleteMessage = personnelBLImpl.delete("P0001");
//		if (deleteMessage == ResultMessage.SUCCESS) {
//			System.out.println("删除成功");
//		}else {
//			System.out.println("删除失败");
//		}
		System.out.println("---test-update---");
		PersonnelVO updateVO = new PersonnelVO("P0001", "danni", PositionType.ADMINISTRATOR, OrganizationType.HEADQUARTERS, "O2001");
		ResultMessage updateMessage = personnelBLImpl.update(updateVO);
		if (updateMessage == ResultMessage.SUCCESS) {
			System.out.println("更新成功");
		}else {
			System.out.println("更新失败");
		}
	
		System.out.println("---test-show---");
		ArrayList<PersonnelVO> shows = personnelBLImpl.show();
		int size = shows.size();
//		System.out.println(size);
		for (int i = 0; i < size; i++) {
			System.out.println(shows.get(i).name + " " + shows.get(i).organization);
		}
		
		System.out.println("---test-findById---");
		ArrayList<PersonnelVO> idvo = personnelBLImpl.findById("P0001");
		int size1 = idvo.size();
		System.out.println(size1);
		for (int i = 0; i < size1; i++) {
			System.out.println(idvo.get(i).name + " " + idvo.get(i).organization);
		}
		
		System.out.println("---test-findByName---");
		ArrayList<PersonnelVO> namevo = personnelBLImpl.findByName("crr");
		int size2 = namevo.size();
		System.out.println(size2);
		for (int i = 0; i < size2; i++) {
			System.out.println(namevo.get(i).name + " " + namevo.get(i).organization);
		}
	}
}
