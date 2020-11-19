/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author Haider
 */
public class Fpacket implements Serializable{
    
    String typeOfRequest;
    String arg1;
    String arg2;
    
   public Fpacket(String typeOfRequest, String arg1){
        
        this.typeOfRequest = typeOfRequest;
        this.arg1 = arg1;
    }
    
   public Fpacket(String typeOfRequest, String arg1, String arg2){
        
        this.typeOfRequest = typeOfRequest;
        this.arg1 = arg1;
        this.arg2 = arg1;
    }
   public String getTpeOfRequest(){
       return typeOfRequest;
   }
   public String getArg1(){
       return arg1;
   }
   public String getArg2(){
       return arg2;
   }
    
    
    
}
