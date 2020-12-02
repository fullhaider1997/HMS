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

public class patientFormController implements Initializable {

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

	Patient newpatient;

	public void ExitButton(ActionEvent event) throws IOException {
		PatientViewController.setScreen("canceladd");

		Utilities utility = new Utilities();

		utility.EmbeddFXMLIntoFXML(event, "/Usergui/Admin/FXMLPatientView.fxml", "/Usergui/Admin/FXMLAdmin.fxml");

	}

	public void confirmButton(ActionEvent event) throws IOException {

		newpatient = new Patient(firstNameField.getText(), lastNameField.getText(), dobField.getValue(),
				addressField.getText(), phoneNumberField.getText(), conditionField.getText());

		if (dobField.getValue() == null) {
			
			dobField.setPromptText("INVALID DOB");
			
		} else {
	
			PatientViewController.setScreen("addsuccess");

			QueryRequest.AddPatient(newpatient);

			Utilities utility = new Utilities();

			utility.EmbeddFXMLIntoFXML(event, "/Usergui/Admin/FXMLPatientView.fxml", "/Usergui/Admin/FXMLAdmin.fxml");
		}

	}

	@Override
	public void initialize(URL url, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}
