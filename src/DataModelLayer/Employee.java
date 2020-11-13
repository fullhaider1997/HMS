/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataModelLayer;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Haider
 */
public class Employee {
    
    private final SimpleStringProperty firstName;
    private final SimpleStringProperty department;
    private final SimpleStringProperty jobTitle;
    
    
    public Employee(String name, String department,String jobTitle){
       
        this.firstName = new SimpleStringProperty(name);
        this.department = new SimpleStringProperty(department);
        this.jobTitle = new SimpleStringProperty(jobTitle);
        
    }
    
    public void setfirstName(String firstName){
        this.firstName.set(firstName);
    }
    public void setDepartment(String department){
        this.department.set(department);
    }
    public void setjobTitle(String jobTitle){
        this.jobTitle.set(jobTitle);
    }
    
    public String getFirstName(){
        return firstName.get();
    }
    public String getDepartment(){
        return department.get();
    }
    public String getJobTitle(){
        return jobTitle.get();
    }
    
    
    
}
