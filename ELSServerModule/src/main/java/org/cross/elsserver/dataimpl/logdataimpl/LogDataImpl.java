package org.cross.elsserver.dataimpl.logdataimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.cross.elscommon.dataservice.logdataservice.LogDataService;
import org.cross.elscommon.po.LogPO;
import org.cross.elscommon.util.MySQL;
import org.cross.elscommon.util.ResultMessage;

public class LogDataImpl extends UnicastRemoteObject implements LogDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	MySQL mysql;

	public LogDataImpl() throws RemoteException {
		super();
		mysql = new MySQL();
	}

	@Override
	public ResultMessage insert(LogPO po) throws RemoteException {
		String sql = "insert ignore into `log`(`number`, `time`, `operator`, `operation`) values ('"
				+ po.getId()+"','"+po.getTime()+"','"+po.getOperator()+"','"+po.getContent()+"')";
		if(!mysql.execute(sql)) return ResultMessage.FAILED;
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<LogPO> find(String startTime, String endTime) throws RemoteException {
		String sql = "select * from `log`";
		ArrayList<LogPO> logs = new ArrayList<LogPO>();
		ResultSet rs = mysql.query(sql);
		LogPO log = null;
		while((log = getFromDB(rs))!=null) logs.add(log);
		return logs;
	}

	@Override
	public ArrayList<LogPO> show() throws RemoteException {
		String sql = "select * from `log`";
		ArrayList<LogPO> logs = new ArrayList<LogPO>();
		ResultSet rs = mysql.query(sql);
		LogPO log = null;
		while((log = getFromDB(rs))!=null) logs.add(log);
		return logs;
	}
	
	public LogPO getFromDB(ResultSet rs) {
		LogPO po = null;
		try {
			if (rs.next()) {
				po = new LogPO(rs.getString("number"), rs.getString("time"), 
						rs.getString("operator"), rs.getString("operation"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
	}

}
