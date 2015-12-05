package org.cross.elsserver.dataimpl.salarydataimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import org.cross.elscommon.dataservice.salarydataservice.SalaryDataService;
import org.cross.elscommon.po.SalaryPO;
import org.cross.elscommon.util.MySQL;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.SalaryType;

public class SalaryDataImpl extends UnicastRemoteObject implements SalaryDataService {

	MySQL mysql;

	public SalaryDataImpl() throws RemoteException {
		super();
		mysql = new MySQL();
	}

	@Override
	public ResultMessage insert(SalaryPO po) throws RemoteException {
		String sql = "insert ignore into `salary`(`type`, `salaryByMonth`, `addOnce`, `addNum`, `perNum`) values ('"
				+ po.getType().toString() + "'," + po.getSalaryByMonth() + "," + po.getAddOnce() + "," + po.getAddNum()
				+ ",'" + po.getPerNum() + "')";
		if(!mysql.execute(sql)) return ResultMessage.FAILED;
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage delete(String perNum) throws RemoteException {
		String sql = "delete from `salary` where `perNum` = '"+perNum+"'";
//		if(!mysql.execute(sql)) return 
	}

	@Override
	public ResultMessage update(SalaryPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<SalaryPO> show() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SalaryPO findbyPerNum(String perNum) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<SalaryPO> findByType(SalaryType type) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
