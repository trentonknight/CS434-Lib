/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package miniserver.service;

import miniserver.domain.Login;

/**
 *
 * @author trentonknight
 */
public interface IAuthenticationSvc {
     
     public Login add(Login login);
     public Login getUser(Login login);
}

