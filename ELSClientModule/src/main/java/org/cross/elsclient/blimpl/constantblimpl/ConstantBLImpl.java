package org.cross.elsclient.blimpl.constantblimpl;

import org.cross.elsclient.blimpl.blUtility.ConstantInfo;
import org.cross.elsclient.blservice.constantblservice.ConstantBLService;
import org.cross.elsclient.vo.ConstantVO;
import org.cross.elscommon.dataservice.constantdataservice.ConstantDataService_Stub;
import org.cross.elscommon.po.ConstantPO;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.UserType;

public class ConstantBLImpl implements ConstantBLService,ConstantInfo{

	public ConstantDataService_Stub constantData;
	
	public ConstantBLImpl(ConstantDataService_Stub constantData){
		this.constantData = constantData;
	}
	
	@Override
	public ResultMessage update(ConstantVO vo) {
		ConstantPO po = toConstantPO(vo);
		return constantData.update(po);
	}

	@Override
	public ConstantVO show() {
		ConstantVO vo = toConstantVO(constantData.show());
		return vo;
	}

	@Override
	public ConstantVO toConstantVO(ConstantPO po) {
		ConstantVO vo = new ConstantVO();
		vo.baseMoneyForADMINISTRATOR = po.getBaseMoney(UserType.ADMINISTRATOR);
		vo.baseMoneyForBUSINESSHALLCLERK = po.getBaseMoney(UserType.BUSINESSHALLCLERK);
		vo.baseMoneyForCOUNTER = po.getBaseMoney(UserType.COUNTER);
		vo.baseMoneyForCOURIER = po.getBaseMoney(UserType.COURIER);
		vo.baseMoneyForMANAGER = po.getBaseMoney(UserType.MANAGER);
		vo.baseMoneyForSTOCKKEEPER = po.getBaseMoney(UserType.STOCKKEEPER);
		vo.baseMoneyForTRANSITCENTERCLERK = po.getBaseMoney(UserType.TRANSITCENTERCLERK);
		vo.distance_Beijing_Guangzhou = po.getDistance_Beijing_Guangzhou();
		vo.distance_Beijing_Nanjing = po.getDistance_Beijing_Nanjing();
		vo.distance_Beijing_Shanghai = po.getDistance_Beijing_Shanghai();
		vo.distance_Nanjing_Guangzhou = po.getDistance_Nanjing_Guangzhou();
		vo.distance_Nanjing_Shanghai = po.getDistance_Nanjing_Shanghai();
		vo.distance_Shanghai_Guangzhou = po.getDistance_Shanghai_Guangzhou();
		vo.price = po.getPrice();
		vo.timeBykilo = po.getTimeBykilo();
		return vo;
	}

	@Override
	public ConstantPO toConstantPO(ConstantVO vo) {
		ConstantPO po = new ConstantPO();
		po.setBaseMoney(UserType.ADMINISTRATOR, vo.baseMoneyForADMINISTRATOR);
		po.setBaseMoney(UserType.BUSINESSHALLCLERK, vo.baseMoneyForBUSINESSHALLCLERK);
		po.setBaseMoney(UserType.COUNTER, vo.baseMoneyForCOUNTER);
		po.setBaseMoney(UserType.COURIER, vo.baseMoneyForCOURIER);
		po.setBaseMoney(UserType.MANAGER, vo.baseMoneyForMANAGER);
		po.setBaseMoney(UserType.STOCKKEEPER, vo.baseMoneyForSTOCKKEEPER);
		po.setBaseMoney(UserType.TRANSITCENTERCLERK, vo.baseMoneyForTRANSITCENTERCLERK);
		
		po.setPrice(vo.price);
		po.setTimeBykilo(vo.timeBykilo);
		
		po.setDistance_Beijing_Guangzhou(vo.distance_Beijing_Guangzhou);
		po.setDistance_Beijing_Nanjing(vo.distance_Beijing_Nanjing);
		po.setDistance_Beijing_Shanghai(vo.distance_Beijing_Shanghai);
		po.setDistance_Nanjing_Guangzhou(vo.distance_Nanjing_Guangzhou);
		po.setDistance_Nanjing_Shanghai(vo.distance_Nanjing_Shanghai);
		po.setDistance_Shanghai_Guangzhou(vo.distance_Shanghai_Guangzhou);
		return po;
	}

}
