package com.infosource_solutions.quickwork;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainDash extends AppCompatActivity {

    private Toolbar mToolbar;
    private TabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int[] tabIcons = {
            R.drawable.ic_cat_bus_selected,
            R.drawable.ic_dock_black_24dp,
            R.drawable.ic_message_black_24dp
    };
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dash);
        mToolbar = findViewById(R.id.tool_bar);
        //mToolbar.setNavigationIcon(R.drawable.hamburger);
        setSupportActionBar(mToolbar);
        mToolbar.setTitle("");
        mDrawerLayout = findViewById(R.id.drawer_layout);
        t = new ActionBarDrawerToggle(this, mDrawerLayout,R.string.Open, R.string.Close);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mDrawerLayout.addDrawerListener(t);
        t.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//       t.setDrawerIndicatorEnabled(false);
//       t.setHomeAsUpIndicator(R.drawable.menu_icon_big);
        NavigationView navigationView = findViewById(R.id.nv);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (mDrawerLayout.isDrawerOpen(Gravity.RIGHT)) {
                    mDrawerLayout.closeDrawer(Gravity.RIGHT);
                } else {
                    mDrawerLayout.openDrawer(Gravity.RIGHT);
                }
            }
        });
//        View headerView = navigationView.getHeaderView(0);
//        TextView navemail = (TextView) headerView.findViewById(R.id.user_eamil);
//        final TextView navUsername = (TextView) headerView.findViewById(R.id.username);
//        final TextView profileInitials = (TextView) headerView.findViewById(R.id.initials);
//
//
//        navemail.setText(email);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch(id)
                {
                    case R.id.feed:

                        break;
                    case R.id.Report:

                        break;
                    case R.id.wallet:

                        break;
                    default:
                        return true;
                }


                return true;

            }
        });

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        adapter = new TabAdapter(getSupportFragmentManager(),this);
        adapter.addFragment(new FreeLancer(), "Freelancer", tabIcons[0]);
        adapter.addFragment(new My(), "My", tabIcons[1]);
        adapter.addFragment(new Messages(), "Messages", tabIcons[2]);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        highLightCurrentTab(0); // for initial selected tab view
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                highLightCurrentTab(position); // for tab change
            }
            @Override
            public void onPageScrollStateChanged(int state) {
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
}
