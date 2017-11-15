package com.example.pramod.samplemvp.retrofit;

import com.example.pramod.samplemvp.data.model.Post;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by pramod on 11/10/17.
 */

public interface ApiInterface {
    String GET_POSTS = "posts";

    @GET(GET_POSTS)
    Call<ArrayList<Post>> fetchPosts();

}
