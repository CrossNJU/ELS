package org.cross.elsclient.blservice.constantblservice;

import org.cross.elscommon.util.ResultMessage;
import org.cross.elsclient.vo.ConstantVO;

public interface ConstantBLService {
	
	/**
	 * 更新业务常量
	 * @para 
	 * @return ResultMessage
	 */
	public ResultMessage update(ConstantVO vo);
	
	/**
	 * 显示业务常量
	 * @para 
	 * @return 业务常量VO类
	 */
	public ConstantVO show();
	
}
