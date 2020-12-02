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

public class EditEmployeeController implements Initializable {

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

	Employee employee = HosptialEmployeesController.getEmployee();

	public void ExitButton(ActionEvent event) throws IOException {
		HosptialEmployeesController.setScreen("cancelmod");

		HosptialEmployeesController.reset();
		
		Utilities utility = new Utilities();

		utility.EmbeddFXMLIntoFXML(event, "/Usergui/Admin/FXMLHosptialEmployees.fxml", "/Usergui/Admin/FXMLAdmin.fxml");

	}

	public void confirmButton(ActionEvent event) throws IOException {
		Employee edited = new Employee(employee.getID(), firstNameField.getText(), lastNameField.getText(),
				dobField.getValue(), addressField.getText(), phoneNumberField.getText(), jobTitleField.getText());

		if (dobField.getValue() == null) {
			
			dobField.setPromptText("INVALID DOB");
			
		} else{

			QueryRequest.ModifyEmployee(edited);
			
			HosptialEmployeesController.reset();
			
			HosptialEmployeesController.setScreen("editsuccess");

			Utilities utility = new Utilities();

			utility.EmbeddFXMLIntoFXML(event, "/Usergui/Admin/FXMLHosptialEmployees.fxml", "/Usergui/Admin/FXMLAdmin.fxml");
		}

	}

	@Override
	public void initialize(URL url, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		String fname = employee.getFirstName();
		String lname = employee.getLastName();
		String address = employee.getAddress();
		String phonenumber = employee.getPhoneNumber();
		String jobtitle = employee.getJobTitle();
		String dob = employee.getDOB();
		
		firstNameField.setText(fname);
		lastNameField.setText(lname);
		addressField.setText(address);
		phoneNumberField.setText(phonenumber);
		dobField.setPromptText(dob);
		jobTitleField.setText(jobtitle);
	}

}
