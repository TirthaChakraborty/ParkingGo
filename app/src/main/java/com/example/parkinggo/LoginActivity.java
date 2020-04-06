package com.example.parkinggo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends Activity {

    private Context mcontext;
    private EditText usermail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_pg);
        mcontext=this;
        usermail=(EditText)findViewById(R.id.et_mail);

    }

    public void login(View view){

        SharedPreferences sharedPreferences=getSharedPreferences("UserDetails", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("useremailid", usermail.getText().toString());
        editor.commit();
        Intent intent = new Intent(mcontext, ChooseUserActivity.class);
        startActivity(intent);
    }

}