/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cliente
 */
public class DbConnection {
    public static Connection connection = null;
    
    private static DbConnection dbConnectionInstance;
    
    private DbConnection(){}
    
    public static synchronized DbConnection getInstance(){
        if (dbConnectionInstance == null)
            dbConnectionInstance = new DbConnection();
 
        return dbConnectionInstance;
    }
            
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/teste", "root", "");
            return connection;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Não encontrado");
            return null;
            //Logger.getLogger(conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
