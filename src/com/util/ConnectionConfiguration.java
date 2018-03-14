//defining the connection
//return connection object
//every time we need to connect to mysql, we use this method

package com.util;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionConfiguration {

    public static Connection getConnection(){
        Connection connection = null;

        //1. try to connect to the sql database
        try{
            //pointer to driver mysql connector
            Class.forName("com.mysql.jdbc.Driver");
            //retrieving my connection object

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demojdbc", "root", "root");

        }
        catch(Exception exc){
            exc.printStackTrace();
        }

        return connection;
    }



}
