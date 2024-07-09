package com.pankx.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Testjdbc {
	
	public static void main(String args[]) {
		String url = "jdbc:mysql://localhost:3306/users";
		String user = "root";
		String pwd = "root";
		String sql = "select * from user";
		Connection conn=  null;
		Statement stm = null;
		ResultSet re = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 conn = DriverManager.getConnection(url, user, pwd);
			 stm = conn.createStatement();
			 re = stm.executeQuery(sql);
			 
			 System.out.println("uid " + "  " + " name " +"  " + " password "+ "  " + " email "+ "  " + " birthday ");
		
		while(re.next()) {
			System.out.println(
					re.getInt("uid") + " " +
					re.getString("name") + " " +
							re.getString("password") + " " +
					re.getString("email") + " " +
							re.getString("birthday")
					);
		}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(re != null) {
				try {
					re.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(stm !=null) {
				try {
					stm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn !=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				conn = null;
			}
 		}
	}

}
