package com.vd.meetup.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.vd.meetup.R;

public class LoginActivity extends Activity implements View.OnClickListener {

    private TextView mTextViewLogin;
    private TextView mTextViewPassword;
    private Button mButtonLogin;
    private Button mButtonSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bindValues();
    }

    public void bindValues() {
        mTextViewLogin = (TextView) findViewById(R.id.email_et);
        mTextViewPassword = (TextView) findViewById(R.id.password_et);
        mButtonLogin = (Button) findViewById(R.id.login_btn);
        mButtonSignUp = (Button) findViewById(R.id.sign_up_btn);
        mButtonLogin.setOnClickListener(this);
        mButtonSignUp.setOnClickListener(this);
    }


    public static void startLogInActivity(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);

    }

    private void logInUser() {
        String login = mTextViewLogin.getText().toString();
        String password = mTextViewPassword.getText().toString();

        ParseUser.logInInBackground(login,password,new LogInCallback() {
            @Override
            public void done(ParseUser parseUser, ParseException e) {
                if (parseUser != null){
                    MeetUpActivity.startMeetUpActivity(LoginActivity.this);
                }
                else {
                    Toast.makeText(getApplication(),"Login Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.login_btn:
                logInUser();
                break;
            case R.id.sign_up_btn:
                SignUpActivity.startSignUpActivity(LoginActivity.this);
                break;
        }
    }

}
