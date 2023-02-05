package com.example.retrofitexample.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitexample.R;
import com.example.retrofitexample.model.PostModel;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    List<PostModel> postModelList;

    public PostAdapter(List<PostModel> postModelList) {
        this.postModelList = postModelList;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_posts, parent, false);
        return new PostViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.tvTitle.setText(postModelList.get(position).getTitle());
        holder.tvBody.setText(postModelList.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return postModelList.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvBody;

        public PostViewHolder(@NonNull View v) {
            super(v);
            tvTitle = v.findViewById(R.id.tvTitle);
            tvBody = v.findViewById(R.id.tvBody);
        }
    }
}
