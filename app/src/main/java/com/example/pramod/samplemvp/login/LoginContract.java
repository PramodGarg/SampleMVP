package com.example.pramod.samplemvp.login;

import com.example.pramod.samplemvp.base.BasePresenter;
import com.example.pramod.samplemvp.base.BaseView;

/**
 * Created by pramod on 11/10/17.
 */

public interface LoginContract {
    interface View extends BaseView {
        /**
         * show error if invalid email
         */
        void showInvalidEmailError(int resId);

        /**
         * show error if invalid password
         */
        void showInvalidPasswordError(int resId);

        /**
         * show error if invalid email/password combination
         */
        void showInvalidCombinationError(int resId);

        /**
         * navigate to main screen
         */
        void navigateToMainScreen();

    }

    interface Presenter extends BasePresenter {
        /**
         * user login
         *
         * @param email    : email of user
         * @param password : password of user
         */
        void onLogin(String email, String password);
    }

    interface LoginInteractor {

        void loginUser(String email, String password, OnLoginCallBack onLoginCallBack);

        /**
         * callback for login api
         */
        interface OnLoginCallBack {

            /**
             * if login succeed
             */
            void onSuccess();

            /**
             * if login fails
             */
            void onFailure();
        }
    }
}
