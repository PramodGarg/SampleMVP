package com.example.pramod.samplemvp.retrofit;

import com.example.pramod.samplemvp.BuildConfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Developer: Saurabh Verma
 * Dated: 27-09-2016.
 */
public final class RestClient {
    private static final Integer BKS_KEYSTORE_RAW_FILE_ID = 0;
    // Integer BKS_KEYSTORE_RAW_FILE_ID = R.raw.keystorebks;
    private static final Integer SSL_KEY_PASSWORD_STRING_ID = 0;
    private static Retrofit retrofit = null;
    private static Retrofit retrofitGoogle = null;
    //Integer SSL_KEY_PASSWORD_STRING_ID = R.string.sslKeyPassword;

    /**
     * Empty Constructor
     * not called
     */
    private RestClient() {
    }

    /**
     * Gets api interface.
     *
     * @return object of ApiInterface
     */
    public static ApiInterface getApiInterface() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BuildConfig.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient().build())
                    //.client(secureConnection().build())
                    .build();
        }
        return retrofit.create(ApiInterface.class);
    }


    /**
     * Gets retrofit builder.
     *
     * @return object of Retrofit
     */
    static Retrofit getRetrofitBuilder() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BuildConfig.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient().build())
                    .build();
        }
        return retrofit;
    }

    /**
     * @return object of OkHttpClient.Builder
     */
    private static OkHttpClient.Builder httpClient() {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        // add your other interceptors …
        // add logging as last interceptor
        httpClient.addInterceptor(getLoggingInterceptor());
        return httpClient;
    }

    /**
     * Method to get object of HttpLoggingInterceptor
     *
     * @return object of HttpLoggingInterceptor
     */
    private static HttpLoggingInterceptor getLoggingInterceptor() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // set your desired log level
        //logging.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        if (BuildConfig.DEBUG) {
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        }
        return logging;
    }
}
