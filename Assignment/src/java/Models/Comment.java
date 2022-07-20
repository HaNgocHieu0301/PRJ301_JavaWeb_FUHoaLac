/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author ADMIN
 */
public class Comment {

    private int comment_id;
    private String comment_time;
    private String comment_date;
    private String comment_content;
    private UserInfo username;
    private int item_id;

    public Comment() {
    }

    public Comment(int comment_id, String comment_time, String comment_date, String comment_content, UserInfo username, int item_id) {
        this.comment_id = comment_id;
        this.comment_time = comment_time;
        this.comment_date = comment_date;
        this.comment_content = comment_content;
        this.username = username;
        this.item_id = item_id;
    }

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public String getComment_time() {
        return comment_time;
    }

    public void setComment_time(String comment_time) {
        this.comment_time = comment_time;
    }

    public String getComment_date() {
        return comment_date;
    }

    public void setComment_date(String comment_date) {
        this.comment_date = comment_date;
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

    public UserInfo getUsername() {
        return username;
    }

    public void setUsername(UserInfo username) {
        this.username = username;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

}
