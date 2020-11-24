/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataModelLayer;

import java.time.*;
import javafx.beans.property.SimpleStringProperty;
import java.io.Serializable;

/**
 *
 * @author maiken
 */
public class Bed implements Serializable{
    private String bedID;
    private String roomID;
    private String status;
    
    public Bed (String bedID, String roomID, String status)
    {
        this.bedID= bedID;
        this.roomID =roomID;
        this.status=status;
    }
    
    public void setBedID(String ID){
        this.bedID=ID;
    }
    
    public void setRoomID(String ID)
    {
        this.roomID=ID;
    }
    public void setStatus(String status){
        this.status=status;
    }
       
    public String getBedID()
    {
        return this.bedID;
    }
    public String getRoomID()
    {
        return this.roomID;
    }public String getStatus()
    {
        return this.status;
    }
    
}
