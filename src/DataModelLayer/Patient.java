/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataModelLayer;

/**
 *
 * @author maiken
 */
import java.time.*;
import javafx.beans.property.SimpleStringProperty;
import java.io.Serializable;

public class Patient implements Serializable{
    
    private int ID;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String address;
    private String phoneNumber;
    
    
    public Patient(int ID,String firstName, String lastName , LocalDate dob, String address, String phoneNumber)
    {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.address = address;
        this.phoneNumber =phoneNumber;
    }
    public Patient(String firstName, String lastName , LocalDate dob, String address, String phoneNumber){
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.address = address;
        this.phoneNumber =phoneNumber;
    }
    
    
    public void setFirstName(String firstName){
        this.firstName= firstName;
    }
    public void setLastName(String lastname){
        this.lastName =lastname;
    }
    public void setDOB(LocalDate dob){
        this.dob = dob;
    }
    public void setAddress(String address){
        this.address = address;   
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber= phoneNumber;   
    }
    
    
    public int getID(){
        return ID;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getAddress(){
        return address;
    }
    public String getDOB(){
        return dob.toString();
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
}
