/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.admin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import DataModelLayer.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import utilities.QueryRequest;
import utilities.Utilities;
/**
 * FXML Controller class
 *
 * @author Haider
 */
public class FXMLHosptialEmployeesFormController implements Initializable {

    /**
     * Initializes the controller class.
     */
	
	@FXML 
    private TextField firstNameField;
	@FXML 
    private TextField lastNameField;
	@FXML 
    private DatePicker dobField;
	@FXML 
    private TextField addressField;
	@FXML 
    private TextField phoneNumberField;
	@FXML 
    private TextField jobTitleField;
	@FXML 
    private TextField specialtyField;
	
	Employee newEmp;
	
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    	
    }   
    
    
    
    public void ExitButton(ActionEvent event) throws IOException{
    	HosptialEmployeesController.setScreen("canceladd");
        
        Utilities utility = new Utilities();
        
        utility.EmbeddFXMLIntoFXML(event, "/Usergui/Admin/FXMLHosptialEmployees.fxml", "/Usergui/Admin/FXMLAdmin.fxml");
        
    }
    
    public void confirmButton(ActionEvent event) throws IOException{
    	
    	newEmp = new Employee(firstNameField.getText(), lastNameField.getText(), dobField.getValue(), addressField.getText(), phoneNumberField.getText() , jobTitleField.getText(), specialtyField.getText());
  
    	if (dobField.getValue() == null) {
			
			dobField.setPromptText("INVALID DOB");
			
		} else {
	
			HosptialEmployeesController.setScreen("addsuccess");

			QueryRequest.AddEmployee(newEmp);
	        
	        Utilities utility = new Utilities();
	        
	        utility.EmbeddFXMLIntoFXML(event, "/Usergui/Admin/FXMLHosptialEmployees.fxml", "/Usergui/Admin/FXMLAdmin.fxml");
		}
    	
    }
    
}
