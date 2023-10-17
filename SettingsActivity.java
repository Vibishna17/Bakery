package com.example.lab_05;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {
    EditText name, passwd, ph, mail;
    Button save, button;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        save = findViewById(R.id.sbutton);
        name = findViewById(R.id.names);
        passwd = findViewById(R.id.passs);
        ph = findViewById(R.id.TextPhone);
        DB = new DBHelper(this);
        ImageButton passwordToggle = findViewById(R.id.passwordToggles);

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


        // Retrieve the username and password from the database
        String usernameFromDB = DB.getUsername(); // Implement the method to get the username
        String passwordFromDB = DB.getPassword();
        String phFromDB = DB.getPh();
        // Implement the method to get the password

        // Set the retrieved username and password in the EditText fields
        name.setText(usernameFromDB);
        passwd.setText(passwordFromDB);
        ph.setText(phFromDB);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show a Toast message on clicking save button
                Toast.makeText(SettingsActivity.this, "Settings Saved", Toast.LENGTH_SHORT).show();
            }
        });

        button = findViewById(R.id.sbutton);

        // Setting onClick behavior to the button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                String passTXT = passwd.getText().toString();
                String passPASS=ph.getText().toString();

                Boolean checkUpdate = DB.updateuserdata(nameTXT, passTXT,passPASS);
                if (checkUpdate == true) {
                    Toast.makeText(SettingsActivity.this, "Entry Updated", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SettingsActivity.this, Login_Activity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(SettingsActivity.this, "Not Updated", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
        // Initializing the popup menu and giving the reference as current context
//                PopupMenu popupMenu = new PopupMenu(SettingsActivity.this, button);
//
//                // Inflating popup menu from popup_menu.xml file
//                popupMenu.getMenuInflater().inflate(R.menu.pop_up, popupMenu.getMenu());
//                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//                    @Override
//                    public boolean onMenuItemClick(MenuItem menuItem) {
//                        // Toast message on menu item clicked
//                        Toast.makeText(SettingsActivity.this, "You Clicked " + menuItem.getTitle(), Toast.LENGTH_SHORT).show();
//                        return true;
//                    }
//                });
//                // Showing the popup menu
//                popupMenu.show();

