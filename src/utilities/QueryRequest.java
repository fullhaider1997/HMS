/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import DataModelLayer.*;
import java.sql.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.util.*;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;
import java.time.LocalDate;
/**
 *
 * @author maiken
 */
public class QueryRequest {
    public static String RegisterUser(UserModule ur)
    {
        String verify="";
        //check if ID is valid
        try{
            Connection con=ConnectionProvider.getCon();
            System.out.println("Connected to Microsft SQL SERVER:Registering user..");
            PreparedStatement myStmt= con.prepareStatement("Select adminID from Admins where adminID= ?"
                    + "union select patientID from Patients where patientID =?"
                    + "union select practitionerID from Practitioners where practitionerID=?"
                    + "union select nurseID from Nurses where nurseID=?");
            myStmt.setInt(1, ur.getID());
            myStmt.setInt(2, ur.getID());
            myStmt.setInt(3, ur.getID());
            myStmt.setInt(4, ur.getID());
            
            ResultSet res = myStmt.executeQuery();
            if(!res.next()){
                con.close();
                return "invalidID";
            }
        }
         catch(SQLException ex) 
        {
            System.out.println("Error: User registration..");
            ex.printStackTrace();
            return "error";
        }
        
        //check if username/ID already used
        try{
            Connection con=ConnectionProvider.getCon();
            PreparedStatement myStmt= con.prepareStatement("Select username, ID from Users where username= ? or "
                    + "ID =?");
            myStmt.setString(1,ur.getUsername());
            myStmt.setInt(2, ur.getID());
            
            ResultSet res = myStmt.executeQuery();
            while(res.next())
            {
                if(res.getString("username").equals(ur.getUsername()))
                {
                    con.close();
                    return "usernameused";
                }
                if(res.getInt("ID") == ur.getID())
                {
                    con.close();
                    return "IDused";
                }
            }
        }
         catch(SQLException ex) 
        {
            System.out.println("Error: User registration..");
            ex.printStackTrace();
            return "error";
        }
        
        //all checks done, insert to Users
        try{
            Connection con=ConnectionProvider.getCon();
            PreparedStatement myStmt= con.prepareStatement("Insert into Users (username,password,ID)"
                    + "Values (?,?,?)");
            myStmt.setString(1,ur.getUsername());
            myStmt.setString(2, ur.getPassword());
            myStmt.setInt(3, ur.getID());
            
            int count = myStmt.executeUpdate();
            //if it is added
            if(count>0)
            {
                con.close();
                verify = "registered";
            }
            else{
                con.close();
                return "error";
            }
        }
         catch(SQLException ex) 
        {
            System.out.println("Error: User registration..");
            ex.printStackTrace();
            return "error";
        }
        //if it gets here, everything is good
        return verify;
    }
    
    public static String VerifyLogin(UserModule user)
    {
        String verify="";
        try{
            Connection con=ConnectionProvider.getCon();
            System.out.println("Connected to Microsft SQL SERVER:Checking Login user..");
            
            PreparedStatement myStmt = con.prepareStatement("Select * from Users where username = ? and "
                    + "password = ?");
            myStmt.setString(1, user.getUsername());
            myStmt.setString(2, user.getPassword());
            ResultSet res = myStmt.executeQuery();
            if(res.getRow()!=1)
            {   
                String id= res.getString("ID");
                switch (id.charAt(0)) {
                    case '1':
                        verify="patient";
                        break;
                    case '2':
                        verify="doctor";
                        break;
                    case '3':
                        verify="nurse";
                        break;
                    case '4':
                        verify="admin";
                        break;
                    default:
                        break;
                }
                con.close();
            }
            else
            {
                verify="invalidlogin";
            }
        }
        catch(SQLException ex) 
        {
            System.out.println("Error: Login Verification");
            ex.printStackTrace();
            return "error";
        }
        return verify;
    }
   
    public static String AddPatient(Patient p)
    {
        String verify="";
        try{
            Connection con=ConnectionProvider.getCon();
            System.out.println("Connected to Microsft SQL SERVER:Adding Patient..");
            
            PreparedStatement myStmt = con.prepareStatement("Insert into Patients(firstname,lastname,dob,addr,phonenumber,conditions)"
                    + " Values(?,?,?,?,?,?)");
            myStmt.setString(1, p.getFirstName());
            myStmt.setString(2, p.getLastName());
            myStmt.setString(3, p.getDOB().toString());
            myStmt.setString(4, p.getAddress());
            myStmt.setString(5, p.getPhoneNumber());
            myStmt.setString(6, p.getConditions());
           
            int count = myStmt.executeUpdate();
            if(count>0)
            {
                verify="success";
                System.out.println("Success:Added Patient..");
                con.close();
            }
            else
                verify="fail";
            con.close();
        }
        catch(SQLException ex) 
        {
            System.out.println("Error: Adding Patient");
            ex.printStackTrace();
        }
        return verify;
    }
    
