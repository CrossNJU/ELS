package org.cross.elsclient.test;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.accountblimpl.AccountInfoImpl;
import org.cross.elsclient.blimpl.initialblimpl.InitialBLImpl;
import org.cross.elsclient.blimpl.initialblimpl.InitialInfo;
import org.cross.elsclient.blimpl.initialblimpl.InitialInfoImpl;
import org.cross.elsclient.blimpl.organizationblimpl.OrganizationInfoImpl;
import org.cross.elsclient.blimpl.personnelblimpl.PersonnelInfoImpl;
import org.cross.elsclient.blimpl.stockblimpl.StockInfoImpl;
import org.cross.elsclient.blimpl.vehicleblimpl.VehicleInfoImpl;
import org.cross.elsclient.network.Datafactory;
import org.cross.elsclient.vo.AccountVO;
import org.cross.elsclient.vo.InitialVO;
import org.cross.elsclient.vo.OrganizationVO;
import org.cross.elsclient.vo.PersonnelVO;
import org.cross.elsclient.vo.StockVO;
import org.cross.elsclient.vo.VehicleVO;
import org.cross.elscommon.dataservice.datafactoryservice.DataFactoryService;
import org.cross.elscommon.util.ResultMessage;

public class InitialBLTest {

	public static void main(String[] args) throws RemoteException{
		DataFactoryService dataFactory = new Datafactory();
		OrganizationInfoImpl orginfo = new OrganizationInfoImpl();
		PersonnelInfoImpl personnelInfo = new PersonnelInfoImpl();
		VehicleInfoImpl vehicleInfo = new VehicleInfoImpl();
		StockInfoImpl stockInfo = new StockInfoImpl();
		AccountInfoImpl accountInfo = new AccountInfoImpl();
		InitialInfoImpl initialInfo = new InitialInfoImpl(orginfo, personnelInfo, vehicleInfo, stockInfo, accountInfo);
		InitialBLImpl initialBLImpl = new InitialBLImpl(dataFactory.getinInitialData(), initialInfo, orginfo, personnelInfo, vehicleInfo, stockInfo, accountInfo);
		System.out.println("---test-add---");
		InitialVO newVO = new InitialVO("1", "crr", 2015, new ArrayList<OrganizationVO>(), new ArrayList<PersonnelVO>(), new ArrayList<VehicleVO>(), new ArrayList<StockVO>(), new ArrayList<AccountVO>());
		ResultMessage addMessage = initialBLImpl.addInitial(newVO);
		if (addMessage == ResultMessage.SUCCESS) {
			System.out.println("增加成功");
		}else {
			System.out.println("增加失败");
		}
		System.out.println("---test-show---");
		ArrayList<InitialVO> show = initialBLImpl.show();
		if (show == null) {
			System.out.println("是空的啊");
		}else {
			int size = show.size();
			for (int i = 0; i < size; i++) {
				System.out.println(show.get(i).name + " " + show.get(i).year + " " + show.get(i).id);
			}
		}
		System.out.println("---test-showOrg---");
		ArrayList<OrganizationVO> orgVO = initialBLImpl.showOrganization("1");
		System.out.println("---test-showPersonnel---");
		System.out.println("---test-showVehicle---");
		System.out.println("---test-showStock---");
		System.out.println("---test-showAccount---");
		
	}
}
