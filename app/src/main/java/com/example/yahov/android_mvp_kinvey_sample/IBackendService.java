package com.example.yahov.android_mvp_kinvey_sample;

public interface IBackendService {
    void signIn(String userName, String password, IBackendServiceSignIn iBackendServiceSignIn);
}
