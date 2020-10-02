/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginModule;

import java.io.IOException;
import java.net.URL;
import static java.time.Clock.system;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


/**
 *
 * @author Haider
 */
public class FXMLLoginSystemController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Button button;
    @FXML 
    private TextField userNameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private FXMLLoginSystemController controllerClass;
    FXMLLoader fxmlLoader;
    
    private final String staffUsername = "medical";
    private final String patientUsername = "patient";
    private final String adminUsername = "admin";
    private final String password = "123";
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
       public void ButtonGoToRegistration(ActionEvent event) throws IOException{
        
        System.out.println("Hello world");
         fxmlLoader = new FXMLLoader();
     
        AnchorPane parentScene = (AnchorPane)fxmlLoader.load(getClass().getResource("/RegistrationModule/FXMLRegistrationSystem.fxml"));
        Scene NextScene = new Scene(parentScene);
        
       
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(NextScene);
        window.show();
    }    
       
    /**
     *
     * @param event
     * @throws IOException
     */
    public void Login(ActionEvent event)throws IOException{

        String username = userNameField.getText();
        String password = passwordField.getText();
        if(username == null || password == null){
             System.out.println("user name is null");
        }
        
        if(adminUsername.equals(username))
         {
            
            
       // FXMLLoader fxmlLoader = new FXMLLoader();
        AnchorPane parentScene = (AnchorPane)fxmlLoader.load(getClass().getResource("/AdminGui/FXMLAdminGui.fxml"));
        Scene NextScene = new Scene(parentScene);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(NextScene);
        window.show();
 
       }else if(staffUsername.equals(username)){
           
        AnchorPane parentScene = (AnchorPane)fxmlLoader.load(getClass().getResource("/medicalGui/FXMLMedicalGui.fxml"));
        Scene NextScene = new Scene(parentScene);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(NextScene);
        window.show();
           
       }
    }
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
}
