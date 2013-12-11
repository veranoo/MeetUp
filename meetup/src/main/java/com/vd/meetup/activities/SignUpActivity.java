package com.vd.meetup.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.vd.meetup.R;

public class SignUpActivity extends Activity implements View.OnClickListener {

    private EditText mEditTextUserName;
    private EditText mEditTextPassword;
    private EditText mEditTextEmail;
    private Button mButtonSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        bindValues();


    }

    private void bindValues() {
        mEditTextUserName = (EditText) findViewById(R.id.username_su);
        mEditTextPassword = (EditText) findViewById(R.id.password_su);
        mEditTextEmail = (EditText) findViewById(R.id.email_su);
        mButtonSignUp = (Button) findViewById(R.id.sing_up_btn_su);
        mButtonSignUp.setOnClickListener(this);
    }

    public static void startSignUpActivity(Context context) {
        Intent intent = new Intent(context, SignUpActivity.class);
        context.startActivity(intent);

    }

    private void signUpUser(){

        String username = mEditTextUserName.getText().toString();
        String password = mEditTextPassword.getText().toString();
        String email = mEditTextEmail.getText().toString();


        ParseUser user = new ParseUser();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);


        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    MeetUpActivity.startMeetUpActivity(SignUpActivity.this);
                } else {
                    Toast.makeText(getApplication(), "Login Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.sing_up_btn_su:
                signUpUser();
                break;
        }
    }
}
