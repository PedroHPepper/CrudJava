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
public class Users extends UsersModel{
    public static String LIST = "SELECT * from usuarios";
    
    public static String REGISTER = "INSERT INTO usuarios("
            + "username,"
            + "email,"
            + "password)"
            + "values(?,?,?)";
    
    public static String UPDATE = "UPDATE usuarios SET "
            + "username = ?,"
            + "email = ?,"
            + "password = ?"
            + "WHERE id = ?";
    
    public static String DELETE = "DELETE from usuarios WHERE id = ?";
    
    public static String TRUNCATE = "TRUNCATE TABLE usuarios";
    
    private String id;
    private String username;
    private String email;
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
    
}
