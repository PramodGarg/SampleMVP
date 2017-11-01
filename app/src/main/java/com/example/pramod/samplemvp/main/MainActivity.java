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

import com.example.pramod.samplemvp.R;
import com.example.pramod.samplemvp.login.data.Post;
import com.example.pramod.samplemvp.login.PostAdapter;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by pramod on 12/10/17.
 */

public class MainActivity extends AppCompatActivity implements MainContract.View, View.OnClickListener {
    private MainContract.Presenter mPresenter;

    private Button mBtFetchUsers;
    private ProgressBar mProgressBar;
    private TextView mTvNoUsers;
    private RecyclerView mRvUsers;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter = new MainPresenter(this);
        init();
        setListeners();
    }


    private void init() {
        mBtFetchUsers = (Button) findViewById(R.id.btFetchUsers);
        mRvUsers = (RecyclerView) findViewById(R.id.rvUsers);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        mTvNoUsers = (TextView) findViewById(R.id.tvNoUsers);

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
                mPresenter.fetchUsers();
                break;
            default:
                break;
        }
    }

    @Override
    public void showNoUserLabel() {
        mTvNoUsers.setVisibility(View.VISIBLE);
        mProgressBar.setVisibility(View.GONE);
        mRvUsers.setVisibility(View.GONE);
    }

    @Override
    public void showUsers(ArrayList<Post> postList) {
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
