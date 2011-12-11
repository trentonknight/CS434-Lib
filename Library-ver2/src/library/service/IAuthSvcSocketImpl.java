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

        try {
            socket = new Socket(InetAddress.getLocalHost(), 4444);
            in = new ObjectInputStream(socket.getInputStream());
            out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(login.toString());
        } catch (IOException e) {
            System.err.println("Could not listen on port: 4444.");
            System.exit(1);
        }

        try {
            in.close();
            out.close();
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(IAuthSvcSocketImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return login;
    }

    public Login getUser(Login login) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
