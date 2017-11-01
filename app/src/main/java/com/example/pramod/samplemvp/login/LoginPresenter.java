package com.example.pramod.samplemvp.login;

import javax.inject.Inject;

/**
 * Created by pramod on 11/10/17.
 */

public class LoginPresenter implements LoginContract.Presenter, LoginContract.Presenter.OnLoginCallBack {

    private LoginContract.View mView;
    private LoginInteractor mMainInteractor;

    @Inject
    public LoginPresenter(LoginContract.View view, LoginInteractorImpl loginInteractor) {
        mView = view;
        mMainInteractor = loginInteractor;
    }

    @Override
    public void login(String email, String password) {
        mView.showProgress();
        mMainInteractor.loginApi(email, password, this);
    }

    @Override
    public void onEmailError() {

        mView.hideProgress();
        mView.showEmailError();
    }

    @Override
    public void onPasswordError() {

        mView.hideProgress();
        mView.showPasswordError();
    }

    @Override
    public void success() {

        mView.hideProgress();
        mView.navigateToMainActivity();
    }

    @Override
    public void failure() {

        mView.hideProgress();
        mView.showInvalidCombinationError();
    }
}
