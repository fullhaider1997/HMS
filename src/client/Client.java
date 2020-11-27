/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import common.ChatIF;
import utilities.*;
import java.io.IOException;

import Controllers.LoginSystemController;
import ocsf.client.AbstractClient;

/**
 *
 * @author Haider
 */
public class Client extends AbstractClient  {
    
    //Instance variables **********************************************
  
  /**
   * The interface type variable.  It allows the implementation of 
   * the display method in the client.
   */
  ChatIF clientUI;
  String clientSession;
 
 
  //Constructors ****************************************************
  
  /**
   * Constructs an instance of the chat client.
   *
   * @param host The server to connect to.
   * @param port The port number to connect on.
   * @param clientUI The interface type variable.
   */
  
  public Client (String host, int port, ChatIF clientUI) throws IOException 
  {
    super(host, port); //Call the superclass constructor
    this.clientUI = clientUI;
    openConnection();
  }
    
  /**
   * This method handles all data that comes in from the server.
   *
   * @param msg The message from the server.
   */
  public void handleMessageFromServer(Object msg) 
  {
    //clientUI.display(msg.toString());
      
      Fpacket fp = (Fpacket)msg;
      
      
     // clientUI.display("Message from server Message from server !" + fp.getArg1());
      
      if(fp.getTpeOfRequest().equals("login"))
      {
          if(fp.getArg1().equals("patient"))
          {
        	
        	  System.out.println("ClientSession is " + clientSession);
        	  clientSession = fp.getArg1().toString();
            
          }
          else if(fp.getArg1().equals("admin")){
              //show admin UI
               //SessionType= "admin";
        	 
        	
        	  clientSession = fp.getArg1().toString();
        	  System.out.println("ClientSession is " + clientSession);
        	 
        	  
          }
          else if(fp.getArg1().equals("doctor")){
              //show show doctor UI
               //SessionType= "doctor";
        	  clientSession = fp.getArg1().toString();
        	  System.out.println("ClientSession is " + clientSession);
         	 
        	  
          }else if(fp.getArg1().equals("invalidlogin")){
        	
        	  clientSession = "invalidlogin";
        	  
        	  }
          
          //do the same for nurse
      }
      
      if(fp.getTpeOfRequest().equals("register"))
      {
          if(fp.getArg1().equals("success"))
          {
              //show something like "registration successful log in now"
          }
          else if(fp.getArg1().equals("invalidusername")){
        	  
              //show something like "username already used try a different one"
        	  
          }
          else if(fp.getArg1().equals("invalidID")){
        	  
              //show something like "ID doesnt exist, contact Admin to get your ID"
          }
      }
    
   
        
    
  }

  /**
   * This method handles all data coming from the UI            
   *
   * @param message The message from the UI.    
   */
  public void handleMessageFromClientUI(String message)
  {
    try
    {
      sendToServer(message);
      clientUI.display("Send from client:" + message);
    }
    catch(IOException e)
    {
      clientUI.display
        ("Could not send message to server.  Terminating client.");
      quit();
    }
  }
  
  /**
   * This method terminates the client.
   */
  public void quit()
  {
    try
    {
      closeConnection();
    }
    catch(IOException e) {}
    System.exit(0);
  }

    public String getSessionType() {
       
        
        return clientSession;
       
    }

    
}


