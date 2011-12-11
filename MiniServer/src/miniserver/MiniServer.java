/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package miniserver;
import java.net.*;
import java.io.*;
/**
 *
 * @author trentonknight
 */
public class MiniServer {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException {
   ServerSocket server = null;
   Socket socket = null;
   ObjectInputStream in = null;
   ObjectOutputStream out = null;
   boolean exit = false;
   try {
       server = new ServerSocket(4444,100);
       socket = server.accept( ); // accept the next connection request
       while (!exit) {           
          System.out.println("Connected from " + server.getInetAddress() + " on port "
             + server.getLocalSocketAddress() + " to port " + server.getLocalPort() + " of "
             + server.getReceiveBufferSize());
          in = new ObjectInputStream(socket.getInputStream());
          out = new ObjectOutputStream(socket.getOutputStream());

          String inputStr = (String)in.readObject();
          if ( ! inputStr.equals("exit")) {
             out.writeObject("Hello " + inputStr);
          }
          else {
             exit = true;
             out.writeObject("Exiting");
          }
      
          in.close();
          out.close();
          socket.close();
      }
   } catch (Exception e) {
     System.exit(1);
   } 
      server.close();  
     }
}
