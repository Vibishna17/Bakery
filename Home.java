package com.example.lab_05;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.SeekBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.navigation.NavigationView;

public class Home extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationview;
    SeekBar slider;
    ActionBarDrawerToggle drawertoggle;
    String name;
    //FirebaseAuth auth;
    //FirebaseUser user;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (drawertoggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Button back=findViewById(R.id.button_bl);
        name=SharedPref.getName(this);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home.this,Login_Activity.class);
                        startActivity(intent);
            }
        });
        Toolbar toolbar = findViewById(R.id.toolbar_h);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Home");
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationview = findViewById(R.id.nav_view);
        navigationview.bringToFront();
        ViewPager viewPager = findViewById(R.id.viewPager1); // Make sure the ID matches your layout XML
        ImageAdapter adapter = new ImageAdapter(this, viewPager); // Pass the ViewPager as an argument
        viewPager.setAdapter(adapter);

        slider = findViewById(R.id.slider);
        // Respond to changes in the SeekBar (slider).
        slider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // Update ViewPager content based on the SeekBar position (progress).
                // Calculate which page to show based on progress and set it in the ViewPager.
                int totalPages = viewPager.getAdapter().getCount();
                int pageToDisplay = (int) ((float) progress / 100 * (totalPages - 1));
                viewPager.setCurrentItem(pageToDisplay);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Handle when the user starts dragging the SeekBar.
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Handle when the user releases the SeekBar.
            }
        });
        View Header = navigationview.getHeaderView(0);
        TextView HeaderText = Header.findViewById(R.id.welcomeMessageTextView);
        HeaderText.setText(name.equals("")? getString(R.string.app_name): "Hello " + name + "!");


        drawertoggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(drawertoggle);
        drawertoggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationview.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.sign_m) {
                    Intent intent = new Intent(Home.this,Registration.class);
                    startActivity(intent);
                    //Toast.makeText(Home.this, "Sign_up", Toast.LENGTH_SHORT).show();
                } else if (itemId == R.id.pas_m) {
                   // Toast.makeText(Home.this, "Pastries", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Home.this,pasteries.class);
                    startActivity(intent);

                } else if (itemId == R.id.cake_m) {
                    //Toast.makeText(Home.this, "Cake", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Home.this, cakes.class);
                    startActivity(intent);

                }
                else if (itemId == R.id.pizza_m) {
                    //Toast.makeText(Home.this, "Pizza", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Home.this, pizza.class);
                    startActivity(intent);

                }
                else if (itemId == R.id.settings_m) {
                    //Toast.makeText(Home.this, "Pizza", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Home.this, SettingsActivity.class);
                    startActivity(intent);

                }
                else if (itemId == R.id.abt_m) {
                    //Toast.makeText(Home.this, "Pizza", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Home.this, aboutus.class);
                    startActivity(intent);

                } else if (itemId ==R.id.log_out) {
                    SharedPreferences sharedpreferences = getSharedPreferences("mypreference", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putBoolean("isLoggedIn", false);
                    editor.remove("username"); // Remove the stored username
                    editor.apply();

                    // Redirect to the login activity
                    Intent intent = new Intent(Home.this, Login_Activity.class);
                    startActivity(intent);
                    finish(); // Finish the current activity to prevent going back to it
                    return true;
                }
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}

