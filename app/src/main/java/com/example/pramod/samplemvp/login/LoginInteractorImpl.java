package com.example.pramod.samplemvp.login;


import android.os.Handler;

import javax.inject.Inject;

public class LoginInteractorImpl implements LoginInteractor {

    @Inject
    public LoginInteractorImpl() {
    }

    /**
     * mocks server calls
     *
     * @param email           : mail
     * @param password        : password
     * @param onLoginCallBack :onSuccess/fail callback
     */
    @Override
    public void loginApi(final String email, final String password, final LoginContract.Presenter.OnLoginCallBack onLoginCallBack) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (email == null || email.isEmpty()) {
                    onLoginCallBack.onEmailError();
                    return;
                }
                if (password == null || password.isEmpty()) {
                    onLoginCallBack.onPasswordError();
                    return;
                }
                if (email.equals("email@gmail.com") && password.equals("password")) {
                    onLoginCallBack.onSuccess();
                } else {
                    onLoginCallBack.onFailure();
                }

            }
        }, 1500);
    }
}
