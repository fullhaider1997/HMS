/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.admin;

import DataModelLayer.Patient;
import DataModelLayer.Room;
import client.Client;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Map;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import utilities.Utilities;
/**
 *
 * @author Haider
 */
public class PatientViewController implements Initializable{

    
        @FXML
    private Label label;
    @FXML private TextField filterFieldPatient;
    @FXML private TableView<Patient> tableViewPatients; 
    @FXML private TableColumn <Patient, String> firstName;
    @FXML private TableColumn <Patient, String> lastName;
    @FXML private TableColumn <Patient, String> typeOfPatient;
 
     private final ObservableList<Patient> patientDataList = FXCollections.observableArrayList();
    private Client adminClient;
    
    public void setClient(Client client) throws IOException {
          
          this.adminClient = client; 
         
          adminClient.sendToServer("We are still connected");
          
      }
     
     
     
     
     
     
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
        
        firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        typeOfPatient.setCellValueFactory(new PropertyValueFactory<>("typeOfPatient"));
        LocalDate dob = null;
        Patient patient1 = new Patient("Haider","Ibrahim", dob.now(), "Inpatient"," 65 falconer drive","414-414-414");
        Patient patient2 = new Patient("Alex","John", dob.now(), "Outpatient"," 25 morning drive","414-414-414");
      
         patientDataList.addAll(patient1,patient2);
        
        FilteredList<Patient> filterdData = new FilteredList<>(patientDataList, b-> true);

         filterFieldPatient.textProperty().addListener((observable,oldValue,newValue)->{
            filterdData.setPredicate(Patient -> {
                
                 if(newValue== null || newValue.isEmpty()) {
                     return true;
                 }
                 if(newValue == null || newValue.isEmpty()){
                     return true;
                 }
                
                 String lowerCaseFilter = newValue.toLowerCase();
                 
                 if(Patient.getFirstName().toLowerCase().contains(lowerCaseFilter) ){
                     return true;
                 }
                 else if (Patient.getLastName().toLowerCase().contains(lowerCaseFilter))
                 {
                     return true;
                 }
                 else if(Patient.getAddress().toLowerCase().contains(lowerCaseFilter)){
                     ;
                     return true;
                 }
                
                 else 
                     return false;
             
                
            });
            
        });
        
     
    
    
       SortedList<Patient> sortedData = new SortedList<Patient>(filterdData);
      
       sortedData.comparatorProperty().bind(tableViewPatients.comparatorProperty());
       
       tableViewPatients.setItems(sortedData);
        
        
        
    }
    
}