    public static String ModifyPatient(Patient p)
    {
        String verify="";
        try{
            Connection con=ConnectionProvider.getCon();
            System.out.println("Connected to Microsft SQL SERVER:Modifying Patient..");
            
            PreparedStatement myStmt = con.prepareStatement("Update Patients Set firstname=?"
                    + "lastname=?, dob=?, addr=?,phonenumber=?, conditions=? where patientID=?");
            myStmt.setString(1, p.getFirstName());
            myStmt.setString(2, p.getLastName());
            myStmt.setString(3, p.getDOB());
            myStmt.setString(4, p.getAddress());
            myStmt.setString(5, p.getPhoneNumber());
            myStmt.setString(6, p.getConditions());
            myStmt.setInt(7,p.getID());
            int count = myStmt.executeUpdate();
            if(count>0)
            {
                verify="success";
                System.out.println("Success:Modified Patient..");
                con.close();
            }
            else
                verify="fail";
            con.close();
        }
        catch(SQLException ex) 
        {
            System.out.println("Error: Modifying Patient");
            ex.printStackTrace();
        }
        return verify;
    }
    public static String AddEmployee(Employee e){
        String verify="";
        try{
            Connection con=ConnectionProvider.getCon();
            System.out.println("Connected to Microsft SQL SERVER:Adding Employee..");
            
            PreparedStatement myStmt = con.prepareStatement("Insert into ? Values(?,?,?,?,?,?)");

            if(e.getJobTitle().equals("doctor")){
                myStmt.setString(1, "Practitioners");
                myStmt.setString(7, e.getSpecialty());
            }
            
            else if(e.getJobTitle().equals("nurse")){
                myStmt.setString(1, "Nurses");
                myStmt.setString(7, null);
            }
            
            myStmt.setString(2, e.getFirstName());
            myStmt.setString(3, e.getLastName());
            myStmt.setString(4, e.getDOB());
            myStmt.setString(5, e.getAddress());
            myStmt.setString(6, e.getPhoneNumber());
            
            int count = myStmt.executeUpdate();
            if(count>0)
            {
                verify="success";
                con.close();
            }
            else
                verify="fail";
            con.close();
        }
        catch(SQLException ex) 
        {
            System.out.println("Error: Adding Employee");
            ex.printStackTrace();
        }
        return verify;
    }
    public static String ModifyEmployee(Employee e){
        String verify="";
        int count=0;
        try{
            Connection con=ConnectionProvider.getCon();
            System.out.println("Connected to Microsft SQL SERVER:Modifying Employee..");
             PreparedStatement myStmt;
            if(e.getJobTitle().toString().equals("doctor")){
                myStmt = con.prepareStatement("Update Practitioners Set firstname=?"
                    + "lastname=?, dob=?, addr=?,phonenumber=?, specialty =? "
                        + "where practitionerID=?");
                myStmt.setString(1, e.getFirstName());
                myStmt.setString(2, e.getLastName());
                myStmt.setString(3, e.getDOB());
                myStmt.setString(4, e.getAddress());
                myStmt.setString(5, e.getPhoneNumber());
                myStmt.setString(6, e.getSpecialty());
                myStmt.setInt(7,e.getID());
                count = myStmt.executeUpdate();
            }
            else if(e.getJobTitle().toString().equals("nurse")){
                 myStmt = con.prepareStatement("Update Nurses Set firstname=?"
                    + "lastname=?, dob=?, addr=?,phonenumber=? where nurseID=?");
                myStmt.setString(1, e.getFirstName());
                myStmt.setString(2, e.getLastName());
                myStmt.setString(3, e.getDOB());
                myStmt.setString(4, e.getAddress());
                myStmt.setString(5, e.getPhoneNumber());
                myStmt.setInt(6,e.getID());
                count = myStmt.executeUpdate();
            }
            
            if(count>0)
            {
                verify="success";
                System.out.println("Success:Modified Patient..");
                con.close();
            }
            else
                verify="fail";
            con.close();
        }
        catch(SQLException ex) 
        {
            System.out.println("Error: Modifying Patient");
            ex.printStackTrace();
        }
        return verify;
    }
    
