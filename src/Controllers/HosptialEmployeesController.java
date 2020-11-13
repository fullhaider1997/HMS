
package Controllers;

import java.net.URL;
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

public class HosptialEmployeesController implements Initializable {
    
    @FXML
    private Label label;
    @FXML private TextField filterField;
    @FXML private TableView<Employee> tabelView; 
    @FXML private TableColumn <Employee, String> firstName;
    @FXML private TableColumn <Employee, String> department;
    @FXML private TableColumn <Employee, String> jobTitle;
    
    
    
    private final ObservableList<Employee> employeeDataList = FXCollections.observableArrayList();
    
    public void EmployeeTab(ActionEvent event) throws IOException{
        
        System.out.println("Employee tab");
        FXMLLoader fxmlLoader = new FXMLLoader();
        
       
        
      
        AnchorPane HosptialEmployeeForm = (AnchorPane)fxmlLoader.load(getClass().getResource("/Usergui/Admin/FXMLHosptialEmployeesForm.fxml"));
       
        StackPane AdminScene = (StackPane)fxmlLoader.load(getClass().getResource("/Usergui/Admin/FXMLAdmin.fxml"));
        
        BorderPane borderpane =(BorderPane)  AdminScene.lookup("#BorderPane");
        
         if(borderpane!=null){
             System.out.println("border pane exist");
         }else{
             System.out.println("border doesn't exist");
         }
         
         borderpane.setCenter(HosptialEmployeeForm );
         Scene NextScene = new Scene(AdminScene);
         Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
         window.setScene(NextScene);
         window.show();
        

        
    }
    
  
    
    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        firstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        department.setCellValueFactory(new PropertyValueFactory<>("department"));
        jobTitle.setCellValueFactory(new PropertyValueFactory<>("JobTitle"));
        
        
        Employee emp1 = new Employee("Haider","Neurology","Surgeon");
        Employee emp2 = new Employee("Joe","Internal surgery","Surgeon assistant");
        Employee emp3 = new Employee("Alaa","radiology","Surgeon");
        Employee emp4 = new Employee("Biden","Administrative","admin");
        
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
                 else if (employee.getDepartment().toLowerCase().contains(lowerCaseFilter))
                 {
                     return true;
                 }
                 else if(employee.getJobTitle().toLowerCase().contains(lowerCaseFilter)){
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
