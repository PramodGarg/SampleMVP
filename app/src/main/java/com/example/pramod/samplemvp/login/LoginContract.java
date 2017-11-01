package com.example.pramod.samplemvp.login;

import com.example.pramod.samplemvp.base.BasePresenter;
import com.example.pramod.samplemvp.base.BaseView;

/**
 * Created by pramod on 11/10/17.
 */

public interface LoginContract {
    interface View extends BaseView {
        void showEmailError();

        void showPasswordError();

        void showInvalidCombinationError();

        void navigateToMainActivity();

    }

    interface Presenter extends BasePresenter {
        void login(String email, String password);

        interface OnLoginCallBack {

            void onEmailError();

            void onPasswordError();

            void onSuccess();

            void onFailure();
        }
    }
}
