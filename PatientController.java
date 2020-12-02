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
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import utilities.Utilities;

/**
 * FXML Controller class
 *
 * @author Haider
 */
public class PatientController implements Initializable,ChatIF  {

	 @FXML
	 private Label StatusField;
	 static Client patientClient;
	 final public static int DEFAULT_PORT = 5555;
	 String host = "";
	 Utilities utility = new Utilities();

    public void setUserName(String username) throws IOException {
        
        
        StatusField.setText(username);
      
    }
    public void setClient(Client client) throws IOException {

        PatientController.patientClient = client;

    }
	
	 public void AppointmentPatientTab(ActionEvent event) throws IOException{
	      
            
		 patientClient.sendToServer("From Appointment : AppointmentPatientTab");
		 
	     utility.EmbeddFXMLIntoFXML(event, "/Usergui/patient/FXMLAppointmentsPatient.fxml", "/Usergui/patient/FXMLPatient.fxml");
	        
	   
	      
	 }
	 
	 public void FeedbackTab(ActionEvent event) throws IOException{
	      
	        
		    patientClient.sendToServer("From patient : FeedbackTab");
	     
	        utility.EmbeddFXMLIntoFXML(event, "/Usergui/patient/FXMLFeedback.fxml", "/Usergui/patient/FXMLPatient.fxml");
	        
	   
	      
	 }
	
	 public void MedicalHistoryTab(ActionEvent event) throws IOException{
	      
		    patientClient.sendToServer("From patient : MedicalHistoryTab");
	     
	     
	        utility.EmbeddFXMLIntoFXML(event, "/Usergui/patient/FXMLMedicalHistory.fxml", "/Usergui/patient/FXMLPatient.fxml");
	        
	   
	      
	 }
	 
	 public void PatientGuideTab(ActionEvent event) throws IOException{
	      
	     
	        utility.EmbeddFXMLIntoFXML(event, "/Usergui/patient/FXMLpatientGuide.fxml", "/Usergui/patient/FXMLPatient.fxml");
	        
	   
	      
	 }
	
	
	
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	
    	
    	 
        try {
        	 patientClient = new Client(host, DEFAULT_PORT, this);
     
        	 patientClient.openConnection();
        } catch (IOException ex) {
             Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
       }
    	
    	
    	
    }
	@Override
	public void display(String message) {
		// TODO Auto-generated method stub
		
	}    
    
}
