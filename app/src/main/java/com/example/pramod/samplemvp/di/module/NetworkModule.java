package com.example.pramod.samplemvp.di.module;

import com.example.pramod.samplemvp.BuildConfig;
import com.example.pramod.samplemvp.retrofit.ApiInterface;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by pramod on 12/10/17.
 */

@Module
public class NetworkModule {
    @Singleton
    @Provides
    ApiInterface providesApiInterface(Retrofit retrofit) {
        return retrofit.create(ApiInterface.class);
    }

    @Singleton
    @Provides
    Retrofit providesRetrofit(OkHttpClient.Builder builder) {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                //.client(secureConnection().build())
                .build();
    }

    @Singleton
    @Provides
    OkHttpClient.Builder providesBuilder(HttpLoggingInterceptor interceptor) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        // add your other interceptors …
        // add logging as last interceptor
        httpClient.addInterceptor(interceptor);
        return httpClient;
    }

    @Singleton
    @Provides
    HttpLoggingInterceptor providesLoggingInterceptor() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // set your desired log level
        //logging.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        if (BuildConfig.DEBUG) {
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        }
        return logging;
    }

}
