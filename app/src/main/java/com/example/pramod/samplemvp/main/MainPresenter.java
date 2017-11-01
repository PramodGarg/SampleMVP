package com.example.pramod.samplemvp.main;

import com.example.pramod.samplemvp.main.data.Post;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by pramod on 12/10/17.
 */

public class MainPresenter implements MainContract.Presenter, MainContract.Presenter.OnPostFetchCallback {
    private MainInteractorImpl mMainInteractor;
    private MainContract.View mView;

    @Inject
    public MainPresenter(final MainInteractorImpl mainInteractor, final MainContract.View view) {
        mMainInteractor = mainInteractor;
        mView = view;
    }

    @Override
    public void fetchUsers() {
        mView.showProgress();
        mMainInteractor.fetchPosts(this);
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
        mView.showNoUserLabel();
    }
}
