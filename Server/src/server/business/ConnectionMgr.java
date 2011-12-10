/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.business;
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author trentonknight
 */
public class ConnectionMgr {

    

    public class hostCon{
    
    ServerSocket serve = null;
    Socket socket = null;
    ObjectInputStream in = null;
    ObjectOutputStream out = null;
    boolean exit = false;
    
  
    ServerSocket = new ServerSocket(8000,100);
    while(!exit){
        try {
            socket = serve.accept();
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
            String inputStr = null;
            try {
                inputStr = (String)in.readObject();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConnectionMgr.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(!inputStr.equals("exit")){
                out.writeObject("Hello" + inputStr);
            }
            else{
                exit = true;
                out.writeObject("Exiting");
            }
            in.close();
            out.close();
            socket.close();
            serve.close();
        } catch (IOException ex) {
            Logger.getLogger(ConnectionMgr.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }
    }
}
