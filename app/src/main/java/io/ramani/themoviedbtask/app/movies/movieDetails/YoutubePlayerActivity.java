package io.ramani.themoviedbtask.app.movies.movieDetails;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import io.ramani.themoviedbtask.R;
import io.ramani.themoviedbtask.data.commonData.Constants;

public class YoutubePlayerActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
    public static String VIDEO_ID_PARAM = "videoId";

    private String videoId;

    YouTubePlayerView youTubePlayerView;
    ImageButton closeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube_player);

        youTubePlayerView = findViewById(R.id.video_view);
        closeButton = findViewById(R.id.close_button);

        videoId = getIntent().getStringExtra(VIDEO_ID_PARAM);
        if (videoId != null && !videoId.isEmpty()) {
            youTubePlayerView.initialize(Constants.YOUTUBE_API_KEY, this);
        }

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.loadVideo(videoId);
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(this, youTubeInitializationResult.name(), Toast.LENGTH_LONG).show();
    }
}