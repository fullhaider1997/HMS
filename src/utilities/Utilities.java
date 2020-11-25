/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Haider
 */
public class Utilities {
    
    
    
    public void EmbeddFXMLIntoFXML(ActionEvent event, String embeddedFXML, String backgroundFXML) throws IOException{
        
       
        AnchorPane HosptialEmployeeForm = (AnchorPane)FXMLLoader.load(getClass().getResource(embeddedFXML));
       
        StackPane AdminScene = (StackPane)FXMLLoader.load(getClass().getResource(backgroundFXML));
        
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
    
    
}
