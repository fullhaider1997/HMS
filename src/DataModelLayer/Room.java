/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataModelLayer;

import java.util.HashSet;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Haider
 */
public class Room {
    private final SimpleStringProperty roomID;
    private final SimpleStringProperty typeOfBed;
    private final SimpleStringProperty StatusAvailability;
    private final SimpleStringProperty numberOfBeds;
    
    
    
    public Room(String roomID, String typeOfBed, String numberOfBeds,String StatusAvailability){
       
        this.roomID = new SimpleStringProperty(roomID);
        this.typeOfBed= new SimpleStringProperty(typeOfBed);
        this.numberOfBeds = new SimpleStringProperty(numberOfBeds);
        this.StatusAvailability = new SimpleStringProperty(StatusAvailability);
        
    }
    
    public void setRoomID(String roomID){
        this. roomID.set(roomID);
    }
    public void setTypeOfBed(String typeOfBed){
        this.typeOfBed.set(typeOfBed);
    }
    public void setStatusAvailability(String StatusAvailability){
        this.StatusAvailability.set(StatusAvailability);
    }
    public void setNumberOfBeds(String numOfBeds){
        this.numberOfBeds.set(numOfBeds);
    }
    
    
    
    public String getRoomID(){
        return roomID.get();
    }
    public String getTypeOfBed(){
        return typeOfBed.get();
    }
    public String getStatusAvailability(){
        return StatusAvailability.get();
    }
    public String getNumOfBeds(){
        return numberOfBeds.get();
    }
}
