package io.ramani.themoviedbtask.app.movies.movieDetails;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import io.ramani.themoviedbtask.R;
import io.ramani.themoviedbtask.app.base.BaseActivity;
import io.ramani.themoviedbtask.app.viewModels.MoviesViewModel;
import io.ramani.themoviedbtask.data.commonData.Constants;
import io.ramani.themoviedbtask.domain.model.MoviesModel;

public class MovieDetailsActivity extends BaseActivity<MoviesViewModel> {

    public static String MOVIE_ID_PARAM = "movieId";

    private ProgressBar loader;
    ImageView moviePosterImageView;
    TextView movieReleaseDateTextView;
    TextView movieVotesCountTextView;
    Button playVideoButton;
    RatingBar movieRatingBar;

    @Override
    protected MoviesViewModel initiateViewModel() {
        return new MoviesViewModel();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        loader = findViewById(R.id.loader_view);
        playVideoButton = findViewById(R.id.play_video_button);
        moviePosterImageView = findViewById(R.id.movie_poster_image_view);
        movieRatingBar = findViewById(R.id.movie_rating_bar);
        movieReleaseDateTextView = findViewById(R.id.movie_release_date_text_view);
        movieVotesCountTextView = findViewById(R.id.movie_votes_count_text_view);

        int movieId = getIntent().getIntExtra(MOVIE_ID_PARAM, 0);

        if (movieId > 0) {
            viewModel.getMovieDetails(movieId);
        }
        observeLoading();
        observeError();
        observeMovieDetails();
    }

    private void observeLoading() {
        viewModel.loading.observe(this, visible -> {
            loader.setVisibility(visible ? View.VISIBLE : View.GONE);
        });
    }

    private void observeError() {
        viewModel.error.observe(this, error -> {
            Toast.makeText(this, error, Toast.LENGTH_LONG).show();
        });
    }

    private void observeMovieDetails() {
        viewModel.movieDetails.observe(this, this::showMovieData);
    }

    private void showMovieData(MoviesModel movie) {
        if (movie.posterPath != null && !movie.posterPath.isEmpty()) {
            Glide.with(this).load(Constants.BASE_Media_URL + movie.posterPath)
                    .apply(RequestOptions.centerCropTransform()).into(moviePosterImageView);
        }
        setTitle(movie.title);
        movieReleaseDateTextView.setText(getResources().getString(R.string.release_date) + " " + movie.releaseDate);
        movieRatingBar.setRating((float) (movie.voteAverage / 2.0));
        movieVotesCountTextView.setText(getResources().getString(R.string.total_votes) + " " + movie.voteCount);


        if (movie.videoId != null && !movie.videoId.isEmpty()) {
            playVideoButton.setVisibility(View.VISIBLE);
            playVideoButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MovieDetailsActivity.this, YoutubePlayerActivity.class);
                    intent.putExtra(YoutubePlayerActivity.VIDEO_ID_PARAM, movie.videoId);
                    startActivity(intent);
                }
            });
        } else {
            playVideoButton.setVisibility(View.GONE);
        }
    }
}