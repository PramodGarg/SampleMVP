package com.example.pramod.samplemvp.main.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pramod.samplemvp.R;
import com.example.pramod.samplemvp.main.data.Post;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by pramod on 12/10/17.
 */

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostVH> {


    private MainActivity mActivity;
    private PostViewHolderFactory mPostViewHolderFactory;
    private ArrayList<Post> mPostList;

    @Inject
    public PostAdapter(MainActivity activity, ArrayList<Post> mPostList, PostViewHolderFactory postViewHolderFactory) {
        this.mPostList = mPostList;
        mActivity = activity;
        mPostViewHolderFactory = postViewHolderFactory;

    }

    @Override
    public PostVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        if (viewType % 2 == 0) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);

        } else if (viewType % 2 != 0) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user_even, parent, false);
        }
        return mPostViewHolderFactory.createViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PostVH holder, int position) {
        int pos = holder.getAdapterPosition();
        Post post = mPostList.get(pos);
        if (post != null) {
            holder.mTvId.setText(post.getId());
            holder.mTvUserId.setText(post.getUserId());
            holder.mTvTitle.setText(post.getTitle());
            holder.mTvBody.setText(post.getBody());
        }
    }

    @Override
    public int getItemCount() {
        return mPostList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public static class PostVH extends RecyclerView.ViewHolder {
        private TextView mTvId, mTvUserId, mTvTitle, mTvBody;

        public PostVH(View itemView) {
            super(itemView);
            mTvId = itemView.findViewById(R.id.tvId);
            mTvUserId = itemView.findViewById(R.id.tvUserId);
            mTvTitle = itemView.findViewById(R.id.tvTitle);
            mTvBody = itemView.findViewById(R.id.tvBody);
        }
    }
}
