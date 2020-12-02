/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataModelLayer;

import java.io.*;

/**
 *
 * @author Haider
 */
public class Room implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int roomID;
    private String type;
    private String StatusAvailability;
    private int numberOfBeds;
    
    
    
    public Room(int roomID, int num, String type,String StatusAvailability){
       
        this.roomID = roomID;
        this.type = type;
        this.numberOfBeds = num;
        this.StatusAvailability = StatusAvailability;
        
    }
    

	public void setRoomID(int roomID){
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
    
    
    
    public int getRoomID(){
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
