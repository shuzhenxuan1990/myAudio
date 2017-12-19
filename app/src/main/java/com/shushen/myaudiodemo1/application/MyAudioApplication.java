package com.shushen.myaudiodemo1.application;

import android.app.Application;

/**
 * Created by Administrator on 2017/12/19.
 */

public class MyAudioApplication extends Application {

    public static MyAudioApplication myApplication = null;

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
    }

    public static MyAudioApplication getInstance() {
        return myApplication;
    }

}
