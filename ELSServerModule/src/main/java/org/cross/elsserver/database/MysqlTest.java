package org.cross.elsserver.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MysqlTest {
	public static void main(String[] args)throws Exception{
		final String url = "jdbc:mysql://127.0.0.1/ELS";  
	    final String name = "com.mysql.jdbc.Driver";  
	    final String user = "test";  
	    final String password = "chen123";  
	  
	    Connection conn = null;  
	    PreparedStatement pst = null;
	    String sql = "select *from goods";
	    ResultSet rs = null;
	   
	        try {  
	            Class.forName(name);//指定连接类型  
	            conn = DriverManager.getConnection(url, user, password);//获取连接  
	            pst = conn.prepareStatement(sql);//准备执行语句  
	            rs = pst.executeQuery(sql);
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	     while(rs.next()){
	    	 System.out.println(rs.getString("belongStockArea"));
	     }
	}
}
