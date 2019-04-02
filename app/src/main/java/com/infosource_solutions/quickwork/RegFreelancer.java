package com.infosource_solutions.quickwork;

import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hbb20.CountryCodePicker;
import com.tomergoldst.tooltips.ToolTip;
import com.tomergoldst.tooltips.ToolTipAnimator;
import com.tomergoldst.tooltips.ToolTipsManager;

import de.hdodenhof.circleimageview.CircleImageView;

public class RegFreelancer extends AppCompatActivity implements ToolTipsManager.TipListener,PhotoOptionsSheet.BottomSheetListener {

    private ImageButton infoBtn;
    private ImageButton freelancePic;
    private Button cancelBtn, createBtn;
    private LinearLayout actionLayout;
    private TextView fullName, email, dob, city, terms, privacy;
    private EditText phoneNumber, pass, repPass;
    private RelativeLayout main_layout;
    private CountryCodePicker ccp_country, ccp;
    PhotoOptionsSheet picOptionsSheet = new PhotoOptionsSheet();
    ToolTipsManager toolTipsManager = new ToolTipsManager(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_freelancer);
       // setupWindowAnimations();
        main_layout = findViewById(R.id.main_layout);
        ccp_country = findViewById(R.id.ccp_country);
        ccp = findViewById(R.id.ccp);
        freelancePic = findViewById(R.id.freelancer_pic);
        cancelBtn = findViewById(R.id.cancel_btn);
        createBtn = findViewById(R.id.create_account);
        infoBtn = findViewById(R.id.info_btn);
        fullName = findViewById(R.id.full_name);
        email = findViewById(R.id.email);
        dob = findViewById(R.id.date_birth);
        city = findViewById(R.id.city);
        phoneNumber = findViewById(R.id.phone_number);
        terms = findViewById(R.id.terms);
        privacy = findViewById(R.id.privacy);
        pass = findViewById(R.id.password);
        repPass = findViewById(R.id.repeat_pass);
        actionLayout = findViewById(R.id.action_layout);

        terms.setPaintFlags(terms.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        privacy.setPaintFlags(privacy.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        initFonts();

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancelRegistration();
            }
        });

        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectPhoto();
            }
        });

        infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToolTip();
            }
        });

        freelancePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectPhoto();
            }
        });
    }

    private void setupWindowAnimations() {
        Slide slide = new Slide();
        slide.setDuration(500);
        getWindow().setExitTransition(slide);
    }

    private void cancelRegistration(){
        super.onBackPressed();
    }

    private void showToolTip(){
        ToolTip.Builder builder = new ToolTip.Builder(this, infoBtn, main_layout, "Tip message", ToolTip.POSITION_BELOW);
        builder.setBackgroundColor(getResources().getColor(R.color.white));
        builder.setTextAppearance(R.style.TooltipTextAppearance); // from `styles.xml`
        toolTipsManager.show(builder.build());
    }

    private void selectPhoto(){
        picOptionsSheet.show(getSupportFragmentManager(), "editLoanDialog");
        Toast.makeText(getApplicationContext(), "testing sheet", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onTipDismissed(View view, int anchorViewId, boolean byUser) {
    }

    @Override
    public void onButtonClicked(int button) {

    }

    private void initFonts(){
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/quicksand/Quicksand-Regular.otf");
        fullName.setTypeface(typeface);
        email.setTypeface(typeface);
        dob.setTypeface(typeface);
        city.setTypeface(typeface);
        phoneNumber.setTypeface(typeface);
        terms.setTypeface(typeface);
        privacy.setTypeface(typeface);
        pass.setTypeface(typeface);
        repPass.setTypeface(typeface);
        cancelBtn.setTypeface(typeface);
        createBtn.setTypeface(typeface);
        ccp_country.setTypeFace(typeface);
    }
}
