/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.Classi;

/**
 *
 * @author martinasalis
 */
public class post {

    public void setUser(utentiReg utenteById) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public enum Type {
        IMAGE, LINK
    };

    protected int id;
    private String content;
    private Type postType;
    private String url;
    protected int user_id;
    protected int group_id;

    public post() {
        id = 0;
        content = "";
        postType = Type.IMAGE;
        url = "";
        user_id = -1;
        group_id = -1;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the postType
     */
    public Type getPostType() {
        return postType;
    }

    /**
     * @param postType the postType to set
     */
    public void setPostType(Type postType) {
        this.postType = postType;
    }
    
    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }
    
    /**
     * @return the user_id
     */
    public int getUserId() {
        return user_id;
    }

    /**
     * @param user_id the user_id to set
     */
    public void setUserId(int user_id) {
        this.user_id = user_id;
    }
    
    /**
     * @return the group_id
     */
    public int getGroupId() {
        return group_id;
    }

    /**
     * @param group_id the group to set
     */
    public void setGroupId(int group_id) {
        this.group_id = group_id;
    }
}

