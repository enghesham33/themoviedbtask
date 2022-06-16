package io.ramani.themoviedbtask.data.moviesData.local;

import java.util.List;

import io.ramani.themoviedbtask.data.models.MoviesRemoteResponse;
import io.ramani.themoviedbtask.domain.model.MoviesModel;
import io.reactivex.Single;

public interface MoviesLocalDataSource {
    Single<List<MoviesModel>> getMoviesList(String query, boolean includeAdult);

    void saveMoviesList(List<MoviesModel> moviesModels);
}
