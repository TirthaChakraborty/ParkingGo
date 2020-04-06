package com.example.parkinggo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Reg_page2 extends Activity {

    private EditText mail,mob;
    private TextView otpMessage;
    private Context mcontext;
    Button confirm;
    ImageButton verify;

    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private  static  final  String MOBILE_PATTERN = "^([9]{1})([234789]{1})([0-9]{8})$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reg_pg2);
         mcontext=this;

         confirm=findViewById(R.id.button);
         verify=findViewById(R.id.imageButton2);
        otpMessage=findViewById(R.id.otp_message);

        mail=findViewById(R.id.et_email);

//        mail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//
//                if(!hasFocus){
//                    //this if condition is true when edittext lost focus...
//                    //check here for number is larger than 10 or not
//
//
//                    if(mail.getText().toString().isEmpty()) {
//                        mail.setError("Field cannot be empty");
//
//                    }else {
//                        if (mail.getText().toString().trim().matches(EMAIL_PATTERN)) {
//
//
//                        } else {
//                            mail.setError("Enter Valid Email address");
//
//                        }
//                    }
//
//                }
//            }
//        });

        mob=findViewById(R.id.et_phone);
//        mob.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//
//                if(!hasFocus){
//                    //this if condition is true when edittext lost focus...
//                    //check here for number is larger than 10 or not
//
//
//                    if(mob.getText().toString().isEmpty()) {
//                        mob.setError("Field cannot be empty");
//
//                    }else {
//                        if (mob.getText().toString().trim().matches(MOBILE_PATTERN)) {
//
//
//                        } else {
//                            mob.setError("Enter Valid Mobile Number");
//
//                        }
//                    }
//
//                }
//            }
//        });



    }

    public void onPost(View view)
    {
        String url = "https://ananthous-corrosion.000webhostapp.com/register.php";
        JSONObject postparams = new JSONObject();
        try {

            postparams.put("email",mail.getText());
            postparams.put("phone",mob.getText());
        }catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                url, postparams,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //Success Callback
                        otpMessage.setText("An OTP has been sent to your registered email id");

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Failure Callback
                        otpMessage.setText(error.getMessage());
                    }
                });
// Adding the request to the queue along with a unique string tag
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonObjReq);
    }

    public void Next2(View view){

        if (mail.getText().toString().isEmpty()) {
            mail.setError("Field cannot be empty");
        }
        if (!(mail.getText().toString().trim().matches(EMAIL_PATTERN)))
            mail.setError("Enter valid email id");

        if (mob.getText().toString().isEmpty()) {
            mob.setError("Field cannot be empty");
        }
        if (!(mob.getText().toString().trim().matches(MOBILE_PATTERN)))
            mob.setError("Enter valid Mobile Number");
        else {
            Intent intent = new Intent(mcontext, Reg_page3.class);
            startActivity(intent);
        }
    }

    }
