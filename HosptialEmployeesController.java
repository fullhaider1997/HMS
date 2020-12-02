
package Controllers.admin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import DataModelLayer.Employee;
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
import utilities.QueryRequest;
import utilities.Utilities;

public class HosptialEmployeesController implements Initializable {
    
    @FXML
    private Label label;
    @FXML private TextField filterField;
    @FXML private TableView<Employee> tabelView; 
    @FXML private TextArea screen;
   
    private static String message;
    
    private static Employee editEmployee;
    
    public static Employee getEmployee() {
    	return editEmployee;
    }
    
    public static void reset() {
    	editEmployee = null;
    }
    
    public static void setScreen(String s) {
		message = s;
	}

	public String getMessage() {
		return message;
	}

	
    
    private final ObservableList<Employee> employeeDataList = QueryRequest.GetAllEmployees();
    
    public void EmployeeTab(ActionEvent event) throws IOException{
        
        
        Utilities utility = new Utilities();
        
        utility.EmbeddFXMLIntoFXML(event, "/Usergui/Admin/FXMLHosptialEmployeesForm.fxml", "/Usergui/Admin/FXMLAdmin.fxml");
       
        
    }
    
  
    public void displaySelected(MouseEvent event) {
		Employee exist = tabelView.getSelectionModel().getSelectedItem();
		if (exist == null)
			screen.setText("No item selected");
		else {
			int ID = exist.getID();
			String fname = exist.getFirstName();
			String lname = exist.getLastName();
			String dob = exist.getDOB();
			String address = exist.getAddress();
			String phonenumber = exist.getPhoneNumber();
			String jobtitle = exist.getJobTitle();
			screen.setText(
					String.format("ID: %d\nDOB: %s\nFirstname: %s\nLastname: %s" + "\nAddress: %s\nPhonenumber: %s\nJob Title: %s",
							ID, dob, fname, lname, address, phonenumber, jobtitle));
			editEmployee = exist;
		}
	}
    
    public void editEmployee(ActionEvent event) throws IOException {
		if (editEmployee == null)
			screen.setText("SORRY, YOU HAVE NOT SELECTED AN EMPLOYEE\nclick on a row to select an employee"
					+ "\nTIP: you can search for employees with the search bar by name or ID (or any column id)");
		else {
			Utilities utility = new Utilities();

			utility.EmbeddFXMLIntoFXML(event, "/Usergui/Admin/FXMLEditEmployeeForm.fxml",
					"/Usergui/Admin/FXMLAdmin.fxml");
		}
	}
    
    public void deleteEmployee(ActionEvent event) throws IOException {
		if (editEmployee == null)
			screen.setText("SORRY, YOU HAVE NOT SELECTED AN EMPLOYEE\nclick on a row to select an employee"
					+ "\nTIP: you can search for employees with the search bar by name or ID (or any column id)");
		else {
			Utilities utility = new Utilities();

			utility.EmbeddFXMLIntoFXML(event, "/Usergui/Admin/FXMLDeleteEmployeeForm.fxml",
					"/Usergui/Admin/FXMLAdmin.fxml");
		}
	}
    
   
    @SuppressWarnings("unchecked")
	@Override
    public void initialize(URL url, ResourceBundle rb) {
    	
    	if (message == "editsuccess") 
			screen.setText("Employee data successfully modified");
		else if(message == "addsuccess")
			screen.setText("Employee successfully added into the system");
		else if(message == "delsuccess")
			screen.setText("Employee successfully deleted from the system");
		else if(message == "canceladd")
			screen.setText("QUERY(add employee) CANCELLED");
		else if(message == "cancelmod")
			screen.setText("QUERY(modify employee) CANCELLED");
		else if(message == "canceldel")
			screen.setPromptText("QUERY(delete employee) CANCELLED");
		else if(message == "home")
			screen.setPromptText("no selected item");
        
        TableColumn <Employee, Integer> ID = new TableColumn<Employee, Integer>("ID");
        TableColumn<Employee, String> firstname = new TableColumn<Employee, String>("FirstName");        
        TableColumn<Employee, String> lastname = new TableColumn<Employee, String>("LastName");
        TableColumn<Employee, String> dob = new TableColumn<Employee, String>("Date of Birth");
        TableColumn<Employee, String> address = new TableColumn<Employee, String>("Address");
        TableColumn<Employee, String> phonenumber = new TableColumn<Employee, String>("Phone Number");
        TableColumn<Employee, String> jobtitle = new TableColumn<Employee, String>("Job Title");
       
        ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        firstname.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        lastname.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        jobtitle.setCellValueFactory(new PropertyValueFactory<>("JobTitle"));
        dob.setCellValueFactory(new PropertyValueFactory<>("DOB"));
        address.setCellValueFactory(new PropertyValueFactory<>("Address"));
        phonenumber.setCellValueFactory(new PropertyValueFactory<>("PhoneNumber"));
     

        tabelView.getColumns().addAll(ID,firstname, lastname, dob, address, phonenumber, jobtitle);

        
        FilteredList<Employee> filterdData = new FilteredList<>(employeeDataList, b-> true);
        
        
        filterField.textProperty().addListener((observable,oldValue,newValue)->{
            filterdData.setPredicate(employee -> {
                
                 if(newValue== null || newValue.isEmpty()) {
                     return true;
                 }
                 if(newValue == null || newValue.isEmpty()){
                     return true;
                 }
                
                 String lowerCaseFilter = newValue.toLowerCase();
                 
                 if(employee.getFirstName().toLowerCase().contains(lowerCaseFilter) ){
                     return true;
                 }
                 else if(employee.getLastName().toLowerCase().contains(lowerCaseFilter) ){
                     return true;
                 }
                 else if(employee.getJobTitle().toLowerCase().contains(lowerCaseFilter) ){
                     return true;
                 }
                 else if(employee.getDOB().toLowerCase().contains(lowerCaseFilter) ){
                     return true;
                 }
                 else if(employee.getAddress().toLowerCase().contains(lowerCaseFilter) ){
                     return true;
                 }
                 else if(employee.getPhoneNumber().toLowerCase().contains(lowerCaseFilter) ){
                     return true;
                 }
                 else if (Integer.toString(employee.getID()).toLowerCase().contains(lowerCaseFilter))
                 {
                     return true;
                 
                 }
                 else 
                     return false;
             
                
            });
            
        });
        
     
    
    
       SortedList<Employee> sortedData = new SortedList<Employee>(filterdData);
      
       sortedData.comparatorProperty().bind(tabelView.comparatorProperty());
       
       tabelView.setItems(sortedData);
    
    
    }
}
