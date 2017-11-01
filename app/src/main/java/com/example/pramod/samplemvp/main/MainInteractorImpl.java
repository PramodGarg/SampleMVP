package com.example.pramod.samplemvp.main;

import android.support.annotation.NonNull;

import com.example.pramod.samplemvp.login.data.Post;
import com.example.pramod.samplemvp.retrofit.RestClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by pramod on 12/10/17.
 */

public class MainInteractorImpl implements MainInteractor {
    @Override
    public void fetchUsers(final MainContract.Presenter.OnUserFetchCallback callback) {
        RestClient.getApiInterface().fetchPosts().enqueue(new Callback<ArrayList<Post>>() {
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
