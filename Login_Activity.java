package com.example.lab_05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class Login_Activity extends AppCompatActivity {
    private EditText editText;
    private EditText passwd;

    private Button login_main;

    // private boolean isPasswordVisible = false;
    DBHelper DB;
    SharedPreferences sharedpreferences; // Declare SharedPreferences

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editText = findViewById(R.id.editText);
        passwd = findViewById(R.id.passswd);
        DB = new DBHelper(this);
        ImageButton passwordToggle = findViewById(R.id.passwordToggle);

        passwordToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (passwd.getText().toString().isEmpty()) {
                    passwd.setError("Please Enter Password");
                } else {
                    if (passwordToggle.getContentDescription().equals("Show")) {
                        passwordToggle.setContentDescription("Hide");
                        passwd.setTransformationMethod(null);
                    } else {
                        passwordToggle.setContentDescription("Show");
                        passwd.setTransformationMethod(new PasswordTransformationMethod());
                    }
                }
            }
        });

        // Initialize SharedPreferences
       sharedpreferences = getSharedPreferences("mypreference", Context.MODE_PRIVATE);

        login_main = findViewById(R.id.login_main);
        TextView signUpTextView = findViewById(R.id.sign_t);

        signUpTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_Activity.this, Registration.class);
                startActivity(intent);
            }
        });

        login_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editText.getText().toString().trim();
                String password = passwd.getText().toString().trim();
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(Login_Activity.this, "Enter the user name and password", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean checkuserpass = DB.checkusernamepassword(username, password);
                    if (checkuserpass == true) {
                        // Save login state in SharedPreferences
                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        editor.putBoolean("isLoggedIn", true);
                        editor.putString("username", username);
                        editor.putString("password",password);
                        // Save the username
                        editor.apply();


                        Toast.makeText(Login_Activity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        SharedPref.setName(Login_Activity.this,username);
                        Intent intent = new Intent(Login_Activity.this, Home.class);
                        startActivity(intent);
                        finish(); // Finish the login activity to prevent going back to it
                    } else {
                        Toast.makeText(Login_Activity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
