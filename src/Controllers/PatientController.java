/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
public class PatientController implements Initializable {

	 @FXML
	 private Label StatusField;
    

    public void setUserName(String username) throws IOException {
        
        
        StatusField.setText(username);
      
    }
    
	
	 public void AppointmentPatientTab(ActionEvent event) throws IOException{
	      
	        Utilities utility = new Utilities();
	     
	   
	     
	        utility.EmbeddFXMLIntoFXML(event, "/Usergui/patient/FXMLAppointmentsPatient.fxml", "/Usergui/patient/FXMLPatient.fxml");
	        
	   
	      
	 }
	 
	 public void FeedbackTab(ActionEvent event) throws IOException{
	      
	        Utilities utility = new Utilities();
	     
	     
	        utility.EmbeddFXMLIntoFXML(event, "/Usergui/patient/FXMLFeedback.fxml", "/Usergui/patient/FXMLPatient.fxml");
	        
	   
	      
	 }
	
	 public void MedicalHistoryTab(ActionEvent event) throws IOException{
	      
	        Utilities utility = new Utilities();
	     
	     
	        utility.EmbeddFXMLIntoFXML(event, "/Usergui/patient/FXMLMedicalHistory.fxml", "/Usergui/patient/FXMLPatient.fxml");
	        
	   
	      
	 }
	 
	 public void PatientGuideTab(ActionEvent event) throws IOException{
	      
	        Utilities utility = new Utilities();
	     
	     
	        utility.EmbeddFXMLIntoFXML(event, "/Usergui/patient/FXMLpatientGuide.fxml", "/Usergui/patient/FXMLPatient.fxml");
	        
	   
	      
	 }
	
	
	
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
