package com.OnlineMobileStore.entities;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "OrderItemModel")
public class OrderItemModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    private int orderId;

    private int mobileId;
    private int quantity;
    private float totalCost;

    public OrderItemModel() {
    }

    public OrderItemModel(int orderId, int mobileId, int quantity, float totalCost) {
        this.orderId = orderId;
        this.mobileId = mobileId;
        this.quantity = quantity;
        this.totalCost = totalCost;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getMobileId() {
        return mobileId;
    }

    public void setMobileId(int mobileId) {
        this.mobileId = mobileId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }
}
