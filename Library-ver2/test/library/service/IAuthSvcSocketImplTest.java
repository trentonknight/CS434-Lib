/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library.service;

import library.domain.Login;
import org.junit.Test;
import static org.junit.Assert.*;

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
    public void testAdd() {
        System.out.println("add");
        Login login = new Login();
        login.setUsername("admin");
        login.setPassword("passwordHere");
        IAuthSvcSocketImpl instance = new IAuthSvcSocketImpl();
        Login result = instance.add(login);
        
    }

    /**
     * Test of getUser method, of class IAuthSvcSocketImpl.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        Login login = null;
        IAuthSvcSocketImpl instance = new IAuthSvcSocketImpl();
        Login expResult = null;
        Login result = instance.getUser(login);
        assertEquals(expResult, result);
        
    }
}
