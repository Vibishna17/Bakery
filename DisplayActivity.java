package com.example.lab_05;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {
    private ImageView imageView;
    private TextView textView;
    private TextView qty;
    private TextView price; // Declare as a class-level field
    private TextView desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        Button addToCartButton = findViewById(R.id.button);
        addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToCart();
//                Intent intent =new Intent(DisplayActivity.this, cart.class);
//                startActivity(intent);
//
            }
        });

        imageView = findViewById(R.id.image);
        textView = findViewById(R.id.title);
        qty = findViewById(R.id.qnt);
        price = findViewById(R.id.pricetag); // Initialize the TextView
        desc = findViewById(R.id.de);

        Intent intent = getIntent();
        int imageResource = intent.getIntExtra("image", 0);
        String title = intent.getStringExtra("title");
        int quantity = intent.getIntExtra("quantity", 0);
        String Price = intent.getStringExtra("price"); // Get the price as a String
        String des = intent.getStringExtra("desc");

        imageView.setImageResource(imageResource);
        textView.setText(title);
        qty.setText(String.valueOf(quantity));
        price.setText(Price); // Set the price TextView
        desc.setText(des);
    }

    private void addToCart() {
        String itemName = textView.getText().toString();
        String priceStr = price.getText().toString();
        // Get the price as a String
        String numericPriceStr = priceStr.replaceAll("[^\\d.]+", "");
        int itemPrice = Integer.parseInt(numericPriceStr);
        // Remove leading zeros from quantity
        int itemQuantity = Integer.parseInt(qty.getText().toString().replaceFirst("^0+(?!$)", ""));
        int totalPriceForItem = ShoppingCart.calculateTotalPrice(itemPrice, itemQuantity);
        CartItem cartItem = new CartItem(itemName, itemPrice, itemQuantity);
        // Add the cartItem to your shopping cart list
        ShoppingCart.addItem(cartItem);

        // Pass the values to the cart activity
        Intent cartIntent = new Intent(DisplayActivity.this, cart.class);
        cartIntent.putExtra("quantity", itemQuantity);
        cartIntent.putExtra("itemPrice", itemPrice);
        cartIntent.putExtra("totalPriceForItem", totalPriceForItem);
        startActivity(cartIntent);
    }

}
