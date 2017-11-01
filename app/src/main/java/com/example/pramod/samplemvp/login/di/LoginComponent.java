package com.example.pramod.samplemvp.login.di;

import com.example.pramod.samplemvp.di.PerActivity;
import com.example.pramod.samplemvp.login.LoginActivity;

import dagger.Component;

/**
 * Created by pramod on 12/10/17.
 */

@PerActivity
@Component(modules = LoginModule.class)
public interface LoginComponent {
    void inject(LoginActivity loginActivity);
}
