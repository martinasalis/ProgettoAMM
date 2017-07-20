/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.Classi;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author martinasalis
 */
public class utentiRegFactory {
    
        private static utentiRegFactory singleton;

    public static utentiRegFactory getInstance() {
        if (singleton == null) {
            singleton = new utentiRegFactory();
        }
        return singleton;
    }
    private String connectionString;
    
    public utentiReg getUtenteById(int id){
         
        try{
          
        Connection conn = DriverManager.getConnection(connectionString, "martinasalis", "martinasalis");
            
            String query = 
                      "select * from users "
                    + "where user_id = ?";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setInt(1, id);
            
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                utentiReg current = new utentiReg();
                current.setId(res.getInt("user_id"));
                current.setNome(res.getString("name"));
                current.setCognome(res.getString("surname"));
                current.setPassword(res.getString("password"));
                current.setCompleanno(res.getString("birthday"));
                current.setCompleanno(res.getString("presentation"));
                current.setUrlFotoProfilo(res.getString("urlFotoProfilo"));

                stmt.close();
                conn.close();
                return current;
            }

            stmt.close();
            conn.close();
            
        }
        catch(SQLException e){
            
            e.printStackTrace();
            
        }
        
        return null;
        
    }
    
    public int getIdByUserAndPassword(String user, String password) throws FileNotFoundException{
        
        try{
          
            Connection conn = DriverManager.getConnection(connectionString, "martinasalis", "martinasalis");
            
            String query = 
                      "select user_id from users "
                    + "where name = ? and password = ?";
            
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            
            stmt.setString(1, user);
            stmt.setString(2, password);
            
            
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                 
                int id = res.getInt("user_id");
                stmt.close();
                conn.close();
                return id;
            }

            stmt.close();
            conn.close();
            
        }
        catch(SQLException e){
            
            PrintWriter s = new PrintWriter("/Users/martinasalis/Desktop/log.txt");
            s.write(e.getMessage());
            s.close();
            
        }
        
        return -1;
        
    }
    
    public List<utentiReg> getUtentiList() {
        
        List<utentiReg> list = new ArrayList<utentiReg>();
        
        try{
          
        Connection conn = DriverManager.getConnection(connectionString, "martinasalis", "martinasalis");
            
            String query = 
                      "select * from users";
            
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            ResultSet res = stmt.executeQuery();
            while(res.next()) {
                utentiReg current = new utentiReg();
                current.setId(res.getInt("user_id"));
                current.setNome(res.getString("name"));
                current.setCognome(res.getString("surname"));
                current.setPassword(res.getString("password"));
                current.setCompleanno(res.getString("birthday"));
                current.setCompleanno(res.getString("presentation"));
                current.setUrlFotoProfilo(res.getString("urlFotoProfilo"));
                
                list.add(current);

            }

            stmt.close();
            conn.close();

        }
        catch(SQLException e){
            
            e.printStackTrace();
            
        }
        
        return list;
        
    }
    
    public List getUtentiList(String name) {
        List<utentiReg> listaUtenti = new ArrayList<utentiReg>();
        
        try {
            Connection conn = DriverManager.getConnection(connectionString, "martinasalis", "martinasalis");
            
            String query = 
                      "select * from users where name like ?";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1, "%" + name + "%");
            
            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                utentiReg current = new utentiReg();
                current.setId(res.getInt("user_id"));
                current.setNome(res.getString("name"));
                current.setCognome(res.getString("surname"));
                current.setPassword(res.getString("password"));
                current.setCompleanno(res.getString("birthday"));
                current.setCompleanno(res.getString("presentation"));
                current.setUrlFotoProfilo(res.getString("urlFotoProfilo"));
                
                listaUtenti.add(current);
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return listaUtenti;
    }
    
    
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    
    public String getConnectionString(){
            return this.connectionString;
    }
}
