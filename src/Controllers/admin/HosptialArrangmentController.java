/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.admin;

import DataModelLayer.Employee;
import DataModelLayer.Room;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


public class HosptialArrangmentController implements Initializable {

     @FXML
    private Label label;
    @FXML private TextField filterFieldRooms;
    @FXML private TableView<Room> tabelViewRooms; 
    @FXML private TableColumn <Room, String> roomID;
    @FXML private TableColumn <Room, String> typeOfBed;
    @FXML private TableColumn <Room, String> StatusAvailability;
    @FXML private TableColumn <Room, Integer> numberOfBeds;
 
    
    
     private final ObservableList<Room> roomDataList = FXCollections.observableArrayList();
     
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        roomID.setCellValueFactory(new PropertyValueFactory<>("roomID"));
        typeOfBed.setCellValueFactory(new PropertyValueFactory<>("type"));
        numberOfBeds.setCellValueFactory(new PropertyValueFactory<>("NumOfBeds"));
        StatusAvailability.setCellValueFactory(new PropertyValueFactory<>("StatusAvailability"));
        
        
        Room room1 = new Room("101","Shared",3,"0/3");
        Room room2 = new Room("102","Shared",3,"2/3");
        Room room3 = new Room("103","Private",1,"1/1");
        Room room4 = new Room("104","Private",1, "0/1");
       
        
        roomDataList.addAll(room1,room2,room3,room4);
        
        FilteredList<Room> filterdData = new FilteredList<>(roomDataList, b-> true);

         filterFieldRooms.textProperty().addListener((observable,oldValue,newValue)->{
            filterdData.setPredicate(Room -> {
                
                 if(newValue== null || newValue.isEmpty()) {
                     return true;
                 }
                 if(newValue == null || newValue.isEmpty()){
                     return true;
                 }
                
                 String lowerCaseFilter = newValue.toLowerCase();
                 //int bednum = Integer.valueOf(lowerCaseFilter);
                 
                 if(Room.getRoomID().contains(lowerCaseFilter) ){
                     return true;
                 }
                 else if(Room.getType().toLowerCase().contains(lowerCaseFilter)){
                     return true;
                 }
                 else if(Room.getStatusAvailability().toLowerCase().contains(lowerCaseFilter)){
                     return true;
                 } 
                 else if (Integer.toString(Room.getNumOfBeds()).contains(lowerCaseFilter)){
                     return true;
                 }
                 else 
                     return false;
             
                
            });
            
        });
        
     
    
    
       SortedList<Room> sortedData = new SortedList<Room>(filterdData);
      
       sortedData.comparatorProperty().bind(tabelViewRooms.comparatorProperty());
       
       tabelViewRooms.setItems(sortedData);
        
        
        
        
        
        
        
        
        
        
        
       
    }    
    
    
    
    
    
    
}
