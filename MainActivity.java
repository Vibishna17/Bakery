package com.example.lab_05;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.Button;
import android.view.View;
import android.widget.ImageView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button login;
    private Button register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // TextView textView =findViewById(R.id.textView13);
        //registerForContextMenu(textView);
        ImageView img=findViewById(R.id.imageView2);
        registerForContextMenu(img);
        login=findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent =new Intent(MainActivity.this, Login_Activity.class);
                startActivity(intent);
            }
        });
        register=findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent =new Intent(MainActivity.this, Registration.class);
                startActivity(intent);
            }
        });


    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu,menu);

    }

    @Override
    public boolean onContextItemSelected( MenuItem item)
    {
        int id = item.getItemId();

        if (id == R.id.mail) {
            Toast.makeText(this, "bakencake@gmail.com", Toast.LENGTH_LONG).show();
            return true;
        } else if (id == R.id.add) {
            Toast.makeText(this, "Anna Nagar Madurai", Toast.LENGTH_LONG).show();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }


    }
