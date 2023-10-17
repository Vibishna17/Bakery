package com.example.lab_05;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class cart extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        TextView quan=findViewById(R.id.Qty);
        TextView item=findViewById(R.id.pr);
        Button button=findViewById(R.id.confirm);
        TextView totalPriceTextView = findViewById(R.id.total);
        int quantity = getIntent().getIntExtra("quantity", 0);
        int itemPrice = getIntent().getIntExtra("itemPrice", 0);
        int totalPriceForItem = getIntent().getIntExtra("totalPriceForItem", 0);

        //double totalPrice = ShoppingCart.calculateTotalPrice( quantity, (int) itemPrice);

        // Update the TextView with the total price
        totalPriceTextView.setText(String.valueOf(totalPriceForItem));
        quan.setText(String.valueOf(quantity));
        item.setText(String.valueOf(itemPrice));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(cart.this, "Order Confirmed", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(cart.this,Home.class);
                startActivity(intent);
            }
        });

        // Now you have the quantity, itemPrice, and totalPriceForItem, and you can use them as needed in your cart activity.
    }
}
