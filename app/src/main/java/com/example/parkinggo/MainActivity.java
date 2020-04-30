package com.example.parkinggo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {

    private ImageView imgview;
    private Context mcontext;
    private EditText name,address;
    private LottieAnimationView nextpage,car;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mcontext=this;
        nextpage = findViewById(R.id.signinnextpage);
        car=findViewById(R.id.signinpageanimation);
        car.setAnimation(R.raw.signinpagecar);
        car.playAnimation();
        nextpage.setAnimation(R.raw.signinnextpage);
        nextpage.playAnimation();
        nextpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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


        });


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
