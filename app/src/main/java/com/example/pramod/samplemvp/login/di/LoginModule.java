package com.example.pramod.samplemvp.login.di;

import com.example.pramod.samplemvp.di.PerActivity;
import com.example.pramod.samplemvp.login.LoginContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pramod on 12/10/17.
 */

@Module
public class LoginModule {
    private LoginContract.View mView;

    public LoginModule(LoginContract.View mView) {
        this.mView = mView;
    }

    @PerActivity
    @Provides
    LoginContract.View providesView() {
        return mView;
    }
}
