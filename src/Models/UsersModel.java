/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Cliente
 */
abstract class UsersModel {
    
    abstract String getId();

    abstract void setId(String id);

    abstract String getUsername();

    abstract void setUsername(String username);

    abstract String getEmail();

    abstract void setEmail(String email);

    abstract String getPassword();

    abstract void setPassword(String password);
    
}
