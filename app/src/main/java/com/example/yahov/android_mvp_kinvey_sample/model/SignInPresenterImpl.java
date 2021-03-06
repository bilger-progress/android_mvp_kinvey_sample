package com.example.yahov.android_mvp_kinvey_sample.model;

import com.example.yahov.android_mvp_kinvey_sample.IBackendService;
import com.example.yahov.android_mvp_kinvey_sample.IBackendServiceSignIn;
import com.example.yahov.android_mvp_kinvey_sample.presenter.SignInPresenter;
import com.example.yahov.android_mvp_kinvey_sample.view.SignInView;

public class SignInPresenterImpl implements SignInPresenter {

    private SignInView signInView;
    private IBackendService iBackendService;

    public SignInPresenterImpl(SignInView signInView, IBackendService iBackendService) {
        this.signInView = signInView;
        this.iBackendService = iBackendService;
    }

    @Override
    public void signIn(String userName, String password) {
        iBackendService.signIn(userName, password, new IBackendServiceSignIn() {
            @Override
            public void onSuccess(Object user) {
                signInView.signInSuccess(user);
            }

            @Override
            public void onFailure(Object throwable) {
                signInView.signInError(throwable);
            }
        });
    }
}