/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author USER
 */
public class Conexion {
    public static Connection getConexion(){
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/sakila?useSSL=false";
        String user = "root";
        String pass = "root";
        String driver = "com.mysql.jdbc.Driver";
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url,user,pass);
        } catch (Exception e) {
            System.out.println("ERROR CONEXION");
        }
        return conn;
    }
}
