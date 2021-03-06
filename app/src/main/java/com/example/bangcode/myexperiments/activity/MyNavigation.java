package com.example.bangcode.myexperiments.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.bangcode.myexperiments.R;
import com.example.bangcode.myexperiments.fragment.AsyncFragment;
import com.example.bangcode.myexperiments.fragment.BasicTextViewFragment;
import com.example.bangcode.myexperiments.fragment.ConstraintHelloToastFragment;
import com.example.bangcode.myexperiments.fragment.ImplicitsIntentFragment;
import com.example.bangcode.myexperiments.fragment.LinearHelloToastFragment;
import com.example.bangcode.myexperiments.fragment.RelativeHelloToastFragment;
import com.example.bangcode.myexperiments.fragment.SpinnerFragment;
import com.example.bangcode.myexperiments.fragment.TabAsync;
import com.example.bangcode.myexperiments.fragment.TabHelloToastFragment;
import com.example.bangcode.myexperiments.fragment.TabTextEntryFragment;

public class MyNavigation extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG= MyNavigation.class.getSimpleName();

    public static final int PAGE_TAB_HELLOTOAST=0;
    public static final int PAGE_TAB_ASYNC=1;
    public static final int PAGE_BASIC_TEXTVIEW=4;
    public static final int PAGE_IMPLICIT_INTENT=5;
    public static final int PAGE_TAB_TEXT_ENTRY=6;


    private Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
        
        setContentView(R.layout.activity_my_navigation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        changeFragment(PAGE_TAB_ASYNC);

        setActionBarTitle("Main Fragment");

//        Intent intent = getIntent();
//        Uri uri = intent.getData();
//        if (uri != null){
//            String uri_string = "URI:"+uri.toString();
//            TextView textView = (TextView) findViewById(R.id.tex_uri_message);
//            textView.setText(uri_string);
//        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my_navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.hellotoast_app) {
            // Handle the camera action
            changeFragment(PAGE_TAB_HELLOTOAST);
        }else if (id == R.id.textview_app) {
            changeFragment(PAGE_BASIC_TEXTVIEW);
        }else if (id == R.id.implicitsintent) {
            changeFragment(PAGE_IMPLICIT_INTENT);
        }else if (id == R.id.textEntry) {
            changeFragment(PAGE_TAB_TEXT_ENTRY);
        }else if (id == R.id.asyncme) {
            changeFragment(PAGE_TAB_ASYNC);
        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void changeFragment(int page){
        switch (page){
            case PAGE_TAB_HELLOTOAST:
                currentFragment= TabHelloToastFragment.newInstance();
                break;
            case PAGE_BASIC_TEXTVIEW:
                currentFragment= BasicTextViewFragment.newInstance();
                break;
            case PAGE_IMPLICIT_INTENT:
                currentFragment= ImplicitsIntentFragment.newInstance();
                break;
            case PAGE_TAB_TEXT_ENTRY:
                currentFragment= TabTextEntryFragment.newInstance();
                break;
            case PAGE_TAB_ASYNC:

                    currentFragment= AsyncFragment.newInstance();

                break;

        }

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, currentFragment)
                .commit();
    }

    public void setActionBarTitle(String title){
        getSupportActionBar().setTitle(title);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }


    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

            getSupportFragmentManager().putFragment(outState, "currentfragment", currentFragment);
    }
}
