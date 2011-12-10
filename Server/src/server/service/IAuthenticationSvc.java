/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.service;
import server.domain.Login;

public interface IAuthenticationSvc {
     public Login add(Login login);
     public Login getUser(Login login);

}
