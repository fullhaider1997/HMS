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
public class DoctorAvailability implements Serializable{
    private int practitionerID;
    private LocalDate date;
    private LocalTime timeslot;
    private String status;
    public DoctorAvailability(int practitionerID, LocalDate date, LocalTime timeslot,String status)
    {
        this.practitionerID=practitionerID;
        this.date=date;
        this.timeslot=timeslot;
        this.status=status;
    }
    
    public void setPractitionerID(int ID)
    {
        this.practitionerID=ID;
    }
    public void setDate(LocalDate date)
    {
        this.date =date;
    }
    public void setTime(LocalTime time)
    {
        this.timeslot=time;
    }
    public void setStatus(String status)
    {
        this.status=status;
    }
    public int getPractitionerID()
    {
        return this.practitionerID;
    }
    public LocalDate getDate()
    {
        return this.date;
    }
    public LocalTime getTime()
    {
        return this.timeslot;
    }
    public String getStatus()
    {
        return this.status;
    }
}
