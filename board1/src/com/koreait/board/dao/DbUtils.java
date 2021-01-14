package com.koreait.board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbUtils {
	public static Connection getCon() throws Exception {
		final String URL = "jdbc:mysql://localhost/javaboard1?serverTimezone=UTC&characterEncoding=UTF-8";
		final String USERNAME = "root";
		final String PASSWORD = "koreait2020";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		System.out.println("연결 이상 무");
		return con;
	}
	public static void close(Connection con, PreparedStatement ps) {
		if(ps != null) {
			try {
				ps.close();
			}catch(Exception e) {
				
			}
		}
		if(con != null) {
			try {con.close();} catch(Exception e) {}
		}
	}
	
	public static void close(Connection con, PreparedStatement ps, ResultSet rs) {
		if(rs !=null) {
			try {rs.close();} catch(Exception e) {}
		}
		close(con,ps);
	}
}
