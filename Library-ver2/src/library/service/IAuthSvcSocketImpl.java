/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library.service;

import java.io.*;
import java.net.*;
import library.domain.Login;

/**
 *
 * @author trentonknight
 */
public class IAuthSvcSocketImpl implements IAuthSvc {

    ObjectInputStream in = null;
    ObjectOutputStream out = null;

    public Login add(Login login) {
        Socket socket = null;
        ObjectOutputStream out = null;
        try {
            InetAddress connect = InetAddress.getLocalHost();
            socket = new Socket(connect, 4444);
            System.out.println("socket channel: " + socket.getChannel()
                    + "\nsocket inet address: " + socket.getInetAddress()
                    + "\nsocket get input stream: " + socket.getInputStream()
                    + "\nsocket local address: " + socket.getLocalAddress()
                    + "\nsocket local port: " + socket.getLocalPort()
                    + "\nsocket local socket address: " + socket.getLocalSocketAddress()
                    + "\nsocket get output stream: " + socket.getOutputStream()
                    + "\nsocket get port: " + socket.getPort()
                    + "\nsocket get recieved buffer size: " + socket.getReceiveBufferSize()
                    + "\nsocket get remote socket address: " + socket.getRemoteSocketAddress());


            out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(login);
        } catch (Exception e) {
            // log the error
            System.out.println("Exception " + e.getMessage());
        } finally {
            try {
                out.close();
                socket.close();
            } catch (Exception e) {
                // log the error
                System.out.println("Exception " + e.getMessage());
            }
        }
        return login;
    }

    public Login getUser(Login login) {
        Socket socket = null;
        ObjectInputStream in = null;
        try {
            InetAddress connect = InetAddress.getLocalHost();
            socket = new Socket(connect, 4444);
            System.out.println("socket channel: " + socket.getChannel()
                    + "\nsocket inet address: " + socket.getInetAddress()
                    + "\nsocket get input stream: " + socket.getInputStream()
                    + "\nsocket local address: " + socket.getLocalAddress()
                    + "\nsocket local port: " + socket.getLocalPort()
                    + "\nsocket local socket address: " + socket.getLocalSocketAddress()
                    + "\nsocket get output stream: " + socket.getOutputStream()
                    + "\nsocket get port: " + socket.getPort()
                    + "\nsocket get recieved buffer size: " + socket.getReceiveBufferSize()
                    + "\nsocket get remote socket address: " + socket.getRemoteSocketAddress());

       in = new ObjectInputStream(socket.getInputStream());
       login = (Login)in.readObject(); 
       
        } catch (Exception e) {
            // log the error
            System.out.println("Exception " + e.getMessage());
        } finally {
            try {
                in.close();
                socket.close();
            } catch (Exception e) {
                // log the error
                System.out.println("Exception " + e.getMessage());
            }
        }
        return login;
    }
}
