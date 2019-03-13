package com.example.yahov.android_mvp_kinvey_sample;

import com.kinvey.android.model.User;

public interface IBackendServiceSignIn {
    void onSuccess(User user);
    void onFailure(Throwable throwable);
}
