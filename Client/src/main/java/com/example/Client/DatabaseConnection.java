package com.example.Client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class DatabaseConnection {
    public Connection databaseLink;

    public Connection getConnection(){
        /*String databaseName = "account_db";
        String databaseUser = "root";
        String databasePassword = "abcd1234";
        String url = "jdbc:mysql://localhost:3306/" + databaseName;*/

        ResourceBundle rd = ResourceBundle.getBundle("auth");

        // driver name for mysql
        String databaseName = rd.getString("databaseName");

        // url of the database
        String url = rd.getString("url");

        // username to connect db
        String databaseUser = rd.getString("databaseUser");

        // password to connect db
        String databasePassword = rd.getString("databasePassword");

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
