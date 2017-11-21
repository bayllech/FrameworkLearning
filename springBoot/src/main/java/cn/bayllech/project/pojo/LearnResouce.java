package cn.bayllech.project.pojo;

import java.io.Serializable;

/**
 * @Author bei.qi
 * @Description
 * @Date 2017-11-21 16:02
 */
public class LearnResouce implements Serializable {
    private static final long serialVersionUID = -7841847168876169409L;
    
    public LearnResouce(String author,String title,String url){
        this.author=author;
        this.title=title;
        this.url=url;
    };
    
    String url;
    String title;
    String author;
    
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public String getUrl() {
        return url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    
}


