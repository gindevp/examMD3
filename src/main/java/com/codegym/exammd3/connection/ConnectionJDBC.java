package com.codegym.exammd3.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {
    public Connection getConnect(){
        Connection connection=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students?useSSL=false","root","123456");
            System.out.println("connect success");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            System.out.println("connect failed");
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static void main(String[] args) {
new ConnectionJDBC().getConnect();
    }
}
