package com.example.pramod.samplemvp.main;

import com.example.pramod.samplemvp.main.data.Post;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by pramod on 12/10/17.
 */

public class PostAdapterFactory {

    /*mView is just to test assisted injection */
    @Inject
    MainContract.View mView;

    public PostAdapter createPostAdapter(ArrayList<Post> postList) {
        return new PostAdapter(mView, postList);
    }
}
