package com.infosource_solutions.quickwork.Activity;

import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.infosource_solutions.quickwork.AboutActivity;
import com.infosource_solutions.quickwork.BusinessHomeFragment;
import com.infosource_solutions.quickwork.ContactActivity;
import com.infosource_solutions.quickwork.Fragment.WalletFragment;
import com.infosource_solutions.quickwork.PaymentActivity;
import com.infosource_solutions.quickwork.R;
import com.infosource_solutions.quickwork.ReportActivity;
import com.infosource_solutions.quickwork.SettingsActivity;
import com.infosource_solutions.quickwork.WalletActivity;

public class MainDash extends AppCompatActivity {

    private Toolbar mToolbar;

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle t;
    Fragment fragment;
    Button wallet;
    RelativeLayout toolbar;
    RelativeLayout relativeLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dash);
        toolbar = findViewById(R.id.tool_bar);
        wallet=findViewById(R.id.wallet);
        relativeLayout=findViewById(R.id.relative_layout);
        ImageView hamburger=findViewById(R.id.hamburger);
        fragment = new BusinessHomeFragment();
        loadFragment(fragment);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        t = new ActionBarDrawerToggle(this, mDrawerLayout,R.string.Open, R.string.Close);
       // getSupportActionBar().setDisplayShowTitleEnabled(false);
        mDrawerLayout.addDrawerListener(t);
        t.syncState();
        LinearLayout navigationView = findViewById(R.id.nv);
        hamburger.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (mDrawerLayout.isDrawerOpen(Gravity.RIGHT)) {
                    mDrawerLayout.closeDrawer(Gravity.RIGHT);
                } else {
                    mDrawerLayout.openDrawer(Gravity.RIGHT);
                }
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item != null && item.getItemId() == android.R.id.home) {
            if (mDrawerLayout.isDrawerOpen(Gravity.RIGHT)) {
                mDrawerLayout.closeDrawer(Gravity.RIGHT);
            }
            else {
                mDrawerLayout.openDrawer(Gravity.RIGHT);
            }
        }
        return false;
    }

    private void loadFragment(Fragment fragment) {
        // load fragment

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
       // transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
        transaction.replace(R.id.frame_container, fragment);
        //transaction.addToBackStack(null);
        transaction.commit();




    }



    public void wallet(View view){
        Intent intent=new Intent(this, WalletActivity.class);
        startActivity(intent);
        finish();




    }

    public void ReportActivity(View view){
        Intent intent=new Intent(this, ReportActivity.class);
        startActivity(intent);
        finish();




    }


    public void FeedActivity(View view){
        Intent intent=new Intent(this, MainDash.class);
        startActivity(intent);
        finish();




    }

    public void PaymentActivity(View view){
        Intent intent=new Intent(this, PaymentActivity.class);
        startActivity(intent);
        finish();




    }

    public void Settings(View view){
        Intent intent=new Intent(this, SettingsActivity.class);
        startActivity(intent);
        finish();




    }
    public void logout(View view){




    }


    public void about(View view){
        Intent intent=new Intent(this, AboutActivity.class);
        startActivity(intent);
        finish();

    }
    public void contact(View view){
        Intent intent=new Intent(this, ContactActivity.class);
        startActivity(intent);
        finish();




    }

    boolean doubleBackToExitPressedOnce = false;
    @Override
    public void onBackPressed() {
       // super.onBackPressed();



        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Snackbar.make(relativeLayout,"Please click BACK again to exit",Snackbar.LENGTH_SHORT).show();
        //Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
}
