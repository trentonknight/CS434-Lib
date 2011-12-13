/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package miniserver.business;

import java.net.*;
import java.io.*;
import miniserver.domain.Login;

/**
 *
 * @author trentonknight
 */
public class ConnectionMgr {

    /**
     * @param args the command line arguments
     */
    public Login Conn(Login login) throws IOException {
        ServerSocket server = null;
        Socket socket = null;
        ObjectInputStream in = null;
        ObjectOutputStream out = null;
        boolean exit = false;
        try {
            InetAddress connect = InetAddress.getLocalHost();
            System.out.println("Local Host: " + connect.toString());
            server = new ServerSocket(4444);
            while (!exit) {
                socket = server.accept(); // accept the next connection request
                in = new ObjectInputStream(socket.getInputStream());
                out = new ObjectOutputStream(socket.getOutputStream());

                System.out.println("server channel: " + server.getChannel()
                        + "\nserver inet address: " + server.getInetAddress()
                        + "\nserver local port: " + server.getLocalPort()
                        + "\nserver local socket address: " + server.getLocalSocketAddress());
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
                //get username
                String name = (String) in.readObject();
                if(!"admin".equals(name)){
                    System.out.println("Invalid Name!\n Shutting down miniServer...");
                    System.exit(0);
                }
                login.setUsername(name);
                System.out.println(login.getUsername());
                if("exit".equals(name)){
                    exit = true;
                }
                //get password
                String password = (String) in.readObject();
                if(!"passwordHere".equals(password)){
                    System.out.println("Invalid Name!\n Shutting down miniServer...");
                    System.exit(0);
                }
                login.setPassword(password);
                System.out.println(password);
                FileOutputStream fos = new FileOutputStream("login.txt");
                ObjectOutputStream output = new ObjectOutputStream(fos);
                output.writeObject(login);
                output.flush();
                output.close();

                in.close();
                out.close();
                socket.close();
            }
        } catch (Exception e) {
            System.err.println("Connection failed!");
            System.exit(1);
        } finally {
            server.close();
            System.exit(0);
        }
        return login;
    }
}
