
package Controllers.admin;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.Initializable;
import DataModelLayer.Employee;
import DataModelLayer.Patient;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import utilities.QueryRequest;
import utilities.Utilities;

public class HosptialEmployeesController implements Initializable {
    
    @FXML
    private Label label;
    @FXML private TextField filterField;
    @FXML private TableView<Employee> tabelView; 
    
    
   
   
    
    
    
    private final ObservableList<Employee> employeeDataList = QueryRequest.GetAllEmployees();
    
    public void EmployeeTab(ActionEvent event) throws IOException{
        
        
        Utilities utility = new Utilities();
        
        utility.EmbeddFXMLIntoFXML(event, "/Usergui/Admin/FXMLHosptialEmployeesForm.fxml", "/Usergui/Admin/FXMLAdmin.fxml");
       
        
    }
    
  
    
    
   
    @SuppressWarnings("unchecked")
	@Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
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
