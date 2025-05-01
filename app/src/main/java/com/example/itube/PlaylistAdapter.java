package com.example.itube;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class PlaylistAdapter extends RecyclerView.Adapter<PlaylistAdapter.ViewHolder> {
    private List<VideoItem> videos;
    private final OnVideoClickListener listener;

    public interface OnVideoClickListener {
        void onVideoClick(VideoItem video);
    }

    public PlaylistAdapter(List<VideoItem> videos, OnVideoClickListener listener) {
        this.videos = videos;
        this.listener = listener;
    }

    public void setVideos(List<VideoItem> videos) {
        this.videos = videos;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_playlist, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        VideoItem video = videos.get(position);
        holder.videoTitle.setText(video.title);
        holder.itemView.setOnClickListener(v -> listener.onVideoClick(video));
    }

    @Override
    public int getItemCount() {
        return videos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView videoTitle;

        public ViewHolder(View view) {
            super(view);
            videoTitle = view.findViewById(R.id.videoTitle);
        }
    }
}