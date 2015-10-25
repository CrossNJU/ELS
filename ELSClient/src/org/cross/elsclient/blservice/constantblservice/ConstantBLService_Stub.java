package org.cross.elsclient.blservice.constantblservice;

import org.cross.elsclient.util.City;
import org.cross.elsclient.util.ResultMessage;
import org.cross.elsclient.vo.ConstantVO;

public class ConstantBLService_Stub implements ConstantBLService {



	@Override
	public ConstantVO show() {
		// TODO Auto-generated method stub
		return new ConstantVO();
	}

	@Override
	public ResultMessage update(ConstantVO vo) {
		return ResultMessage.SUCCESS;
	}

}
