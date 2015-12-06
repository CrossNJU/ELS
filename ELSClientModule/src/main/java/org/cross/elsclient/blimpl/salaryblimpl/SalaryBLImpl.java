package org.cross.elsclient.blimpl.salaryblimpl;

import java.rmi.RemoteException;

import org.cross.elsclient.blimpl.blUtility.SalaryInfo;
import org.cross.elscommon.dataservice.salarydataservice.SalaryDataService;
import org.cross.elscommon.po.SalaryPO;

public class SalaryBLImpl implements SalaryInfo{
	SalaryDataService salaryData;
	
	public SalaryBLImpl(SalaryDataService salaryData){
		this.salaryData = salaryData;
	}
	
	@Override
	public SalaryPO findbyPerNum(String perNum) throws RemoteException {
		SalaryPO po = salaryData.findbyPerNum(perNum);
		return po;
	}

}
