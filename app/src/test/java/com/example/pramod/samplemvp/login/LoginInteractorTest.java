package com.example.pramod.samplemvp.login;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

/**
 * Created by pramod on 27/10/17.
 */

public class LoginInteractorTest {
    @Mock
    private
    LoginPresenterImpl.OnLoginCallBack mOnLoginCallBack;
    private LoginInteractor mLoginInteractor;

    @Before
    public void setLoginInteractor() {
        mLoginInteractor = new LoginInteractorImpl();
        mOnLoginCallBack = Mockito.mock(LoginPresenterImpl.OnLoginCallBack.class);
    }

    @Test
    public void loginApi_invalidEmail_callsOnEmailError() {

        mLoginInteractor.loginUser("", "", mOnLoginCallBack);
        Mockito.verify(mOnLoginCallBack, Mockito.times(1)).onEmailError();
        Mockito.verify(mOnLoginCallBack, Mockito.never()).onPasswordError();
        Mockito.verify(mOnLoginCallBack, Mockito.never()).onFailure();
        Mockito.verify(mOnLoginCallBack, Mockito.never()).onSuccess();
    }

    @Test
    public void loginApi_invalidPassword_callsOnPasswordError() {

        mLoginInteractor.loginUser("email@gmail.com", "", mOnLoginCallBack);

        Mockito.verify(mOnLoginCallBack, Mockito.times(1)).onPasswordError();
        Mockito.verify(mOnLoginCallBack, Mockito.never()).onEmailError();
        Mockito.verify(mOnLoginCallBack, Mockito.never()).onFailure();
        Mockito.verify(mOnLoginCallBack, Mockito.never()).onSuccess();
    }

    @Test
    public void loginApi_valid_UnAuthenticated_EmailPassword_callsOnFailure() {

        mLoginInteractor.loginUser("email@gmail.com", "password1", mOnLoginCallBack);

        Mockito.verify(mOnLoginCallBack, Mockito.times(1)).onFailure();
        Mockito.verify(mOnLoginCallBack, Mockito.never()).onEmailError();
        Mockito.verify(mOnLoginCallBack, Mockito.never()).onPasswordError();
        Mockito.verify(mOnLoginCallBack, Mockito.never()).onSuccess();
    }

    @Test
    public void loginApi_valid_Authenticated_EmailPassword_callsOnSuccess() {

        mLoginInteractor.loginUser("email@gmail.com", "password", mOnLoginCallBack);

        Mockito.verify(mOnLoginCallBack, Mockito.times(1)).onSuccess();
        Mockito.verify(mOnLoginCallBack, Mockito.never()).onEmailError();
        Mockito.verify(mOnLoginCallBack, Mockito.never()).onPasswordError();
        Mockito.verify(mOnLoginCallBack, Mockito.never()).onFailure();
    }

}
