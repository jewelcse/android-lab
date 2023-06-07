package com.jewelcse.hello.db;

public class Cart {
    private int id;
    private String productName;

    public Cart(String productName) {
        this.productName = productName;
    }

    public Cart(int id, String productName) {
        this.id = id;
        this.productName = productName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