    public static String AddRoom(Room r){
         String verify="";
        try{
            Connection con=ConnectionProvider.getCon();
            System.out.println("Connected to Microsft SQL SERVER:Adding Room..");
            
            PreparedStatement myStmt = con.prepareStatement("Insert into Rooms(roomID,bedcount,type,status)"
                    + " Values(?,?,?,?)");
            myStmt.setString(1, r.getRoomID());
            myStmt.setInt(2, r.getNumOfBeds());
            myStmt.setString(3, r.getType());
            myStmt.setString(4, r.getStatusAvailability());
        
           
            int count = myStmt.executeUpdate();
            if(count>0)
            {
                verify="success";
                System.out.println("Success:Added Room..");
                con.close();
            }
            else
                verify="fail";
            con.close();
        }
        catch(SQLException ex) 
        {
            System.out.println("Error: Adding Room");
            ex.printStackTrace();
        }
        return verify;
    }
    
     public static String ModifyRoom(Room r){
         String verify="";
        try{
            Connection con=ConnectionProvider.getCon();
            System.out.println("Connected to Microsft SQL SERVER:Adding Room..");
            
            //cannot change number of bed, need to use Bed class to remove beds or add beds
            PreparedStatement myStmt = con.prepareStatement("Update Rooms Set roomID =?,type = ?,status=?)");
            myStmt.setString(1, r.getRoomID());
            myStmt.setString(2, r.getType());
            myStmt.setString(3, r.getStatusAvailability());
        
           
            int count = myStmt.executeUpdate();
            if(count>0)
            {
                verify="success";
                System.out.println("Success:Modified Room..");
                con.close();
            }
            else
                verify="fail";
            con.close();
        }
        catch(SQLException ex) 
        {
            System.out.println("Error: Modifying Room");
            ex.printStackTrace();
        }
        return verify;
    }
     
    public static String AddBed(Bed b){
         String verify="";
        try{
            Connection con=ConnectionProvider.getCon();
            System.out.println("Connected to Microsft SQL SERVER:Adding Bed..");
            
            PreparedStatement myStmt = con.prepareStatement("Insert into Beds(bedID, roomID, status)"
                    + " Values(?,?,?)");
            myStmt.setString(1, b.getBedID());
            myStmt.setString(2, b.getRoomID());
            myStmt.setString(3, b.getStatus());
        
            int count = myStmt.executeUpdate();
            if(count>0)
            {
                verify="success";
                System.out.println("Success:Added Bed.");
                con.close();
            }
            else
                verify="fail";
            con.close();
        }
        catch(SQLException ex) 
        {
            System.out.println("Error: Adding Bed");
            ex.printStackTrace();
        }
        
        //need to update of bedcounts in that room
        try{
            Connection con=ConnectionProvider.getCon();
            
            //cannot change number of bed, need to use Bed class to remove beds or add beds
            PreparedStatement myStmt = con.prepareStatement("Update Rooms Set bedcount= bedcount+1)");
           
            int count = myStmt.executeUpdate();
            if(count>0)
            {
                verify="success";
                System.out.println("Success:Updated Room bedcount..");
                con.close();
            }
            else
                verify="fail";
            con.close();
        }
        catch(SQLException ex) 
        {
            System.out.println("Error: Updating Room bedcount..");
            ex.printStackTrace();
        }
        
        return verify;
    }
    
    public static String ModifyBed(Bed b){
         String verify="";
        try{
            Connection con=ConnectionProvider.getCon();
            System.out.println("Connected to Microsft SQL SERVER:Adding Room..");
            
            //cannot change number of bed, need to use Bed class to remove beds or add beds
            PreparedStatement myStmt = con.prepareStatement("Update Bed Set bedID = ?,roomID= ?,status=?)");
            myStmt.setString(1, b.getBedID());
            myStmt.setString(2, b.getRoomID());
            myStmt.setString(3, b.getStatus());
        
           
            int count = myStmt.executeUpdate();
            if(count>0)
            {
                verify="success";
                System.out.println("Success:Modified Bed..");
                con.close();
            }
            else
                verify="fail";
            con.close();
        }
        catch(SQLException ex) 
        {
            System.out.println("Error: Modifying Bed");
            ex.printStackTrace();
        }
        return verify;
    }
    
    //sends back a list of patients
    public static ObservableList<Patient> GetAllPatients(){
        ObservableList<Patient> patients= FXCollections.observableArrayList();
         try{
            Connection con=ConnectionProvider.getCon();
            System.out.println("Connected to Microsft SQL SERVER:Getting all patients..");
            PreparedStatement myStmt= con.prepareStatement("Select * from Patients");
            
            
            ResultSet res = myStmt.executeQuery();
            while(res.next())
            {
                Patient p = new Patient(res.getInt("patientID"),res.getString("firstname"),res.getString("lastname"),
                        LocalDate.parse(res.getString("dob")),res.getString("addr"),
                        res.getString("phonenumber"),res.getString("conditions"));
                patients.add(p);
            }
        }
         catch(SQLException ex) 
        {
            System.out.println("Error: Getting all patients..");
            ex.printStackTrace();
        }
         return patients;
    }
    
