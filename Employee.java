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
import java.io.*;


public class Employee implements Serializable{
    
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
    private String jobtitle;
    private String specialty;
    
    
    public Employee(int ID, String firstName, String lastName , LocalDate dob, String address, String phoneNumber, String jobtitle, String specialty){
        
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.address = address;
        this.phoneNumber =phoneNumber;
        this.jobtitle = jobtitle;
        this.specialty = specialty;
    }
    public Employee(int ID, String firstName, String lastName , LocalDate dob, String address, String phoneNumber, String jobtitle){
        
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.address = address;
        this.phoneNumber =phoneNumber;
        this.jobtitle = jobtitle;
        
    }
    
    public Employee(String firstName, String lastName , LocalDate dob, String address, String phoneNumber, String jobtitle, String specialty){
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.address =address;
        this.phoneNumber = phoneNumber;
        this.jobtitle = jobtitle;
        this.specialty = specialty;
    }
      

	public void setFirstName(String firstName){
        this.firstName=firstName;
    }
    public void setLastName(String lastname){
        this.lastName= lastname;
    }
    public void setDOB(LocalDate dob){
        this.dob = dob;
    }
    public void setAddress(String address){
        this.address=address;   
    }
     public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;   
    }
    public void setJobTitle(String title){
        this.jobtitle = title;   
    }
    public void setSpecialty(String specialty){
        this.specialty = specialty;   
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
    public String getJobTitle(){
        return jobtitle;
    }
    public String getSpecialty(){
        return specialty;
    }
    
}

