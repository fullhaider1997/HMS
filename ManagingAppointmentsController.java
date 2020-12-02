/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.admin;

import java.net.URL;
import java.util.ResourceBundle;

import DataModelLayer.Appointment;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import utilities.QueryRequest;

/**
 * FXML Controller class
 *
 * @author Haider
 */
public class ManagingAppointmentsController implements Initializable {

	/**
	 * Initializes the controller class.
	 */

	@FXML
	private TextField filterField;
	@FXML
	private TextField filterField1;
	@FXML
	private TableView<Appointment> approvedTable;
	@FXML
	private TableView<Appointment> waitlistedTable;
	@FXML
	private TabPane tabPane;
	@FXML
	private Tab approveTab;
	@FXML
	private Tab waitlistTab;
	@FXML
	private TableColumn<Appointment, Integer> appID = new TableColumn<Appointment, Integer>("Appointment ID");
	@FXML
	private TableColumn<Appointment, Integer> patientID = new TableColumn<Appointment, Integer>("Patient ID");
	@FXML
	private TableColumn<Appointment, Integer> practitionerID = new TableColumn<Appointment, Integer>("Practioner ID");
	@FXML
	private TableColumn<Appointment, Integer> roomID = new TableColumn<Appointment, Integer>("Room ID");
	@FXML
	private TableColumn<Appointment, String> appDate = new TableColumn<Appointment, String>("Date");
	@FXML
	private TableColumn<Appointment, String> appTime = new TableColumn<Appointment, String>("Time");
	@FXML
	private TableColumn<Appointment, String> status = new TableColumn<Appointment, String>("Status");
	@FXML
	private TableColumn<Appointment, Integer> appID1 = new TableColumn<Appointment, Integer>("Appointment ID");
	@FXML
	private TableColumn<Appointment, Integer> patientID1 = new TableColumn<Appointment, Integer>("Patient ID");
	@FXML
	private TableColumn<Appointment, Integer> practitionerID1 = new TableColumn<Appointment, Integer>("Practioner ID");
	@FXML
	private TableColumn<Appointment, Integer> roomID1 = new TableColumn<Appointment, Integer>("Room ID");
	@FXML
	private TableColumn<Appointment, String> appDate1 = new TableColumn<Appointment, String>("Date");
	@FXML
	private TableColumn<Appointment, String> appTime1 = new TableColumn<Appointment, String>("Time");
	@FXML
	private TableColumn<Appointment, String> status1 = new TableColumn<Appointment, String>("Status");

	private final ObservableList<Appointment> AppointmentDataList = QueryRequest.GetApproved();
	private final ObservableList<Appointment> AppointmentDataList2 = QueryRequest.GetWaitlisted();
	
	public void handleApprove(Event t) {
		
		appID.setCellValueFactory(new PropertyValueFactory<>("appID"));
		patientID.setCellValueFactory(new PropertyValueFactory<>("patientID"));
		practitionerID.setCellValueFactory(new PropertyValueFactory<>("practitionerID"));
		roomID.setCellValueFactory(new PropertyValueFactory<>("roomID"));
		appDate.setCellValueFactory(new PropertyValueFactory<>("appDate"));
		appTime.setCellValueFactory(new PropertyValueFactory<>("appTime"));
		status.setCellValueFactory(new PropertyValueFactory<>("status"));
		
		FilteredList<Appointment> filterdData = new FilteredList<>(AppointmentDataList, b -> true);

		filterField.textProperty().addListener((observable, oldValue, newValue) -> {
			filterdData.setPredicate(Appointment -> {

				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}

				String lowerCaseFilter = newValue.toLowerCase();

				if (Integer.toString(Appointment.getAppID()).toLowerCase().contains(lowerCaseFilter)) {
					return true;
				} else if (Integer.toString(Appointment.getPatientID()).toLowerCase().contains(lowerCaseFilter)) {
					return true;
				} else if (Integer.toString(Appointment.getPractitionerID()).toLowerCase().contains(lowerCaseFilter)) {
					return true;
				} else if (Integer.toString(Appointment.getRoomID()).toLowerCase().contains(lowerCaseFilter)) {
					return true;
				} else if (Appointment.getAppDate().toLowerCase().contains(lowerCaseFilter)) {
					return true;
				} else if (Appointment.getAppTime().toLowerCase().contains(lowerCaseFilter)) {
					return true;
				} else if (Appointment.getStatus().toLowerCase().contains(lowerCaseFilter)) {
					return true;

				} else
					return false;

			});

		});

		SortedList<Appointment> sortedData = new SortedList<Appointment>(filterdData);

		sortedData.comparatorProperty().bind(approvedTable.comparatorProperty());

		approvedTable.setItems(sortedData);
	}

	public void handleWaitlist(Event t) {
	
		appID1.setCellValueFactory(new PropertyValueFactory<>("appID"));
		patientID1.setCellValueFactory(new PropertyValueFactory<>("patientID"));
		practitionerID1.setCellValueFactory(new PropertyValueFactory<>("practitionerID"));
		roomID1.setCellValueFactory(new PropertyValueFactory<>("roomID"));
		appDate1.setCellValueFactory(new PropertyValueFactory<>("appDate"));
		appTime1.setCellValueFactory(new PropertyValueFactory<>("appTime"));
		status1.setCellValueFactory(new PropertyValueFactory<>("status"));

		FilteredList<Appointment> filterdData = new FilteredList<>(AppointmentDataList2, b -> true);

		filterField1.textProperty().addListener((observable, oldValue, newValue) -> {
			filterdData.setPredicate(Appointment -> {

				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}

				String lowerCaseFilter = newValue.toLowerCase();

				if (Integer.toString(Appointment.getAppID()).toLowerCase().contains(lowerCaseFilter)) {
					return true;
				} else if (Integer.toString(Appointment.getPatientID()).toLowerCase().contains(lowerCaseFilter)) {
					return true;
				} else if (Integer.toString(Appointment.getPractitionerID()).toLowerCase().contains(lowerCaseFilter)) {
					return true;
				} else if (Integer.toString(Appointment.getRoomID()).toLowerCase().contains(lowerCaseFilter)) {
					return true;
				} else if (Appointment.getAppDate().toLowerCase().contains(lowerCaseFilter)) {
					return true;
				} else if (Appointment.getAppTime().toLowerCase().contains(lowerCaseFilter)) {
					return true;
				} else if (Appointment.getStatus().toLowerCase().contains(lowerCaseFilter)) {
					return true;

				} else
					return false;

			});

		});

		SortedList<Appointment> sortedData = new SortedList<Appointment>(filterdData);

		sortedData.comparatorProperty().bind(waitlistedTable.comparatorProperty());

		waitlistedTable.setItems(sortedData);

	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
	}

}
