package crud.operations.controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static Connection myConnection;


    // design pattern single 2
    
    private DBConnection(){}
    
    public static Connection getConnection() {
        try {

            if (myConnection == null) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/MyDatabase", "root", "");
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return myConnection;
    }

    public static void disconnect() {
        if (myConnection != null) {
            myConnection = null;
        }
    }

    public static void main(String[] args) {
        DBConnection db = new DBConnection();
        db.getConnection();
    }

}
