package com.example.pramod.samplemvp.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.pramod.samplemvp.MyApplication;
import com.example.pramod.samplemvp.R;
import com.example.pramod.samplemvp.main.MainActivity;

/**
 * Created by pramod on 11/10/17.
 */

public class LoginActivity extends AppCompatActivity implements LoginContract.View, View.OnClickListener {
    private LoginContract.Presenter mPresenter;

    private ProgressBar mProgressBar;
    private Button mBtLogin;
    private EditText mEtEmail, mEtPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
        setListeners();

    }

    private void init() {
        mPresenter = new LoginPresenterImpl(this, MyApplication.getUserSource());

        mProgressBar = findViewById(R.id.progressBar);
        mBtLogin = findViewById(R.id.btLogin);
        mEtEmail = findViewById(R.id.etEmail);
        mEtPassword = findViewById(R.id.etPassword);
    }

    private void setListeners() {
        mBtLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btLogin:
                mPresenter.onLogin(mEtEmail.getText().toString().trim(),
                        mEtPassword.getText().toString().trim());
                break;
            default:
                break;
        }
    }

    @Override
    public void showInvalidEmailError(int resId) {
        Toast.makeText(this, resId, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showInvalidPasswordError(int resId) {
        Toast.makeText(this, resId, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showInvalidCombinationError(int resId) {
        Toast.makeText(this, resId, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateToMainScreen() {
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.GONE);
    }
}
