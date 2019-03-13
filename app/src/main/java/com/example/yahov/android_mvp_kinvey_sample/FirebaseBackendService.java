package com.example.yahov.android_mvp_kinvey_sample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class FirebaseBackendService implements IBackendService{

    private FirebaseAuth mAuth;

    public FirebaseBackendService() { }

    @Override
    public void init(Context context) {
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void signIn(String userName, String password, final IBackendServiceSignIn iBackendServiceSignIn) {
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            Log.i("info:", "Firebase user already present.");
            iBackendServiceSignIn.onSuccess(currentUser.getEmail());
        } else {
            Log.i("info:", "Firebase user not present. Logging-in now.");
            mAuth.signInWithEmailAndPassword(userName, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                FirebaseUser user = mAuth.getCurrentUser();
                                iBackendServiceSignIn.onSuccess(user.getEmail());
                            } else {
                               iBackendServiceSignIn.onFailure(task.getException());
                            }
                        }
                    });
        }
    }
}
