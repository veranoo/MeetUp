package com.vd.meetup.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.vd.meetup.R;

public class LoginActivity extends Activity {

    String sUser = "Veranoo";
    String sEmail = "veranoodesign@gmail.com";
    String sPassword = "123456";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public static void startLogInActivity(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);

    }

    private void signUpUser(){
        ParseUser user = new ParseUser();
        user.setUsername(sUser);
        user.setPassword(sPassword);
        user.setEmail(sEmail);


        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null){
                    MeetUpActivity.startMeetUpActivity(LoginActivity.this);
                }else{
                    Toast.makeText(getApplication(),"Login Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
