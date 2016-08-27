package com.khanepani.khanepanischedule;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.NameList;

public class home extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    Button btn1, btn2, btn3;
    TextView select;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        navigationView = (NavigationView) findViewById(R.id.navigation);

        btn1 = (Button) findViewById(R.id.tole1);
        btn2 = (Button) findViewById(R.id.tole2);
        btn3 = (Button) findViewById(R.id.tole3);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);      //toggle enabled
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toggle = new ActionBarDrawerToggle(this, drawerLayout,toolbar, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle("List");
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getSupportActionBar().setTitle("KhanePaaniSchedule");
            }
        };
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.select:
                        Intent intent=new Intent(home.this,home.class);
                        startActivity(intent);
//                        Toast.makeText(home.this, "Select ur tole", Toast.LENGTH_LONG).show();
                        return true;

                    case R.id.settings:
                        Intent intent1 = new Intent(home.this, Settings.class);
                        startActivity(intent1);
//                        Toast.makeText(home.this, "settings", Toast.LENGTH_LONG).show();
                        return true;

                    case R.id.about:
                        Toast.makeText(home.this, "About Activity", Toast.LENGTH_LONG).show();
                        return true;

                    case R.id.contact:
                        Toast.makeText(home.this, "Contact Activity", Toast.LENGTH_LONG).show();
                        return true;

                    default:
                        Toast.makeText(home.this, " Activity", Toast.LENGTH_LONG).show();
                        return true;
                }

            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(home.this, tole1.class);
                startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(home.this, Tole2.class);
                startActivity(intent);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(home.this, Tole3.class);
                startActivity(intent);
            }
        });
    }

        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.navigationmenu, menu);
            //return super.onCreateOptionsMenu(menu);
            return true;

        }

        @Override
        public boolean onOptionsItemSelected (MenuItem item){
            if (toggle.onOptionsItemSelected(item)) {
                return true;
            }
            return super.onOptionsItemSelected(item);
        }



}



