package com.example.yahov.android_mvp_kinvey_sample;

import com.kinvey.android.Client;
import com.kinvey.android.callback.KinveyPingCallback;
import android.app.Application;
import android.util.Log;

public class App extends Application {

    private Client mKinveyClient;

    @Override
    public void onCreate() {
        super.onCreate();
        mKinveyClient = new Client.Builder("xxx", "xxx", this).build();
        mKinveyClient.ping(new KinveyPingCallback() {
            public void onFailure(Throwable t) {
                Log.e("error","Kinvey Ping Failed");
            }
            public void onSuccess(Boolean b) {
                Log.d("debug","Kinvey Ping Success");
            }
        });
    }

    public Client getKinveyClient(){
        return mKinveyClient;
    }
}