/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import utilities.*;
import java.sql.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;
import utilities.Fpacket;
import DataModelLayer.*;
/**
 *
 * @author Haider
 */
public class Server extends AbstractServer{
      
  
     final String url = "jdbc:sqlserver://maikenserver.database.windows.net:1433;DatabaseName=hmsdatabase";
     final String user = "HMSAdmin";
     final String password = "NinjaWay123";
    
    
    
  final public static int DEFAULT_PORT = 5555;
  
  //Constructors ****************************************************
  
  /**
   * Constructs an instance of the echo server.
   *
   * @param port The port number to connect on.
   */
  public Server(int port) 
  {
    super(port);
  }
  
  public void checkUserName(){
      
  }
  

  
  //Instance methods ************************************************
  
  /**
   * This method handles any messages received from the client.
   *
   * @param msg The message received from the client.
   * @param client The connection from which the message originated.
   */
  public void handleMessageFromClient (Object msg, ConnectionToClient client)

  {
        System.out.println("Message received: "  + " from " + client);
        Fpacket Fmsg = (Fpacket)msg;
        if(Fmsg.getTpeOfRequest().equals("register"))
        {
            UserModule um= (UserModule)Fmsg.getArg1();
            try {
                client.sendToClient(QueryRequest.VerifyLogin(um));
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(Fmsg.getTpeOfRequest().equals("login"))
        {
            UserModule um= (UserModule)Fmsg.getArg1();
            try {
                client.sendToClient(QueryRequest.RegisterUser(um));
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(Fmsg.getTpeOfRequest().equals("addpatient")){
            Patient p =(Patient)Fmsg.getArg1();
            try {
                client.sendToClient(QueryRequest.AddPatient(p));
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(Fmsg.getTpeOfRequest().equals("modifypatient")){
            Patient p =(Patient)Fmsg.getArg1();
            try {
                client.sendToClient(QueryRequest.ModifyPatient(p));
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(Fmsg.getTpeOfRequest().equals("modifyemployee")){
            Employee e =(Employee)Fmsg.getArg1();
            try {
                client.sendToClient(QueryRequest.ModifyEmployee(e));
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
         //System.out.println(Fmsg.getTpeOfRequest());

      {
          
          
         System.out.println("Message received: " + msg + " from " + client);
         Fpacket Fmsg = (Fpacket)msg;
         String MessageType = Fmsg.getTpeOfRequest();
         if(MessageType.equals("authentication")){
              HandleAuthneticationRequests(Fmsg);
         }

               
               
          
         
          
       
       //this.sendToAllClients(msg);
  }
    
  public void HandleAuthneticationRequests(Fpacket msg){
      
      
              System.out.println("Handle Authnetication");
              System.out.println(msg.getTpeOfRequest());
              System.out.println(msg.getArg1());
              System.out.println(msg.getArg2());
              
        
        
      
  }
  
  protected void ConnectToDatabase() throws ClassNotFoundException {
      
       
       try {
              Class.forName("com.mysql.jdbc.Driver");
          
             Connection connection = DriverManager.getConnection(url, user, password);
             System.out.println("Connected");
             
         } catch (SQLException ex) {
             Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
             System.out.print("Error creating connection: "+ex);
         }
  }
  
  
  
  
  
  /**
   * This method overrides the one in the superclass.  Called
   * when the server starts listening for connections.
   */
  protected void serverStarted() {
      
        
      System.out.println("Server listening for connections on port " + getPort());
        
      
         try {
             ConnectToDatabase();
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
         }
     
  }
  
  /**
   * This method overrides the one in the superclass.  Called
   * when the server stops listening for connections.
   */
  protected void serverStopped()
  {
    System.out.println
      ("Server has stopped listening for connections.");
  }
  
  //Class methods ***************************************************
  
  /**
   * This method is responsible for the creation of 
   * the server instance (there is no UI in this phase).
   *
   * @param args[0] The port number to listen on.  Defaults to 5555 
   *          if no argument is entered.
   */
  public static void main(String[] args) 
  {
    int port = 0; //Port to listen on

    try
    {
      port = Integer.parseInt(args[0]); //Get port from command line
    }
    catch(Throwable t)
    {
      port = DEFAULT_PORT; //Set port to 5555
    }

    
    Server sv = new Server(port);
    
    try 
    {
       
      //sv.ConnectToDatabase();
      sv.listen(); //Start listening for connections
        
      
    } 
    catch (Exception ex) 
    {
      System.out.println("ERROR - Could not listen for clients!");
    }
    
  
     
    
  }

     
}
