package com.OnlineMobileStore.entities;

import javax.persistence.*;

@Entity
@Table(name = "CartModel")
public class CartModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    //@OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "product_id")
    private int product;//Foreign key


    private int quantity;
    private int userid;
    private float price;

    public CartModel() {
    }

    public CartModel(int product, int quantity, int userid, float price) {
        this.product = product;
        this.quantity = quantity;
        this.userid = userid;
        this.price = price;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }


    public int getCartId() {
        return id;
    }

    public void setCartId(int id) {
        this.id = id;
    }

    public int getProduct() {
        return product;
    }

    public void setProduct(int product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }


}
