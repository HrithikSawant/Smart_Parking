/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.smartparkingmanagement.helper;


import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionProvider {
   private static Connection con;

    public static Connection getConnection() {
        try {
            if (con == null) {
                //1 load the driver
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/smart_parking", "root", "");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
