package com.example.pramod.samplemvp.main;

import com.example.pramod.samplemvp.login.data.Post;

import java.util.ArrayList;

/**
 * Created by pramod on 12/10/17.
 */

public class MainPresenter implements MainContract.Presenter, MainContract.Presenter.OnUserFetchCallback {
    private MainInteractor mainInteractor;
    private MainContract.View mView;

    public MainPresenter(MainContract.View view) {
        mainInteractor = new MainInteractorImpl();
        mView = view;
    }

    @Override
    public void fetchUsers() {
        mView.showProgress();
        mainInteractor.fetchUsers(this);
    }

    @Override
    public void onSuccess(ArrayList<Post> postList) {
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
