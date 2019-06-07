package com.infosource_solutions.quickwork.Activity;

import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.transition.Fade;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.infosource_solutions.quickwork.R;


public class Category extends AppCompatActivity {

    private Button freelanceBtn, businesBtn;
    private TextView signInLink, registered, regTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        setupWindowAnimations();
        signInLink = findViewById(R.id.sign_in);
        registered = findViewById(R.id.registered);
        regTitle = findViewById(R.id.register_message);
        freelanceBtn = findViewById(R.id.freelanceBtn);
        businesBtn = findViewById(R.id.businesBtn);
        initFonts();
        signInLink.setPaintFlags(signInLink.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        signInLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivity(new Intent(Category.this, SignIn.class));
            }
        });

        freelanceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //freelancerRegistration ();

                Intent intent = new Intent(Category.this, RegFreelancer.class);
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(Category.this, freelanceBtn, ViewCompat.getTransitionName(freelanceBtn));
                startActivity(intent, options.toBundle());
            }
        });

        businesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Category.this, RegBusiness.class);
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(Category.this, businesBtn, ViewCompat.getTransitionName(freelanceBtn));
                startActivity(intent, options.toBundle());
            }
        });
    }

    private void setupWindowAnimations(){
        Fade slide = new Fade();
        slide.setDuration(500);
        getWindow().setExitTransition(slide);
    }

    private void freelancerRegistration () {
        Intent intent = new Intent(Category.this, RegFreelancer.class);
            ActivityOptionsCompat options = ActivityOptionsCompat.
                    makeSceneTransitionAnimation(Category.this, freelanceBtn, ViewCompat.getTransitionName(freelanceBtn));
            startActivity(intent, options.toBundle());

    }

    private void businessRegistration () {

    }

    private void initFonts(){
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/quicksand/Quicksand-Regular.otf");
        Typeface typeface1 = Typeface.createFromAsset(getAssets(), "fonts/quicksand/Quicksand-Bold.otf");
        signInLink.setTypeface(typeface);
        freelanceBtn.setTypeface(typeface);
        businesBtn.setTypeface(typeface);
        regTitle.setTypeface(typeface1);
        registered.setTypeface(typeface);
    }
}
