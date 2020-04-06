package com.example.parkinggo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.regex.Pattern;

public class Reg_page3 extends Activity {

    private EditText pass1,pass2;
    private Context mcontext;
    private static final Pattern PASSWORD_PATTERN = (Pattern) Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,}$");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reg_pg3);
        mcontext=this;


        pass1=findViewById(R.id.et_pass1);

//        pass1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//
//                if(!hasFocus){
//                    //this if condition is true when edittext lost focus...
//                    //check here for number is larger than 10 or not
//
//
//                    if(pass1.getText().toString().isEmpty()) {
//                        pass1.setError("Field cannot be empty");
//
//                    }else {
//                        if (!PASSWORD_PATTERN.matcher(pass1.getText().toString().trim()).matches()) {
//                            pass1.setError("Atleast one : lowercse letter, uppercase letter, special character, digit and no white space");
//
//                        } else {
//                            pass1.setError(null);
//
//                        }
//                    }
//
//                }
//            }
//        });

        pass2=findViewById(R.id.et_pass2);
//        pass2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//
//                if(!hasFocus){
//                    //this if condition is true when edittext lost focus...
//                    //check here for number is larger than 10 or not
//
//
//                    if(pass2.getText().toString().isEmpty()) {
//                        pass2.setError("Field cannot be empty");
//
//                    }else {
//                        if (!PASSWORD_PATTERN.matcher(pass2.getText().toString().trim()).matches()) {
//                            pass2.setError("Follow password convention given above");
//
//                        } else {
//                            pass2.setError(null);
//
//                        }
//                    }
//
//                }
//            }
//        });
    }

    public void register(View view){

        if (pass1.getText().toString().isEmpty()) {
            pass1.setError("Field cannot be empty");
        }
        if (pass2.getText().toString().isEmpty()) {
            pass2.setError("Field cannot be empty");
        }

//        if (!PASSWORD_PATTERN.matcher(pass2.getText().toString().trim()).matches()) {
//            pass2.setError("Follow password convention given above");
//        }

        else if(!(pass1.getText().toString().equals(pass2.getText().toString()))){
            pass2.setError("Re-entered password does not match");
        }

        else {

            Intent intent = new Intent(mcontext, LoginActivity.class);
            startActivity(intent);
        }
    }
}
