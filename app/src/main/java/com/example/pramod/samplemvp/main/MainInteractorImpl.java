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
    private PostSource mPostSource;

    MainInteractorImpl(final ApiInterface apiInterface, final PostSource postSource) {
        mApiInterface = apiInterface;
        mPostSource = postSource;
    }

    @Override
    public void fetchPosts(final MainInteractor.OnPostFetchCallback callback) {
        mApiInterface.fetchPosts().enqueue(new Callback<ArrayList<Post>>() {
            @Override
            public void onResponse(Call<ArrayList<Post>> call, @NonNull Response<ArrayList<Post>> response) {
                List<Post> postList = response.body();
                if (postList != null) {
                    mPostSource.savePostList(postList);
                }
                callback.onSuccess(postList);
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<Post>> call, Throwable t) {
                callback.onFailure(t.getMessage());
            }
        });
    }
}