     public static ObservableList<Employee> GetAllDoctors(){
    	 ObservableList<Employee> doctors= FXCollections.observableArrayList();
         try{
            Connection con=ConnectionProvider.getCon();
            System.out.println("Connected to Microsft SQL SERVER:Getting all doctors..");
            PreparedStatement myStmt= con.prepareStatement("Select * from Practitioners");
            
            
            ResultSet res = myStmt.executeQuery();
            while(res.next())
            {
                Employee e = new Employee(res.getInt(""), res.getString("firstname"),res.getString("lastname"),
                        LocalDate.parse(res.getString("dob")),res.getString("addr"),
                        res.getString("phonenumber"),"doctor",res.getString("specialty"));
                doctors.add(e);
            }
        }
         catch(SQLException ex) 
        {
            System.out.println("Error: Getting all doctors..");
            ex.printStackTrace();
        }
         return doctors;
    }
     
    public static ObservableList<Employee> GetAllNurses(){
        ObservableList<Employee> nurses= FXCollections.observableArrayList();
         try{
            Connection con=ConnectionProvider.getCon();
            System.out.println("Connected to Microsft SQL SERVER:Getting all nurses..");
            PreparedStatement myStmt= con.prepareStatement("Select * from Nurses");
            
            
            ResultSet res = myStmt.executeQuery();
            while(res.next())
            {
                Employee e = new Employee(res.getInt(""), res.getString("firstname"),res.getString("lastname"),
                        LocalDate.parse(res.getString("dob")),res.getString("addr"),
                        res.getString("phonenumber"),"nurse",res.getString("specialty"));
                nurses.add(e);
            }
        }
         catch(SQLException ex) 
        {
            System.out.println("Error: Getting all nurses..");
            ex.printStackTrace();
        }
         return nurses;
    }
    
    public static ObservableList<Employee> GetAllAdmin(){
        ObservableList<Employee> admins= FXCollections.observableArrayList();
         try{
            Connection con=ConnectionProvider.getCon();
            System.out.println("Connected to Microsft SQL SERVER:Getting all admins..");
            PreparedStatement myStmt= con.prepareStatement("Select * from Admins");
            
            
            ResultSet res = myStmt.executeQuery();
            while(res.next())
            {
                Employee e = new Employee(res.getInt(""), res.getString("firstname"),res.getString("lastname"),
                        LocalDate.parse(res.getString("dob")),res.getString("addr"),
                        res.getString("phonenumber"),"admin",res.getString("specialty"));
                admins.add(e);
            }
        }
         catch(SQLException ex) 
        {
            System.out.println("Error: Getting all patients..");
            ex.printStackTrace();
        }
         return admins;
    }
    
    public static ObservableList<UserModule> GetAllUsers(){
        ObservableList<UserModule> users= FXCollections.observableArrayList();
         try{
            Connection con=ConnectionProvider.getCon();
            System.out.println("Connected to Microsft SQL SERVER:Getting all users..");
            PreparedStatement myStmt= con.prepareStatement("Select * from Users");
            
            
            ResultSet res = myStmt.executeQuery();
            while(res.next())
            {
                UserModule u = new UserModule(res.getString("username"),res.getString("password"),res.getInt("ID"));
                users.add(u);
            }
        }
         catch(SQLException ex) 
        {
            System.out.println("Error: Getting all users..");
            ex.printStackTrace();
        }
         return users;
    }
    
    public static String RequestAppointment(Appointment a){
        String verify="";
        try{
            Connection con=ConnectionProvider.getCon();
            System.out.println("Connected to Microsft SQL SERVER:Adding Appointment..");
            
            PreparedStatement myStmt = con.prepareStatement("Insert into Appointments"
                    + "(patientID,practitionerID,roomID,appDate,appTime,status)"
                    + " Values(?,?,?,?,?,?)");
            myStmt.setInt(1, a.getPatientID());
            myStmt.setInt(2, a.getPractitionerID());
            myStmt.setString(3,a.getRoomID());
            myStmt.setString(4, a.getappDate().toString());
            myStmt.setString(5, a.getappTime().toString());
            myStmt.setString(6,a.getStatus());
        
           
            int count = myStmt.executeUpdate();
            if(count>0)
            {
                verify="success";
                System.out.println("Success:Added Appointment..");
                con.close();
            }
            else
                verify="fail";
            con.close();
        }
        catch(SQLException ex) 
        {
            System.out.println("Error: Adding Appointment");
            ex.printStackTrace();
        }
        return verify;
    }
    
    
}
