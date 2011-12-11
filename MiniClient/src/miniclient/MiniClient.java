/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package miniclient;

import java.io.*;
import java.net.*;

/**
 *
 * @author trentonknight
 */
public class MiniClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Socket socket = null;
        ObjectInputStream in = null;
        ObjectOutputStream out = null;
        try {
            InetAddress connect = InetAddress.getLocalHost();
            socket = new Socket(connect, 4444);
            System.out.println("socket channel: " + socket.getChannel()+
                                   "\nsocket inet address: " + socket.getInetAddress()+
                                   "\nsocket get input stream: " + socket.getInputStream()+
                                   "\nsocket local address: " + socket.getLocalAddress()+
                                   "\nsocket local port: " + socket.getLocalPort()+
                                   "\nsocket local socket address: " + socket.getLocalSocketAddress()+
                                   "\nsocket get output stream: " + socket.getOutputStream()+
                                   "\nsocket get port: " + socket.getPort()+
                                   "\nsocket get recieved buffer size: " + socket.getReceiveBufferSize()+
                                   "\nsocket get remote socket address: " + socket.getRemoteSocketAddress());

       
       out = new ObjectOutputStream(socket.getOutputStream());
       System.out.println("\nclient out: "+ out.toString());
       in = new ObjectInputStream(socket.getInputStream());
       System.out.println("\nclient in: "+ in.toString());
       out.writeObject("Java Joe");
       String str = (String)in.readObject();
       System.out.println(str);
   } catch (Exception e) {
       // log the error
       System.out.println("Exception " + e.getMessage());
   } finally {
     try {
         in.close();
         out.close();
         socket.close();
     } catch (Exception e) {
      // log the error
      System.out.println("Exception " + e.getMessage());
   }
    }
}}
