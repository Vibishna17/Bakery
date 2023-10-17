package com.example.lab_05;

public class CartItem {
    private String productName;
    private double productPrice;
    private int quantity;

    public CartItem(String productName, double productPrice, int quantity) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public int getQuantity() {
        return quantity;
    }
}
