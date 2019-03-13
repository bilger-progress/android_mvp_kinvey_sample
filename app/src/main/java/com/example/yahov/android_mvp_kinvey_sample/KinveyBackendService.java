package com.example.yahov.android_mvp_kinvey_sample;

import com.kinvey.android.Client;
import com.kinvey.android.model.User;
import com.kinvey.android.store.UserStore;
import com.kinvey.java.core.KinveyClientCallback;

import java.io.IOException;

public class KinveyBackendService implements IBackendService {

    private Client kinveyClient;

    KinveyBackendService(Client kinveyClient) {
        this.kinveyClient = kinveyClient;
    }

    @Override
    public void signIn(String userName, String password, final IBackendServiceSignIn iBackendServiceSignIn) {
        try {
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
