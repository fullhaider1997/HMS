/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author maiken
 */

///Provides the connection do database for Query Requests
public class ConnectionProvider {
    public static Connection getCon()
    {
          String url = "jdbc:sqlserver://maikenserver.database.windows.net:1433;database=hmsdatabase";
          String user= "HMSAdmin";
          String password= "NinjaWay123";
        try{
             Connection connection = DriverManager.getConnection(url,user,password);
             return connection;
        }
        catch(Exception e){
            return null;
        }
    }
}
