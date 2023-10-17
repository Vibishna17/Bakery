package com.example.lab_05;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private static List<CartItem> cartItems = new ArrayList<>();

    public static void addItem(CartItem item) {
        cartItems.add(item);
    }

    public static void removeItem(CartItem item) {
        cartItems.remove(item);
    }

    public static List<CartItem> getCartItems() {
        return cartItems;
    }

    public static int calculateTotalPrice(int itemPrice, int itemQuantity) {
        return itemPrice * itemQuantity;
    }

}
