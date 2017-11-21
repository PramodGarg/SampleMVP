package com.example.pramod.samplemvp.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pramod.samplemvp.MyApplication;
import com.example.pramod.samplemvp.R;
import com.example.pramod.samplemvp.data.model.Post;
import com.example.pramod.samplemvp.main.adapter.PostAdapter;

import java.util.List;

/**
 * Created by pramod on 12/10/17.
 */

public class MainActivity extends AppCompatActivity implements MainView, View.OnClickListener {
    private MainPresenter mPresenter;

    private Button mBtFetchUsers;
    private ProgressBar mProgressBar;
    private TextView mTvNoUsers;
    private RecyclerView mRvUsers;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter = new MainPresenterImpl(this, MyApplication.getPostSource());
        init();
        setListeners();
    }


    private void init() {
        mBtFetchUsers = findViewById(R.id.btFetchUsers);
        mRvUsers = findViewById(R.id.rvUsers);
        mProgressBar = findViewById(R.id.progressBar);
        mTvNoUsers = findViewById(R.id.tvNoUsers);

        mRvUsers.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setListeners() {
        mBtFetchUsers.setOnClickListener(this);
    }

    @Override
    public void showProgress() {
        mTvNoUsers.setVisibility(View.GONE);
        mProgressBar.setVisibility(View.VISIBLE);
        mRvUsers.setVisibility(View.GONE);
    }

    @Override
    public void hideProgress() {
        mTvNoUsers.setVisibility(View.VISIBLE);
        mProgressBar.setVisibility(View.GONE);
        mRvUsers.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btFetchUsers:
                mPresenter.onFetchUsers();
                break;
            default:
                break;
        }
    }

    @Override
    public void showNoPostLabel() {
        mTvNoUsers.setVisibility(View.VISIBLE);
        mProgressBar.setVisibility(View.GONE);
        mRvUsers.setVisibility(View.GONE);
    }

    @Override
    public void showUsers(List<Post> postList) {
        PostAdapter postAdapter = new PostAdapter(postList);
        mRvUsers.setAdapter(postAdapter);

        mTvNoUsers.setVisibility(View.GONE);
        mRvUsers.setVisibility(View.VISIBLE);
    }

    @Override
    public void showNetworkError(String error) {
        Toast.makeText(this, "" + error, Toast.LENGTH_SHORT).show();
    }
}
