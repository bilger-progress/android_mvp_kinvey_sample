package com.example.yahov.android_mvp_kinvey_sample;

import android.app.Application;

public class App extends Application {

    private IBackendService iBackendService;

    @Override
    public void onCreate() {
        super.onCreate();

        // Decide what Backend Service will be used.
        // iBackendService = new KinveyBackendService("xxx", "xxx");
        // iBackendService = new FirebaseBackendService();
        // iBackendService.init(this);
    }

    public IBackendService getiBackendService() {
        return iBackendService;
    }
}