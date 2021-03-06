package com.example.pramod.samplemvp.main.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pramod.samplemvp.R;
import com.example.pramod.samplemvp.data.model.Post;

import java.util.List;

/**
 * Created by pramod on 12/10/17.
 */

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostVH> {
    private List<Post> mPostList;

    public PostAdapter(List<Post> mPostList) {
        this.mPostList = mPostList;
    }

    @Override
    public PostVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new PostVH(view);
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

    class PostVH extends RecyclerView.ViewHolder {
        private TextView mTvId, mTvUserId, mTvTitle, mTvBody;

        PostVH(View itemView) {
            super(itemView);
            mTvId = itemView.findViewById(R.id.tvId);
            mTvUserId = itemView.findViewById(R.id.tvUserId);
            mTvTitle = itemView.findViewById(R.id.tvTitle);
            mTvBody = itemView.findViewById(R.id.tvBody);
        }
    }
}
