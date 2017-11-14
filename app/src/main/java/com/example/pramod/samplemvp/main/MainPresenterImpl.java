package com.example.pramod.samplemvp.main;

import com.example.pramod.samplemvp.main.data.Post;
import com.example.pramod.samplemvp.retrofit.RestClient;

import java.util.List;

/**
 * Created by pramod on 12/10/17.
 */

public class MainPresenterImpl implements MainContract.Presenter, MainContract.Presenter.OnPostFetchCallback {
    private MainInteractor mainInteractor;
    private MainContract.View mView;

    public MainPresenterImpl(MainContract.View view) {
        mainInteractor = new MainInteractorImpl(RestClient.getApiInterface());
        mView = view;
    }

    @Override
    public void fetchUsers() {
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
        mView.showNoUserLabel();
    }
}
