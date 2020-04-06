package com.example.parkinggo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class ChooseUserActivity extends AppCompatActivity {

    private Context mcontext;
    ImageButton cust,rent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooseuser);
        mcontext=this;

        SharedPreferences sh
                = getSharedPreferences("UserDetails",
                MODE_PRIVATE);
        String mail=sh.getString("useremailid","");

        ActionBar actionBar = getSupportActionBar(); // or getActionBar();
        getSupportActionBar().setTitle(mail);


        cust=(ImageButton)findViewById(R.id.customer);
        rent=(ImageButton)findViewById(R.id.renter);
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




    public void openCustomer(View view){

        Intent intent = new Intent(mcontext, Dashboard.class);
        startActivity(intent);

    }

    public void openRenter(View view){

        Intent intent = new Intent(mcontext, Rent.class);
        startActivity(intent);

    }
}
