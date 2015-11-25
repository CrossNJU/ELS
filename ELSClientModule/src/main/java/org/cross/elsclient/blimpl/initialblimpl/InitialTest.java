//package org.cross.elsclient.blimpl.initialblimpl;
//
//import static org.junit.Assert.*;
//
//import java.util.ArrayList;
//
//import org.cross.elsclient.vo.AccountVO;
//import org.cross.elsclient.vo.InitialVO;
//import org.cross.elsclient.vo.OrganizationVO;
//import org.cross.elsclient.vo.PersonnelVO;
//import org.cross.elsclient.vo.StockVO;
//import org.cross.elsclient.vo.VehicleVO;
//import org.cross.elscommon.util.City;
//import org.cross.elscommon.util.OrganizationType;
//import org.cross.elscommon.util.PositionType;
//import org.cross.elscommon.util.ResultMessage;
//import org.junit.Test;
//
//public class InitialTest {
//	@Test
//	public void testInitial(){
//		Initial initial = new Initial();
//		assertEquals(ResultMessage.SUCCESS,initial.createLog("2015/11/16 initialize"));
//		
//		ArrayList<OrganizationVO> organizationVOs = new ArrayList<OrganizationVO>();
//		organizationVOs.add(new OrganizationVO(City.NANJING, OrganizationType.BUSINESSHALL,"00009"));
//		ArrayList<PersonnelVO> personnelVOs = new ArrayList<PersonnelVO>();
//		personnelVOs.add(new PersonnelVO("00002", "小明", PositionType.COUNTER, OrganizationType.BUSINESSHALL, "00009"));
//		ArrayList<VehicleVO> vehicleVOs = new ArrayList<VehicleVO>();
//		vehicleVOs.add(new VehicleVO("GX22210"));
//		ArrayList<StockVO> stockVOs = new ArrayList<StockVO>();
//		stockVOs.add(new StockVO("S0003", 10));
//		ArrayList<AccountVO> accountVOs = new ArrayList<AccountVO>();
//		accountVOs.add(new AccountVO("account", "365722992200000", 222.398));
//		assertEquals(ResultMessage.SUCCESS, initial.addInitial(new InitialVO("00000", "name1", organizationVOs, personnelVOs,
//				vehicleVOs, stockVOs, accountVOs)));
//	}
//
//}
