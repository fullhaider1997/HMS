/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataModelLayer;

import java.time.*;
import java.io.*;

/**
 *
 * @author maiken
 */
public class Appointment implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int appID;
    private int patientID;
    private int PractitionerID;
    private int roomID;
    private LocalDate appDate;
    private LocalTime appTime;
    private String status;
    
    public Appointment(int patientID, int practitionerID, int roomID, LocalDate appDate, LocalTime appTime, String status)
    {
        this.patientID = patientID;
        this.PractitionerID = practitionerID;
        this.roomID= roomID;
        this.appDate= appDate;
        this.appTime= appTime;
        this.status= status;
    }
    public Appointment(int appID, int patientID, int practitionerID, int roomID, LocalDate appDate, LocalTime appTime, String status)
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
   public void setRoomID(int ID){
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
       return patientID;
   }
   public int getPractitionerID()
   {
       return PractitionerID;
   }
   public int getAppID()
   {
       return appID;
   }
   public int getRoomID()
   {
       return roomID;
   }
   public String getAppDate()
   {
       return appDate.toString();
   }
   public String getAppTime()
   {
       return appTime.toString();
   }
   public String getStatus()
   {
       return status;
   }
}
