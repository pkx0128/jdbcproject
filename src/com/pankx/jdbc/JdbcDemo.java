package com.pankx.jdbc;

import java.sql.*;

/**
 * @author pankx
 * @date 2024/7/12 1:10 下午
 */
public class JdbcDemo {
    public static void main(String[] args) {
            String url = "jdbc:mysql://localhost:3306/users";
            String user = "root";
            String pwd = "root";
            Connection conn = null;
            Statement stm = null;
            String sql = "select * from user";
            ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

           conn = DriverManager.getConnection(url,user,pwd);
           stm = conn.createStatement();
          rs = stm.executeQuery(sql);

          while (rs.next()) {
              System.out.println(
                      rs.getInt("uid") + "   " +
                              rs.getString("name") + "  " +
                              rs.getString("password") + "  " +
                              rs.getString("email") + "  " +
                              rs.getString("birthday")

              );
          }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
