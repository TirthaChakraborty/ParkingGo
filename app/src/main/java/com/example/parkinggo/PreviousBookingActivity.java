package com.example.parkinggo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

public class PreviousBookingActivity extends Dashboard {

    //BottomNavigationView bottomNavigation;
   private Context mcontext;
   LinearLayout dynamicContent,bottonNavBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_previousbooking);
//        mcontext = this;


//        bottomNavigation = findViewById(R.id.bottom_navigation);
//        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);


        dynamicContent = (LinearLayout) findViewById(R.id.dynamicContent);
        bottonNavBar= (LinearLayout) findViewById(R.id.bottonNavBar);
        View wizard = getLayoutInflater().inflate(R.layout.activity_previousbooking, null);
        dynamicContent.addView(wizard);

        RadioGroup rg=(RadioGroup)findViewById(R.id.radioGroup1);
        RadioButton rb=(RadioButton)findViewById(R.id.prevbooking);
        rb.setCompoundDrawablesWithIntrinsicBounds( 0,R.drawable.recents_selected, 0,0);
        rb.setTextColor(Color.parseColor("#3F51B5"));



        Realm.init(mcontext);
        Realm realm=Realm.getDefaultInstance();
        RealmResults<Booking> book=realm.where(Booking.class).findAll();

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

         if(book.isEmpty())
        {
//            Toast.makeText(this, "Fragment to be loaded", Toast.LENGTH_SHORT).show();
            ft.add(R.id.frame_container,new EmptyListFragment());
        }
        else  {

           //Log.i("dashboard", "task exist");

            ft.add(R.id.frame_container, new PrevListFragment(book));
        }



        //ft.addToBackStack(null);}
//        else
//        {
//            RealmResults<Booking> b=realm.where(Booking.class).findAll();
//            if(b.size()>0)
//            {   realm.beginTransaction();
//
//                b.deleteAllFromRealm();
//                realm.commitTransaction();
//                booking = realm.where(Booking.class).findAll();
////            }
//
//            ft.add(R.id.frame_container,new PrevListFragment(booking));


//        }
        ft.commit();


    }






}
