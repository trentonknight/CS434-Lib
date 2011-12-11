package server.business;
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class ConnectionMgr {
    public startCon() throws Exception {
        
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(4444);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 4444.");
            System.exit(1);
        }
        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }
        ObjectInputStream in = null;
        ObjectOutputStream out = null;
        boolean exit = false;
        while(!exit){
            clientSocket = serverSocket.accept();
            out = new ObjectOutputStream(clientSocket.getOutputStream());
            in = new ObjectInputStream(clientSocket.getInputStream());
            try {
                String inputStr = (String)in.readObject();
                out.writeObject("Hello" + inputStr);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConnectionMgr.class.getName()).log(Level.SEVERE, null, ex);
            }
           in.close();
           out.close();
           clientSocket.close();
        }
        serverSocket.close();
    }
}