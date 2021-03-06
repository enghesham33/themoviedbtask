package io.ramani.themoviedbtask.data.moviesData.remote;

import java.util.List;

import io.ramani.themoviedbtask.data.models.MovieRemoteModel;
import io.ramani.themoviedbtask.data.models.MoviesRemoteResponse;
import io.ramani.themoviedbtask.domain.model.MoviesModel;
import io.ramani.themoviedbtask.domain.model.MoviesResponseModel;
import io.reactivex.Single;

public interface MoviesRemoteDataSource {
    Single<MoviesResponseModel> getMoviesList(String query, int page, boolean includeAdult);

    Single<MoviesModel> getMovieDetails(int id);
}
