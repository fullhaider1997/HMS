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
    
    private final String staffUsername = "medical";
    private final String patientUsername = "patient";
    private final String adminUsername = "admin";
    private final String password = "123";
    final public static int DEFAULT_PORT = 5555;
    Fpacket fpacket;
    
    
    Client client = null;
    
    String host = "";
    
    AdminController admincontroller;
 
    
    
    
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
     
        AnchorPane parentScene = (AnchorPane)fxmlLoader.load(getClass().getResource("/Usergui/FXMLRegistrationSystem.fxml"));
        
        
        Scene NextScene = new Scene(parentScene);
        
       
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(NextScene);
        window.show();
    }    
       
    /**
     *
     * @param event
     * @throws IOException
     */
    public void Login(ActionEvent event)throws IOException{

        //Get password and username from user
        String username = userNameField.getText();
        String password = passwordField.getText();
        String host = "";
      
        
        //Check if user name is valid or not
        if(username == null || password == null){
             System.out.println("user name is null");
        }
        
         
               client = new Client(host, DEFAULT_PORT, this);
             // Create the client
             //Open connection    
               client.openConnection();
            
           if(client.isConnected()== true){
               
               System.out.println("Client is connected");
               
               fpacket = new Fpacket("authentication",username,password);
             
               client.sendToServer(fpacket);
               
               
               
               
               
               
           }else{
               
               System.out.println("Client failed to connect !");
               client.sendToServer("Failed to connect !");
      
             }
          
             
           
        if(adminUsername.equals(username))
         {
          
          
        
         fxmlLoader = new FXMLLoader(); 
         fxmlLoader.setLocation(LoginSystemController.class.getResource("/Usergui/Admin/FXMLAdmin.fxml"));
         
         StackPane parentScene = fxmlLoader.load();
         
         AdminController admincontroller = fxmlLoader.getController();
  
         if(admincontroller == null){
             System.out.println("Admin controller is null !");
         }else{
             System.out.println("Admin controller is not null !");
         }
     
        
        Scene NextScene = new Scene(parentScene);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(NextScene);
        window.show();
         
       
 
       }else if(staffUsername.equals(username)){
           
        AnchorPane parentScene = (AnchorPane)fxmlLoader.load(getClass().getResource("/Usergui/FXMLMedical.fxml"));
        Scene NextScene = new Scene(parentScene);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(NextScene);
     
        window.show();
           
       } else if (patientUsername.equals(username)){
           
        AnchorPane parentScene = (AnchorPane)fxmlLoader.load(getClass().getResource("/Usergui/FXMLPatient.fxml"));
        Scene NextScene = new Scene(parentScene);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(NextScene);
        window.show();
           
           
       }
        
       
        
    }
    
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }    
    
}
