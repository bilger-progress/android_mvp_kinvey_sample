package com.example.yahov.android_mvp_kinvey_sample;

import android.content.Context;

public interface IBackendService {

    void init(Context context);

    void signIn(String userName, String password, IBackendServiceSignIn iBackendServiceSignIn);
}
