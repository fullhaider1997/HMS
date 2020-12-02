package Controllers.admin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import DataModelLayer.Patient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import utilities.QueryRequest;
import utilities.Utilities;

public class EditPatientController implements Initializable {

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
	private TextField conditionField;

	Patient patient = PatientViewController.getPatient();

	public void ExitButton(ActionEvent event) throws IOException {
		PatientViewController.setScreen("cancelmod");

		PatientViewController.reset();
		
		Utilities utility = new Utilities();

		utility.EmbeddFXMLIntoFXML(event, "/Usergui/Admin/FXMLPatientView.fxml", "/Usergui/Admin/FXMLAdmin.fxml");

	}

	public void confirmButton(ActionEvent event) throws IOException {
		Patient edited = new Patient(patient.getID(), firstNameField.getText(), lastNameField.getText(),
				dobField.getValue(), addressField.getText(), phoneNumberField.getText(), conditionField.getText());

		if (dobField.getValue() == null) {
							
			dobField.setPromptText("INVALID DOB");
			
		} else {

			QueryRequest.ModifyPatient(edited);
			
			PatientViewController.reset();
			
			PatientViewController.setScreen("editsuccess");

			Utilities utility = new Utilities();

			utility.EmbeddFXMLIntoFXML(event, "/Usergui/Admin/FXMLPatientView.fxml", "/Usergui/Admin/FXMLAdmin.fxml");
		}

	}

	@Override
	public void initialize(URL url, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		String fname = patient.getFirstName();
		String lname = patient.getLastName();
		String address = patient.getAddress();
		String phonenumber = patient.getPhoneNumber();
		String condition = patient.getConditions();
		String dob = patient.getDOB();
		
		firstNameField.setText(fname);
		lastNameField.setText(lname);
		addressField.setText(address);
		phoneNumberField.setText(phonenumber);
		dobField.setPromptText(dob);
		conditionField.setText(condition);
	}

}
