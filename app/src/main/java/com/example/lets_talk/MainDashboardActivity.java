package com.example.lets_talk;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.lets_talk.ui.changepassword.ChangePasswordFragment;
import com.example.lets_talk.ui.changepassword.ListMenuFragment;
import com.example.lets_talk.ui.home.HomeFragment;
import com.example.lets_talk.ui.hotels.HotelsFragment;
import com.example.lets_talk.ui.hotels.MyListActivity;
import com.example.lets_talk.ui.settings.SettingsFragment;
import com.example.lets_talk.ui.slideshow.SlideshowFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainDashboardActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    BottomNavigationView bottomNavigationView;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dashboard);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


//        bottomNavigationView.setOnItemSelectedListener(item -> {
//            Fragment selectedFragment = new Fragment();
//            switch (item.getItemId()) {
//                case R.id.home:
//                    selectedFragment = new HomeFragment();
//                    break;
//
//                case R.id.settings:
//                    selectedFragment = new SettingsFragment();
//                    break;
//
//                case R.id.order:
//                    selectedFragment = new GalleryFragment();
//                    break;
//
//                case R.id.cart:
//                    selectedFragment = new SlideshowFragment();
//                    break;
//
//            }
//            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_main_dashboard, selectedFragment)
//                    .addToBackStack(null).commit();
//
//            return true;
//        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_help, menu);
        return true;
    }


    @SuppressLint("RestrictedApi")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /*
         Handle action bar item clicks here. The action bar will
         automatically handle clicks on the Home/Up button, so long
         as you specify a parent activity in AndroidManifest.xml.
        */
        int id = item.getItemId();

        /* logout button implementation */
        if(id == R.id.action_logout){
            Intent intent = new Intent(MainDashboardActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
            return true;
        }

        /* change password button implementation */
        if(id == R.id.action_change_password){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.nav_host_fragment_content_main_dashboard, new ChangePasswordFragment()).commit();
        }

        if(id == R.id.action_profile){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.nav_host_fragment_content_main_dashboard, new ListMenuFragment()).commit();
        }

        if(id == R.id.action_settings){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.nav_host_fragment_content_main_dashboard, new SettingsFragment()).commit();
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /*  navigation panel  */
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        /* Handle navigation view item clicks here. */
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.nav_host_fragment_content_main_dashboard, new HomeFragment()).commit();


        } else if (id == R.id.nav_hotel) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.nav_host_fragment_content_main_dashboard, new HotelsFragment()).commit();


        } else if (id == R.id.nav_location) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.nav_host_fragment_content_main_dashboard, new SlideshowFragment()).commit();


        } else if (id == R.id.nav_posts) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.nav_host_fragment_content_main_dashboard, new ListMenuFragment()).commit();

        } else if (id == R.id.nav_messages) {

            Intent intent = new Intent(MainDashboardActivity.this, MyListActivity.class);
            startActivity(intent);
            finish();
            return true;

        }else if(id == R.id.nav_friends){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.nav_host_fragment_content_main_dashboard, new SlideshowFragment()).commit();

        }else if(id == R.id.nav_contact){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.nav_host_fragment_content_main_dashboard, new HomeFragment()).commit();

    }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}