package cn.bayllech.project.pojo;

import java.io.Serializable;

/**
 * @Author bei.qi
 * @Description
 * @Date 2017-11-22 14:51
 */
public class User implements Serializable {
    private static final long serialVersionUID = 5883575658152535110L;
    
    String username;
    String password;
    
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
}
