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
public class postFactory {
    
    private static postFactory singleton;

    public static postFactory getInstance() {
        if (singleton == null) {
            singleton = new postFactory();
        }
        return singleton;
    }
    private String connectionString;
    
    public post getPostById(int id){
           
        try{
          
        Connection conn = DriverManager.getConnection(connectionString, "martinasalis", "martinasalis");
            
            String query = 
                      "select * from post "
                    + "where post_id = ?" ;
            
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, id);
            
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
           
                post current = new post();
                current.setId(res.getInt("post_id"));
                current.setContent(res.getString("content"));
                current.setPostType(this.postTypeFromString(res.getString("posttype_name")));
                current.setUrl(res.getString("urlPost"));
                current.setGroupId(res.getInt("group_ip"));
                current.setUserId(res.getInt("user_id"));

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
    
    public List<post> getPostList (utentiReg usr) {
    
         List<post> list = new ArrayList<post>();
        
        try {

            Connection conn = DriverManager.getConnection(connectionString, "martinasalis", "martinasalis");
            
            String query = 
                      "select * from post "
                    + "join posttype on post.type = posttype.posttype_id "
                    + "where user_id = ?";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setInt(1, usr.getId());
           
            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                
                post current = new post();
                
                current.setId(res.getInt("post_id"));
                
                current.setContent(res.getString("content"));
                
                current.setUrl(res.getString("urlPost"));
                
                current.setGroupId(res.getInt("grpup_id"));
                
                current.setUserId(res.getInt("user_id"));
                
                current.setPostType(this.postTypeFromString(res.getString("posttype_name")));

                //current.setUser(usr);
                
                list.add(current);
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return list;
        
    }
    
    public List<post> getPostList (gruppi gr){
    
        List<post> list = new ArrayList<post>();
        
        try{
          
        Connection conn = DriverManager.getConnection(connectionString, "martinasalis", "martinasalis");
            
            String query = 
                      "select * from post " +
                      "where group_id = ?";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setInt(1, gr.getId());
            
            ResultSet res = stmt.executeQuery();
            while(res.next()) {
                post current = new post();
                current.setId(res.getInt("post_id"));
                
                current.setContent(res.getString("content"));
                
                current.setUrl(res.getString("urlPost"));
                
                current.setGroupId(res.getInt("grpup_id"));
                
                current.setUserId(res.getInt("user_id"));
                
                current.setPostType(this.postTypeFromString(res.getString("posttype_name")));
                
                //current.s(usr);
                
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
    
    public void addNewPost(post post){

        try {

            Connection conn = DriverManager.getConnection(connectionString, "martinasalis", "martinasalis");

            String query = 
                      "insert into post (post_id, content, type, urlPost, user_id, group_id) "
                    + "values (default, ? , ? , ?, ?, ? )";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setInt(1, post.getId());
            stmt.setString(2, post.getContent());
            stmt.setInt(3, this.postTypeFromEnum(post.getPostType()));
            stmt.setString(4, post.getUrl());
            stmt.setInt(5, post.getUserId());
            stmt.setInt(6, post.getGroupId());
            
            stmt.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
        
        return;
        
    }
    
    private post.Type postTypeFromString(String type){
        
        if(type.equals("IMAGE"))
            return post.Type.IMAGE;
        else
            return post.Type.LINK;
        
    }
    
    private int postTypeFromEnum(post.Type type){
        
        if(type == post.Type.IMAGE)
            return 1;
        else if(type == post.Type.LINK)
            return 2;
        else
            return 3;
        
    }
    
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    
    public String getConnectionString(){
            return this.connectionString;
    }
    
}
