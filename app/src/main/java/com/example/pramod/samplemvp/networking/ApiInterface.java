package com.example.pramod.samplemvp.networking;

import com.example.pramod.samplemvp.data.model.Post;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by pramod on 11/10/17.
 */

public interface ApiInterface {
    String GET_POSTS = "posts";

    /**
     * get posts lists from api
     *
     * @return : list of posts
     */
    @GET(GET_POSTS)
    Call<ArrayList<Post>> fetchPosts();

}
