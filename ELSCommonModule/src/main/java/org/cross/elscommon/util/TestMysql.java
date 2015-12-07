package org.cross.elscommon.util;

public class TestMysql {
	public static void main(String[] args){
		MySQL mysql = new MySQL();
		String sql = "insert ignore into `test`(`number`,`num`) values ('001',10)";
//		String sql2 = "delete from"
		System.out.println(mysql.execute(sql));
	}
}
