/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library.service;

import library.domain.Login;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Test.*;

/**
 *
 * @author trentonknight
 */
public class IAuthSvcSocketImplTest {
    
    public IAuthSvcSocketImplTest() {
    }

    /**
     * Test of add method, of class IAuthSvcSocketImpl.
     */
    @Test
    public void testGetAdd() {
        System.out.println("add");
        Login login = new Login();
        login.setUsername("admin");
        login.setPassword("passwordHere");
        IAuthSvcSocketImpl instance = new IAuthSvcSocketImpl();
        instance.add(login);
        Login newLogin = instance.getUser(login);
        assertSame(newLogin, login);
    }

    

    
}
