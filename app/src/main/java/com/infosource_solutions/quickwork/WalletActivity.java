package com.infosource_solutions.quickwork;

import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.infosource_solutions.quickwork.Activity.MainDash;
import com.infosource_solutions.quickwork.Adapter.TabAdapter;
import com.infosource_solutions.quickwork.Fragment.FreeLancer;
import com.infosource_solutions.quickwork.Fragment.Messages;
import com.infosource_solutions.quickwork.Fragment.My;
import com.infosource_solutions.quickwork.Fragment.WalletFragment;

public class WalletActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle t;
    Fragment fragment;
    Button wallet;
    TabItem topup,withdraw;
    RelativeLayout toolbar;
    private TabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int[] tabIcons = {
            R.drawable.ic_wallet_15,
            R.drawable.ic_jobs,
            R.drawable.ic_messages
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);
        toolbar = findViewById(R.id.tool_bar);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        wallet=findViewById(R.id.wallet);
        fragment = new WalletFragment();
        loadFragment(fragment);
        ImageView hamburger=findViewById(R.id.hamburger);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tabLayout.getSelectedTabPosition()==0){
                    topupfrag();


                }
                else if (tabLayout.getSelectedTabPosition()==1){
                    withdrawfrag();
                }
                else if (tabLayout.getSelectedTabPosition()==2){
                    paymentfrag();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mDrawerLayout = findViewById(R.id.drawer_layout);
        t = new ActionBarDrawerToggle(this, mDrawerLayout,R.string.Open, R.string.Close);
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
    private void highLightCurrentTab(int position) {
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            assert tab != null;
            tab.setCustomView(null);
            tab.setCustomView(adapter.getTabView(i));
        }
        TabLayout.Tab tab = tabLayout.getTabAt(position);
        assert tab != null;
        tab.setCustomView(null);
        tab.setCustomView(adapter.getSelectedTabView(position));
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

    public void topupfrag(){
        fragment = new TopUpFragment();
        loadFragment(fragment);
    }
    public void withdrawfrag(){
        fragment = new withdrawFragment();
        loadFragment(fragment);
    }

    public void paymentfrag(){
        fragment = new PaymentFragment();
        loadFragment(fragment);
    }

    private void loadFragment(Fragment fragment) {
        // load fragment

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        // transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
        transaction.replace(R.id.container, fragment);
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
        FeedActivity(null);


    }
}
