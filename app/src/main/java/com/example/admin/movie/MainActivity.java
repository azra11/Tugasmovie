package com.example.admin.movie;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button logout;
    private SlidingTabLayout nslidingTabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        viewPager = (ViewPager) findViewById(R.id.vp);
        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager(), this));

        nslidingTabLayout = (SlidingTabLayout) findViewById(R.id.sliding);
        nslidingTabLayout.setDistributeEvenly(true);
        nslidingTabLayout.setCustomTabView(R.layout.tab_view, R.id.tv_view);
        nslidingTabLayout.setViewPager(viewPager);

        Check();
        SharedPreferences SP = getApplicationContext().getSharedPreferences("Name", 0);
        logout = (Button) findViewById(R.id.b_logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pola.saveSharedsetting(MainActivity.this, "myclip", "false");
                pola.SAVE(getApplicationContext(), "");
                Intent logout = new Intent(getApplicationContext(), login.class);
                startActivity(logout);
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void Check() {
        Boolean cek = Boolean.valueOf(pola.readSharedSetting(MainActivity.this, "halo", "true"));

        Intent introIntent = new Intent(MainActivity.this, login.class);
        introIntent.putExtra("myclip", cek);
        if (cek) {
            startActivity(introIntent);
        }
    }
}