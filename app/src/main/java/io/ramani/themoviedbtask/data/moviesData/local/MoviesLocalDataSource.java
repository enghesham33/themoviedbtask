package io.ramani.themoviedbtask.data.moviesData.local;

import java.util.List;

import io.ramani.themoviedbtask.domain.model.MoviesModel;
import io.ramani.themoviedbtask.domain.model.MoviesResponseModel;
import io.reactivex.Single;

public interface MoviesLocalDataSource {
    Single<MoviesResponseModel> getMoviesList(String query, boolean includeAdult);

    Single<MoviesModel> getMovieDetails(int movieId);

    void saveMoviesList(List<MoviesModel> moviesModels);
}
