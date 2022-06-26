package com.example.readingapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.readingapplication.API.Wattpad;

public class AdapterStory extends RecyclerView.Adapter<AdapterStory.StoryHolder> {
    private Wattpad wattpad;
    private Context context;

    public AdapterStory(Wattpad wattpad, Context context) {
        this.wattpad = wattpad;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterStory.StoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StoryHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_story, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterStory.StoryHolder holder, int position) {
        holder.judul.setText(wattpad.getStories().get(position).getTitle());
        holder.penulis.setText(wattpad.getStories().get(position).getUser().getFullname());
        Glide.with(context).load(wattpad.getStories().get(position).getCover()).into(holder.cover);
        Glide.with(context).load(wattpad.getStories().get(position).getUser().getAvatar()).into(holder.avatar);
    }

    @Override
    public int getItemCount() {
        return wattpad.getStories().size();
    }

    public static class StoryHolder extends RecyclerView.ViewHolder{
        ImageView cover, avatar;
        TextView judul,penulis;
        public StoryHolder(@NonNull View itemView) {
            super(itemView);
            cover = itemView.findViewById(R.id.story_cover);
            avatar = itemView.findViewById(R.id.avatar_penulis);
            judul = itemView.findViewById(R.id.judul_buku);
            penulis = itemView.findViewById(R.id.penulis_buku);
        }
    }
}
