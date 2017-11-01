package com.example.pramod.samplemvp.main.di;

import android.support.v7.widget.LinearLayoutManager;

import com.example.pramod.samplemvp.di.PerActivity;
import com.example.pramod.samplemvp.main.MainActivity;
import com.example.pramod.samplemvp.main.MainContract;
import com.example.pramod.samplemvp.main.PostAdapterFactory;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pramod on 12/10/17.
 */

@Module
public class MainModule {
    private MainContract.View mView;

    public MainModule(MainContract.View mView) {
        this.mView = mView;
    }

    @PerActivity
    @Provides
    MainContract.View providesView() {
        return mView;
    }

    @PerActivity
    @Provides
    PostAdapterFactory providesPostAdapterFactory() {
        return new PostAdapterFactory();
    }

    @PerActivity
    @Provides
    MainActivity providesMainActivity(MainContract.View view) {
        return (MainActivity) view;
    }

    @PerActivity
    @Provides
    LinearLayoutManager providesLinearLayoutManager(MainActivity activity) {
        return new LinearLayoutManager(activity);
    }


}
