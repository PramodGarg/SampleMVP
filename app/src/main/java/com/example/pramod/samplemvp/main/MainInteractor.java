package com.example.pramod.samplemvp.main;

import com.example.pramod.samplemvp.data.model.Post;

import java.util.List;

/**
 * Created by pramod on 12/10/17.
 */

public interface MainInteractor {

    /**
     * fetch posts from api
     *
     * @param callback : callback for aoi listener
     */
    void fetchPosts(OnPostFetchCallback callback);

    /**
     * callback fot fetch posts api
     */
    interface OnPostFetchCallback {
        /**
         * if api hit is successful
         *
         * @param postList : list of posts
         */
        void onSuccess(List<Post> postList);

        /**
         * if api hit fails
         */
        void onFailure(String error);

    }
}
