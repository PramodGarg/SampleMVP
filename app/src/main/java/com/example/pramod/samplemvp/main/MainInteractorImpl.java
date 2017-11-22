package com.example.pramod.samplemvp.main;

import android.support.annotation.NonNull;

import com.example.pramod.samplemvp.data.model.Post;
import com.example.pramod.samplemvp.data.source.PostSource;
import com.example.pramod.samplemvp.networking.ApiInterface;

import java.util.ArrayList;
import java.util.List;

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
    public void fetchPosts(final MainInteractor.OnPostFetchCallback callback) {
        mApiInterface.fetchPosts().enqueue(new Callback<ArrayList<Post>>() {
            @Override
            public void onResponse(Call<ArrayList<Post>> call, @NonNull Response<ArrayList<Post>> response) {
                List<Post> postList = response.body();
                callback.onSuccess(postList);
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<Post>> call, Throwable t) {
                callback.onFailure(t.getMessage());
            }
        });
    }
}
