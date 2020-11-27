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
public class InPatientAdmission {
    private int patientID;
    private String bedID;
    private LocalDate inDate;
    private LocalDate outDate;
    private int nurseID;
    public InPatientAdmission(int pID,String bID,LocalDate indate, LocalDate outdate, int nID){
        this.patientID=pID;
        this.bedID= bID;
        this.inDate=indate;
        this.outDate=outdate;
        this.nurseID=nID;
    }
    
    
    public void setpatientID(int ID)
    {
        this.patientID=ID;
    }
    public void setInDate(LocalDate date)
    {
        this.inDate =date;
    }
    public void setOutDate(LocalDate date)
    {
        this.outDate =date;
    }
    public void setnurseID(int nurseID)
    {
        this.nurseID=nurseID;
    }
    
    public int getpatientID()
    {
        return this.patientID;
    }
    public LocalDate getinDate()
    {
        return this.inDate;
    }
    public LocalDate getoutDate()
    {
        return this.outDate;
    }
    public int getNurseID()
    {
        return this.nurseID;
    }
    
}
