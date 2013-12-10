package com.vd.meetup.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.parse.ParseAnalytics;
import com.parse.ParseUser;
import com.vd.meetup.R;

public class MeetUpActivity extends Activity {

    private ParseUser mCurrentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ParseAnalytics.trackAppOpened(getIntent());

        mCurrentUser = ParseUser.getCurrentUser();
        if (mCurrentUser == null){
            LoginActivity.startLogInActivity(this);
            finish();
        }

        setContentView(R.layout.activity_meet_up);



    }
    public static void startMeetUpActivity(Context context){
        Intent intent = new Intent(context, MeetUpActivity.class);
        context.startActivity(intent);

    }



}
