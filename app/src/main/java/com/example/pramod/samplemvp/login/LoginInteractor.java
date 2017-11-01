package com.example.pramod.samplemvp.login;

/**
 * Created by pramod on 12/10/17.
 */

public interface LoginInteractor {
    void loginApi(String email, String password, LoginContract.Presenter.OnLoginCallBack onLoginCallBack);
}
