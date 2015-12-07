package org.cross.elscommon.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
			if(pst.executeUpdate() > 0) return true;
			else return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public ResultSet query(String sql){
		try {
			pst = con.prepareStatement(sql);
			return pst.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
