package com.infosource_solutions.quickwork;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainDash extends AppCompatActivity {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dash);

        mToolbar = findViewById(R.id.tool_bar);

        //mToolbar.setNavigationIcon(R.drawable.hamburger);
        setSupportActionBar(mToolbar);
    }
}
