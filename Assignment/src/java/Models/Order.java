/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author ADMIN
 */
public class Order {

    private int order_id;
    private String delivery_address;
    private String delivery_transport;
    private String order_note;
    private int payment_id;
    private String username;
    private String order_status;

    public Order() {
    }

    public Order(int order_id, String delivery_address, String delivery_transport, String order_note, int payment_id, String username, String order_status) {
        this.order_id = order_id;
        this.delivery_address = delivery_address;
        this.delivery_transport = delivery_transport;
        this.order_note = order_note;
        this.payment_id = payment_id;
        this.username = username;
        this.order_status = order_status;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getDelivery_address() {
        return delivery_address;
    }

    public void setDelivery_address(String delivery_address) {
        this.delivery_address = delivery_address;
    }

    public String getDelivery_transport() {
        return delivery_transport;
    }

    public void setDelivery_transport(String delivery_transport) {
        this.delivery_transport = delivery_transport;
    }

    public String getOrder_note() {
        return order_note;
    }

    public void setOrder_note(String order_note) {
        this.order_note = order_note;
    }

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }
}
