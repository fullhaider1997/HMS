package Controllers.doctor;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import DataModelLayer.Appointment;
import DataModelLayer.Employee;
import client.Client;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ViewAppointments implements Initializable {

	   
	@FXML private TextField SearchBox;
	@FXML private TableView   <Appointment> tabelView; 
	@FXML private TableColumn <Appointment, Integer> patientID;
	@FXML private TableColumn <Appointment, String> patientName;
	@FXML private TableColumn <Appointment, String> date;
	@FXML private TableColumn <Appointment, String> patientCondition;
    
	static Client doctorClient;
	 
	 
	public void setClient(Client client) throws IOException {
		
		doctorClient = client;
		
		doctorClient.sendToServer("from doctor: view appointments class");
		
	}
	 
	 
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
