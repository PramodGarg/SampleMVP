package com.example.pramod.samplemvp;

import android.app.Application;

import com.example.pramod.samplemvp.di.component.AppComponent;
import com.example.pramod.samplemvp.di.component.DaggerAppComponent;
import com.example.pramod.samplemvp.di.module.AppModule;

/**
 * Created by pramod on 12/10/17.
 */

public class MyApplication extends Application {


    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }


    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
