/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import utilities.*;
import java.sql.*;
import java.io.IOException;
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
        Fpacket reply;
        if(Fmsg.getTpeOfRequest().equals("register"))
        {
            UserModule um= (UserModule)Fmsg.getArg1();
            reply= new Fpacket(Fmsg.getTpeOfRequest(),QueryRequest.RegisterUser(um));
            try {
                client.sendToClient(reply);
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(Fmsg.getTpeOfRequest().equals("login"))
        {
            UserModule um= (UserModule)Fmsg.getArg1();
            reply= new Fpacket(Fmsg.getTpeOfRequest(),QueryRequest.VerifyLogin(um));
            try {
                client.sendToClient(reply);
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(Fmsg.getTpeOfRequest().equals("addpatient")){
            Patient p =(Patient)Fmsg.getArg1();
            reply= new Fpacket(Fmsg.getTpeOfRequest(),QueryRequest.AddPatient(p));
            try {
                client.sendToClient(reply);
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(Fmsg.getTpeOfRequest().equals("modifypatient")){
            Patient p =(Patient)Fmsg.getArg1();
            reply= new Fpacket(Fmsg.getTpeOfRequest(),QueryRequest.ModifyPatient(p));
            try {
                client.sendToClient(reply);
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        else if(Fmsg.getTpeOfRequest().equals("addemployee")){
            Employee e =(Employee)Fmsg.getArg1();
            reply= new Fpacket(Fmsg.getTpeOfRequest(),QueryRequest.AddEmployee(e));
            try {
                client.sendToClient(reply);
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        else if(Fmsg.getTpeOfRequest().equals("modifyemployee")){
            Employee e =(Employee)Fmsg.getArg1();
            reply= new Fpacket(Fmsg.getTpeOfRequest(),QueryRequest.ModifyEmployee(e));
            try {
                client.sendToClient(reply);
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(Fmsg.getTpeOfRequest().equals("addroom")){
            Room r= (Room)Fmsg.getArg1();
            reply= new Fpacket(Fmsg.getTpeOfRequest(),QueryRequest.AddRoom(r));
            try {
                client.sendToClient(QueryRequest.AddRoom(r));
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(Fmsg.getTpeOfRequest().equals("modifyroom")){
            Room r= (Room)Fmsg.getArg1();
            reply= new Fpacket(Fmsg.getTpeOfRequest(),QueryRequest.ModifyRoom(r));
            try {
                client.sendToClient(reply);
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(Fmsg.getTpeOfRequest().equals("addbed")){
            Bed b= (Bed)Fmsg.getArg1();
            reply= new Fpacket(Fmsg.getTpeOfRequest(),QueryRequest.AddBed(b));
            try {
                client.sendToClient(reply);
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(Fmsg.getTpeOfRequest().equals("modifybed")){
            Bed b= (Bed)Fmsg.getArg1();
            reply= new Fpacket(Fmsg.getTpeOfRequest(),QueryRequest.ModifyBed(b));
            try {
                client.sendToClient(reply);
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(Fmsg.getTpeOfRequest().equals("allpatients")){
            reply = new Fpacket(Fmsg.getTpeOfRequest(),QueryRequest.GetAllPatients());
            try {
                client.sendToClient(reply);
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(Fmsg.getTpeOfRequest().equals("alldoctors")){
            reply = new Fpacket(Fmsg.getTpeOfRequest(),QueryRequest.GetAllDoctors());
            try {
                client.sendToClient(reply);
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(Fmsg.getTpeOfRequest().equals("allnurses")){
            reply = new Fpacket(Fmsg.getTpeOfRequest(),QueryRequest.GetAllNurses());
            try {
                client.sendToClient(reply);
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(Fmsg.getTpeOfRequest().equals("alladmin")){
              reply = new Fpacket(Fmsg.getTpeOfRequest(),QueryRequest.GetAllAdmin());
            try {
                client.sendToClient(reply);
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(Fmsg.getTpeOfRequest().equals("allusers")){
            reply = new Fpacket(Fmsg.getTpeOfRequest(),QueryRequest.GetAllUsers());
            try {
                client.sendToClient(reply);
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(Fmsg.getTpeOfRequest().equals("allemployees")){
            reply = new Fpacket(Fmsg.getTpeOfRequest(),QueryRequest.GetAllEmployees());
            try {
                client.sendToClient(reply);
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        else if(Fmsg.getTpeOfRequest().equals("requestappointment"))
        {
            Appointment a= (Appointment)Fmsg.getArg1();
            try {
                client.sendToClient(QueryRequest.RequestAppointment(a));
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
  }

  
  
  
  
  /**
   * This method overrides the one in the superclass.  Called
   * when the server starts listening for connections.
   */
  protected void serverStarted() {
      
        
      System.out.println("Server listening for connections on port " + getPort());
        
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

