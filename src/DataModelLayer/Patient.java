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
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int ID;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String address;
    private String phoneNumber;
    private String conditions;
    
    
    public Patient(int ID,String firstName, String lastName , LocalDate dob, String address, String phoneNumber, String conditions)
    {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.address = address;
        this.phoneNumber =phoneNumber;
        this.conditions= conditions;
    }
    public Patient(String firstName, String lastName , LocalDate dob, String address, String phoneNumber, String conditions){
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.address = address;
        this.phoneNumber =phoneNumber;
        this.conditions = conditions;
    }
    
    
    public Patient(String string, String string2, String string3) {
		// TODO Auto-generated constructor stub
    	this.firstName = string;
    	this.lastName = string2;
    	this.conditions = string3;
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
    public void setConditions(String conditions){
        this.conditions =conditions;
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
    public String getConditions(){
        return conditions;
    }
}
