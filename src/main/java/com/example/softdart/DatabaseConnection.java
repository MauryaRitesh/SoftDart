package com.example.softdart;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public Connection databaseLink;
//    private String databaseName;
//    private String databaseUser;
    public Connection getConnection(){
        String databaseName = "account_db";
        String databaseUser = "root";
        String databasePassword = "admin";
        //String databaseName;
        String url = "jdbc:mysql://localhost:3306/" + "account_db" ;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
        return databaseLink;
    }
}
