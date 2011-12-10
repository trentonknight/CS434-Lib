/*
 * CS 434 Java - Mid Term Exam
 */

package library.domain;

import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author trentonknight
 */
public class LoginTest {

    public LoginTest() {
    }

    /**
     * Test of equals method, of class Login.
     */
    @Test
    public void testEquals() {
        System.out.println("equal");
        Object obj = null;
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        Assert.assertFalse(result);
        result = (!(instance.equals(obj)));
        Assert.assertTrue(result);
    }
    
    @Test
    public void testValidate() {
        System.out.println("validate");
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.validate();
        Assert.assertFalse(result);
        result = (!(instance.validate()));
        Assert.assertTrue(result);
        
    }

}