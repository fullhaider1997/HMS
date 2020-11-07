/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class Server {
    
    
      private static final int PORT = 9090;
    
      private  static ArrayList<ClientHandler> ListOfAllClients;
   
    
    public static void main(String[] args) throws IOException {
       
        ServerSocket listener = new ServerSocket(PORT);
        
        
        while(true){
            
           System.out.println("[SERVER] Waiting for client connection....");
           Socket client = listener.accept();
           System.out.println("[SERVER] connected to client ! ");
           
           ClientHandler clientThread = new ClientHandler(client, ListOfAllClients);
           ListOfAllClients.add(clientThread);
           
           new Thread(clientThread).start();
           
        }
    }

    
    
 

    
    
}
