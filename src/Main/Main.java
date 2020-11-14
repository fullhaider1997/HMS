package Main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Haider
 */
public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/Usergui/FXMLLoginSystem.fxml"));
        
        Scene scene = new Scene(root);
      
        stage.setScene(scene);
        
        stage.show();
    }

    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        

        launch(args);
        
      
    }
}
     

