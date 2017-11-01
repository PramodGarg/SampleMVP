package com.example.pramod.samplemvp.retrofit;

import com.example.pramod.samplemvp.main.data.Post;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by pramod on 11/10/17.
 */

public interface ApiInterface {
    String GET_POSTS = "posts";

    @GET(GET_POSTS)
    Observable<ArrayList<Post>> fetchPosts();

}
