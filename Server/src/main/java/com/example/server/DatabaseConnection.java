package com.example.server;

        import java.sql.Connection;
        import java.sql.DriverManager;

public class DatabaseConnection {
    public static Connection databaseLink;

    public static Connection getConnection(){
        String databaseName = "account_db"; //name of the db
        String databaseUser = "root"; //username of the db
        String databasePassword = "abcd1234";//password of the db
        String url = "jdbc:mysql://localhost:3306/" + databaseName; //url of the db

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        }catch (Exception e){
            e.printStackTrace();// print stack tree
            e.getCause();
        }
        return databaseLink;
    }
}
