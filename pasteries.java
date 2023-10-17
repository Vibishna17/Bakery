
package com.example.lab_05;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

public class pasteries extends AppCompatActivity {

    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerViewAdapterc recyclerViewAdapter;

    int []arr={R.drawable.pa1,R.drawable.pa2,R.drawable.pa3,R.drawable.pa4,R.drawable.pa5,R.drawable.pa6};
    String []arr1={"Donut","Cup Cakes","Croissant","Tart","Muffins","Waffles"};
    String []arrp={"100","220","329","399","50","420"};
    String []arrd={"A sweet, fried or baked pastry with a ring shape, often glazed or filled.","Small, individual cakes, usually frosted and decorated, perfect for one person."," A buttery and flaky pastry, typically crescent-shaped, hailing from France","A baked dish with a pastry crust and sweet or savory fillings","ngle-serving, soft and spongy cakes, available in various flavo","Crispy, grid-patterned pancakes served with fresh or syrup-soaked strawberries."};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasteries);

        recyclerView=findViewById(R.id.recyclerview1);
        layoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerViewAdapter=new RecyclerViewAdapterc(arr,arr1,arrp,arrd,this);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setHasFixedSize(true);
    }

}