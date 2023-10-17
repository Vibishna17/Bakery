
package com.example.lab_05;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

public class cakes extends AppCompatActivity {

    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerViewAdapterc recyclerViewAdapter;

    int []arr={R.drawable.c1,R.drawable.c2,R.drawable.c3,R.drawable.c4,R.drawable.c5,R.drawable.c6};
    String []arr1={"Victoria","Choco Truffle","DreamLand","White Forest","Chocolate Overloaded","Red Velvet"};
    String []arrp={"599","599","499","499","450","480"};
    String []arrd={"Victoria cake, also known as Victoria sponge cake, is a classic British dessert. It consists of two layers of light and airy sponge cake sandwiched together with a layer of strawberry jam and whipped cream.","\n" +
            "Choco truffle,is a decadent dessert crafted from a luscious blend of melted chocolate and cream. These bite-sized delights, often dusted with cocoa or coated in chocolate, offer an irresistible treat for chocolate enthusiasts","DreamLand cake, A light, airy dessert with sponge cake layers, flavored syrups, creamy fillings, and delightful toppings, perfect for those with a sweet tooth","White Forest cake is a delightful dessert known for its white chocolate shavings, cherries, and layers of moist white sponge cake with whipped cream. It offers a perfect blend of sweet and tart flavors in a visually appealing white exterior","Chocolate Overload Cake is a decadent dessert bursting with layers of chocolatey goodness, including chocolate cake, ganache, chips, and cocoa, creating an irresistible treat for chocolate lovers"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cakes);

        recyclerView=findViewById(R.id.recyclerview);
        layoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerViewAdapter=new RecyclerViewAdapterc(arr,arr1,arrp,arrd,this);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setHasFixedSize(true);
    }

}