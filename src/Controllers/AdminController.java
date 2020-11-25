
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import static Controllers.LoginSystemController.DEFAULT_PORT;
import client.Client;
import common.ChatIF;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.HashSet;
import java.util.Map;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Application.launch;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import utilities.Utilities;

/**
 * FXML Controller class
 *
 * @author Haider
 */
public class AdminController implements Initializable,ChatIF {
	
     static Client adminClient;
     static String name;
    final public static int DEFAULT_PORT = 5555;
    String host = "";
    Utilities utility = new Utilities();
    
    
      public void setClient(Client client) throws IOException {
          
          
          AdminController.name = "haider";
          AdminController.adminClient = client;
          
      }
      
    
    public void ButtonGoToLogin(ActionEvent event) throws IOException{
        
        Parent parentScene = FXMLLoader.load(getClass().getResource("/Usergui/FXMLLoginSystem.fxml"));
        Scene NextScene = new Scene(parentScene);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(NextScene);
        window.show();
        
    }    
    
     public void PatientTab(ActionEvent event) throws IOException{
     
        
        if(name != null){
            System.out.println("name is not null");
        }else{
           System.out.println("name is null !");
        }
         if(adminClient == null){
            System.out.println("adminClient is null 1");
        }else{
            System.out.println("adminClient is not null 1 ! ");
        }
         
         //adminClient.sendToServer("Hello from patient tab");
       
        
        utility.EmbeddFXMLIntoFXML(event, "/Usergui/Admin/FXMLPatientView.fxml", "/Usergui/Admin/FXMLAdmin.fxml");
      
    }  
    public void EmployeeTab(ActionEvent event) throws IOException{
        
        if(adminClient == null){
            System.out.println("adminClient is null 2");
        }else{
            System.out.println("adminClient is not null 2 ! ");
        }
     
     
        utility.EmbeddFXMLIntoFXML(event, "/Usergui/Admin/FXMLHosptialEmployees.fxml", "/Usergui/Admin/FXMLAdmin.fxml");
     
        
        
       
        
    }
    
    public void HosptialArragmentTab(ActionEvent event) throws IOException {
        
     
        
        utility.EmbeddFXMLIntoFXML(event, "/Usergui/Admin/FXMLHosptialArrangment.fxml", "/Usergui/Admin/FXMLAdmin.fxml");
        
       
    }
    
    public void AdminGuideTab(ActionEvent event) throws IOException {
       
        
        
        utility.EmbeddFXMLIntoFXML(event, "/Usergui/Admin/FXMLAdminGuide.fxml", "/Usergui/Admin/FXMLAdmin.fxml");
        
    }
    
   public void ManageAppointmentsTab(ActionEvent event) throws IOException{
       
        
        
        utility.EmbeddFXMLIntoFXML(event, "/Usergui/Admin/FXMLManagingAppointments.fxml", "/Usergui/Admin/FXMLAdmin.fxml");
      
       
   }
   
   public void ExportDataTab(ActionEvent event) throws IOException {
       
      
        
       utility.EmbeddFXMLIntoFXML(event, "/Usergui/Admin/FXMLExportData.fxml", "/Usergui/Admin/FXMLAdmin.fxml");
       
       
   }
    
    
   
    
    public static void Main(String[] args) throws IOException {
         System.out.println("Admin controller 1");
                
         
   
    }
    
 

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        {
         
            System.out.println("initalize admin controller");
            
            try {
                adminClient = new Client(host, DEFAULT_PORT, this);
                adminClient.openConnection();
            } catch (IOException ex) {
                Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

   
      }

    @Override
    public void display(String message) {
        System.out.println(message);
    }
    }
