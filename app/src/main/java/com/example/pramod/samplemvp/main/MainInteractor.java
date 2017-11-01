package com.example.pramod.samplemvp.main;

/**
 * Created by pramod on 12/10/17.
 */

public interface MainInteractor {

    void fetchPosts(MainContract.Presenter.OnPostFetchCallback callback);
}
