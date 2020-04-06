package com.example.parkinggo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Rent extends AppCompatActivity {

    ImageButton b;
    private Context mcontext;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent);
        mcontext=this;
        b=(ImageButton)findViewById(R.id.submit_rent);

        SharedPreferences sh
                = getSharedPreferences("UserDetails",
                MODE_PRIVATE);
        String mail=sh.getString("useremailid","");

        ActionBar actionBar = getSupportActionBar(); // or getActionBar();
        getSupportActionBar().setTitle(mail);



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

    public void onSubmit(View view){

        Intent intent = new Intent(mcontext, ConfirmRentActivity.class);
        startActivity(intent);

    }
}
