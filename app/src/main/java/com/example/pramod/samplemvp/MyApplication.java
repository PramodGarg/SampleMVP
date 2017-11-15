package com.example.pramod.samplemvp;

import android.app.Application;

import com.example.pramod.samplemvp.data.source.PostRepository;
import com.example.pramod.samplemvp.data.source.PostSource;

import io.paperdb.Paper;

/**
 * Created by pramod on 15/11/17.
 */

public class MyApplication extends Application {
    private static MyApplication application;
    private static PostSource sPostSource;

    public static MyApplication getInstance() {
        return application;
    }

    public static PostSource getPostSource() {
        if (sPostSource == null) {
            sPostSource = new PostRepository();
        }
        return sPostSource;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        Paper.init(getInstance());
    }
}
