package com.example.pramod.samplemvp.di.component;

import com.example.pramod.samplemvp.di.module.AppModule;
import com.example.pramod.samplemvp.di.module.NetworkModule;
import com.example.pramod.samplemvp.retrofit.ApiInterface;
import com.example.pramod.samplemvp.util.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by pramod on 01/11/17.
 */
@Singleton
@Component(modules = {AppModule.class, NetworkModule.class})
public interface AppComponent {
    SchedulerProvider exposeSchedulerProvider();

    ApiInterface exposeApiInterface();
}
