package com.example.pramod.samplemvp.login;


import com.example.pramod.samplemvp.data.source.UserSource;

public class LoginInteractorImpl implements LoginContract.LoginInteractor {
    private UserSource mUserSource;

    LoginInteractorImpl(final UserSource userSource) {
        mUserSource = userSource;
    }

    /**
     * mocks user login
     *
     * @param email           : mail
     * @param password        : password
     * @param onLoginCallBack :onSuccess/fail callback
     */
    @Override
    public void loginUser(final String email, final String password,
                          final LoginContract.LoginInteractor.OnLoginCallBack onLoginCallBack) {

        if (email.equals("email@gmail.com") && password.equals("password")) {
            String accessToken = "dummyAccessToken";
            mUserSource.saveAccessToken(accessToken);
            onLoginCallBack.onSuccess();
        } else {
            onLoginCallBack.onFailure();
        }
    }
}
