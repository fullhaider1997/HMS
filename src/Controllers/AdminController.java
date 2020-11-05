/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Haider
 */
public class AdminController implements Initializable {

      private static final String SERVER_IP = "127.0.0.1";
      private static final int SERVER_PORT = 9090;
    
    public void ButtonGoToLogin(ActionEvent event) throws IOException{
        
        
        Parent parentScene = FXMLLoader.load(getClass().getResource("/Usergui/FXMLLoginSystem.fxml"));
        Scene NextScene = new Scene(parentScene);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(NextScene);
        window.show();
    }    
    public void EmployeeTab(ActionEvent event) throws IOException{
        
        System.out.println("Employee tab");
    }
    
    
    
   
    
    public static void Main(String[] args) throws IOException {
         System.out.println("Admin controller");
                
         
   
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        {
        }
        }

    
}
