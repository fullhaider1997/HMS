/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataModelLayer;

import java.io.Serializable;
import java.util.HashSet;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Haider
 */
public class Room implements Serializable{
    private String roomID;
    private String type;
    private String StatusAvailability;
    private int numberOfBeds;
    
    
    
    public Room(String roomID, String type, int string,String StatusAvailability){
       
        this.roomID = roomID;
        this.type = type;
        this.numberOfBeds = string;
        this.StatusAvailability = StatusAvailability;
        
    }
    
   

	public void setRoomID(String roomID){
        this.roomID = roomID;
    }
    public void setType(String type){
        this.type= type;
    }
    public void setStatusAvailability(String StatusAvailability){
        this.StatusAvailability = StatusAvailability;
    }
    public void setNumberOfBeds(int numOfBeds){
        this.numberOfBeds = numOfBeds;
    }
    
    
    
    public String getRoomID(){
        return roomID;
    }
    public String getType(){
        return type;
    }
    public String getStatusAvailability(){
        return StatusAvailability;
    }
    public int getNumOfBeds(){
        return numberOfBeds;
    }
}
