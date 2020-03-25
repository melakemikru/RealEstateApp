package com.melake.realestateapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;

public class Navigation2 extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    private AppBarConfiguration mAppBarConfiguration;
    private SharedPreferenceConfig preferenceConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle= new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        preferenceConfig = new SharedPreferenceConfig(getApplicationContext());
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        //mAppBarConfiguration = new AppBarConfiguration.Builder(
        //      R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
        //    R.id.nav_tools, R.id.nav_share, R.id.nav_send)
        //  .setDrawerLayout(drawer)
        //.build();
        //NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        //NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        //NavigationUI.setupWithNavController(navigationView, navController);
    }

    public void buttonGallery(View view){
        Intent intent= new Intent(Navigation2.this, Gallery.class);
        startActivity(intent);

    }
    public void buttonLocation(View view){
        Intent intent= new Intent(Navigation2.this, Location.class);
        startActivity(intent);

    }
    public void buttonTestimonial(View view){
        Intent intent= new Intent(Navigation2.this, Testimonial.class);
        startActivity(intent);

    }
    public void buttonContactUs(View view){
        Intent intent= new Intent(Navigation2.this, ContactUs.class);
        startActivity(intent);

    }

    @Override
    public void onBackPressed(){
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();

        if(id==R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item){
        int id=item.getItemId();

        if(id==R.id.viewgallery){
            Intent intent=new Intent(this,Gallery.class);
            startActivity(intent);

        } else if (id==R.id.ourlocations){
            Intent intent=new Intent(this,Location.class);
            startActivity(intent);

        } else if (id==R.id.testimonials){
            Intent intent=new Intent(this,Testimonial.class);
            startActivity(intent);

        } else if (id==R.id.contactus){
            Intent intent=new Intent(this,ContactUs.class);
            startActivity(intent);

        } else if (id==R.id.logout){
            preferenceConfig.writeLoginStatus(false);
            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
            finish();

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    // @Override
    //public boolean onSupportNavigateUp() {
    //  NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
    //return NavigationUI.navigateUp(navController, mAppBarConfiguration)
    //      || super.onSupportNavigateUp();
    //}
}
