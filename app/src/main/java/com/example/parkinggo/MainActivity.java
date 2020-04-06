package com.example.parkinggo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imgview;
    private Context mcontext;
    private EditText name,address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mcontext=this;


        name=findViewById(R.id.et_name);
//        name.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//
//                if (!hasFocus) {
//                    //this if condition is true when edittext lost focus...
//                    //check here for number is larger than 10 or not
//
//
//                    if (name.getText().toString().isEmpty()) {
//                        name.setError("Field cannot be empty");
//
//                    }
//                }
//
//            }
//        });

        address=findViewById(R.id.et_address);
//        address.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//
//                if (!hasFocus) {
//                    //this if condition is true when edittext lost focus...
//                    //check here for number is larger than 10 or not
//
//
//                    if (address.getText().toString().isEmpty()) {
//                        address.setError("Field cannot be empty");
//
//                    }
//                }
//
//            }
//        });

    }

   public void Next1(View view){
       if (address.getText().toString().isEmpty()) {
           address.setError("Field cannot be empty");
       }
       if (name.getText().toString().isEmpty()) {
               name.setError("Field cannot be empty");
           }
       else
        {
            Intent intent = new Intent(mcontext, Reg_page2.class);
            startActivity(intent);
        }
    }

}
