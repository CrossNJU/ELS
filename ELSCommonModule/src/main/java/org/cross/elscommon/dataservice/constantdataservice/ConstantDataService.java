package org.cross.elscommon.dataservice.constantdataservice;

import org.cross.elscommon.po.ConstantPO;

public interface ConstantDataService {
	
	/**
	 * 更新业务常量
	 * @para 
	 * @return ResultMessage
	 */
	public void update(ConstantPO po);
	
	/**
	 * 显示业务常量
	 * @para 
	 * @return 业务常量VO类
	 */
	public ConstantPO show();
}
