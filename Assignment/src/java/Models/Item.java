/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author ADMIN
 */
public class Item {

    private int item_id;
    private String item_name;
    private float item_price;
    private int item_quantity;
    private String item_description;
    private String tag_name;
    private int discount;
    private String username;
    private String item_img;

    public Item() {
    }

    public Item(int item_id, String item_name, float item_price, int item_quantity, String item_description, String tag_name, int discount, String username, String item_img) {
        this.item_id = item_id;
        this.item_name = item_name;
        this.item_price = item_price;
        this.item_quantity = item_quantity;
        this.item_description = item_description;
        this.tag_name = tag_name;
        this.discount = discount;
        this.username = username;
        this.item_img = item_img;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public float getItem_price() {
        return item_price;
    }

    public void setItem_price(float item_price) {
        this.item_price = item_price;
    }

    public int getItem_quantity() {
        return item_quantity;
    }

    public void setItem_quantity(int item_quantity) {
        this.item_quantity = item_quantity;
    }

    public String getItem_description() {
        return item_description;
    }

    public void setItem_description(String item_description) {
        this.item_description = item_description;
    }

    public String getTag_name() {
        return tag_name;
    }

    public void setTag_name(String tag_name) {
        this.tag_name = tag_name;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getItem_img() {
        return item_img;
    }

    public void setItem_img(String item_img) {
        this.item_img = item_img;
    }
}
