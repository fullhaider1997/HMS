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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utilities.Utilities;

/**
 * FXML Controller class
 *
 * @author Haider
 */
public class MedicalController implements Initializable {

    
    
	  public void ViewPatientsMedicalHistorytTab(ActionEvent event) throws IOException{
	      
	        Utilities utility = new Utilities();
	     
	   
	        utility.EmbeddFXMLIntoFXML(event, "/Usergui/doctor/FXMLViewPatients.fxml", "/Usergui/doctor/FXMLMedical.fxml");
	        
	    
	    }  
	  
	  public void ViewAppointmenttTab(ActionEvent event) throws IOException{
	      
	        Utilities utility = new Utilities();
	     
	   
	        utility.EmbeddFXMLIntoFXML(event, "/Usergui/doctor/FXMLViewAppointment.fxml", "/Usergui/doctor/FXMLMedical.fxml");
	        
	    
	    }  
	  public void DoctorGuidetTab(ActionEvent event) throws IOException{
	      
	        Utilities utility = new Utilities();
	     
	   
	        utility.EmbeddFXMLIntoFXML(event, "/Usergui/doctor/FXMLDoctorGuide.fxml", "/Usergui/doctor/FXMLMedical.fxml");
	        
	    
	    }  
	
	
	
    
   
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
