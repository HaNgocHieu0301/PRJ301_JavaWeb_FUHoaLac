/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author ADMIN
 */
public class Discount {
    private int discount_id;
    private String discount_startTime;
    private String discount_endTime;
    private float discount_percent;

    public Discount() {
    }

    public Discount(int discount_id, String discount_startTime, String discount_endTime, float discount_percent) {
        this.discount_id = discount_id;
        this.discount_startTime = discount_startTime;
        this.discount_endTime = discount_endTime;
        this.discount_percent = discount_percent;
    }

    public int getDiscount_id() {
        return discount_id;
    }

    public void setDiscount_id(int discount_id) {
        this.discount_id = discount_id;
    }

    public String getDiscount_startTime() {
        return discount_startTime;
    }

    public void setDiscount_startTime(String discount_startTime) {
        this.discount_startTime = discount_startTime;
    }

    public String getDiscount_endTime() {
        return discount_endTime;
    }

    public void setDiscount_endTime(String discount_endTime) {
        this.discount_endTime = discount_endTime;
    }

    public float getDiscount_percent() {
        return discount_percent;
    }

    public void setDiscount_percent(float discount_percent) {
        this.discount_percent = discount_percent;
    }
    
    
}
