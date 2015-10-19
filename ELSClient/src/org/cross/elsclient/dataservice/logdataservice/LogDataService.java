package org.cross.elsclient.dataservice.logdataservice;

import java.util.ArrayList;

import org.cross.elsclient.po.LogPO;

public interface LogDataService {
	
	public void insert(LogPO po);
	
	public ArrayList<LogPO> find(String startTime, String endTime);
	
	public ArrayList<LogPO> show();
}
