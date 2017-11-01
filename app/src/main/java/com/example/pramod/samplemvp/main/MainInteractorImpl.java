package com.example.pramod.samplemvp.main;

import com.example.pramod.samplemvp.main.data.Post;
import com.example.pramod.samplemvp.retrofit.ApiInterface;
import com.example.pramod.samplemvp.util.SchedulerProvider;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by pramod on 12/10/17.
 */

public class MainInteractorImpl implements MainInteractor {


    private ApiInterface mApiInterface;
    private SchedulerProvider mSchedulerProvider;
    private List<Post> postList;

    @Inject
    public MainInteractorImpl(final ApiInterface apiInterface, SchedulerProvider schedulerProvider) {
        mSchedulerProvider = schedulerProvider;
        mApiInterface = apiInterface;
    }

    @Override
    public void fetchPosts(final MainContract.Presenter.OnPostFetchCallback callback) {
        Observer<List<Post>> postListObserver = new Observer<List<Post>>() {
            @Override
            public void onSubscribe(final Disposable d) {
            }

            @Override
            public void onNext(final List<Post> post) {
                postList = post;
            }

            @Override
            public void onError(final Throwable e) {
                callback.onFailure(e.getMessage());
            }

            @Override
            public void onComplete() {
                callback.onSuccess(postList);
            }
        };

        mApiInterface.fetchPosts().subscribeOn(mSchedulerProvider.backgroundThread())
                .observeOn(mSchedulerProvider.mainThread())
                .subscribe(postListObserver);
    }
}
