package org.cross.elsserver.ui.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.cross.elscommon.util.DatabaseConstant;

public class MySQL {
	
	Connection con;
	PreparedStatement pst;
	
	public MySQL(){
		connect();
	}
	
	public void connect(){
		try {
			Class.forName(DatabaseConstant.name);
			con = DriverManager.getConnection(
					DatabaseConstant.url, 
					DatabaseConstant.user, 
					DatabaseConstant.password);
			StackTraceElement el = Thread.currentThread().getStackTrace()[2];
//			UIConstant.LOG.addLog(el.getClassName()+" "+el.getMethodName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean execute(String sql){
		try {
			pst = con.prepareStatement(sql);
			StackTraceElement el = Thread.currentThread().getStackTrace()[2];
			String s = el.getClassName()+" "+el.getMethodName();
			if(pst.executeUpdate() > 0) {
				UIConstant.LOG.addLog(s+" success");
				return true;
			}
			else {
				UIConstant.LOG.addLog(s+" fail");
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public ResultSet query(String sql){
		try {
			pst = con.prepareStatement(sql);
			StackTraceElement el = Thread.currentThread().getStackTrace()[2];
			UIConstant.LOG.addLog(el.getClassName()+" "+el.getMethodName());
			return pst.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
//	public void test(){
//		StackTraceElement[] temp = Thread.currentThread().getStackTrace();
//		StackTraceElement a = (StackTraceElement)temp[2];
//		System.out.println(a.getMethodName()+" "+a.getClassName());
//	}
//	
//	public static void main(String[] args){
//		MySQL t = new MySQL();
//		t.test();
//	}
}
