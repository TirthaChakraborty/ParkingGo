package com.example.parkinggo;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import io.realm.Realm;


import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NewbookingActivity extends Dashboard {

    BottomNavigationView bottomNavigation;
    private Context mcontext;
    private String mParam1;
    private String mParam2;
    private EditText toDate, fromDate, toTime, fromTime;
    private EditText cnum,cmod;
    private ImageButton loc;
    private int dayPicked, monthPicked,yearPicked,minutePicked,hourPicked;
    LinearLayout dynamicContent,bottonNavBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dynamicContent = (LinearLayout) findViewById(R.id.dynamicContent);
        bottonNavBar= (LinearLayout) findViewById(R.id.bottonNavBar);
        View wizard = getLayoutInflater().inflate(R.layout.activity_newbooking, null);
        dynamicContent.addView(wizard);

        RadioGroup rg=(RadioGroup)findViewById(R.id.radioGroup1);
        RadioButton rb=(RadioButton)findViewById(R.id.newbooking);
        rb.setCompoundDrawablesWithIntrinsicBounds( 0,R.drawable.plusicon_selected1, 0,0);
        rb.setTextColor(Color.parseColor("#3F51B5"));

        cnum = findViewById(R.id.car_Number);
        cmod = findViewById(R.id.car_model);
        toDate = findViewById(R.id.dateTo);
        fromDate = findViewById(R.id.dateFrom);
        toTime = findViewById(R.id.timeTo);
        fromTime = findViewById(R.id.timeFrom);
        loc = (ImageButton) findViewById(R.id.location_btn);
        Calendar calendar = Calendar.getInstance();
        dayPicked = calendar.get(Calendar.DATE);
        yearPicked = calendar.get(Calendar.YEAR);
    }


        public void PickDate_from(View view)
        {
            DatePickerDialog.OnDateSetListener onDateSetListener=new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    dayPicked = dayOfMonth;
                    monthPicked = month;
                    yearPicked=year;
                    fromDate.setText(dayPicked+"/"+(monthPicked+1)+"/"+yearPicked);
                }
            };
            DatePickerDialog datePickerDialog=new DatePickerDialog(this,onDateSetListener,yearPicked,monthPicked,dayPicked);
            datePickerDialog.show();
        }

    public void PickDate_to(View view)
    {
        DatePickerDialog.OnDateSetListener onDateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                dayPicked = dayOfMonth;
                monthPicked = month;
                yearPicked=year;
                toDate.setText(dayPicked+"/"+(monthPicked+1)+"/"+yearPicked);
            }
        };
        DatePickerDialog datePickerDialog=new DatePickerDialog(this,onDateSetListener,yearPicked,monthPicked,dayPicked);
        datePickerDialog.show();
    }

    public void PickTime_from(View view){
        TimePickerDialog.OnTimeSetListener onTimeSetListener=new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                hourPicked=hourOfDay;
                minutePicked=minute;
                fromTime.setText(hourPicked+":"+minutePicked);
            }
        };
        TimePickerDialog timePickerDialog=new TimePickerDialog(this, onTimeSetListener,hourPicked,minutePicked,true);
        timePickerDialog.show();
    }

    public void PickTime_to(View view){
        TimePickerDialog.OnTimeSetListener onTimeSetListener=new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                hourPicked=hourOfDay;
                minutePicked=minute;
                toTime.setText(hourPicked+":"+minutePicked);
            }
        };
        TimePickerDialog timePickerDialog=new TimePickerDialog(this, onTimeSetListener,hourPicked,minutePicked,true);
        timePickerDialog.show();
    }

 public void location(View view) {

     Realm realm=Realm.getDefaultInstance();
     realm.beginTransaction();
     try{
         Number currentIdNum=realm.where(Booking.class).max("bookingId");
         int nextId = (currentIdNum == null) ? 1 : currentIdNum.intValue() + 1;
         Booking booking=realm.createObject(Booking.class,nextId);
         booking.setCarNo(cnum.getText().toString());
         SimpleDateFormat f=new SimpleDateFormat("dd/MM/yyyy");
         Date d=f.parse(fromDate.getText().toString());

//         Log.i("Date Received : ",mdate.getText().toString());
//         Log.i("Date : ",d.toString());

         booking.setDateFrom(d);
         booking.setCarModel(cmod.getText().toString());

         booking.setTimeFrom(fromTime.getText().toString());
         booking.setTimeTo(toTime.getText().toString());

         //task.setColor(h.getText().toString());
         //task.setUserId(id);
         //task.setChecked("false");

         realm.commitTransaction();
         Toast.makeText(this, "Current task id is "+nextId, Toast.LENGTH_SHORT).show();

         // Intent intent=new Intent(this,Dashboard.class);
         //startActivity(intent);

     }
     catch(Exception e){realm.cancelTransaction();}
     finally {
         realm.close();
     }
     //onBackPressed();


 }





}