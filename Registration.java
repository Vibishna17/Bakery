package com.example.lab_05;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import android.os.Bundle;
import android.content.Intent;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.CompoundButton;
import com.google.android.material.switchmaterial.SwitchMaterial;
import java.util.Objects;


public class Registration extends AppCompatActivity {
    Button regi;
    EditText name, passwd, pho;
    TextView lo;
    RadioGroup radioGroup;
    RadioButton gender;
    DBHelper DB;
    boolean isAllFieldsChecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        regi = findViewById(R.id.sign);
        name = findViewById(R.id.name);
        passwd = findViewById(R.id.password);
        pho = findViewById(R.id.phone);
        radioGroup = (RadioGroup) findViewById(R.id.radiogrp);
        lo=findViewById(R.id.si_l);
        DB = new DBHelper(this);
        lo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Registration.this, Login_Activity.class);
                startActivity(i);
            }
        });
        ImageButton passwordToggle = findViewById(R.id.passwordToggler);

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


        regi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = name.getText().toString();
                String pass = passwd.getText().toString();
                String phone =pho.getText().toString();
                isAllFieldsChecked = CheckAllFields();

                if (isAllFieldsChecked) {
                    Boolean checkuser = DB.checkusername(user);
                    if (checkuser==false) {
                        Boolean insert = DB.insertData(user, pass,phone);
                        if (insert==true) {
                            Toast.makeText(Registration.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(Registration.this, Login_Activity.class);
                            startActivity(i);
                        } else {
                            Toast.makeText(Registration.this, "Registration Failed. Please try again.", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(Registration.this, "User Already Exists. Please choose a different username.", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });
    }

    public void onclickbuttonMethod(View v) {
        int selectedId = radioGroup.getCheckedRadioButtonId();
        gender = (RadioButton) findViewById(selectedId);
        if (selectedId == -1) {
            Toast.makeText(Registration.this, "Nothing selected", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(Registration.this, gender.getText(), Toast.LENGTH_SHORT).show();
        }
    }

    private boolean CheckAllFields() {
        if (name.length() == 0) {
            name.setError("This field is required");
            return false;
        }
        if (passwd.length() == 0) {
            passwd.setError("Password is required");
            return false;
        } else if (passwd.length() < 8) {
            passwd.setError("Password should be maximum 8 characters");
            return false;
        }
        if (pho.length() == 0) {
            pho.setError("Phone number is required");
            return false;
        } else if (pho.length() < 10 || pho.length() > 10) {
            pho.setError("Phone number should be maximum 10 digits");
            return false;
        }
        return true;
    }
}
