/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.admin;

import DataModelLayer.Patient;
import DataModelLayer.Room;
import DataModelLayer.UserModule;
import client.Client;
import common.ChatIF;

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

import Controllers.AdminController;

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
import utilities.Fpacket;
import utilities.QueryRequest;
import utilities.Utilities;
import static Controllers.LoginSystemController.DEFAULT_PORT;
/**
 *
 * @author Haider
 */
public class PatientViewController implements Initializable, ChatIF{

    
        @FXML
    private Label label;
    @FXML private TextField filterFieldPatient;
    @FXML private TableView<Patient> tableViewPatients; 
    //private final String request = "allpatient";
    
    Fpacket fpacket;
    String host = "";
    static Client client = null;
    
    AdminController admincontroller;
   
 
   // private final ObservableList<Patient> patientDataList = FXCollections.observableArrayList();
    
    
    
    
   

     
     
     
    @SuppressWarnings("unchecked")
	@Override
    public void initialize(URL location, ResourceBundle resources) {
       
  /* try {
		client = new Client(host, DEFAULT_PORT, this);
	} catch (IOException e3) {
		// TODO Auto-generated catch block
		e3.printStackTrace();
	}
       // Create the client
       //Open connection    
         try {
			client.openConnection();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
      
     if(client.isConnected()== true){
         
         System.out.println("Client is connected");
         try {
			client.sendToServer(new Fpacket("allpatients"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
   	  	 
         
         try {
			AdminController.setClient(client);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
       
     }else
       {
         
         System.out.println("Client failed to connect !");

       }
     
     while(client.getSessionType()==null) {
  	   
   	  System.out.println("Waiting for server reply....");
      }
     
    	
     try {
		AdminController.getClient().sendToServer(new Fpacket("allpatients"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
     ObservableList<Patient> patientDataList = QueryRequest.GetAllPatients();
		
    	TableColumn <Patient, Integer> ID = new TableColumn<Patient, Integer>("ID");
        TableColumn<Patient, String> firstname = new TableColumn<Patient, String>("FirstName");        
        TableColumn<Patient, String> lastname = new TableColumn<Patient, String>("LastName");
        TableColumn<Patient, String> dob = new TableColumn<Patient, String>("Date of Birth");
        TableColumn<Patient, String> address = new TableColumn<Patient, String>("Address");
        TableColumn<Patient, String> phonenumber = new TableColumn<Patient, String>("Phone Number");
        TableColumn<Patient, String> condition = new TableColumn<Patient, String>("Condition");

        ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        firstname.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastname.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        condition.setCellValueFactory(new PropertyValueFactory<>("conditions"));
        dob.setCellValueFactory(new PropertyValueFactory<>("DOB"));
        address.setCellValueFactory(new PropertyValueFactory<>("Address"));
        phonenumber.setCellValueFactory(new PropertyValueFactory<>("PhoneNumber"));

        tableViewPatients.getColumns().addAll(ID,firstname, lastname, dob, address, phonenumber, condition);


        FilteredList<Patient> filterdData = new FilteredList<>(patientDataList, b-> true);

         filterFieldPatient.textProperty().addListener((observable,oldValue,newValue)->{
            filterdData.setPredicate(Patient -> {

                 if(newValue== null || newValue.isEmpty()) {
                     return true;
                 }
                 if(newValue == null || newValue.isEmpty()){
                     return true;
                 }
                 if(newValue == null || newValue.isEmpty()){
                     return true;
                 }

                 String lowerCaseFilter = newValue.toLowerCase();

                 if(Integer.toString(Patient.getID()).toLowerCase().contains(lowerCaseFilter) ){
                     return true;
                 }
                 else if(Patient.getFirstName().toLowerCase().contains(lowerCaseFilter) ){
                     return true;
                 }
                 else if (Patient.getLastName().toLowerCase().contains(lowerCaseFilter))
                 {
                     return true;
                 }
                 else if(Patient.getDOB().toLowerCase().contains(lowerCaseFilter) ){
                     return true;
                 }
                 else if(Patient.getAddress().toLowerCase().contains(lowerCaseFilter) ){
                     return true;
                 }
                 else if(Patient.getPhoneNumber().toLowerCase().contains(lowerCaseFilter) ){
                     return true;
                 }
                 else if (Patient.getConditions().toLowerCase().contains(lowerCaseFilter))
                 {
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



    public static void setClient(Client client) throws IOException {

        PatientViewController.client = client;

    }


	@Override
	public void display(String message) {
		// TODO Auto-generated method stub
		System.out.println("> " + message);
	}
    
}