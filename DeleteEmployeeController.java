package Controllers.admin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import DataModelLayer.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import utilities.QueryRequest;
import utilities.Utilities;

public class DeleteEmployeeController implements Initializable {

	/**
	 * Initializes the controller class.
	 */

	@FXML TextArea areyousure;

	Employee employee = HosptialEmployeesController.getEmployee();

	public void ExitButton(ActionEvent event) throws IOException {
		HosptialEmployeesController.setScreen("canceldel");

		HosptialEmployeesController.reset();
		
		Utilities utility = new Utilities();

		utility.EmbeddFXMLIntoFXML(event, "/Usergui/Admin/FXMLHosptialEmployees.fxml", "/Usergui/Admin/FXMLAdmin.fxml");

	}

	public void confirmButton(ActionEvent event) throws IOException {
		
			QueryRequest.DeleteEmployee(employee);
			
			HosptialEmployeesController.reset();
			
			HosptialEmployeesController.setScreen("delsuccess");

			Utilities utility = new Utilities();

			utility.EmbeddFXMLIntoFXML(event, "/Usergui/Admin/FXMLHosptialEmployees.fxml", "/Usergui/Admin/FXMLAdmin.fxml");

	}

	@Override
	public void initialize(URL url, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		int ID = employee.getID();
		String fname = employee.getFirstName();
		String lname = employee.getLastName();
		String address = employee.getAddress();
		String phonenumber = employee.getPhoneNumber();
		String jobtitle = employee.getJobTitle();
		String dob = employee.getDOB();
		
		areyousure.setText(String.format("Are you sure you want to delete the employee with the\nfollowing credential?"
				+ "Employee ID:\t%d\n"
				+ "Employee First Name:\t%s\n"
				+ "Employee Last Name:\t%s\n"
				+ "Employee DOB:\t%s\n"
				+ "Employee Address:\t%s\n"
				+ "Employee Phone:\t%s\n"
				+ "Employee Job Title:\t%s", ID, fname, lname, dob, address, phonenumber, jobtitle));
	}

}
