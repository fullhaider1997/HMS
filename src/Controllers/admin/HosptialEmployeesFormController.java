/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.admin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import utilities.Utilities;
/**
 * FXML Controller class
 *
 * @author Haider
 */
public class HosptialEmployeesFormController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    
    public void ExitButton(ActionEvent event) throws IOException{
        
        Utilities utility = new Utilities();
        
        utility.EmbeddFXMLIntoFXML(event, "/Usergui/Admin/FXMLHosptialEmployees.fxml", "/Usergui/Admin/FXMLAdmin.fxml");
        
    }
    
    public void confirmButton(ActionEvent event) throws IOException{
        
        
        Utilities utility = new Utilities();
        
        utility.EmbeddFXMLIntoFXML(event, "/Usergui/Admin/FXMLHosptialEmployees.fxml", "/Usergui/Admin/FXMLAdmin.fxml");
    }
    
}
