package io.ramani.themoviedbtask.data.moviesData;

import java.util.List;

import io.ramani.themoviedbtask.data.apiServices.RemoteService;
import io.ramani.themoviedbtask.data.moviesData.local.MoviesLocalDataSource;
import io.ramani.themoviedbtask.data.moviesData.local.MoviesLocalDataSourceImpl;
import io.ramani.themoviedbtask.data.moviesData.remote.MoviesRemoteDataSource;
import io.ramani.themoviedbtask.data.moviesData.remote.MoviesRemoteDataSourceImpl;
import io.ramani.themoviedbtask.domain.model.MoviesModel;
import io.ramani.themoviedbtask.domain.model.MoviesResponseModel;
import io.reactivex.Single;

public class MoviesDataRepository {

    private final MoviesLocalDataSource localDataSource;

    private final MoviesRemoteDataSource remoteDataSource;

    public MoviesDataRepository() {
        this.remoteDataSource = MoviesRemoteDataSourceImpl.getInstance(RemoteService.getInstance().getApiCall());
        this.localDataSource = MoviesLocalDataSourceImpl.getInstance();
    }

    public Single<MoviesResponseModel> getMoviesList(String query, int page, boolean includeAdult) {
        if (RemoteService.getInstance().isInternetAvailable()) {
            return remoteDataSource.getMoviesList(query, page, includeAdult);
        } else {
            return localDataSource.getMoviesList(query, includeAdult).flatMap(Single::just);
        }
    }

    public Single<MoviesModel> getMovieDetails(int movieId) {
        if (RemoteService.getInstance().isInternetAvailable()) {
            return remoteDataSource.getMovieDetails(movieId);
        } else {
            return localDataSource.getMovieDetails(movieId);
        }
    }

    public void saveData(List<MoviesModel> moviesModels) {
        this.localDataSource.saveMoviesList(moviesModels);
    }
}
