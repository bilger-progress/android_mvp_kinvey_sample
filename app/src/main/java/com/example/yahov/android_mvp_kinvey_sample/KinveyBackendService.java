package com.example.yahov.android_mvp_kinvey_sample;

import android.content.Context;
import android.util.Log;

import com.kinvey.android.Client;
import com.kinvey.android.callback.KinveyPingCallback;
import com.kinvey.android.model.User;
import com.kinvey.android.store.UserStore;
import com.kinvey.java.core.KinveyClientCallback;

import java.io.IOException;

public class KinveyBackendService implements IBackendService {

    private Client kinveyClient;
    private String kinveyAppKey;
    private String kinveyAppSecret;

    KinveyBackendService(String kinveyAppKey, String kinveyAppSecret) {
        this.kinveyAppKey = kinveyAppKey;
        this.kinveyAppSecret = kinveyAppSecret;
    }

    @Override
    public void init(Context context) {
        kinveyClient = new Client.Builder(kinveyAppKey, kinveyAppSecret, context).build();
        kinveyClient.ping(new KinveyPingCallback() {
            public void onFailure(Throwable t) {
                Log.e("error","Kinvey Ping Failed");
            }
            public void onSuccess(Boolean b) {
                Log.d("debug","Kinvey Ping Success");
            }
        });
    }

    @Override
    public void signIn(String userName, String password, final IBackendServiceSignIn iBackendServiceSignIn) {
        try {
            User activeUser = kinveyClient.getActiveUser();
            if (activeUser != null){
                Log.i("info:", "Kinvey user already present.");
                iBackendServiceSignIn.onSuccess(activeUser);
            } else {
                Log.i("info:", "Kinvey user not present. Logging-in now.");
                UserStore.login(userName, password, kinveyClient, new KinveyClientCallback<User>() {
                    @Override
                    public void onFailure(Throwable throwable) {
                        iBackendServiceSignIn.onFailure(throwable);
                    }
                    @Override
                    public void onSuccess(User user) {
                        iBackendServiceSignIn.onSuccess(user);
                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
