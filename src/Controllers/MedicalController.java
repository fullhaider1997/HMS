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

import client.Client;
import common.ChatIF;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import utilities.Utilities;

/**
 * FXML Controller class
 *
 * @author Haider
 */
public class MedicalController implements Initializable, ChatIF {

    
	 @FXML
	 private Label StatusField;
	 static Client doctorClient;
	 final public static int DEFAULT_PORT = 5555;
	 static String name;
	 String host = "";
	 Utilities utility = new Utilities();

    public void setUserName(String username) throws IOException {
        
        
        StatusField.setText(username);
      
    }
    public void setClient(Client client) throws IOException {

        MedicalController.doctorClient = client;

    }
    
    
    
    
	  public void ViewPatientsMedicalHistorytTab(ActionEvent event) throws IOException{
	      
	        doctorClient.sendToServer("From doctor : ViewPatientsMedicalHistorytTab");
	     
	   
	        utility.EmbeddFXMLIntoFXML(event, "/Usergui/doctor/FXMLViewPatients.fxml", "/Usergui/doctor/FXMLMedical.fxml");
	        
	    
	    }  
	  
	  public void ViewAppointmenttTab(ActionEvent event) throws IOException{
	      
		   doctorClient.sendToServer("From doctor : ViewAppointmenttTab");
		  
	    
	        utility.EmbeddFXMLIntoFXML(event, "/Usergui/doctor/FXMLViewAppointment.fxml", "/Usergui/doctor/FXMLMedical.fxml");
	        
	    
	    }  
	  
	  public void DoctorGuidetTab(ActionEvent event) throws IOException{
	      
		   doctorClient.sendToServer("From doctor : DoctorGuidetTab");      
		
	   
	        utility.EmbeddFXMLIntoFXML(event, "/Usergui/doctor/FXMLDoctorGuide.fxml", "/Usergui/doctor/FXMLMedical.fxml");
	        
	    
	    }  
	
	
	
    
   
    
    
	  @Override
		public void display(String message) {
			// TODO Auto-generated method stub
			
		}
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      

        System.out.println("initalize doctor controller");
        
         try {
              doctorClient = new Client(host, DEFAULT_PORT, this);
      
              doctorClient.openConnection();
         } catch (IOException ex) {
              Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	

    }    
    

