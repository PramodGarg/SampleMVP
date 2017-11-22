package com.example.pramod.samplemvp.main;

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
    private PostSource mPostSource;

    MainPresenterImpl(MainView view, PostSource postSource) {
        mainInteractor = new MainInteractorImpl(RestClient.getApiInterface());
        mView = view;
        mPostSource = postSource;
    }

    @Override
    public void onFetchUsers() {
        mView.showProgress();
        mainInteractor.fetchPosts(this);
    }

    @Override
    public void onSuccess(List<Post> postList) {
        if (postList != null) {
            mPostSource.savePostList(postList);
        }
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
