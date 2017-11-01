package com.example.pramod.samplemvp.main;

import com.example.pramod.samplemvp.login.data.Post;
import com.example.pramod.samplemvp.retrofit.ApiInterface;
import com.example.pramod.samplemvp.util.FileUtils;
import com.example.pramod.samplemvp.util.SynchronousExecutorService;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.IOException;

import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by pramod on 27/10/17.
 */

public class MainInteractorTest {

    @Mock
    private MainContract.Presenter.OnPostFetchCallback mOnPostFetchCallback;
    private MockWebServer mMockWebServer;
    private ApiInterface mApiInterface;

    @Before
    public void setUpApiIneterface() throws IOException {
        mOnPostFetchCallback = Mockito.mock(MainContract.Presenter.OnPostFetchCallback.class);
        mMockWebServer = new MockWebServer();
        mMockWebServer.start();

        mApiInterface = new Retrofit.Builder()
                .baseUrl(mMockWebServer.url("/"))
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient().newBuilder()
                        .dispatcher(new Dispatcher(new SynchronousExecutorService())).build())
                .build().create(ApiInterface.class);
    }

    @Test
    public void fetchPosts_apiSuccess_callsOnSuccess() throws Exception {
        mMockWebServer.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(FileUtils.convertStreamToString(getClass().getClassLoader()
                        .getResourceAsStream("login_200.json")))
        );
        MainInteractor mainInteractor = new MainInteractorImpl(mApiInterface);
        mainInteractor.fetchPosts(mOnPostFetchCallback);
        Mockito.verify(mOnPostFetchCallback, Mockito.times(1)).onSuccess(Mockito.<Post>anyList());
        Mockito.verify(mOnPostFetchCallback, Mockito.never()).onFailure(Mockito.anyString());
    }

    @Test
    public void fetchPosts_apiFailure_callsOnFailure() throws Exception {
        mMockWebServer.enqueue(new MockResponse()
        );
        MainInteractor mainInteractor = new MainInteractorImpl(mApiInterface);
        mainInteractor.fetchPosts(mOnPostFetchCallback);
        Mockito.verify(mOnPostFetchCallback, Mockito.times(1)).onFailure(Mockito.anyString());
        Mockito.verify(mOnPostFetchCallback, Mockito.never()).onSuccess(Mockito.<Post>anyList());
    }
}
