
package com.example.lab_05;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

public class pizza extends AppCompatActivity {

    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerViewAdapterc recyclerViewAdapter;

    int []arr={R.drawable.pi1,R.drawable.pi2,R.drawable.pi3,R.drawable.pi4,R.drawable.pi5,R.drawable.pi6};
    String []arr1={"Corn Pizza","Crust Pizza","Mushroom Pizza","Pepperoni Pizza","Basil Pizza","Chicken Pizza"};
    String []arrp={"150","220","250","399","250","420"};
    String []arrd={"A pizza topped with sweet and savory corn kernels for a unique twist."," A pizza variation focusing on the crispy, doughy crust, often brushed with garlic butter."," A pizza featuring sliced or sautéed mushrooms as the primary topping."," A classic pizza topped with spicy, thinly sliced pepperoni sausage."," A pizza garnished with fresh basil leaves for a fragrant and herbaceous flavor."," A pizza adorned with tender chicken pieces, often combined with other toppings for a hearty meal."};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pizza);

        recyclerView=findViewById(R.id.recyclerview2);
        layoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerViewAdapter=new RecyclerViewAdapterc(arr,arr1,arrp,arrd,this);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setHasFixedSize(true);
    }

}