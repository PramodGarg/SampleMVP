package com.example.pramod.samplemvp.main;

import com.example.pramod.samplemvp.MyApplication;
import com.example.pramod.samplemvp.data.model.Post;
import com.example.pramod.samplemvp.data.source.PostSource;
import com.example.pramod.samplemvp.networking.RestClient;

import java.util.List;

/**
 * Created by pramod on 12/10/17.
 */

public class MainPresenterImpl implements MainPresenter, MainInteractor.OnPostFetchCallback {
    private MainInteractor mainInteractor;
    private MainView mView;

    MainPresenterImpl(MainView view, PostSource postSource) {
        mainInteractor = new MainInteractorImpl(RestClient.getApiInterface(),postSource );
        mView = view;
    }

    @Override
    public void onFetchUsers() {
        mView.showProgress();
        mainInteractor.fetchPosts(this);
    }

    @Override
    public void onSuccess(List<Post> postList) {
        mView.hideProgress();
        mView.showUsers(postList);
    }

    @Override
    public void onFailure(String error) {
        mView.showNetworkError(error);
        mView.hideProgress();
        mView.showNoPostLabel();
    }
}
