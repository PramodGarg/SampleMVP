package com.example.pramod.samplemvp.login;


public class LoginInteractorImpl implements LoginContract.LoginInteractor {

    LoginInteractorImpl() {
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
            onLoginCallBack.onSuccess(accessToken);
        } else {
            onLoginCallBack.onFailure();
        }
    }
}
