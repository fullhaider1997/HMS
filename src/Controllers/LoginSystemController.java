/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
//dsdsd 
 */
package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import  client.*;
import client.Client;
import common.ChatIF;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import DataModelLayer.UserModule;

import java.net.URL;
import java.util.HashMap;
import javafx.scene.Parent;

import utilities.Fpacket;

/**
 *
 * @author Haider
 */
public class LoginSystemController implements Initializable,ChatIF {
    
    @FXML
    private Label label;
    @FXML
    private Button button;
    @FXML 
    private TextField userNameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private LoginSystemController controllerClass;
    FXMLLoader fxmlLoader;
    @FXML
    private Label StatusField;
    
    private final String staffUsername = "doctor";
    private final String patientUsername = "patient";
    private final String adminUsername = "admin";
    private final String password = "123";
    final public static int DEFAULT_PORT = 5555;
    Fpacket fpacket;
    String host = "";
    String SessionType = "";
    Object msg = null;
  
    
    Client client = null;
    
   
    
    AdminController admincontroller;
 
  
    public void setSessionType(String string) {
    	
    	SessionType = string;
    }
    
  
    
    
    @Override
    public void display(String message) 
     {
       System.out.println("> " + message);
     }
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
       public void ButtonGoToRegistration(ActionEvent event) throws IOException{
        
        System.out.println("Hello world");
         fxmlLoader = new FXMLLoader();
     
        AnchorPane parentScene = (AnchorPane)FXMLLoader.load(getClass().getResource("/Usergui/FXMLRegistrationSystem.fxml"));
        
        
        Scene NextScene = new Scene(parentScene);
        
       
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(NextScene);
        window.show();
    }    
       
    /**
     *
     * @param event
     * @throws IOException
     * @throws InterruptedException 
     */
    public void Login(ActionEvent event)throws IOException, InterruptedException{

        //Get password and username from user
        String username = userNameField.getText();
        String password = passwordField.getText();
        
        
        //Check if user name is valid or not
        if(username == null || password == null) {
             System.out.println("user name is null");
        }
        
               client = new Client(host, DEFAULT_PORT, this);
             // Create the client
             //Open connection    
               client.openConnection();
            
           if(client.isConnected()== true){
               
               System.out.println("Client is connected");
               
               UserModule user = new UserModule(username,password);
               
               fpacket = new Fpacket("login",user);
             
               client.sendToServer(fpacket);
			   
             
           }else
             {
               
               System.out.println("Client failed to connect !");
               client.sendToServer("Failed to connect !");
      
             }
           
           //TimeUnit.SECONDS.sleep(2);
        
           //Wait for server reply
           while(client.getSessionType()==null) {
        	   
        	  System.out.println("Waiting for server reply....");
           }
           
           
           if(client.getSessionType()=="invalidlogin") 
             {
              StatusField.setStyle("-fx-border-color:red; -fx-background-color: red;");
              StatusField.setText("Wrong password or username !");
           }
           
        if(adminUsername.equals(client.getSessionType()))
         {
          
          
              
         fxmlLoader = new FXMLLoader(); 
         fxmlLoader.setLocation(LoginSystemController.class.getResource("/Usergui/Admin/FXMLAdmin.fxml"));
         
         StackPane parentScene = fxmlLoader.load();
         
         AdminController admincontroller = fxmlLoader.getController();
         admincontroller.setUserName("Username: " +username);
          admincontroller.setClient(client);
          
        Scene NextScene = new Scene(parentScene);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(NextScene);
        window.show();
         
       
 
       }else if(staffUsername.equals(client.getSessionType())){
    	   
           
    	fxmlLoader = new FXMLLoader(); 
        fxmlLoader.setLocation(LoginSystemController.class.getResource("/Usergui/doctor/FXMLMedical.fxml"));  
        
        
        StackPane parentScene = fxmlLoader.load();
        Scene NextScene = new Scene(parentScene);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        MedicalController doctorcontroller = fxmlLoader.getController();
        
        doctorcontroller.setUserName("Username: " +username);
        
        window.setScene(NextScene);
     
        window.show();
           
       } else if (patientUsername.equals(client.getSessionType())){
    	   
    	
    	   
    	   
        fxmlLoader = new FXMLLoader(); 
        fxmlLoader.setLocation(LoginSystemController.class.getResource("/Usergui/patient/FXMLPatient.fxml")); 
        StackPane parentScene = fxmlLoader.load();
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
           

        Scene NextScene = new Scene(parentScene);
        
        PatientController doctorcontroller = fxmlLoader.getController();
        
        doctorcontroller.setUserName("Username: " + username);
       
        
        window.setScene(NextScene);
        window.show();
           
           
       }
        
       
        
    }
    
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }    
    
}
