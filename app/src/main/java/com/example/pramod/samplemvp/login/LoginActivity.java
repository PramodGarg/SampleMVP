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

import com.example.pramod.samplemvp.R;
import com.example.pramod.samplemvp.login.di.DaggerLoginComponent;
import com.example.pramod.samplemvp.login.di.LoginModule;
import com.example.pramod.samplemvp.main.ui.MainActivity;

import javax.inject.Inject;

/**
 * Created by pramod on 11/10/17.
 */

public class LoginActivity extends AppCompatActivity implements LoginContract.View, View.OnClickListener {
    @Inject
    LoginPresenter loginPresenter;

    private ProgressBar mProgressBar;
    private Button mBtLogin;
    private EditText mEtEmail, mEtPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        DaggerLoginComponent.builder().loginModule(new LoginModule(this)).build().inject(this);

        init();
        setListeners();

    }

    private void init() {
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        mBtLogin = (Button) findViewById(R.id.btLogin);
        mEtEmail = (EditText) findViewById(R.id.etEmail);
        mEtPassword = (EditText) findViewById(R.id.etPassword);
    }

    private void setListeners() {
        mBtLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btLogin:
                loginPresenter.login(mEtEmail.getText().toString().trim(),
                        mEtPassword.getText().toString().trim());
                break;
            default:
                break;
        }
    }

    @Override
    public void showEmailError() {
        Toast.makeText(this, R.string.invaid_email, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showPasswordError() {
        Toast.makeText(this, R.string.invalid_password, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showInvalidCombinationError() {
        Toast.makeText(this, R.string.invalid_email_password, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateToMainActivity() {
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
