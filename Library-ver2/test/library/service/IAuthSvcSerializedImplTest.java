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
public class IAuthSvcSerializedImplTest {
    
    public IAuthSvcSerializedImplTest() {
    }


    /**
     * Test of add method, of class IAuthSvcSerializedImpl.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Login login = null;
        IAuthSvcSerializedImpl instance = new IAuthSvcSerializedImpl();
        Login expResult = null;
        Login result = instance.add(login);
        assertEquals(expResult, result);
      
    }

    /**
     * Test of getUser method, of class IAuthSvcSerializedImpl.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        Login login = null;
        IAuthSvcSerializedImpl instance = new IAuthSvcSerializedImpl();
        Login expResult = null;
        Login result = instance.getUser(login);
        assertEquals(expResult, result);
      
    }
}
