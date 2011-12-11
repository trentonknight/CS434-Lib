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
            socket = new Socket(InetAddress.getLocalHost(),4444);
            in = new ObjectInputStream(socket.getInputStream());
            out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject("Java Joe");
            String str = (String) in.readObject();
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
    }
}
