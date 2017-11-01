package com.example.pramod.samplemvp.di.component;

import com.example.pramod.samplemvp.di.module.RetrofitModule;
import com.example.pramod.samplemvp.retrofit.ApiInterface;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by pramod on 12/10/17.
 */

@Singleton
@Component(modules = {RetrofitModule.class})
public interface RetrofitComponent {
    ApiInterface exposeApiInterface();
}
