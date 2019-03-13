package com.example.yahov.android_mvp_kinvey_sample.view;

import com.kinvey.android.model.User;

public interface SignInView {
    void signInSuccess(User user);
    void signInError(Throwable throwable);
}
