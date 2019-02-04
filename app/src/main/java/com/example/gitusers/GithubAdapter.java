package com.example.gitusers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class GithubAdapter extends RecyclerView.Adapter<GithubAdapter.githuViewHolder> {

    private  Context context;
    private User[] data;

    public  GithubAdapter (Context context, User[] data){

        this.context = context;
        this.data= data;

    }

    @NonNull
    @Override
    public githuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_user_layout, parent, false);

        return new githuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull githuViewHolder holder, int position) {

        User user = data[position];
        holder.textUser.setText(user.getLogin());
        Glide.with(holder.imgUser.getContext()).load(user.getAvatarUrl()).into(holder.imgUser);

    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public  class githuViewHolder extends RecyclerView.ViewHolder{
        ImageView imgUser;
        TextView textUser;

        public githuViewHolder(View itemView) {
            super(itemView);

            imgUser =(ImageView) itemView.findViewById(R.id.imgUser);
            textUser = (TextView) itemView.findViewById(R.id.txtUser);

        }
    }
}
