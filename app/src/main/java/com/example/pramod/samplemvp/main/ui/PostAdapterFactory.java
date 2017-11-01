package com.example.pramod.samplemvp.main.ui;

import com.example.pramod.samplemvp.main.data.Post;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by pramod on 12/10/17.
 */

public class PostAdapterFactory {

    private MainActivity mainActivity;
    private PostViewHolderFactory mViewHolderFactory;

    @Inject
    public PostAdapterFactory(MainActivity mainActivity, PostViewHolderFactory viewHolderFactory) {
        this.mainActivity = mainActivity;
        this.mViewHolderFactory = viewHolderFactory;
    }

    PostAdapter createPostAdapter(List<Post> postList) {
        return new PostAdapter(mainActivity, postList, mViewHolderFactory);
    }
}
