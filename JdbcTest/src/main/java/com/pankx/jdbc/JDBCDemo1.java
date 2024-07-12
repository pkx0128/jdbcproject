package com.pankx.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String user = "root";
		String pwd = "pkx0128";
		String sql = "select * from users";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pwd);
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println(
							rs.getInt("id") + "  " +
									rs.getString("name") + " " +
									rs.getString("password") + " " +
									rs.getString("email") + " " +
									rs.getString("birthday")
						);
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
