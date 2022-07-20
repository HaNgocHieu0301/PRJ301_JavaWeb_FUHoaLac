/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author ADMIN
 */
public class PaymentSeller {

    private int payment_id;
    private String payment_name;
    private String payment_note;
    private String username;

    public PaymentSeller() {
    }

    public PaymentSeller(int payment_id, String payment_name, String payment_note, String username) {
        this.payment_id = payment_id;
        this.payment_name = payment_name;
        this.payment_note = payment_note;
        this.username = username;
    }

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public String getPayment_name() {
        return payment_name;
    }

    public void setPayment_name(String payment_name) {
        this.payment_name = payment_name;
    }

    public String getPayment_note() {
        return payment_note;
    }

    public void setPayment_note(String payment_note) {
        this.payment_note = payment_note;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
}
