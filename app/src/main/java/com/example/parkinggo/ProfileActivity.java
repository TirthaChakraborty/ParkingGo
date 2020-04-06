package com.example.parkinggo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfileActivity extends Dashboard {

    //BottomNavigationView bottomNavigation;
    private Context mcontext;
    LinearLayout dynamicContent,bottonNavBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_profile);
//        mcontext = this;

//        bottomNavigation = findViewById(R.id.bottom_navigation);
//        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);


        dynamicContent = (LinearLayout) findViewById(R.id.dynamicContent);
        bottonNavBar= (LinearLayout) findViewById(R.id.bottonNavBar);
        View wizard = getLayoutInflater().inflate(R.layout.activity_profile, null);
        dynamicContent.addView(wizard);

        RadioGroup rg=(RadioGroup)findViewById(R.id.radioGroup1);
        RadioButton rb=(RadioButton)findViewById(R.id.profile);
        rb.setCompoundDrawablesWithIntrinsicBounds( 0,R.drawable.profileicon_selected, 0,0);
        rb.setTextColor(Color.parseColor("#3F51B5"));

    }

//    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
//            new BottomNavigationView.OnNavigationItemSelectedListener() {
//                @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                    switch (item.getItemId()) {
//                        case R.id.navigation_newbooking:
//                        {
//                            Intent intent = new Intent(mcontext, NewbookingActivity.class);
//                            startActivity(intent);
//                            return true;
//                        }
//
//                        case R.id.navigation_prevbooking:
//                        {
//                            Intent intent = new Intent(mcontext, PreviousBookingActivity.class);
//                            startActivity(intent);
//                            return true;
//                        }
//
//                        case R.id.navigation_payment:
//                        {  Intent intent = new Intent(mcontext, Reg_page2.class);
//                            startActivity(intent);
//                            return true;
//                        }
//                        case R.id.navigation_profile:
//                        {
//                            Intent intent = new Intent(mcontext, ProfileActivity.class);
//                            startActivity(intent);
//                            return true;
//                        }
//
//                    }
//                    return false;
//                }
//            };

}
