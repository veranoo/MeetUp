package com.vd.meetup.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.parse.ParseAnalytics;
import com.parse.ParseUser;
import com.vd.meetup.R;

public class MeetUpActivity extends Activity implements View.OnClickListener {

    private ParseUser mCurrentUser;
    private Button mButtonLogOut;

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
        bindValues();

    }

    private void bindValues() {
        mButtonLogOut = (Button) findViewById(R.id.log_out_btn);
        mButtonLogOut.setOnClickListener(this);
    }


    public static void startMeetUpActivity(Context context){
        Intent intent = new Intent(context, MeetUpActivity.class);
        context.startActivity(intent);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.log_out_btn:
                mCurrentUser.logOut();
                LoginActivity.startLogInActivity(this);
                break;
        }
    }
}
