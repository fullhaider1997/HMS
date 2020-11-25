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
        
       
        FXMLLoader fxmlLoader = new FXMLLoader();
        
        AnchorPane InjectedScene = (AnchorPane)fxmlLoader.load(getClass().getResource(embeddedFXML));
       
        StackPane Scene = (StackPane)fxmlLoader.load(getClass().getResource(backgroundFXML));
        
        BorderPane borderpane =(BorderPane)  Scene.lookup("#BorderPane");
        
         if(borderpane!=null){
             System.out.println("border pane exist");
         }else{
             System.out.println("border doesn't exist");
         }
         
         borderpane.setCenter(InjectedScene );
         Scene NextScene = new Scene(Scene);
         Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
         window.setScene(NextScene);
         window.show();
        
        
    }
    
    
}
