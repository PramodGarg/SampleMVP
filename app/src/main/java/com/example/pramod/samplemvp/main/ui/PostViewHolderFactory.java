package com.example.pramod.samplemvp.main.ui;

import android.view.View;

/**
 * Created by pramod on 14/10/17.
 */

public class PostViewHolderFactory {
    public PostAdapter.PostVH createViewHolder(View view) {
        return new PostAdapter.PostVH(view);
    }
}
