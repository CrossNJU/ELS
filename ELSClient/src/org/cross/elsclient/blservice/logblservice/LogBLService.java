package org.cross.elsclient.blservice.logblservice;

import java.util.ArrayList;

import org.cross.elsclient.vo.LogVO;

import util.ResultMessage;

public interface LogBLService {

	/**
	 * 查看系统日志
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public ArrayList<LogVO> show(String startTime,String endTime);
	
	/**
	 * 添加系统日志
	 * @param vo
	 * @return
	 */
	public ResultMessage add(LogVO vo);
	
}
