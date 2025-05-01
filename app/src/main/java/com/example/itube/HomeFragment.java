package com.example.itube;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private PlaylistAdapter playlistAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        EditText urlInput = view.findViewById(R.id.urlInput);
        RecyclerView playlistView = view.findViewById(R.id.playlistRecyclerView);

        // Setup playlist RecyclerView
        playlistView.setLayoutManager(new LinearLayoutManager(getContext()));
        playlistAdapter = new PlaylistAdapter(new ArrayList<>(), video -> {
            Intent intent = new Intent(getActivity(), PlayerActivity.class);
            intent.putExtra("VIDEO_URL", video.videoUrl);
            startActivity(intent);
        });
        playlistView.setAdapter(playlistAdapter);

        view.findViewById(R.id.btnPlay).setOnClickListener(v -> {
            String url = urlInput.getText().toString();
            if (!url.isEmpty()) {
                Intent intent = new Intent(getActivity(), PlayerActivity.class);
                intent.putExtra("VIDEO_URL", url);
                startActivity(intent);
            }
        });

        view.findViewById(R.id.btnAddToPlaylist).setOnClickListener(v -> {
            String url = urlInput.getText().toString();
            if (!url.isEmpty()) {
                new Thread(() -> {
                    VideoItem item = new VideoItem();
                    item.videoUrl = url;
                    item.title = "Video " + System.currentTimeMillis();
                    VideoDatabase.getDatabase(getContext()).videoDao().insert(item);
                }).start();
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        VideoDatabase.getDatabase(requireContext()).videoDao().getAllVideos()
                .observe(getViewLifecycleOwner(), videos -> {
                    playlistAdapter.setVideos(videos);
                });
    }
}