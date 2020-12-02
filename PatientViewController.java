/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.admin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Controllers.AdminController;
import DataModelLayer.Patient;
import client.Client;
import common.ChatIF;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import utilities.Fpacket;
import utilities.QueryRequest;
import utilities.Utilities;

/**
 *
 * @author Haider
 */
public class PatientViewController implements Initializable, ChatIF {

	@FXML
	private Label label;
	@FXML
	private TextField filterFieldPatient;
	@FXML
	private TableView<Patient> tableViewPatients;
	@FXML
	private TextArea screen;
	@FXML
	private TableColumn<Patient, Integer> ID = new TableColumn<Patient, Integer>("ID");
	@FXML
	private TableColumn<Patient, String> firstname = new TableColumn<Patient, String>("FirstName");
	@FXML
	private TableColumn<Patient, String> lastname = new TableColumn<Patient, String>("LastName");
	@FXML
	private TableColumn<Patient, String> dob = new TableColumn<Patient, String>("Date of Birth");
	@FXML
	private TableColumn<Patient, String> address = new TableColumn<Patient, String>("Address");
	@FXML
	private TableColumn<Patient, String> phonenumber = new TableColumn<Patient, String>("Phone Number");
	@FXML
	private TableColumn<Patient, String> condition = new TableColumn<Patient, String>("Condition");

	private final ObservableList<Patient> patientDataList = QueryRequest.GetAllPatients();

	private static Patient editPatient;

	private static String message;

	Fpacket fpacket;
	String host = "";
	static Client client = null;

	AdminController admincontroller;

	public static Patient getPatient() {
		return editPatient;
	}

	public static void reset() {
		editPatient = null;
	}
	
	public static void setScreen(String s) {
		message = s;
	}

	public String getMessage() {
		return message;
	}

	public void displaySelected(MouseEvent event) {
		Patient exist = tableViewPatients.getSelectionModel().getSelectedItem();
		if (exist == null)
			screen.setText("No item selected");
		else {
			int ID = exist.getID();
			String fname = exist.getFirstName();
			String lname = exist.getLastName();
			String dob = exist.getDOB();
			String address = exist.getAddress();
			String phonenumber = exist.getPhoneNumber();
			screen.setText(
					String.format("ID: %d\nDOB: %s\nFirstname: %s\nLastname: %s" + "\nAddress: %s\nPhonenumber: %s",
							ID, dob, fname, lname, address, phonenumber));
			editPatient = exist;
		}
	}

	public void editPatient(ActionEvent event) throws IOException {
		if (editPatient == null)
			screen.setText("SORRY, YOU HAVE NOT SELECTED A PATIENT\nclick on a row to select a patient"
					+ "\nTIP: you can search for patients with the search bar by name or ID (or any column id)");
		else {
			Utilities utility = new Utilities();

			utility.EmbeddFXMLIntoFXML(event, "/Usergui/Admin/FXMLEditPatientForm.fxml",
					"/Usergui/Admin/FXMLAdmin.fxml");
		}
	}

	public void AddPatient(ActionEvent event) throws IOException {

		Utilities utility = new Utilities();

		utility.EmbeddFXMLIntoFXML(event, "/Usergui/Admin/FXMLPatientForm.fxml", "/Usergui/Admin/FXMLAdmin.fxml");

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		if (message == "editsuccess") 
			screen.setText("Patient data successfully modified");
		else if(message == "addsuccess")
			screen.setText("Patient successfully added into the system");
		else if(message == "canceladd")
			screen.setText("QUERY(add patient) CANCELLED");
		else if(message == "cancelmod")
			screen.setText("QUERY(modify patient) CANCELLED");
		else if(message == "home")
			screen.setPromptText("no selected item");
		
			ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
			firstname.setCellValueFactory(new PropertyValueFactory<>("firstName"));
			lastname.setCellValueFactory(new PropertyValueFactory<>("lastName"));
			condition.setCellValueFactory(new PropertyValueFactory<>("conditions"));
			dob.setCellValueFactory(new PropertyValueFactory<>("DOB"));
			address.setCellValueFactory(new PropertyValueFactory<>("Address"));
			phonenumber.setCellValueFactory(new PropertyValueFactory<>("PhoneNumber"));

			FilteredList<Patient> filterdData = new FilteredList<>(patientDataList, b -> true);

			filterFieldPatient.textProperty().addListener((observable, oldValue, newValue) -> {
				filterdData.setPredicate(Patient -> {

					if (newValue == null || newValue.isEmpty()) {
						return true;
					}
					if (newValue == null || newValue.isEmpty()) {
						return true;
					}
					if (newValue == null || newValue.isEmpty()) {
						return true;
					}

					String lowerCaseFilter = newValue.toLowerCase();

					if (Integer.toString(Patient.getID()).toLowerCase().contains(lowerCaseFilter)) {
						return true;
					} else if (Patient.getFirstName().toLowerCase().contains(lowerCaseFilter)) {
						return true;
					} else if (Patient.getLastName().toLowerCase().contains(lowerCaseFilter)) {
						return true;
					} else if (Patient.getDOB().toLowerCase().contains(lowerCaseFilter)) {
						return true;
					} else if (Patient.getAddress().toLowerCase().contains(lowerCaseFilter)) {
						return true;
					} else if (Patient.getPhoneNumber().toLowerCase().contains(lowerCaseFilter)) {
						return true;
					} else if (Patient.getConditions().toLowerCase().contains(lowerCaseFilter)) {
						return true;
					} else
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