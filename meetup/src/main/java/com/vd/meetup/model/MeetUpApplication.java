package com.vd.meetup.model;

import android.app.Application;

import com.parse.Parse;

public class MeetUpApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this, Secrets.PARSE_APP_ID, Secrets.PARSE_CLIENT_KEY);
    }
}
