package com.example.pramod.samplemvp.data.source;

import com.example.pramod.samplemvp.data.model.Post;

import java.util.List;

/**
 * Created by pramod on 15/11/17.
 */

public interface PostSource {

    void savePostList(List<Post> postList);
}
