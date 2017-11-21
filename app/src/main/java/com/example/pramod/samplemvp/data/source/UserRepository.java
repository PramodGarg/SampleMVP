package com.example.pramod.samplemvp.data.source;

import io.paperdb.Paper;

import static com.example.pramod.samplemvp.constant.DatabaseConstant.PAPER_USER_ACCESS_TOKEN;

/**
 * Created by pramod on 20/11/17.
 */

public class UserRepository implements UserSource {
    @Override
    public void saveAccessToken(final String accessToken) {
        Paper.book().write(PAPER_USER_ACCESS_TOKEN, accessToken);
    }
}
