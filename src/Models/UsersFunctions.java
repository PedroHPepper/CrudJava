/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Models.Users;
import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory;
import Data.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import principal.Crud;

/**
 *
 * @author Cliente
 */
public class UsersFunctions {
    private static DbConnection con = DbConnection.getInstance();
    private static Connection connection = con.getConnection();
    private static PreparedStatement ps = null;
    
    public static boolean isRegister(Users s){
        String sql = Users.REGISTER;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, s.getUsername());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getPassword());
            
            ps.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            return false;
            //Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static boolean isUpdate(Users s){
        String sql = Users.UPDATE;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, s.getUsername());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getPassword());
            ps.setString(4, s.getId());
            
            ps.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            return false;
            //Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static boolean isDelete(Users s){
        String sql = Users.DELETE;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, s.getId());
            
            ps.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            return false;
            //Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static boolean isTruncate(){
        String sql = Users.TRUNCATE;
        try {
            ps = connection.prepareStatement(sql);
            
            ps.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            return false;
            //Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void setList(String search){
        DefaultTableModel model = (DefaultTableModel)Crud.Table.getModel();
        
        while(model.getRowCount()>0){
            model.removeRow(0);
        }
        
        String sql = "";
        
        if(search.equals("")){
            sql = Users.LIST;
        }else{
            sql = "SELECT * FROM usuarios WHERE ("
                    + "username LIKE'"+search+"%' OR "
                    + "email LIKE'"+search+"%' OR "
                    + "password LIKE'"+search+"%'"
                    + ")";
        }
        
        String data[] = new String[4];
        
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                data[0] = rs.getString("id");
                data[1] = rs.getString("username");
                data[2] = rs.getString("email");
                data[3] = rs.getString("password");
                
                model.addRow(data);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsersFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static String extractIDMax(){
        String sql = "SELECT MAX(id) FROM usuarios";
        int id = 0;
        
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            if(rs.next()){
                id = rs.getInt(1);
            }
            if(id == 0){
                id = 1;
            }else{
                id = id+1;
            }
            
            return String.valueOf(id);
        } catch (SQLException ex) {
            return null;
            //Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
