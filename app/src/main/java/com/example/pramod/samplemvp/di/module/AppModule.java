package com.example.pramod.samplemvp.di.module;

import android.app.Application;

import com.example.pramod.samplemvp.MyApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pramod on 12/10/17.
 */

@Module
public class AppModule {
    private MyApplication myApplication;

    public AppModule(MyApplication myApplication) {
        this.myApplication = myApplication;
    }

    @Singleton
    @Provides
    Application providesApplication() {
        return myApplication;
    }
}
