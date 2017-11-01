package com.example.pramod.samplemvp.main;

import com.example.pramod.samplemvp.base.BasePresenter;
import com.example.pramod.samplemvp.base.BaseView;
import com.example.pramod.samplemvp.main.data.Post;

import java.util.ArrayList;

/**
 * Created by pramod on 12/10/17.
 */

public interface MainContract {
    interface View extends BaseView {

        void showNoUserLabel();

        void showUsers(ArrayList<Post> postList);

        void showNetworkError(String error);
    }

    interface Presenter extends BasePresenter {

        void fetchUsers();

        interface OnUserFetchCallback {
            void onSuccess(ArrayList<Post> postList);

            void onFailure(String error);

        }

    }
}
