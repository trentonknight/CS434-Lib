/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library.service;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            socket.setKeepAlive(true);
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
            System.out.println("\nclient out: " + out.toString());
            in = new ObjectInputStream(socket.getInputStream());
            System.out.println("\nclient in: " + in.toString());
            out.writeObject(login.getUsername());
            out.writeObject(login.getPassword());


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
        login.setUsername(null);
        login.setPassword(null);
        ObjectInputStream input = null;

        try {
            input = new ObjectInputStream(new FileInputStream("login.txt"));
        } catch (IOException ex) {
            Logger.getLogger(IAuthSvcSocketImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            login = (Login) input.readObject();
        } catch (IOException ex) {
            Logger.getLogger(IAuthSvcSocketImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IAuthSvcSocketImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            input.close();
        } catch (IOException ex) {
            Logger.getLogger(IAuthSvcSocketImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return login;
    }
}
