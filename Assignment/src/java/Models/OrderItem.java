/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author ADMIN
 */
public class OrderItem {

    private Order order;
    private int quantity;
    private Item item;

    public OrderItem() {
    }

    public OrderItem(Order order, int quantity, Item item) {
        this.order = order;
        this.quantity = quantity;
        this.item = item;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public float realPrice() {
        return item.getItem_price() * (1 - item.getDiscount() / 100) * quantity;
    }
}
