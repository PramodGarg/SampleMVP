package com.example.pramod.samplemvp.data.source;

import com.example.pramod.samplemvp.constant.DatabaseConstant;
import com.example.pramod.samplemvp.data.model.Post;

import java.util.List;

import io.paperdb.Paper;

/**
 * Created by pramod on 15/11/17.
 */

public class PostRepository implements PostSource, DatabaseConstant {
    
    @Override
    public void savePostList(final List<Post> postList) {
        Paper.book().write(PAPER_POSTS_LIST, postList);
    }
}
