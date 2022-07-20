/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author ADMIN
 */
public class Post {

    private int post_id;
    private String post_img;
    private String post_content;
    private String post_date;
    private String post_time;
    private String username;

    public Post() {

    }

    public Post(int post_id, String post_img, String post_content, String post_date, String post_time, String username) {
        this.post_id = post_id;
        this.post_img = post_img;
        this.post_content = post_content;
        this.post_date = post_date;
        this.post_time = post_time;
        this.username = username;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public String getPost_img() {
        return post_img;
    }

    public void setPost_img(String post_img) {
        this.post_img = post_img;
    }

    public String getPost_content() {
        return post_content;
    }

    public void setPost_content(String post_content) {
        this.post_content = post_content;
    }

    public String getPost_date() {
        return post_date;
    }

    public void setPost_date(String post_date) {
        this.post_date = post_date;
    }

    public String getPost_time() {
        return post_time;
    }

    public void setPost_time(String post_time) {
        this.post_time = post_time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
}
