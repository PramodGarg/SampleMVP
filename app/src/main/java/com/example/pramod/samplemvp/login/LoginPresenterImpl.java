package com.example.pramod.samplemvp.login;

import com.example.pramod.samplemvp.R;
import com.example.pramod.samplemvp.data.source.UserSource;

/**
 * Created by pramod on 11/10/17.
 */

public class LoginPresenterImpl implements LoginContract.Presenter, LoginContract.LoginInteractor.OnLoginCallBack {

    private LoginContract.View mView;
    private LoginContract.LoginInteractor mLoginInteractor;
    private UserSource mUserSource;

    LoginPresenterImpl(LoginContract.View view, UserSource userSource) {
        mView = view;
        mLoginInteractor = new LoginInteractorImpl();
        mUserSource = userSource;
    }

    @Override
    public void onLogin(String email, String password) {

        if (checkValidation(email, password)) {
            mView.showProgress();
            mLoginInteractor.loginUser(email, password, this);
        }
    }

    /**
     * validates email and password
     *
     * @param email    : email of user
     * @param password : password of user
     * @return : true if validated else false
     */
    private boolean checkValidation(final String email, final String password) {
        if (email.isEmpty()) {
            mView.showInvalidEmailError(R.string.error_invalid_email);
            return false;
        } else if (password.isEmpty()) {
            mView.showInvalidPasswordError(R.string.error_invalid_password);
            return false;
        }
        return true;
    }


    @Override
    public void onSuccess(String accessToken) {
        mUserSource.saveAccessToken(accessToken);
        mView.hideProgress();
        mView.navigateToMainScreen();
    }

    @Override
    public void onFailure() {

        mView.hideProgress();
        mView.showInvalidCombinationError(R.string.error_invalid_email_password_combination);
    }


}
