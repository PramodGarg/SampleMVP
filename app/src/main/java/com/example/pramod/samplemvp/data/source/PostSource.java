package com.example.pramod.samplemvp.data.source;

import com.example.pramod.samplemvp.data.model.Post;

import java.util.List;

/**
 * Created by pramod on 15/11/17.
 */

public interface PostSource {

    /**
     * saves post list to local database
     *
     * @param postList : list of posts
     */
    void savePostList(List<Post> postList);
}
