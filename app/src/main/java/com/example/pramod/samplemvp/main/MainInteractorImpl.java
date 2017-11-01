package com.example.pramod.samplemvp.main;

import android.support.annotation.NonNull;

import com.example.pramod.samplemvp.login.data.Post;
import com.example.pramod.samplemvp.retrofit.ApiInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by pramod on 12/10/17.
 */

public class MainInteractorImpl implements MainInteractor {
    private ApiInterface mApiInterface;

    MainInteractorImpl(final ApiInterface apiInterface) {
        mApiInterface = apiInterface;
    }

    @Override
    public void fetchPosts(final MainContract.Presenter.OnPostFetchCallback callback) {
        mApiInterface.fetchPosts().enqueue(new Callback<ArrayList<Post>>() {
            @Override
            public void onResponse(Call<ArrayList<Post>> call, @NonNull Response<ArrayList<Post>> response) {
                callback.onSuccess(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<Post>> call, Throwable t) {
                callback.onFailure(t.getMessage());
            }
        });
    }
}
