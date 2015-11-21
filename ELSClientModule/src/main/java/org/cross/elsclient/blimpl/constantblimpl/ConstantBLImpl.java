package org.cross.elsclient.blimpl.constantblimpl;

import org.cross.elsclient.blimpl.blUtility.ConstantInfo;
import org.cross.elsclient.blservice.constantblservice.ConstantBLService;
import org.cross.elsclient.vo.ConstantVO;
import org.cross.elscommon.dataservice.constantdataservice.ConstantDataService;
import org.cross.elscommon.dataservice.constantdataservice.ConstantDataService_Stub;
import org.cross.elscommon.po.ConstantPO;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.UserType;

public class ConstantBLImpl implements ConstantBLService{

	public ConstantDataService constantData;
	public ConstantInfo constantInfo;
	
	public ConstantBLImpl(ConstantDataService constantData,ConstantInfo constantInfo){
		this.constantData = constantData;
		this.constantInfo = constantInfo;
	}
	
	@Override
	public ResultMessage update(ConstantVO vo) {
		ConstantPO po = constantInfo.toConstantPO(vo);
		return constantData.update(po);
	}

	@Override
	public ConstantVO show() {
		ConstantVO vo = constantInfo.toConstantVO(constantData.show());
		return vo;
	}

}
