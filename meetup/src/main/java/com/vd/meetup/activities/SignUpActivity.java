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

public class SignUpActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public static void startSignUpActivity(Context context) {
        Intent intent = new Intent(context, SignUpActivity.class);
        context.startActivity(intent);

    }

    private void signUpUser(){


        ParseUser user = new ParseUser();
        user.setUsername("test");
        user.setPassword("password");
        user.setEmail("");


        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null){
                    MeetUpActivity.startMeetUpActivity(SignUpActivity.this);
                }else{
                    Toast.makeText(getApplication(), "Login Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
