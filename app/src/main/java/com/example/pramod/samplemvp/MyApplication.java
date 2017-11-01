package com.example.pramod.samplemvp;

import android.app.Application;

import com.example.pramod.samplemvp.di.component.DaggerRetrofitComponent;
import com.example.pramod.samplemvp.di.component.RetrofitComponent;
import com.example.pramod.samplemvp.di.module.RetrofitModule;

/**
 * Created by pramod on 12/10/17.
 */

public class MyApplication extends Application {


    private RetrofitComponent mRetrofitComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mRetrofitComponent = DaggerRetrofitComponent.builder()
                .retrofitModule(new RetrofitModule()).build();
    }

    public RetrofitComponent getRetrofitComponent() {
        return mRetrofitComponent;
    }
}
