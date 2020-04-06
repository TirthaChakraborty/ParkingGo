package com.example.parkinggo;

import android.content.Context;
import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Dashboard extends AppCompatActivity {

    private Context mcontext;
    RadioGroup radioGroup1;
    RadioButton newbook,prevbook,profile1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        mcontext=this;
        SharedPreferences sh
                = getSharedPreferences("UserDetails",
                MODE_PRIVATE);
        String mail=sh.getString("useremailid","");

        ActionBar actionBar = getSupportActionBar(); // or getActionBar();
        getSupportActionBar().setTitle(mail);


        radioGroup1=(RadioGroup)findViewById(R.id.radioGroup1);
        newbook = (RadioButton)findViewById(R.id.newbooking);
        prevbook = (RadioButton)findViewById(R.id.prevbooking);
        profile1 = (RadioButton)findViewById(R.id.profile);
        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                Intent in;
                Log.i("matching", "matching inside1 bro" + checkedId);
                switch (checkedId)
                {
                    case R.id.newbooking:
//                        Log.i("matching", "matching inside1 matching" +  checkedId);
                        in=new Intent(Dashboard.this,NewbookingActivity.class);
                        startActivity(in);
                        overridePendingTransition(0, 0);
                        break;
                    case R.id.prevbooking:
                        Log.i("matching", "matching inside1 watchlistAdapter" + checkedId);

                        in = new Intent(Dashboard.this, PreviousBookingActivity.class);
                        startActivity(in);
                        overridePendingTransition(0, 0);

                        break;
                    case R.id.profile:
                        Log.i("matching", "matching inside1 rate" + checkedId);

                        in = new Intent(Dashboard.this,ProfileActivity.class);
                        startActivity(in);
                        overridePendingTransition(0, 0);
                        break;
                    case R.id.backtomenu:
                        Log.i("matching", "matching inside1 listing" + checkedId);
                        in = new Intent(Dashboard.this, ChooseUserActivity.class);
                        startActivity(in);
                        overridePendingTransition(0, 0);
                        break;
//                    case R.id.deals:
//                        Log.i("matching", "matching inside1 deals" + checkedId);
//                        in = new Intent(getBaseContext(), DealsActivity.class);
//                        startActivity(in);
//                        overridePendingTransition(0, 0);
//                        break;
                    default:
                        break;
                }
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
    public boolean onOptionsItemSelected(MenuItem item) { switch(item.getItemId()) {
        case R.id.exit:
            Intent intent = new Intent(mcontext, LoginActivity.class);
            startActivity(intent);
            return(true);

    }
        return(super.onOptionsItemSelected(item));
    }
}

