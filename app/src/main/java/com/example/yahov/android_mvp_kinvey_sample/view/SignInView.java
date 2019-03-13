package com.example.yahov.android_mvp_kinvey_sample.view;

public interface SignInView {
    void signInSuccess(Object user);
    void signInError(Object throwable);
}
