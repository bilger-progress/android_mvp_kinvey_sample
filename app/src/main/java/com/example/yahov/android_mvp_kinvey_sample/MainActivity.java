package com.example.yahov.android_mvp_kinvey_sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.yahov.android_mvp_kinvey_sample.model.SignInPresenterImpl;
import com.example.yahov.android_mvp_kinvey_sample.presenter.SignInPresenter;
import com.example.yahov.android_mvp_kinvey_sample.view.SignInView;
import com.kinvey.android.model.User;

public class MainActivity extends AppCompatActivity implements SignInView {

    private SignInPresenter signInPresenter;
    private IBackendService iBackendService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iBackendService = (((App) getApplication()).getiBackendService());
        signInPresenter = new SignInPresenterImpl(MainActivity.this, iBackendService);
        signInPresenter.signIn("xxx", "xxx");
    }

    @Override
    public void signInSuccess(User user) {
        Log.d("debug:", user.toString());
    }

    @Override
    public void signInError(Throwable throwable) {
        Log.e("error:", throwable.getMessage());
    }
}
