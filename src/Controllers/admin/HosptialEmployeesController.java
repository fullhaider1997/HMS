
package Controllers.admin;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.Initializable;
import DataModelLayer.Employee;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import utilities.Utilities;

public class HosptialEmployeesController implements Initializable {
    
    @FXML
    private Label label;
    @FXML private TextField filterField;
    @FXML private TableView<Employee> tabelView; 
    @FXML private TableColumn <Employee, String> firstName;
    @FXML private TableColumn <Employee, String> Specialty;
   
    
    
    
    private final ObservableList<Employee> employeeDataList = FXCollections.observableArrayList();
    
    public void EmployeeTab(ActionEvent event) throws IOException{
        
        
        Utilities utility = new Utilities();
        
        utility.EmbeddFXMLIntoFXML(event, "/Usergui/Admin/FXMLHosptialEmployeesForm.fxml", "/Usergui/Admin/FXMLAdmin.fxml");
       
        
    }
    
  
    
    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        firstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        Specialty.setCellValueFactory(new PropertyValueFactory<>("Specialty"));
        
        
        LocalDate dob = null;
        Employee emp1 = new Employee(0, "Haider","Neurology",dob.now(), "falcner 12", "4123213213", "Nurse", "Heart");
        Employee emp2 = new Employee(1, "Joe","Internal surgery",dob.now(), "Street 32", "23235452", "Doctor", "Brain");
        Employee emp3 = new Employee(2, "Alaa","radiology",dob.now(), "Alex 23", "232323643", "Doctor", "leg");
        Employee emp4 = new Employee(3, "Biden","Administrative",dob.now(), "mohake street ", "23131245341", "Doctor", "heart");
        
        employeeDataList.addAll(emp1,emp2,emp3,emp4);
        
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
                 else if (employee.getSpecialty().toLowerCase().contains(lowerCaseFilter))
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
