package com.example.pramod.samplemvp.main;

import com.example.pramod.samplemvp.base.BaseView;
import com.example.pramod.samplemvp.data.model.Post;

import java.util.List;

/**
 * Created by pramod on 12/10/17.
 */

public interface MainView extends BaseView {
    /**
     * show view if no posts available
     */
    void showNoPostLabel();

    /**
     * show users
     *
     * @param postList : list of users
     */
    void showUsers(List<Post> postList);

    /**
     * show network error
     *
     * @param error : error message
     */
    void showNetworkError(String error);
}
