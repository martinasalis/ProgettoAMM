/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.Classi;

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
public class gruppiFactory {

    static gruppiFactory singleton = null;
    
    public static gruppiFactory getInstance() {
        if (singleton == null) {
            singleton = new gruppiFactory();
        }
        return singleton;
    }

    private String connectionString;
    
    public gruppi getGruppiById(int id){
           
        try{
          
        Connection conn = DriverManager.getConnection(connectionString, "martinasalis", "martinasalis");
            
            String query = 
                      "select * from groups"
                    + "where group_id = ?" ;
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setInt(1, id);
            
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
           
                gruppi current = new gruppi();
                current.setId(res.getInt("group_id"));
                current.setNome(res.getString("name"));

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
    
    public List<gruppi> getGroupList (){
    
         List<gruppi> list = new ArrayList<gruppi>();
        
        try{
          
        Connection conn = DriverManager.getConnection(connectionString, "martinasalis", "martinasalis");
            
            String query = 
                      "select * from gruppi";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            ResultSet res = stmt.executeQuery();
            while(res.next()) {
                gruppi current = new gruppi();
                current.setId(res.getInt("group_id"));
                current.setNome(res.getString("name"));
                
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
    
    public List<gruppi> getGroupList (utentiReg usr){
    
        List<gruppi> list = new ArrayList<gruppi>();
        
        try{
          
        Connection conn = DriverManager.getConnection(connectionString, "martinasalis", "martinasalis");
            
            String query = 
                      "select * from groups " + 
                      "join users_groups on groups.group_id = users_groups.group_id " +
                      "where user_id = ?";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setInt(1, usr.getId());
            
            ResultSet res = stmt.executeQuery();
            while(res.next()) {
                gruppi current = new gruppi();
                current.setId(res.getInt("group_id"));
                current.setNome(res.getString("name"));
                
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
    
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    
    public String getConnectionString(){
            return this.connectionString;
    }
    
}
