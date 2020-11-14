
package DataModelLayer;


import javafx.beans.property.SimpleStringProperty;

public class Patient {
 
    private final SimpleStringProperty firstName;
    private final SimpleStringProperty lastName;
    private final SimpleStringProperty patientType;
    private final SimpleStringProperty address;
    private final SimpleStringProperty phoneNumber;
    
    
     public Patient(String firstName, String lastName, String patientType, String address, String phoneNumber){
        
         this.firstName = new SimpleStringProperty(firstName);
         this.lastName = new SimpleStringProperty(lastName);
         this.patientType = new SimpleStringProperty(patientType);
         this.address = new SimpleStringProperty(address);
         this.phoneNumber = new SimpleStringProperty(phoneNumber);
        
    }
     public void setFirstName(String firstName){
        this.firstName.set(firstName);
    }
    public void setLastName(String department){
        this.lastName.set(department);
    }
    public void setPatientType(String jobTitle){
        this.patientType.set(jobTitle);
    }
    public void setAddress(String address){
        this.address.set(address);   
    }
     public void setPhoneNumber(String phoneNumber){
        this.phoneNumber.set(phoneNumber);   
    }
    
    
    
    public String getFirstName(){
        return firstName.get();
    }
    public String getLastName(){
        return lastName.get();
    }
    public String getAddress(){
        return address.get();
    }
    public String getPatientType(){
        return patientType.get();
    }
    public String getPhoneNumber(){
        return phoneNumber.get();
    }
    
    
    
}
