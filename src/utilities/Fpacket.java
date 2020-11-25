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
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String typeOfRequest;
    Object arg1;
    
   public Fpacket(String typeOfRequest, Object arg1){
        
        this.typeOfRequest = typeOfRequest;
        this.arg1 = arg1;
    }
    
   public String getTpeOfRequest(){
       return typeOfRequest;
   }
   public Object getArg1(){
       return arg1;
   }
}
