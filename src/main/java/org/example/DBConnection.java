package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    static Connection con;
    static Connection createConnection() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/school";
            String root = "root";
            String password = "shruti";
            con = DriverManager.getConnection(url, root, password);
            con.createStatement();
        }catch (Exception e){
            System.out.println(e);
        }
        return con;
    }
}

//yha humne connection create kia hai database se.