package io.ramani.themoviedbtask.app.movies.moviesList;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import io.ramani.themoviedbtask.R;
import io.ramani.themoviedbtask.data.commonData.Constants;
import io.ramani.themoviedbtask.domain.model.MoviesModel;

public class MoviesListAdapter extends RecyclerView.Adapter<MoviesListAdapter.ViewHolder> {

    List<MoviesModel> movies;
    Context context;
    OnItemClickListener onItemClickListener;

    public MoviesListAdapter(List<MoviesModel> movies, Context context, OnItemClickListener onItemClickListener) {
        this.movies = movies;
        this.context = context;
        this.onItemClickListener = onItemClickListener;
    }

    public void changeDataSet(List<MoviesModel> movies) {
        this.movies.clear();
        this.movies.addAll(movies);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MoviesModel movie = movies.get(position);
        if (movie.posterPath != null && !movie.posterPath.isEmpty()) {
            Glide.with(context).load(Constants.BASE_Media_URL + movie.posterPath)
                    .apply(RequestOptions.centerCropTransform()).into(holder.moviePosterImageView);
        }
        holder.movieTitleTextView.setText(movie.title);
        holder.movieVoteAverageTextView.setText(" " + movie.voteAverage);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(movie);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView moviePosterImageView;
        TextView movieTitleTextView;
        TextView movieVoteAverageTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            moviePosterImageView = itemView.findViewById(R.id.movie_poster_image_view);
            movieTitleTextView = itemView.findViewById(R.id.movie_title_text_view);
            movieVoteAverageTextView = itemView.findViewById(R.id.movie_vote_average_text_view);
        }
    }

    interface OnItemClickListener {
        void onItemClick(MoviesModel movie);
    }
}
