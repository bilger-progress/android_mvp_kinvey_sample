package com.example.yahov.android_mvp_kinvey_sample;

public interface IBackendServiceSignIn {
    void onSuccess(Object user);
    void onFailure(Object throwable);
}
