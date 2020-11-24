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
public class Appointment implements Serializable{
    private int appID;
    private int patientID;
    private int PractitionerID;
    private String roomID;
    private LocalDate appDate;
    private LocalTime appTime;
    private String status;
    
    public Appointment(int patientID, int practitionerID, String roomID, LocalDate appDate, LocalTime appTime, String status)
    {
        this.patientID = patientID;
        this.PractitionerID = practitionerID;
        this.roomID= roomID;
        this.appDate= appDate;
        this.appTime= appTime;
        this.status= status;
    }
    public Appointment(int appID, int patientID, int practitionerID, String roomID, LocalDate appDate, LocalTime appTime, String status)
    {
        this.appID = appID;
        this.patientID = patientID;
        this.PractitionerID = practitionerID;
        this.roomID= roomID;
        this.appDate= appDate;
        this.appTime= appTime;
        this.status= status;
    }
    
   public void setAppID(int ID){
       this.appID=ID;
   } 
   public void setPatientID(int ID){
       this.patientID=ID;
   } 
   public void setPractitionerID(int ID){
       this.PractitionerID=ID;
   } 
   public void setRoomID(String ID){
       this.roomID=ID;
   }
   public void setAppDate(LocalDate d){
       this.appDate =d;
   } 
   public void setAppTime(LocalTime t){
       this.appTime=t;
   } 
   public void setStatus(String status){
       this.status = status;
   } 
   
   public int getPatientID()
   {
       return this.patientID;
   }
   public int getPractitionerID()
   {
       return this.PractitionerID;
   }
   public int getAppID()
   {
       return this.appID;
   }
   public String getRoomID()
   {
       return this.roomID;
   }
   public LocalDate getappDate()
   {
       return this.appDate;
   }
   public LocalTime getappTime()
   {
       return this.appTime;
   }
   public String getStatus()
   {
       return this.status;
   }
}
