/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import DataModelLayer.UserModule;
import client.Client;
import common.ChatIF;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import utilities.Fpacket;
import utilities.Utilities;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Haider
 */
public class RegistrationSystemController implements Initializable,ChatIF {

    /**
     * Initializes the controller class.
     */
	
	 @FXML
	 private TextField idField;
	 @FXML
	 private TextField firstNameField;
	 @FXML
	 private TextField lastNameField;

	 Utilities tool = new Utilities();

     static String name;
    final public static int DEFAULT_PORT = 5555;
    String host = "";
    Client registerClient;
	 
	 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	
    	   System.out.println("initalize register");
         
           try {
        	   
              registerClient = new Client(host, DEFAULT_PORT, this);
      
              registerClient.openConnection();
              
          } catch (IOException ex) {
              Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }    
    
    
    public void ButtonGoToLogin(ActionEvent event) throws IOException{
        
        System.out.println("Hello world");
        Parent parentScene = FXMLLoader.load(getClass().getResource("/Usergui/FXMLLoginSystem.fxml"));
        
        Scene NextScene = new Scene(parentScene);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(NextScene);
        window.show();
    }    
    
    public void registerUser(ActionEvent event) throws IOException {
    	
    	System.out.println("Register user");
    	
         
    	String id = idField.getText();
    	String firstName = firstNameField.getText();
    	String lastName = lastNameField.getText();
    	
    	if(!id.matches(("\\d{6}"))) {
    	 
    	  idField.setStyle("-fx-background-color: #FFA07A");
    	  
    	}else{
    		
    	  idField.setStyle(null);
    	}
    	
    	if(firstName == null  || firstName.isEmpty() | Utilities.isNumeric(firstName) ) {
    	     
    	     firstNameField.setStyle("-fx-background-color: #FFA07A");
    	     
    	}else {
    		
    		 firstNameField.setStyle(null);
    	}
    	
    	if(lastName == null || lastName.isEmpty()  |  Utilities.isNumeric(lastName) ) {
    		
    		lastNameField.setStyle("-fx-background-color: #FFA07A");
    		
    	}else {
    		
    		lastNameField.setStyle(null);
    	}
    	
         
    	UserModule user = new UserModule(firstName,lastName, Integer.parseInt(id));
    	
    	Fpacket fpacket = new Fpacket("register",user);
          
    	registerClient.sendToServer(fpacket);
    	
    	
    	
    	
    	
    }


	@Override
	public void display(String message) {
		// TODO Auto-generated method stub
		
	}
    
    
}
